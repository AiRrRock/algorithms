package ru.gb.algoritms.hw6;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RoleDao {
    private DataSource dataSource = dataSource();
    private static final Map<Long, Role> roles = new ConcurrentHashMap<>();

    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:jdbc/data.sql")
                .build();
    }

    public List<Role> getAllRoles() throws SQLException {
        roles.clear();
        List<Role> rolesList = new ArrayList<>();
        ResultSet rs = dataSource.getConnection()
                .createStatement()
                .executeQuery("SELECT * FROM roles;");
        while (rs.next()) {
            Role role = mapRole(rs);
            roles.put(role.getId(), role);
            rolesList.add(role);
        }
        return rolesList;
    }

    public Role getRoleById(Long id) throws SQLException {
        if (roles.containsKey(id)) {
            return roles.get(id);
        } else {
            ResultSet rs = dataSource.getConnection()
                    .createStatement()
                    .executeQuery("SELECT * FROM roles WHERE id = " + id);
            Role role = null;
            if (rs.next()) {
                role = mapRole(rs);
                roles.put(id, role);
            }
            return role;
        }
    }

    public void addOrUpdateRole(Role role) throws SQLException {
        Statement st = dataSource.getConnection()
                .createStatement();
        if (getRoleById(role.getId()) != null) {
            st.execute(String.format("UPDATE roles SET name = '%s' WHERE id=%d", role.getName(), role.getId()));
        } else {
            st.execute(String.format("INSERT INTO roles (id, name) VALUES (%d, '%s')", role.getId(), role.getName()));
        }
        // Only if saving object means that we don't need it anymore, otherwise removing it is not necessary
        roles.remove(role.getId());
    }

    private Role mapRole(ResultSet rs) throws SQLException {
        Role role = new Role();
        role.setId(rs.getLong(1));
        role.setName(rs.getString(2));
        return role;
    }

}

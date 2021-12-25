(function () {
    angular
        .module('magic-button', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
         .when('/', {
                        templateUrl: 'index.html',
                        controller: 'indexController'
                    })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http, $localStorage) {
    }
})();

angular.module('magic-button').controller('indexController', function ($rootScope, $scope, $http, $localStorage) {
    $scope.magicHappened = false;
    $scope.doMagic = function () {
        $http.get('http://localhost:8080/magic-button/api/v1/magic')
            .then(function successCallback(response) {
                if (response.data) {
                    if(response.data.magicTime){
                       $scope.magicHappened = true;
                       alert(response.data.magicMessage)
                    } else {
                       alert(response.data.timesClicked);
                    }
                }
            }, function errorCallback(response) {
            });
    };

});
package ru.gb.algorithms;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/magic")
@RequiredArgsConstructor
public class MagicButtonController {
    private MagicButtonModel model = new MagicButtonModel("Time to disappear");
    private int clicksToDisappear = 3;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public MagicButtonModel getButtonModel() {
        model.setTimesClicked(model.getTimesClicked() + 1);
        if(model.getTimesClicked() >= clicksToDisappear){
            model.setMagicTime(true);
        }
        return model;
    }
}

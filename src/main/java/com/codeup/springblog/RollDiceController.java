package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {
    @GetMapping("roll-dice")
    public String guess(){
        return "roll";
    }

    @GetMapping("roll-dice/{guess}")
    public String result(@PathVariable int guess, Model model){
        int roll = (int) Math.floor((Math.random() * 6) + 1);
        model.addAttribute("guess", guess);
        model.addAttribute("roll", roll);
        if (guess == roll){
            model.addAttribute("result", "correct");
        }
        else {
            model.addAttribute("result", "incorrect");
        }
        return "result";
    }
}

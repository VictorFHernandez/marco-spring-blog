package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @RequestMapping(path ="/add/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number){
        return number + " plus one is " + (number + 1) + "!";
    }
    @RequestMapping(path ="/add/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String subtractOne(@PathVariable int number){
        return number + " minus one is " + (number - 1) + "!";
    }
}

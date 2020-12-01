package com.codeup.blogapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path = "/add/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int firstNumber, @PathVariable int secondNumber){
        int totalValue = firstNumber + secondNumber;
        return firstNumber + " + " + secondNumber + " = " + totalValue;
    }

    @RequestMapping(path = "/subtract/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    @ResponseBody
    public String sub(@PathVariable int firstNumber, @PathVariable int secondNumber){
        int totalValue = firstNumber - secondNumber;
        return firstNumber + " - " + secondNumber + " = " + totalValue;
    }

    @RequestMapping(path = "/divide/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    @ResponseBody
    public String div(@PathVariable int firstNumber, @PathVariable int secondNumber){
        int totalValue = firstNumber / secondNumber;
        return firstNumber + " divided by " + secondNumber + " is " + totalValue;
    }

    @RequestMapping(path = "/multiply/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    @ResponseBody
    public String mult(@PathVariable int firstNumber, @PathVariable int secondNumber){
        int totalValue = firstNumber * secondNumber;
        return firstNumber + " * " + secondNumber + " = " + totalValue;
    }

}

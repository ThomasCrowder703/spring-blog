package com.codeup.blogapplication;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

    @GetMapping("/hello/{name}")
    public String showHelloMessage(@PathVariable String name, Model model){
        model.addAttribute("name", name); //setting an attribute
        return "/hello";
    }

    @GetMapping("/")
    @ResponseBody
    public String homeControl(){
        return "This is the landing page!";
    }

    @GetMapping("/home")
    public String welcome(){
        return "/home";
    }

    @GetMapping("/join")
    public String showJoinForm(Model model){
        List<String> cohortNames = new ArrayList<>();
        cohortNames.add("COBOL");
        cohortNames.add("Draco");

        model.addAttribute("cohortNames", cohortNames);
        return "/join";
    }

    @PostMapping("/join")
    public String postJoinForm(@RequestParam(name = "cohort") String cohort, Model model){
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "/join";
    }

    @GetMapping("/roll-dice")
    public String promptUserGuess(Model model){
//       Generate buttons
        List<Long> buttonOptions = new ArrayList<>();
        for(long i = 1; i <=6; i++){
            buttonOptions.add(i);
        }
        model.addAttribute("buttonOptions",buttonOptions);

        return "/roll-dice";
    }

    @PostMapping("/roll-dice")
    public String postUserGuess(@RequestParam(name = "option") long option,Model model){
        //        Generate Random Number
        Random random = new Random();
        int upperbound = 6;
        int randomLong = random.nextInt(upperbound);


        model.addAttribute("option", "Your guess was " + option);
        model.addAttribute("randomLong","The actual value was " + randomLong);
        return "/roll-dice";
    }



}

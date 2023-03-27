package com.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ThreadLocalRandom;


@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/dice-roll/{n}")
    public String returnDiceGuessView(@PathVariable int n, Model model){
    int roll = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        model.addAttribute("guess", n);
        model.addAttribute("roll", n);

        return "dice-roll";
    }






//    @GetMapping("/roll-dice")
//    public String returnNumber(@PathVariable String  name = "dice", Model model) {
////        System.out.println(dice);
//        return "redirect:/roll-diceNumber";
//    }
//
//
//    @GetMapping("/roll-diceNumber")
//    public String returnUserNumber(){
//        return "roll-diceNumber";
//    }

}

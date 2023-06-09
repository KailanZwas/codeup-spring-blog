package com.codeup.codeupspringblog.controllers;

import jakarta.servlet.annotation.WebListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @GetMapping( "/add/{number1}/and/{number2}")
    @ResponseBody
    public int add(@PathVariable int number1, @PathVariable int number2){
        return number1 + number2;
    }

    @GetMapping( "/subtract/{number1}/and/{number2}")
    @ResponseBody
    public int sub(@PathVariable int number1, @PathVariable int number2){
        return number1 - number2;
    }

    @GetMapping( "/multiply/{number1}/and/{number2}")
    @ResponseBody
    public int multiply(@PathVariable int number1, @PathVariable int number2){
        return number1 * number2;
    }@GetMapping( "/divide/{number1}/and/{number2}")
    @ResponseBody
    public int divide(@PathVariable int number1, @PathVariable int number2){
        return number1 / number2;
    }

}

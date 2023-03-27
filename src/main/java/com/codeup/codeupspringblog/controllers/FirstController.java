//package com.codeup.codeupspringblog.controllers;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class FirstController {
//
//    @GetMapping("/hello")
//    @ResponseBody
//    public String returnHelloWorld(@RequestParam(defaultValue = "true" ) Boolean uppercase) {
//
//        if (uppercase) {
//            return "HELLO ZENITH";
//        } else {
//
//            return "Hello Zenith";
//        }
//    }
//
//    @GetMapping("/justin")
//    @ResponseBody
//    public String returnJustin(){
//        return "<h1>Justin</h1>";
//    }
//
//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String greetName(@PathVariable String name){
//        return "Hello " + name;
//    }
//
//    @GetMapping("/hello/{fname}/{lname}")
//    @ResponseBody
//    public String returnJustin(@PathVariable String fname, @PathVariable String flast ){
//        return "<hello " + fname + flast;
//    }
//
//}

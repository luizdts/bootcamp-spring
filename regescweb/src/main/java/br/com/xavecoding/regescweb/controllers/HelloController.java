package br.com.xavecoding.regescweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @GetMapping("/hello-servlet")
    public String hello(HttpServletRequest request){
        request.setAttribute("nome", "Luiz");
        return "hello";
    }
    @GetMapping("/hello-model")
    public String hello(Model model){
        model.addAttribute("nome", "Henrique");
        return "hello";
    }

    @GetMapping("/hello")
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("nome", "Zezinho!");
        return mv;
    }
}

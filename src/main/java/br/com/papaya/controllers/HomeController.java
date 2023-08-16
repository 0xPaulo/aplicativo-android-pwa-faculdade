package br.com.papaya.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.papaya.model.Pessoa;

@Controller
public class HomeController {

  @GetMapping("/index")
  public ModelAndView index() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("home/index.html");
    return mv;
  }

  @GetMapping("/")
  public ModelAndView logar() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pessoa", new Pessoa());
    mv.setViewName("login/login.html");
    return mv;
  }

  @GetMapping("/list-all")
  public ModelAndView lista() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("item/list-all.html");
    return mv;
  }

}

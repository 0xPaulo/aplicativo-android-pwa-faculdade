package br.com.papaya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.com.papaya.Exceptions.EmailExistsException;
import br.com.papaya.Exceptions.EmailNotNullException;
import br.com.papaya.Exceptions.GenericException;
import br.com.papaya.Exceptions.NameNotNullException;
import br.com.papaya.Exceptions.PasswordNotNullExeception;
import br.com.papaya.Exceptions.UserExistsException;
import br.com.papaya.model.Pessoa;
import br.com.papaya.service.ServiceLoginUser;
import br.com.papaya.service.ServiceRegisterUser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

  @Autowired
  ServiceRegisterUser serviceRegister;
  @Autowired
  ServiceLoginUser sericeLogin;

  @GetMapping("/register")
  public ModelAndView paginaCadastro() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pessoa", new Pessoa());
    mv.setViewName("login/register");
    return mv;
  }

  @PostMapping("/registerUser")
  public ModelAndView registrarPessoa(Pessoa pessoa)
      throws UserExistsException, NameNotNullException, EmailNotNullException, EmailExistsException,
      PasswordNotNullExeception, GenericException {
    ModelAndView mv = new ModelAndView();
    try {
      serviceRegister.serviceSalvarUser(pessoa);
      mv.setViewName("redirect:/");
    } catch (EmailExistsException e) {
      mv.addObject("message", e.getMessage());
      mv.setViewName("login/register.html");
    } catch (UserExistsException e) {
      mv.addObject("message", e.getMessage());
      mv.setViewName("login/register.html");
    } catch (NameNotNullException e) {
      mv.addObject("message", e.getMessage());
      mv.setViewName("login/register.html");
    } catch (EmailNotNullException e) {
      mv.addObject("message", e.getMessage());
      mv.setViewName("login/register.html");
    } catch (PasswordNotNullExeception e) {
      mv.addObject("message", e.getMessage());
      mv.setViewName("login/register.html");
    } catch (GenericException e) {
      mv.addObject("message", e.getMessage());
      mv.setViewName("login/register.html");
    }
    return mv;
  }

  @PostMapping("/login")
  public String fazerLogar(@ModelAttribute("pessoa") Pessoa pessoa) {
    if (sericeLogin.pessoaExiste(pessoa.getName())) {
      return "home/index";
    } else {
      return "/login/register.html";
    }
  }
}

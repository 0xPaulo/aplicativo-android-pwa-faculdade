package br.com.papaya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.papaya.service.ItemService;

@Controller
public class FilterController {

  @Autowired
  private ItemService itemRepository;

  @GetMapping("/filtro-{i}")
  public ModelAndView getListFruts(@PathVariable("i") String i) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("filter/filtro.html");
    if ("frutas".equals(i)) {
      mv.addObject("List__All_Filter", itemRepository.listarFrutas("frutas"));
    } else if ("verduras".equals(i)) {
      mv.addObject("List__All_Filter", itemRepository.listarFrutas("vegetais"));
    } else if ("peixes".equals(i)) {
      mv.addObject("List__All_Filter", itemRepository.listarFrutas("mar"));
    } else if ("cereais".equals(i)) {
      mv.addObject("List__All_Filter", itemRepository.listarFrutas("sementes"));
    }
    return mv;
  }
}

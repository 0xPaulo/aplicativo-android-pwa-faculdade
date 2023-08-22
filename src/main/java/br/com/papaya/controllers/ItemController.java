package br.com.papaya.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.papaya.DAO.ItemDao;
import br.com.papaya.DAO.ListaDao;
import br.com.papaya.model.Item;
import br.com.papaya.model.Lista;
import br.com.papaya.model.Pessoa;

@Controller
public class ItemController {

  @Autowired
  private HttpSession session;

  @Autowired
  private ItemDao itemrepository;
  @Autowired
  private ListaDao listarepository;

  @GetMapping("/salvar")
  public ModelAndView addToList(Lista lista) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/item/item.html");
    mv.addObject("lista", new Lista()); /* Cria um vazio */
    return mv;
  }

  @GetMapping("/my-list")
  public ModelAndView myList() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/item/my-list.html");

    Long userId = (Long) session.getAttribute("id");

    List<Lista> listaItens = listarepository.findByPessoaId(userId);
    List<Item> itens = listaItens.stream()
        .map(Lista::getItem)
        .collect(Collectors.toList());

    mv.addObject("my__list", itens);
    return mv;
  }

  @GetMapping("/item-{id}")
  public ModelAndView showItem(@PathVariable("id") long id) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("item/item.html");
    Boolean selected = listarepository.findSelectedById(id);
    if (selected != null) {
      if (selected) {
        mv.addObject("selected", "x");
      } else {
        mv.addObject("selected", "check");
      }
    } else {
      mv.addObject("selected", "check");
    }
    Item item = itemrepository.getReferenceById(id);
    mv.addObject("item", item);
    return mv;
  }

  @GetMapping("/list")
  public ModelAndView listarAll() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/item/list-all.html");
    mv.addObject("list__all", itemrepository.findAll());
    return mv;
  }

  @Transactional
  @PostMapping("save/{id}")
  public ModelAndView salvarItem(@PathVariable("id") long id, HttpSession session) {
    ModelAndView mv = new ModelAndView();
    // Verifique se existe uma entidade Lista com um item associado ao ID
    // especificado
    boolean existsByItemId = listarepository.existsByItemId(id);

    if (existsByItemId) {
      // Exclua a lista que contém o item com o ID especificado
      listarepository.deleteByItemId(id);
      mv.setViewName("redirect:/my-list");
    } else {
      Lista lista = new Lista();
      Item item = new Item();
      Pessoa pessoa = new Pessoa();
      Long pessoaID = (Long) session.getAttribute("id");
      pessoa.setId(pessoaID);
      item.setId(id);
      lista.setPessoa(pessoa);
      lista.setItem(item);
      lista.setSelected(true);
      listarepository.save(lista);
      mv.setViewName("redirect:/my-list");
    }
    return mv;
  }

}

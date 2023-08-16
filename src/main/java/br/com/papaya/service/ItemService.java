package br.com.papaya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.papaya.DAO.ItemDao;
import br.com.papaya.model.Item;

@Service
public class ItemService {

  @Autowired
  private ItemDao itemRepository;

  public List<Item> listarItems() {
    return itemRepository.findAll();
  }
}

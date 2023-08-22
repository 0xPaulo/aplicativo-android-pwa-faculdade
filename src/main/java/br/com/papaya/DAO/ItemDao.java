package br.com.papaya.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.papaya.model.Item;

public interface ItemDao extends JpaRepository<Item, Long> {

  List<Item> findByCategory(String category);
}

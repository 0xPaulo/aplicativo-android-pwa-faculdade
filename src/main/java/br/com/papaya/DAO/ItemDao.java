package br.com.papaya.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.papaya.model.Item;

public interface ItemDao extends JpaRepository<Item, Long> {

}

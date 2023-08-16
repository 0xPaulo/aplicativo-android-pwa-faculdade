package br.com.papaya.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.papaya.model.Lista;

public interface ListaDao extends JpaRepository<Lista, Long> {

  boolean existsByItemId(long id);

  void deleteByItemId(long id);

}

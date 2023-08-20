package br.com.papaya.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.papaya.model.Lista;

public interface ListaDao extends JpaRepository<Lista, Long> {

  @Query("SELECT i.selected FROM Lista i WHERE i.item.id = :id")
  Boolean findSelectedById(@Param("id") Long id);

  boolean existsByItemId(long id);

  void deleteByItemId(long id);

}

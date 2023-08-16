package br.com.papaya.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.papaya.model.Pessoa;

public interface PessoaDao extends JpaRepository<Pessoa, Long> {

  @Query("SELECT p FROM Pessoa p WHERE p.name = :name")
  public Pessoa buscarPorNome(String name);

  @Query("select i from Pessoa i where i.email = :email")
  public Pessoa findByEmail(String email);
}

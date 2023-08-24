package br.com.papaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.papaya.DAO.PessoaDao;
import br.com.papaya.model.Pessoa;

@Service
public class ServiceLoginUser {
  @Autowired
  private PessoaDao pessoaRepository;

  public boolean pessoaExiste(String usuario, String senha) {
    Pessoa pessoaExiste = pessoaRepository.buscarPorNome(usuario);

    if (pessoaExiste != null) {
      System.out.println("senha que chegou ===========" + senha);
      System.out.println("usuario que chegou ===========" + usuario);
      System.out.println("senha get from db ===========" + pessoaExiste.getSenha());
      System.out.println("pessoa get from db ===========" + pessoaExiste);
      return pessoaExiste.getSenha().equals(senha);
    } else {
      return false; // Pessoa não encontrada, retorna false.
    }
  }

}

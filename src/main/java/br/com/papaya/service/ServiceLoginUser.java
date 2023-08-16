package br.com.papaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.papaya.DAO.PessoaDao;
import br.com.papaya.model.Pessoa;

@Service
public class ServiceLoginUser {
  @Autowired
  private PessoaDao pessoaRepository;

  public boolean pessoaExiste(String identificadorPessoa) {
    Pessoa pessoaComparar = pessoaRepository.buscarPorNome(identificadorPessoa);
    System.out.println(pessoaComparar);
    return pessoaComparar != null;
}

}

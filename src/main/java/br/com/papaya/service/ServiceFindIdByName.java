package br.com.papaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.papaya.DAO.PessoaDao;
import br.com.papaya.model.Pessoa;

@Service
public class ServiceFindIdByName {

  @Autowired
  PessoaDao pessoaRepository;

  public Pessoa encontrarIdPorNome(String name) {
    return pessoaRepository.findIdByName(name);
  }
}

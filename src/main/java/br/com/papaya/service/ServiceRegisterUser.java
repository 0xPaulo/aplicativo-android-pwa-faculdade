package br.com.papaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.papaya.DAO.PessoaDao;
import br.com.papaya.Exceptions.EmailExistsException;
import br.com.papaya.Exceptions.NameNotNullException;
import br.com.papaya.Exceptions.PasswordNotNullExeception;
import br.com.papaya.Exceptions.EmailNotNullException;
import br.com.papaya.Exceptions.GenericException;
import br.com.papaya.Exceptions.UserExistsException;
import br.com.papaya.model.Pessoa;

@Service
public class ServiceRegisterUser {
  @Autowired
  private PessoaDao pessoaRepository;

  public void serviceSalvarUser(Pessoa pessoa)
      throws EmailExistsException, UserExistsException, NameNotNullException, EmailNotNullException,
      PasswordNotNullExeception, GenericException {
    verifiaNomeNaoVazio(pessoa.getName());
    verificaEmailNaoVazio(pessoa.getEmail());
    verificaSenhaNaoVazio(pessoa.getSenha());
    verificaPessoaExiste(pessoa.getName());
    verificaEmailExiste(pessoa.getEmail());
    try {
      pessoaRepository.save(pessoa);
    } catch (Exception e) {
      throw new GenericException("Erro ao validar email");
    }
  }

  private void verifiaNomeNaoVazio(String nomePessoa) throws NameNotNullException {
    if (nomePessoa == null || nomePessoa.isEmpty()) {
      throw new NameNotNullException("O nome de usuario não pode ser vazio");
    }
  }

  private void verificaEmailNaoVazio(String email) throws EmailNotNullException, GenericException {
    if (email == null || email.isEmpty()) {
      throw new EmailNotNullException("O e-mail não pode ser vazio");
    }
  }

  private void verificaSenhaNaoVazio(String senha) throws PasswordNotNullExeception {
    if (senha == null || senha.isEmpty() || senha.length() < 6) {
      throw new PasswordNotNullExeception("A senha deve conter no mínimo 6 caracteres");
    }
  }

  private void verificaPessoaExiste(String nomeUsuario) throws UserExistsException {
    if (pessoaRepository.buscarPorNome(nomeUsuario) != null) {
      throw new UserExistsException("O nome de usuário " + nomeUsuario + " já foi cadastrado");
    }
  }

  private void verificaEmailExiste(String email) throws EmailExistsException {
    if (pessoaRepository.findByEmail(email) != null) {
      throw new EmailExistsException("Já existe um e-mail cadastrado para " + email);
    }
  }

}

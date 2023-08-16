package br.com.papaya.Exceptions;

public class PasswordNotNullExeception extends Exception {

  public PasswordNotNullExeception(String senha) {
    super(senha);
  }

}

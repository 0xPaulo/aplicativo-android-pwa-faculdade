package br.com.papaya.Exceptions;

public class EmailExistsException extends Exception {

  public EmailExistsException(String message) {
    super(message);
  }

}

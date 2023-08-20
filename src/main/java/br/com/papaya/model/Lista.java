package br.com.papaya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lista {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  @ManyToOne
  @JoinColumn(name = "pessoa_id")
  private Pessoa pessoa;

  @ManyToOne
  @JoinColumn(name = "item_id")
  private Item item;

  @Column(name = "selected")
  private Boolean selected;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Boolean getSelected() {
    return selected;
  }

  public void setSelected(Boolean selected) {
    this.selected = selected;
  }
}

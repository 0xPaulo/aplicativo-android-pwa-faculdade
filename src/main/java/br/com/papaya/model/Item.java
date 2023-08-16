package br.com.papaya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "item_name")
  private String name;
  @Column(name = "item_category")
  private String category;
  @Column(name = "item_location")
  private String locationImage;
  @Column(name = "item_description", length = 1500)
  private String description;
  @Column(name = "item_is_selected")
  private boolean is_selected;
  @Column(name = "item_is_favorite")
  private boolean is_favorite;
  @Column(name = "item_kcal")
  private String kcal;
  @Column(name = "item_points")
  private int points;

  public String getKcal() {
    return kcal;
  }

  public void setKcal(String kcal) {
    this.kcal = kcal;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getLocationImage() {
    return locationImage;
  }

  public void setLocationImage(String locationImage) {
    this.locationImage = locationImage;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isIs_selected() {
    return is_selected;
  }

  public void setIs_selected(boolean is_selected) {
    this.is_selected = is_selected;
  }

  public boolean isIs_favorite() {
    return is_favorite;
  }

  public void setIs_favorite(boolean is_favorite) {
    this.is_favorite = is_favorite;
  }

}

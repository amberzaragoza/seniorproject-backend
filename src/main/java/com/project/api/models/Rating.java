package com.project.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "rating")
public class Rating {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id", length = 36)
  private String id;

  @Column(name = "star_rating")
  private float starRating;

  @Column(name = "compliment")
  private String compliment;

  @ManyToOne
  private AppUser user;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public float getStarRating() {
    return starRating;
  }

  public void setStarRating(float starRating) {
    this.starRating = starRating;
  }

  public String getCompliment() {
    return compliment;
  }

  public void setCompliment(String compliment) {
    this.compliment = compliment;
  }

  public AppUser getUser() {
    return user;
  }

  public void setUser(AppUser user) {
    this.user = user;
  }

}

package com.project.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "geolocation")
public class GeoLocation {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id", length = 36)
  private String id;

  @Column(name = "lattitude", length = 120)
  private double lattitude;

  @Column(name = "longitude", length = 120)
  private double longitude;

  @OneToOne
  private AppUser user;

  public GeoLocation() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getLattitude() {
    return lattitude;
  }

  public void setLattitude(double lattitude) {
    this.lattitude = lattitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public AppUser getUser() {
    return user;
  }

  public void setUser(AppUser user) {
    this.user = user;
  }

}

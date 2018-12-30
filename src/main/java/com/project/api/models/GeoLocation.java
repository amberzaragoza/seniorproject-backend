package com.project.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

  @Column(name = "latitude", length = 120)
  private double latitude;

  @Column(name = "longitude", length = 120)
  private double longitude;

  @Column(name = "isShownOnMap")
  private boolean isShownOnMap;

  public GeoLocation() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public boolean isIsShownOnMap() {
    return isShownOnMap;
  }

  public void setIsShownOnMap(boolean isShownOnMap) {
    this.isShownOnMap = isShownOnMap;
  }

}

package com.project.api.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
// import com.vividsolutions.jts.geom.Point;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "appuser")
public class AppUser {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id", length = 36)
  private String id;

  @Column(name = "username", length = 50)
  private String username;

  @Column(name = "lastName", length = 20)
  private String lastName;

  @Column(name = "firstName", length = 20)
  private String firstName;

  @Column(name = "password", length = 80)
  private String password;

  @Column(name = "reset_token")
  private String resetToken;

  @Column(name = "avatarLink")
  private String avatarLink;

  @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
  @JsonManagedReference
  private Business business;

  @ManyToOne(cascade = CascadeType.MERGE)
  private Business employedBy;

  // @Column(name = "location", columnDefinition = "geography(Point, 4326)")
  // @JsonIgnore
  // private Point location;

  @Column(name = "latitude")
  private Double latitude;

  @Column(name = "longitude")
  private Double longitude;

  @Column(name = "isOnline")
  private boolean isOnline;

  public AppUser() {
  }

  public AppUser(String username, String lastName, String firstName, String password, String resetToken,
      String avatarLink) {
    this.username = username;
    this.lastName = lastName;
    this.firstName = firstName;
    this.password = password;
    this.resetToken = resetToken;
    this.avatarLink = avatarLink;
    this.business = new Business();
    this.employedBy = new Business();

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getResetToken() {
    return resetToken;
  }

  public void setResetToken(String resetToken) {
    this.resetToken = resetToken;
  }

  public Business getBusiness() {
    return business;
  }

  public void setBusiness(Business business) {
    this.business = business;
  }

  public Business getEmployedBy() {
    return employedBy;
  }

  public void setEmployedBy(Business employedBy) {
    this.employedBy = employedBy;
  }

  public String getAvatarLink() {
    return avatarLink;
  }

  public void setAvatarLink(String avatarLink) {
    this.avatarLink = avatarLink;
  }

  // public Point getLocation() {
  //   return location;
  // }

  // public void setLocation(Point point) {
  //   this.location = point;
  // }

  public boolean isOnline() {
    return isOnline;
  }

  public void setIsOnline(boolean isOnline) {
    this.isOnline = isOnline;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public boolean isIsOnline() {
    return isOnline;
  }

}

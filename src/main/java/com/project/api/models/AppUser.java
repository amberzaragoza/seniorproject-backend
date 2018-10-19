package com.project.api.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "appuser")
public class AppUser {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private String id;

  @Column(name = "username")
  private String username;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "password")
  private String password;

  @Column(name = "reset_token")
  private String resetToken;

  @OneToOne(mappedBy="owner", cascade = CascadeType.ALL)
  @JsonManagedReference
  private Business business;

  @ManyToOne(cascade = CascadeType.MERGE)
  private Business employedBy;

  public AppUser(){}

  public AppUser(String id, String username, String lastName,
                 String firstName, String password, String resetToken){
    this.id = id;
    this.username = username;
    this.lastName = lastName;
    this.firstName = firstName;
    this.password = password;
    this.resetToken = resetToken;
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

}

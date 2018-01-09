package com.pavoindus.modeltraining.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created 1/9/2018 00:07
 *
 * @author Deepankar Sharma
 */

@Entity
public class TrainingDataInfo implements Serializable {

  protected TrainingDataInfo() {
  }

  public TrainingDataInfo(String name, Status status) {
    this.name = name;
    this.status = status;
    this.whenCreated = new Date();
  }

  public enum Status {
    ACTIVE, INACTIVE, PROCESSING, ERROR
  }
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  @Enumerated(value = EnumType.STRING)
  private Status status;
  private Date whenCreated;
  private String info;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getWhenCreated() {
    return whenCreated;
  }

  public void setWhenCreated(Date whenCreated) {
    this.whenCreated = whenCreated;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}

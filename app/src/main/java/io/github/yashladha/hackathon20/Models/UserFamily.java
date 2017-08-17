package io.github.yashladha.hackathon20.Models;

public class UserFamily {
  private Boolean hof;
  private String nameEng;
  private String nameHnd;
  private String gender;
  private String adhaarId;
  private String dob;

  public UserFamily(Boolean hof, String nameEng, String nameHnd, String gender, String adhaarId, String dob) {
    this.hof = hof;
    this.nameEng = nameEng;
    this.nameHnd = nameHnd;
    this.gender = gender;
    this.adhaarId = adhaarId;
    this.dob = dob;
  }

  public Boolean getHof() {
    return hof;
  }

  public void setHof(Boolean hof) {
    this.hof = hof;
  }

  public String getNameEng() {
    return nameEng;
  }

  public void setNameEng(String nameEng) {
    this.nameEng = nameEng;
  }

  public String getNameHnd() {
    return nameHnd;
  }

  public void setNameHnd(String nameHnd) {
    this.nameHnd = nameHnd;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAdhaarId() {
    return adhaarId;
  }

  public void setAdhaarId(String adhaarId) {
    this.adhaarId = adhaarId;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }
}

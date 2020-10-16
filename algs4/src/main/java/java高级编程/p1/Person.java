package java高级编程.p1;

/**
 * Author: lsf Time: 9/4/20-2:12 PM
 */
public class Person {

  private String name;
  private String gender;

  public Person(String name, String gender) {
    this.name = name;
    this.gender = gender;
  }

  public Person() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String isGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}

package java高级编程.p1;

/**
 * Author: lsf Time: 9/4/20-2:13 PM
 */
public class Child extends Person {

  private int age;

  public Child(String name, String gender, int age) {
    super(name, gender);
    this.age = age;
  }

  public Child(String name, String gender) {
    super(name, gender);
  }

  public Child() {
    super();
  }

  public static void main(String[] args) {
    Child child = new Child("徐海林", "男", 20);
  }
}

package dev.mvc.ajax;

public class MenuVO {
  private int menuno;
  private String name;
  private int price;
  
  public MenuVO(int menuno, String name, int price) {
    this.menuno = menuno;
    this.name = name;
    this.price = price;
  }
 
  public int getMenuno() {
    return menuno;
  }
  public void setMenuno(int menuno) {
    this.menuno = menuno;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
}
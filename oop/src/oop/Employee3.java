package oop;

public class Employee3 {
  private String name;
  private int java;
  private int web;
  private int dbms;
  private int tot;
  private double avg;

  public Employee3() {
    
  }

  public Employee3(String name, int java, int web, int dbms) {
    this.name = name;
    this.java = java;
    this.web = web;
    this.dbms = dbms;
  }
  
  // 전역 변수에 어떤 형태든 자유롭게 접근 가능
  public void calc() {
    this.tot = this.java + this.web + this.dbms;
    this.avg = (this.tot / 3.0) + 0.5;
  }
  
  // 전역 변수에 접근 가능함으로 인쇄 가능
  public void print() {
    System.out.println("성명: " + this.name);
    System.out.println("JAVA: " + this.java);
    System.out.println("WEB: " + this.web);
    System.out.println("DBMS: " + this.dbms);
    System.out.println("총점: " + this.tot);
    System.out.println("평균: " + (int)this.avg);
    System.out.println("────────");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getJava() {
    return java;
  }

  public void setJava(int java) {
    this.java = java;
  }

  public int getWeb() {
    return web;
  }

  public void setWeb(int web) {
    this.web = web;
  }

  public int getDbms() {
    return dbms;
  }

  public void setDbms(int dbms) {
    this.dbms = dbms;
  }
  
  // setter: set + 첫자가 대문자인 변수명 
  // getter: get + 첫자가 대문자인 변수명 
  
    
}




package oop;

public class ComputerUse {

  public static void main(String[] args) {
    // 객체 생성: 메모리 할당 -> 사용 가능
    Computer computer = new Computer();
    System.out.println("name: " + computer.name);
    System.out.println("price: " + computer.price);
    System.out.println("screen: " + computer.screen);
    System.out.println("cpu: " + computer.cpu);
    System.out.println("----------------------------------");

    computer.name = "게이밍 노트북 RTX4090";
    computer.price = 3000000;
    computer.screen = 18.1;
    computer.cpu = "i5 8500";
    
    System.out.println("name: " + computer.name);
    System.out.println("price: " + computer.price);
    System.out.println("screen: " + computer.screen);
    System.out.println("cpu: " + computer.cpu);
    System.out.println("----------------------------------");
    
    computer.name = "LG RTX4090";
    computer.price = 3500000;
    computer.screen = 18.1;
    computer.cpu = "i7 9500";
    
    System.out.println("name: " + computer.name);
    System.out.println("price: " + computer.price);
    System.out.println("screen: " + computer.screen);
    System.out.println("cpu: " + computer.cpu);
    System.out.println("----------------------------------");
    
    computer.name = "Dell RTX3090";
    computer.price = 2500000;
    computer.screen = 18.1;
    computer.cpu = "i9 9700";
    
    System.out.println("name: " + computer.name);
    System.out.println("price: " + computer.price);
    System.out.println("screen: " + computer.screen);
    System.out.println("cpu: " + computer.cpu);
  }

}
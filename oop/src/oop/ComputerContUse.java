package oop;

public class ComputerContUse {

  public static void main(String[] args) {
    // ComputerCont computerCont = new ComputerCont();
    ComputerCont computerCont = new ComputerCont("게이밍 노트북 RTX4090", 3000000, 18.1, "i5 8500");
    computerCont.print();
    
    computerCont = new ComputerCont("LG RTX4090", 3500000, 18.1, "i7 9500");
    computerCont.print();
    
    computerCont = new ComputerCont("Dell RTX3090", 2500000, 18.1, "i9 9700");
    computerCont.print();

  }

}

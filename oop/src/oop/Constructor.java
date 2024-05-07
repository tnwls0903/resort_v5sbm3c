package oop;

public class Constructor{
  String brand;
  String cpu;
  int ram;
  int hdd;
  boolean odd;
  String graphic;
  int usb20;
  int usb30;
  boolean wifi;
  String comcase;
  
  // 기본 생성자는 생략 가능
  
  // 구현하면 호출됨
  public Constructor() {
    System.out.println("객체 생성됨.");
  }

  public Constructor(String brand) {
    this.brand = brand;
  }

  public Constructor(String brand, String cpu) {
    this.brand = brand;
    this.cpu = cpu;
  }

  public Constructor(String brand, String cpu, int ram) {
    this.brand = brand;
    this.cpu = cpu;
    this.ram = ram;
  }

  public Constructor(String brand, String cpu, int ram, int hdd) {
    this.brand = brand;
    this.cpu = cpu;
    this.ram = ram;
    this.hdd = hdd;
  }

  public Constructor(String brand, String cpu, int ram, int hdd, boolean odd) {
    this.brand = brand;
    this.cpu = cpu;
    this.ram = ram;
    this.hdd = hdd;
    this.odd = odd;
  }

  public Constructor(String brand, String cpu, int ram, int hdd, boolean odd, String graphic) {
    this.brand = brand;
    this.cpu = cpu;
    this.ram = ram;
    this.hdd = hdd;
    this.odd = odd;
    this.graphic = graphic;
  }

  public Constructor(String brand, String cpu, int ram, int hdd, boolean odd, String graphic, int usb20) {
    this.brand = brand;
    this.cpu = cpu;
    this.ram = ram;
    this.hdd = hdd;
    this.odd = odd;
    this.graphic = graphic;
    this.usb20 = usb20;
  }

  public Constructor(String brand, String cpu, int ram, int hdd, boolean odd, String graphic, int usb20, int usb30) {
    this.brand = brand;
    this.cpu = cpu;
    this.ram = ram;
    this.hdd = hdd;
    this.odd = odd;
    this.graphic = graphic;
    this.usb20 = usb20;
    this.usb30 = usb30;
  }

  public Constructor(String brand, String cpu, int ram, int hdd, boolean odd, String graphic, int usb20, int usb30,
      boolean wifi) {
    this.brand = brand;
    this.cpu = cpu;
    this.ram = ram;
    this.hdd = hdd;
    this.odd = odd;
    this.graphic = graphic;
    this.usb20 = usb20;
    this.usb30 = usb30;
    this.wifi = wifi;
  }

  public Constructor(String brand, String cpu, int ram, int hdd, boolean odd, String graphic, int usb20, int usb30,
      boolean wifi, String comcase) {
    this.brand = brand;
    this.cpu = cpu;
    this.ram = ram;
    this.hdd = hdd;
    this.odd = odd;
    this.graphic = graphic;
    this.usb20 = usb20;
    this.usb30 = usb30;
    this.wifi = wifi;
    this.comcase = comcase;
  }
  
    
}



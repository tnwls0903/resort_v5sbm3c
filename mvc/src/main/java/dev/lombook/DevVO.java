package dev.lombook;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

//@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class DevVO {
    private String name="";
    private double year = 1.5;
    private int payTot = 2500000;
    private double pay_tax = 1.5;
    
    public String getName() {
      return name;
    }
    
    public double getYear() {
      return year;
    }
    
    public int getPayTot() {
      return payTot;
    }
    
    public double getPay_tax() {
      return pay_tax;
    }
    
    public void setName(String name) {
      this.name = name;
    }
    
    public void setYear(double year) {
      this.year = year;
    }
    
    public void setPayTot(int payTot) {
      this.payTot = payTot;
    }
    
    public void setPay_tax(double pay_tax) {
      this.pay_tax = pay_tax;
    }
}
package inter;

public class AbsTest2 {

  public static void main(String[] args) {
    // Payment payment = new Payment(); // Cannot instantiate the type Payment
    Payment payment = new Pay2015();
    payment.cash();
    payment.card();
    payment.mobile();
    System.out.println("------------------------------");
    
    payment = new Pay2016();
    payment.cash();
    payment.card();
    payment.mobile();
    System.out.println("------------------------------");
    
    payment = new Pay2017();
    payment.cash();
    payment.card();
    payment.mobile();
    System.out.println("------------------------------");
    
//    Pay2015 pay2015 = new Pay2016(); // Type mismatch: cannot convert from Pay2016 to Pay2015
    
  }

}






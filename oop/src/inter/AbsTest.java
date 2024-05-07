package inter;

public class AbsTest {

  public static void main(String[] args) {
    // Payment payment = new Payment(); // Cannot instantiate the type Payment
    Pay2015 pay2015 = new Pay2015();
    pay2015.cash();
    pay2015.card();
    pay2015.mobile();
    System.out.println("------------------------------");
    
    Pay2016 pay2016 = new Pay2016();
    pay2016.cash();
    pay2016.card();
    pay2016.mobile();
    System.out.println("------------------------------");
    
    Pay2017 pay2017 = new Pay2017();
    pay2017.cash();
    pay2017.card();
    pay2017.mobile();
    System.out.println("------------------------------");
    
  }

}




package inter;

public class InterTest {

  public static void main(String[] args) {
    Pay2015Impl pay2015Impl = new Pay2015Impl();
    pay2015Impl.cash();
    pay2015Impl.card();
    pay2015Impl.mobile();
    System.out.println("-------------------------");
    
    Pay2016Impl pay2016Impl = new Pay2016Impl();
    pay2016Impl.cash();
    pay2016Impl.card();
    pay2016Impl.mobile();
    System.out.println("-------------------------");
    
    Pay2017Impl pay2017Impl = new Pay2017Impl();
    pay2017Impl.cash();
    pay2017Impl.card();
    pay2017Impl.mobile();
    System.out.println("-------------------------");

  }

}

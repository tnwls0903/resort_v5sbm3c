package inter;

public class InterTest2 {

  public static void main(String[] args) {
    PaymentInter paymentInter = new Pay2015Impl();
    paymentInter.cash();
    paymentInter.card();
    paymentInter.mobile();
    System.out.println("-----------------------");
    
    paymentInter = new Pay2016Impl();
    paymentInter.cash();
    paymentInter.card();
    paymentInter.mobile();
    System.out.println("-----------------------");
    
    paymentInter = new Pay2017Impl();
    paymentInter.cash();
    paymentInter.card();
    paymentInter.mobile();
    System.out.println("-----------------------");

  }
}


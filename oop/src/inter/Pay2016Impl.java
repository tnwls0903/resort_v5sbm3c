package inter;

public class Pay2016Impl implements PaymentInter {

  @Override
  public void cash() {
    System.out.println("현금 결재");
    
  }
  
  @Override
  public void card() {
    System.out.println("신용 카드 결재 1.7%");

  }

  @Override
  public void mobile() {
    System.out.println("휴대폰 결재 200원");

  }

}


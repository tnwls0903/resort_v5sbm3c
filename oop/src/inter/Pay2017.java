package inter;

public class Pay2017 extends Payment {

  @Override
  public void card() {
    System.out.println("신용 카드 결재 1.0%");

  }

  @Override
  public void mobile() {
    System.out.println("휴대폰 결재 100원");

  }

}
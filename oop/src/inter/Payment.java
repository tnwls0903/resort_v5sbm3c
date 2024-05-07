package inter;

// abstract: 현재 클래스는 모두 구현되지 않음 -> 객체 생성 불가능 -> Payment payment = new Payment(); X
public abstract class Payment {
  public void cash() {
    System.out.println("현금 결재");
  }
  
  // 카드 결재, 추상 메소드, abstract: 기능이 구현 안됨.
  public abstract void card();
  
  // 모바일 결재
  public abstract void mobile();
  
}

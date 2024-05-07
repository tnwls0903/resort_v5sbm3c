package inter;

// 추상 메소드만 존재
public interface PaymentInter {
// interface에는 멤버 메소드가 선언될 수 없음.
//public void cash() { // Abstract methods do not specify a body
// System.out.println("현금 결재");
//}

  // 현금 결재
  public void cash();

  // 카드 결재, 추상 메소드, abstract: 기능이 구현 안됨.
  public abstract void card();

  // 모바일 결재
  public abstract void mobile();
}

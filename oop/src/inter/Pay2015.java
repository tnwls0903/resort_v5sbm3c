package inter;

// Payment 추상 클래스를 상속받아서 구현
public class Pay2015 extends Payment {
  // The method print() of type Pay2015 must override or implement a supertype method
  // @Override  // 부모 클래스의 메소드 재정의 또는 추상 메소드 구현
  public void print() {
    System.out.println("중소기업 활성화 추진");
  }
  
  // Payment에 구현하지 않은 메소드가 있으니 구현하라!
  // 부모 클래스에서 제작된 추상 메소드는 의무적으로 자식 클래스가 구현해야함.
  // 추상 메소드는 강제 구현의 기능이 있음.
  // @Override: 부모 클래스의 추상 메소드를 구현, 부모 클래스에 구현된 메소드를 자식이 다시 정의 
  @Override
  public void card() {
    System.out.println("신용 카드 결재 2.5%");
  }

  @Override
  public void mobile() {
    System.out.println("휴대폰 결재 300원");
  }
  

}

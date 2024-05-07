package util;

import java.util.ArrayList;
import java.util.List;

public class LambdaExample2 {
    public static void main(String[] args) {
        // 숫자 리스트 생성
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

        // java.util.stream.ReferencePipeline$2@64b8f8f4
        System.out.println("-> " + numbers.stream().filter(item -> item % 2 == 0));
        
        // 짝수만 필터링하여 합계 계산
        int evenSum = numbers.stream().filter(number -> number % 2 == 0) // 짝수만 필터링
                .mapToInt(Integer::intValue) // Integer를 int로 매핑, Integer클래스의 intValue static 메소드 호출
                .sum(); // 합계 계산

        // 결과 출력
        System.out.println("Original Numbers: " + numbers);
        System.out.println("Sum of Even Numbers: " + evenSum);
    }
}




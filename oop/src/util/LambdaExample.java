package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        // 문자열 리스트 생성
        List<String> names = new ArrayList<String>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // 문자열을 길이로 정렬하는 람다 함수, 양수가 나오면 값의 위치를 변경함.
        Collections.sort(names, (String a, String b) -> {  return a.length() - b.length(); });

        // 정렬된 결과 출력
        // Sorted Names by Length: [Bob, Alice, David, Charlie]
        System.out.println("Sorted Names by Length: " + names);
    }
}
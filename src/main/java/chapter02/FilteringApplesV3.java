package chapter02;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 일곱 번째 시도 : 리스트 형식으로 추상화
 * 제네릭으로 인자를 추상화하였다.
 * Apple 뿐만 아니라 Orange, 정수, 문자열 등등.. 을 인자로 받을 수 있게 됐다.
 * filter는 리스트를 순회하고 결과를 담아주는 역할만 하고,
 * 어떤 기준으로 거를 건지는 람다 표현식으로 넘겨주면 된다.
 */
public class FilteringApplesV3 {

    interface Predicate<T>{
        boolean test(T t);
    }

    static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if(p.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    List<Apple> redApples = filter(
            Arrays.asList(
                    new Apple(Color.GREEN, 200),
                    new Apple(Color.RED, 150)
            ),
            (Apple apple) -> Color.RED.equals(apple.getColor())
    );

    List<Integer> evenNumbers = filter(
            Arrays.asList(1, 2, 3),
            (Integer i)->i % 2 == 0);
}

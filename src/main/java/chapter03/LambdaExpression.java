package chapter03;

import chapter02.Apple;

import java.util.Comparator;
import java.util.Objects;

public class LambdaExpression {

    /**
     * 람다 표현식은 메서드로 전달할 수 있는 익명 함수를 단순화 한 것
     * 익명 : 보통 메서드와 달리 이름이 없다
     * 함수 : 클래스에 종속되지 않는다
     * 전달 : 람다 표현식을 메서드 인수로 전달하거나 변수로 저장할 수 있다
     * 간결성 : 익명 클래스처럼 많은 코드를 작성할 필요가 없다
     *
     * 동작 파라미터화를 할 때 자바는 인자로 함수를 넘길 수 없고, 객체를 넘겨 메서드를 사용해야 했다
     * 이에 익명클래스를 구현하는 등의 번거로운 작업을 없애고 람다를 이용해서 간단하게 작성하는 것
     */

    Comparator<Apple> byWeight = new Comparator<Apple>() {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight()-o2.getWeight();
        }
    };

    Comparator<Apple> byWeight2 =
            (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();
}

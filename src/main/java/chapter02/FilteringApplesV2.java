package chapter02;

import java.util.ArrayList;
import java.util.List;

public class FilteringApplesV2 {

    /**
     * 네 번째 시도 : 추상적 조건으로 필터링
     * ApplePredicate 객체를 인수로 받도록 하여
     * filterApples 내부에서 컬렉션을 반복하는 로직과
     * 각 요소에 적용할 동작을 분리하였다.
     * 원하는 필터링 방식으로
     * ApplePredicate를 구현하여 메서드를 호출하면 된다!
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }


    static class AppleRedAndHeavyPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return Color.RED.equals(apple.getColor()) && apple.getWeight()>150;
        }
    }

    List<Apple> redAndHeavyApples = filterApples(new ArrayList<>(), new AppleRedAndHeavyPredicate());

    /**
     * 자바에서 메서드는 객체만 인수로 받으므로 test메서드를 ApplePredicate객체로 감싸서 전달해야 한다.
     * 매번 ApplePredicate의 구현체를 정의하고 메서드를 오버라이딩하고
     * ApplePredicate의 인스턴스를 만들어서 함수로 넘기는 것은 굉장히 번거롭다.
     */

    /**
     * 다섯 번째 시도 : 익명 클래스 사용
     * 익명클래스를 사용하여 클래스 선언과 인스턴스화를 한번에 하였다.
     * 하지만 여전히 코드는 길다...
     */
    List<Apple> redApples = filterApples(new ArrayList<>(), new ApplePredicate() {
        @Override
        public boolean test(Apple apple) {
            return Color.RED.equals(apple.getColor());
        }
    });

    /**
     * 여섯 번째 시도 : 람다 표현식 사용
     * 익명 클래스를 선언하는 번거로움을 람다 표현식으로 해결하였다.
     */
    List<Apple> greenApples = filterApples(new ArrayList<>(), (Apple apple)->Color.GREEN.equals(apple.getColor()));

}

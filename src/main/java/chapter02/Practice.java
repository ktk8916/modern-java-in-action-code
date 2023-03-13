package chapter02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Practice {


    /**
     * 사과의 무게순으로 정렬하는 함수
     * Comparator를 익명클래스를 사용해서 재정의
     */
    public static List<Apple> sortByWeightV1(List<Apple> inventory){
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight()-o2.getWeight();
            }
        });
        return inventory;
    }

    /**
     * 위 코드를 람다식으로 변경하였다.
     */
    public static List<Apple> sortByWeightV2(List<Apple> inventory){
        inventory.sort((Apple a1, Apple a2)-> a1.getWeight()-a2.getWeight());
        return inventory;
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(Color.RED, 200), new Apple(Color.RED, 150));
        sortByWeightV1(inventory);
        sortByWeightV2(inventory);
        for (Apple apple : inventory) {
            System.out.println(apple.getWeight());
        }
    }
}

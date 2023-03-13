package chapter02;

import java.util.ArrayList;
import java.util.List;

public class FilteringApplesV1 {

    /**
     * 첫 번째 시도 : 녹색 사과 필터링
     * 다양한 색으로 필터링을 원할 때
     * filterGreenApples, filterRedApples.... 등을 생각할 수 있으나
     * 모든 요구사항에 대해서 사실상 대처 불가능
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(Color.GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 두 번째 시도 : 색을 파라미터화
     * 색을 파라미터화 해서 모든 색에 대해서 대응할 수 있는 코드
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(color.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 필터링 조건에 무게를 추가한 경우
     * 무게 파라미터도 메서드에 추가할 수 있지만,
     * 색깔과 무게로 필터링 하는 경우
     * 탐색 과정이 겹침
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(apple.getWeight()>weight){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 세 번째 시도 : 가능한 모든 속성으로 필터링
     * 색, 무게를 가리키는 flag를 놓고 if문으로 처리..
     * 메서드 사용 시 true와 false의 의미를 명확히 알 수 없고,
     * 다음 요구사항에 유연하게 대처할 수 없음
     * 이런 코드는 결국 filter 메서드가 쪼개지거나, 정말 비대한 filter 메서드가 될 것
     */
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)){
                result.add(apple);
            }
        }
        return result;
    }

}

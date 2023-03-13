package chapter02;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Quiz2_1 {

    interface AppleFormatter{
        String format(Apple apple);
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter f){
        for (Apple apple : inventory) {
            String out = f.format(apple);
            System.out.println(out);
        }
    }

    static class AppleIntroduction implements AppleFormatter{

        @Override
        public String format(Apple apple) {
            return "Color : " + apple.getColor() + " Weight : " + apple.getWeight();
        }
    }

    public static void main(String[] args) {
        prettyPrintApple(
                Arrays.asList(
                        new Apple(Color.GREEN, 150),
                        new Apple(Color.RED, 200)),
                new AppleIntroduction());
    }
}

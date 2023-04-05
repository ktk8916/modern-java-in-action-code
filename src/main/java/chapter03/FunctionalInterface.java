package chapter03;

public class FunctionalInterface {

    /**
     * 함수형 인터페이스 : 오직 하나의 추상 메서드만 가지고 있는 인터페이스
     * 2장에서 만든 Predicate와 자바의 Comparator, Runnable등이 있다
     *
     * 람다 표현식으로 함수형 인터페이스의 추상 메서드 구현을 직접 전달
     *
     * 전체 표현식을 함수형 인터페이스의 인스턴스로 취급
     */


    /**
     * Runnable이 함수형 인터페이스여서 람다표현식 전달 가능
     *
     */
    public static void process(Runnable r){
        r.run();
    }

    public static void main(String[] args) {

        Runnable r1 = () -> System.out.println("람다 표현식1");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 클래스로 구현");
            }
        };

        process(r1);
        process(r2);
        process(()->System.out.println("람다 표현식2"));
    }
}

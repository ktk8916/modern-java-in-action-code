package chapter02;

/**
 * 인수를 받아 참, 거짓을 반환하는 함수를 predicate라 한다.
 * 사과의 선택 조건을 결정하는 인터페이스
 * 사과를 어떻게 분류할 것인지는 구현에 맡기자.
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}

package demo;

import io.vavr.control.Try;

public class MathUtils {

    public static Integer divide(Integer x, Integer y) {
        return x / y;
    }

    public static Try<Integer> divideWithTry(Integer x, Integer y) {
        return Try.of(() -> x / y);
    }
}

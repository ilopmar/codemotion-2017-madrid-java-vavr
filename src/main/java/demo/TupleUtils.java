package demo;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class TupleUtils {

    static Tuple2<String, Integer> someUserInfo(String name, Integer age) {
        return Tuple.of(name.toUpperCase(), age - 10);
    }
}

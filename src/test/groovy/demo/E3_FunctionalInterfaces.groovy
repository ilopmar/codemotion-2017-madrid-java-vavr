package demo

import io.vavr.Function1
import io.vavr.Function2
import io.vavr.Function4
import spock.lang.Specification

import java.util.function.BiFunction
import java.util.function.Function

class E3_FunctionalInterfaces extends Specification {

    void 'Java 8 Function'() {
        given:
            Function<Integer, Integer> square = { Integer num -> num * num }

        expect:
            square.apply(5) == 25
    }

    void 'Java 8 BiFunction'() {
        given:
            BiFunction<Integer, Integer, Integer> sum = { Integer num1, Integer num2 -> num1 + num2 }

        expect:
            sum.apply(5, 7) == 12
    }

    void 'Java 8 Composing functions'() {
        given:
            Function<Integer, Integer> square = { Integer num -> num * num }
            Function<Integer, Integer> plus2 = { Integer num -> num + 2 }

        expect:
            square
                .andThen(plus2)
                .apply(10) == 102
    }

    void 'Vavr Function'() {
        given:
            Function1<Integer, Integer> square = { Integer num -> num * num }
            Function1<Integer, Integer> plus2 = { Integer num -> num + 2 }

        expect:
            square
                .andThen(plus2)
                .apply(10) == 102
    }

    void 'Vavr Function4'() {
        given:
            Function4<String, String, Integer, String, Integer> stringsSize = { a, b, c, d ->
                a.size() + b.size() + c.toString().size() + d.size()
            }

        expect:
            stringsSize.apply('foo', 'bar', 10, 'qux') == 11
    }

    void 'Vavr Function curryfication'() {
        when:
            Function2<Integer, Integer, Integer> sum = { Integer a, Integer b -> a + b }
        then:
            sum.apply(1, 2) == 3

        when:
            Function1<Integer, Integer> add2 = sum.curried().apply(2)
        then:
            add2.apply(5) == 7
    }
}

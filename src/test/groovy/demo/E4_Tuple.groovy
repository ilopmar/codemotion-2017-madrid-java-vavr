package demo

import io.vavr.Tuple2
import spock.lang.Specification

class E4_Tuple extends Specification {

    void 'Get some data from a Tuple'() {
        given:
            Tuple2<String, Integer> userInfo = TupleUtils.someUserInfo('Iván', 37)

        expect:
            userInfo._1() == 'IVÁN'
            userInfo._2() == 27
    }

    void 'Some methods on Tuple'() {
        given:
            Tuple2<String, Integer> userInfo = TupleUtils.someUserInfo('Iván', 37)

//            Function2<String, Integer, String> concatenateInfo = Function2.of { name, age -> "${name}-${age}" }

        expect:
            userInfo.map1 { name -> name.toLowerCase().reverse() }._1() == 'návi'
            userInfo.apply { name, age -> "${name}-${age}" } == 'IVÁN-27'
//            userInfo.apply(concatenateInfo) == 'IVÁN-27'
    }

    void 'Compare tuples'() {
        given:
            def point1 = new Tuple2<Integer, Integer>(10, 5)
            def point2 = new Tuple2<Integer, Integer>(10, 7)
            def point3 = new Tuple2<Integer, Integer>(11, 5)
            def point4 = new Tuple2<Integer, Integer>(11, 5)

        expect:
            point1 < point2
            point3 > point2
            point3 == point4
    }

}

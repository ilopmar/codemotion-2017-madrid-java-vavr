package demo

import io.vavr.collection.List
import spock.lang.Specification

class E5_Collections extends Specification {

    void 'Vavr List'() {
        given:
            List<Integer> list = List.of(1, 2, 3, 4)

        expect:
            list.sum() == 10
    }

    void 'List and Option'() {
        given:
            List<Integer> list = List.of() // List.empty()

        expect:
            list.tailOption().getOrElse(List.of(3, 2, 1)) == List.of(3, 2, 1)
            list.tailOption().getOrElse(List.of(3, 2, 1)).toJavaList() == [3, 2, 1]
    }

    void 'Methods on List'() {
        given:
            List<Integer> list = List.of(1, 2, 3, 4, 4, 4)

        expect:
            list.distinct() == List.of(1, 2, 3, 4)

        and:
            list.size() == 6
            List<Integer> list2 = list.append(5)
            list2.size() == 7
            list.size() == 6
    }

    // Queue
    // Map
}

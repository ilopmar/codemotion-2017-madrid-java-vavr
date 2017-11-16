package demo

import io.vavr.control.Try
import io.vavr.control.Try.Success
import spock.lang.Specification

class E2_Try extends Specification {

    void 'Traditional try-catch'() {
        expect:
            MathUtils.divide(40, 10) == 4
    }

    void 'Using Vavr Try'() {
        when:
            Try<Integer> result = MathUtils.divideWithTry(40, 10)

        then:
            result instanceof Success
            result.get() == 4
//            result instanceof Failure
//            result.isFailure()
//            !result.isSuccess()
//            println "--> " + result.cause

//        and:
//            result.getOrElse(-1) == -1

    }

    void 'Transforming the result'() {
        when:
            Try<Integer> result = MathUtils.divideWithTry(40, 10)

        then:
            result
                .map { n -> n * 2 }
                .getOrElse(0) == 0
    }

    void 'Recover from error'() {
        when:
            Try<Integer> result = MathUtils.divideWithTry(40, 10)

        then:
            result
                .map { n -> this.saveInDatabase(n) }
                .recover { e -> this.emailError(e) }
    }

    private void saveInDatabase(Integer number) {
        println "Number ${number} saved correctly"
    }

    private void emailError(Throwable t) {
        println "There was an error: ${t}"
    }
}

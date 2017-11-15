package demo

import io.vavr.control.Option
import io.vavr.control.Option.None
import io.vavr.control.Option.Some
import spock.lang.Specification

class E1_Option extends Specification {

    void 'Java 8 Optional of null'() {
        when:
            Optional.of(null)

        then:
            thrown(NullPointerException)
    }

    void 'Vavr Option of null'() {
        when:
            def option = Option.of('Hello Codemotion')

        then:
            notThrown NullPointerException
            option instanceof Some
            option.toString() == 'Some(Hello Codemotion)'
    }

    void 'Convert Optional to Option'() {
        given:
            def java8Optional = Optional.of('Hello World')

        when:
            def vavrOption = Option.ofOptional(java8Optional)

        then:
            vavrOption instanceof Some
    }

    void 'Use map with an Option with value'() {
        given:
            Option<String> optionName = UserService
                .findUserByName('Iván')
                .map { u -> u.name.toUpperCase() }

        expect:
            optionName.get() == 'IVÁN'
    }

    void 'Use map with an Option without value'() {
        given:
            Option<String> optionName = UserService
                .findUserByName('')
                .map { u -> u.name.toUpperCase() }

        expect:
            optionName instanceof None
    }

    void 'Get an alternative value'() {
        given:
            Option<String> optionName = UserService
                .findUserByName('')
                .map { u -> u.name.toUpperCase() }
                .orElse(Option.of('Default Value'))

        expect:
            optionName.get() == 'Default Value'
    }

    void 'Get an alternative value (II)'() {
        given:
            Option<String> optionName = UserService
                .findUserByName('Iván')
                .map { u -> u.name.toUpperCase() }

        expect:
            optionName.getOrElse('Default Value') == 'Default Value'
    }
}

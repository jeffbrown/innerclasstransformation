package demo

import spock.lang.Specification

class SomeInnerClassSpec extends Specification {

    void 'test magic number'() {
        when:
        def obj = new Hello.SomeInnerClass()

        then:
        42 == obj.magicNumber
    }
}

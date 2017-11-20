package demo;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Predicates.isIn;

public class StringUtils {

    static String convertIf(Integer i) {
        String output;
        if (i == 0) {
            output = "zero";
        } else if (i == 1) {
            output = "one";
        } else if (i == 2) {
            output = "two";
        } else if (i == 3) {
            output = "three";
        } else {
            output = "unknown";
        }

        return output;
    }

    static String convertSwitch(Integer i) {
        String output;
        switch (i) {
            case 0:
                output = "zero";
                break;
            case 1:
                output = "one";
                break;
            case 2:
                output = "two";
                break;
            case 3:
                output = "three";
                break;
            default:
                output = "unknown";
                break;
        }

        return output;
    }

    static String convert(Integer i) {
        return Match(i).of(
            Case($(0), "zero"),
            Case($(1), "one"),
            Case($(2), "two"),
            Case($(3), "three"),
//            Case($(x ->  x > 2), () -> "greater than 2"),
            Case($(), "unknown")
        );
    }

    static String parseArgs(String arg) {
        return Match(arg).of(
            Case($(isIn("-h", "--help")), "Help"),
            Case($(isIn("-v", "--version")), "Version")
        );
    }
}

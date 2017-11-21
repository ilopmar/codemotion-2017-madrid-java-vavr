package demo;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;

public class UserValidator {

    private static final String ERROR_NAME_MSG = "Invalid characters in name: ";
    private static final String ERROR_AGE_MSG = "Age must be at least 0";

    Validation<Seq<String>, User> validate(String name, int age) {
        return Validation
            .combine(validateName(name), validateAge(age))
            .ap((n, a) -> new User(n, a));
    }

    private static Validation<String, String> validateName(String name) {
        String invalidChars = name.replaceAll("[a-zA-Z áéíóúÁÉÍÓÚ]", "");

        return invalidChars.isEmpty() ?
            Validation.valid(name) :
            Validation.invalid(ERROR_NAME_MSG + invalidChars);
    }

    private static Validation<String, Integer> validateAge(int age) {
        return age < 0 ?
            Validation.invalid(ERROR_AGE_MSG) :
            Validation.valid(age);
    }
}

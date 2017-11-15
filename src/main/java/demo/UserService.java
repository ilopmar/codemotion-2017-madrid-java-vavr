package demo;

import io.vavr.control.Option;

public class UserService {

    static Option<User> findUserByName(String name) {
        return name.isEmpty() ?
            Option.none() :
            Option.of(new User(name, 18));
    }
}

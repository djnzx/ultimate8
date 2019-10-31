package java8.optional;

import java.util.Optional;

public class UserDto {
    private final String name;
    private final Optional<String> extra;

    public UserDto(String name) {
        this.name = name;
        this.extra = Optional.empty();
    }

    public UserDto(String name, String extra) {
        this.name = name;
        this.extra = Optional.of(extra);
    }

    public static void main(String[] args) {
        UserDto u1 = new UserDto("Alex");
        UserDto u2 = new UserDto("Dima", "hello");
    }

}

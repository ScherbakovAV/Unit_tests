package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    /**
     * 3.6. Нужно написать класс User (пользователь) с методом аутентификации по логину и паролю,
     * (В метод передаются логин и пароль, метод возвращает true, если пароль и логин совпадают, иначе - false)
     */
    private User user;
    @BeforeEach
    void start() {
        user = new User("qew", "aaa");
    }

    @Test
    void userCreationSuccess() {
        assertTrue(user.authMethod("qew", "aaa"));
    }
    @Test
    void userCreationFalse() {
        assertFalse(user.authMethod("dfff", "sdfff"));
    }

}
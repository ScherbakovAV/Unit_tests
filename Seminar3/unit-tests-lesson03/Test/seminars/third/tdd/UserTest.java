package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    /**
     * 3.6. Нужно написать класс User (пользователь) с методом аутентификации по логину и паролю,
     * (В метод передаются логин и пароль, метод возвращает true, если пароль и логин совпадают, иначе - false)
     */
    private NewUser user;
    @BeforeEach
    void start() {
        user = new NewUser("qew", "aaa");
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
package tdd;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static tdd.UserRepository.*;

class UserRepositoryTest {
    @Test
    void getUserRepoTest() {
        assertThat(getUserRepo()).isEqualTo(userRepo);
    }
    @Test
    void setUserRepoTest() {
        ArrayList<User> userRepo = new ArrayList<>();
        ArrayList<User> testRepo = new ArrayList<>();
        setUserRepo(testRepo);
        assertThat(userRepo).isEqualTo(testRepo);
    }

    @Test
    void isAuthenticateTrueTest() {
        User usr = new User("David", "1254");
        assertTrue(isAuthenticate(usr));
    }

    @Test
    void isAuthenticateFalseTest() {
        User usr = new User("", "");
        assertFalse(isAuthenticate(usr));
    }

    @Test
    void addUserIfAuthTest() {
        ArrayList<User> userRepo = getUserRepo();
        User usr = new User("Anna", "124");
        addUser(usr);
        assertThat(userRepo.get(0)).isEqualTo(usr);
        userRepo.clear();
    }

    @Test
    void addUserIfNotAuthTest() {
        ArrayList<User> userRepo = new ArrayList<>();
        User usr = new User("", "");
        addUser(usr);
        assertThat(userRepo.size()).isEqualTo(0);
    }

    @Test
    void addAdminRightsIfNotExistTest() {
        User usr = new User("Amy", "alaska!");
        addAdminRights(usr);
        assertTrue(usr.adminRights);
    }

    @Test
    void addAdminRightsIfExistTest() {
        User usr = new User("Amy", "alaska!");
        usr.adminRights = true;
        String expectedMessage = "Пользователь " + usr.login + " уже имеет административные права";
        RuntimeException exception = assertThrows(RuntimeException.class, () -> addAdminRights(usr));
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void deleteNotAdminsTest() {
        ArrayList<User> userRepo = getUserRepo();

        User usr1 = new User("Ben", "Neb");
        usr1.adminRights = true;
        userRepo.add(usr1);

        User usr2 = new User("Timmy", "Nebulae123");
        userRepo.add(usr2);

        deleteNotAdmins();

        assertTrue(userRepo.contains(usr1));
        assertFalse(userRepo.contains(usr2));
        userRepo.clear();
    }

    @Test
    void printRepoTest() {
        ArrayList<User> userRepo = getUserRepo();

        User usr1 = new User("Zeep", "656");
        userRepo.add(usr1);
        User usr2 = new User("Carl", "AaA");
        userRepo.add(usr2);

        String expResult = """
                Login: Zeep, password: 656, admin_rights: нет
                Login: Carl, password: AaA, admin_rights: нет
                """;

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        printRepo();
        String actResult = output.toString();

        assertEquals(expResult, actResult);
    }
}
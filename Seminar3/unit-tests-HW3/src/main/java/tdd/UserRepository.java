// 4. Добавить класс UserRepository (Хранилище для работы с пользователями).
//    В метод addUser передаётся пользователь. Если он зарегистрирован (isAuthenticate возвращает true),
//    то он попадает в список пользователей системы.
// 5. Добавить возможность наделять админскими правами пользователя (User),
//    добавить функцию в UserRepository (TDD), которая будет разлогинивать всех пользователей, кроме админов.
package tdd;

import java.util.ArrayList;

public class UserRepository {
    static ArrayList<User> userRepo = new ArrayList<>();

    //public UserRepository() {
    //}

    public static ArrayList<User> getUserRepo() {
        return userRepo;
    }

    public static void setUserRepo(ArrayList<User> newUserRepo) {
        UserRepository.userRepo = newUserRepo;
    }

    public static boolean isAuthenticate(User user) { // заглушка
        if (!user.login.isEmpty() && !user.password.isEmpty()) return true;
        return false;
    }

    public static void addUser(User user) {
        if (isAuthenticate(user)) userRepo.add(user);
    }

    public static void addAdminRights(User user) {
        if (!user.adminRights) user.adminRights = true;
        else throw new RuntimeException("Пользователь " + user.login + " уже имеет административные права");
    }

    public static void deleteNotAdmins() {
        for (int i = 0; i < userRepo.size(); i++) {
            if (!userRepo.get(i).adminRights) {
                userRepo.remove(userRepo.get(i));
                i--;
            }
        }
    }

    public static void printRepo() {
        userRepo.forEach((k) -> System.out.printf("Login: %s, password: %s, admin_rights: %s\n",
                                k.login, k.password, k.adminRights.equals(true)?"да":"нет"));
    }
}
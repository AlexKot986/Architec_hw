package seminar04.ClientApplication;


import seminar04.Core.UserProvider;
import seminar04.Models.User;

/**
 * Класс аутентификации пользователя
 */
public class Authentication {
    /**
     * Метод производит аутентификацию
     *
     * @param userProvider
     * @param login
     * @param passHash
     * @return
     */




    public static User authentication(UserProvider userProvider, String login, int passHash) {
        var client = userProvider.getClientByName(login);
        if (client.getHashPassword() == passHash) {
            return client;
        } else {
            throw new RuntimeException("Authentication fail");
        }
    }
}

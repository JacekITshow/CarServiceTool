package pl.itshow.java.repository;

import pl.itshow.java.dto.UserDto;

public interface UserDao {

    void createUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void updateUserPassword(int userId, String password);

    void updateUserEmail(int userId, String email);

    void deleteUser(int userId);
}

package pl.itshow.java.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.itshow.java.dto.UserDto;
import pl.itshow.java.entity.user.UserPo;

@Service
@RequiredArgsConstructor
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

    private UserRepository userRepository;

    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDto userDto) {
//        String encryptedPassowrd = new BCryptPasswordEncoder().encode(userDto.getPassword());
        final UserPo user = UserPo.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .gender(userDto.getGender())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .description(userDto.getDescription())
                .build();
        try {
            userRepository.save(user);
        } catch (Exception e) {
            logger.error("Create user failure with data: " + userDto.toString(), e);
            throw new RuntimeException("Create user failure");
        }
    }

    @Override
    public void updateUser(UserDto userDto) {
        UserPo user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("User with ID: " + userDto.getId() + " doesn't not exists"));

        UserPo updatedUser = mapUserDtoToUserEntity(user, userDto);
        try {
            userRepository.save(updatedUser);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateUserPassword(int userId, String password) {
        try {
            UserPo user = userRepository.findById(userId);
            logger.debug("User finded by id: " + userId + " for update password.");
            user.setPassword(password);
            userRepository.save(user);
            logger.debug("Update password for user with id: " + userId + " completed successfully.");
        } catch (Exception e) {
            logger.error("Update password for user with id: " + userId + "completed failure.");
            throw new RuntimeException("Update password for user with id: " + userId + "completed failure.");
        }
    }

    @Override
    public void updateUserEmail(int userId, String email) {
        try {
            UserPo user = userRepository.findById(userId);
            logger.debug("User finded by id: " + userId + " for update email.");
            user.setEmail(email);
            userRepository.save(user);
            logger.debug("Update email for user with id: " + userId + " completed successfully.");
        } catch (Exception e) {
            logger.error("Update email for user with id: " + userId + "completed failure.");
            throw new RuntimeException("Update email for user with id: " + userId + "completed failure.");
        }
    }

    @Override
    public void deleteUser(int userId) {
        try {
            UserPo user = userRepository.findById(userId);
            logger.debug("User finded by id: " + userId + " for delete user.");
            userRepository.delete(user);
            logger.debug("Delete user with id: " + userId + " completed successfully.");
        } catch (Exception e) {
            logger.error("Delete user with id: " + userId + "completed failure.");
            throw new RuntimeException("Delete user with id: " + userId + "completed failure.");
        }
    }

    private UserPo mapUserDtoToUserEntity(UserPo user, UserDto userDto) {
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setBirthdate(userDto.getBirthdate());
        user.setDescription(userDto.getDescription());

        return user;
    }
}

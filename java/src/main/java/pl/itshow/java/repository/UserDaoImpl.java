package pl.itshow.java.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.itshow.java.dto.UserDto;
import pl.itshow.java.entity.User;

@Service
@RequiredArgsConstructor
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

    private UserRepository userRepository;

    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDto userDto) {
        final User user = User.builder()
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
            logger.error("Wystąpił błąd", e);
            throw new RuntimeException("Operacja nie powiodła się");
        }
    }

    @Override
    public void updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("User with ID: " + userDto.getId() + " doesn't not exists"));

        User updatedUser = mapUserDtoToUserEntity(user, userDto);
        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User with ID: " + userId + " doesn't not exists"));
        userRepository.delete(user);
    }

    private User mapUserDtoToUserEntity (User user, UserDto userDto) {
        user.setBirthdate(userDto.getBirthdate());
        user.setGender(userDto.getGender());
        user.setDescription(userDto.getDescription());

        return user;
    }
}

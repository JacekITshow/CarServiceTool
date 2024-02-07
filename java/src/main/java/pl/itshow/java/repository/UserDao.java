package pl.itshow.java.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.itshow.java.dto.UserDto;
import pl.itshow.java.entity.User;

@Service
@RequiredArgsConstructor
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    private UserRepository userRepository;

    public void createUser(UserDto user) {

    }

    public void register(UserDto UserDto) {
//        final User user = User.builder()
//                .login(userDto)
//                .build();
//        studentRepository.save(student);
//        studentMapper.toDto(student);
    }

    public void updateUser (UserDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("User with ID: " + userDto.getId() + " doesn't not exists"));

        userRepository.save(user);
    }

    public void deleteUser (long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User with ID: " + userId + " doesn't not exists"));
        userRepository.delete(user);
    }
}

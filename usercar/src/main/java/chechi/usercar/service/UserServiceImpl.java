package chechi.usercar.service;

import chechi.usercar.converter.UserConverter;
import chechi.usercar.dto.UserRequest;
import chechi.usercar.entity.User;
import chechi.usercar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserConverter userConverter, UserRepository userRepository) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> { throw new EmptyStackException(); });
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);

    }

    @Override
    public void createUser(UserRequest request) {
        userConverter.buildUser(request);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}

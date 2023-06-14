package chechi.usercar.service;

import chechi.usercar.dto.UserRequest;
import chechi.usercar.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers ();
    User findUserById (int id);
    void deleteUser (int id);
    void createUser (UserRequest request);
    User updateUser (User user);
}

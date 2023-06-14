package chechi.usercar.converter;

import chechi.usercar.dto.UserRequest;
import chechi.usercar.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public void buildUser (UserRequest request) {

        User.builder()
                .firstName(request.getFirstName())
                .build();

    }
}

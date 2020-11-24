package boot.bootdemo.service;

import boot.bootdemo.model.User;
import java.util.List;

public interface UserService {
    void saveAll(List<User> users);
}

package boot.bootdemo.service.impl;

import boot.bootdemo.model.User;
import boot.bootdemo.repository.UserRepository;
import boot.bootdemo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }
}

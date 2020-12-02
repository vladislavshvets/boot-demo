package boot.bootdemo.service.impl;

import boot.bootdemo.model.User;
import boot.bootdemo.model.dto.UserResponseDto;
import boot.bootdemo.repository.UserRepository;
import boot.bootdemo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public List<UserResponseDto> findMostActive(int quantity) {
        return userRepository.findMostActive(PageRequest.of(0, quantity));
    }
}

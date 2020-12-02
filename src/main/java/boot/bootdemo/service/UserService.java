package boot.bootdemo.service;

import boot.bootdemo.model.User;
import boot.bootdemo.model.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    void saveAll(List<User> users);

    List<UserResponseDto> findMostActive(int quantity);
}

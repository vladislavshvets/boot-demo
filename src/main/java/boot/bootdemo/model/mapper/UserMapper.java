package boot.bootdemo.model.mapper;

import boot.bootdemo.model.Role;
import boot.bootdemo.model.User;
import boot.bootdemo.model.dto.ReviewDto;
import java.util.Set;

import boot.bootdemo.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private static final String DEFAULT_PASSWORD = "1111";
    public User mapReviewDtoToUser(ReviewDto dto) {
        return User.builder()
                .profileName(dto.getProfileName())
                .internalUserId(dto.getUserId())
                .password(DEFAULT_PASSWORD)
                .build();
    }

    public UserResponseDto mapUserToResponseDto(User user) {
        return UserResponseDto.builder()
                .profileName(user.getProfileName())
                .build();
    }
}

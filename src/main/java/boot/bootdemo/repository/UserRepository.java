package boot.bootdemo.repository;

import boot.bootdemo.model.User;
import boot.bootdemo.model.dto.UserResponseDto;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT new boot.bootdemo.model.dto.UserResponseDto(u.profileName) "
            + "FROM Review r "
            + "JOIN r.user u "
            + "GROUP BY u.id "
            + "ORDER BY COUNT(r) DESC, u.profileName")
    List<UserResponseDto> findMostActive(Pageable pageable);
}

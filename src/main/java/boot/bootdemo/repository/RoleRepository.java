package boot.bootdemo.repository;

import boot.bootdemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository
        extends JpaRepository<Role, Long> {
    Role findByRoleName(Role.RoleName roleName);
}

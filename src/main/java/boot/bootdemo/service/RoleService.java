package boot.bootdemo.service;

import boot.bootdemo.model.Role;
import boot.bootdemo.model.RoleName;

import java.util.List;

public interface RoleService {
    List<Role> saveAll(List<Role> roles);

    Role findByName(RoleName roleName);
}

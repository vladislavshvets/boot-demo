package boot.bootdemo.service;

import boot.bootdemo.model.Role;

public interface RoleService {
    void save(Role role);

    Role findByName(String roleName);
}

package boot.bootdemo.service.impl;

import boot.bootdemo.model.Role;
import boot.bootdemo.repository.RoleRepository;
import boot.bootdemo.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role findByName(String roleName) {
        return roleRepository.findByRoleName(Role.of(roleName).getRoleName());
    }
}

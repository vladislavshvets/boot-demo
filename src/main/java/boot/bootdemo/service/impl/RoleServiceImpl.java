package boot.bootdemo.service.impl;

import boot.bootdemo.model.Role;
import boot.bootdemo.model.RoleName;
import boot.bootdemo.repository.RoleRepository;
import boot.bootdemo.service.RoleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> saveAll(List<Role> roles) {
        return roleRepository.saveAll(roles);}


    @Override
    public Role findByName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}

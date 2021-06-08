package edu.miu.seniorproject.eBicycleRental.serviceimplementation;

import edu.miu.seniorproject.eBicycleRental.model.Role;
import edu.miu.seniorproject.eBicycleRental.repository.IRoleRepository;
import edu.miu.seniorproject.eBicycleRental.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImp implements RoleService {
	
	private IRoleRepository roleRepository;
	
	@Autowired
	public RoleServiceImp(IRoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> findAll() {
		
		return roleRepository.findAll();
	}

	@Override
	public Role save(Role role) {
		
		return roleRepository.save(role);
	}

	@Override
	public Role findById(Long rId) {
		
		return roleRepository.findById(rId).orElse(null);
	}

	@Override
	public void delete(Long rId) {
		roleRepository.deleteById(rId);
		
	}


}
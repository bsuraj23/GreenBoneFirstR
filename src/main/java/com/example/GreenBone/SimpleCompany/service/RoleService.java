package com.example.GreenBone.SimpleCompany.service;

import employeeManagement.entity.Role;

import java.util.List;

public interface RoleService {

	public List<Role> showRoles();
	
	public void saveRole(Role role);
	
	public Role findRoleById(Integer id);
	
	public void deleteRole(Role role);
}
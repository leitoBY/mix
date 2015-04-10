package net.mix.spring.service;

import java.util.List;

import net.mix.spring.dto.DepartmentDTO;

public interface DepartmentService {
	
	public void saveDep(DepartmentDTO departmentDTO);
    public void editDep(DepartmentDTO departmentDTO);
    public List<DepartmentDTO> listDeps();
    public DepartmentDTO getDep(int department_id);
    public void deleteDep(int department_id);
    public void countSalary(DepartmentDTO departmentDTO);
    

}

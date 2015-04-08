package net.mix.spring.service;

import java.util.List;

import net.mix.spring.model.Department;;

public interface DepartmentService {
	
	public void addDep(Department dep);
    public void updateDep(Department dep);
    public List<Department> listDeps();
    public Department getDepbyId(int dept_id);
    public void removeDep(int dept_id);

}

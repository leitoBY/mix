package net.mix.spring.service;

import java.util.List;

import net.mix.spring.dao.DepartmentDAO;
import net.mix.spring.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDAO departmentDAO;
 
    @Override
    @Transactional
    public void addDep(Department dep) {
        this.departmentDAO.addDep(dep);
    }
 
    @Override
    @Transactional
    public void updateDep(Department dep) {
        this.departmentDAO.updateDep(dep);
    }
 
    @Override
    @Transactional
    public List<Department> listDeps() {
        return this.departmentDAO.listDeps();
    }
 
    @Override
    @Transactional
    public Department getDepbyId(int dept_id) {
        return this.departmentDAO.getDepbyId(dept_id);
    }
 
    @Override
    @Transactional
    public void removeDep(int dept_id) {
        this.departmentDAO.removeDep(dept_id);
    }
	

}

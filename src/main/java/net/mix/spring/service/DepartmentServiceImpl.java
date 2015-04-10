package net.mix.spring.service;

import java.util.List;

import net.mix.spring.dao.DepartmentDAO;
import net.mix.spring.dto.DepartmentDTO;
import net.mix.spring.dto.DepartmentDTOFactory;
import net.mix.spring.model.Department;
import net.mix.spring.model.Worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	DepartmentDTOFactory departmentFactory = new DepartmentDTOFactory();
 
    @Override
    @Transactional
    public void saveDep(DepartmentDTO departmentDTO) {
       departmentDAO.addDep(departmentFactory.createModel(departmentDTO));
    }
 
    @Override
    @Transactional
    public void editDep(DepartmentDTO departmnetDTO) {
    	departmentDAO.updateDep(departmentFactory.createModel(departmnetDTO));
    }
 
    @Override
    @Transactional
    public List<DepartmentDTO> listDeps() {
    	
    	List<Department> departments = departmentDAO.listDeps();
        return departmentFactory.createDTOs(departments);
    }
 
    @Override
    @Transactional
    public DepartmentDTO getDep(int department_id) {
    	Department department = departmentDAO.getDepbyId(department_id);
        return departmentFactory.createDTO(department);
    }
 
    @Override
    @Transactional
    public void deleteDep(int department_id) {
        this.departmentDAO.removeDep(department_id);
    }

	@Override
	@Transactional
	public void countSalary(DepartmentDTO departmentDTO) {
		List<Worker> worList = departmentDTO.getlWorkers();
		Double avgSalary = 0D;
		Double sum = 0D;
		if(!worList.isEmpty()) {
			for(Worker  w : worList) {
				sum =sum + w.getSalary();
				
			}
			avgSalary = sum/worList.size();
		}
		else {
		avgSalary = null;
		}
		departmentDTO.setAvg_salary(avgSalary);
		this.departmentDAO.updateDep(departmentFactory.createModel(departmentDTO));
	}



}

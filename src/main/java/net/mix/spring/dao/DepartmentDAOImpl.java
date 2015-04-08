package net.mix.spring.dao;

import java.util.List;

import net.mix.spring.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(WorkerDAOImpl.class);
	 
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void addDep(Department dep) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(dep);
        logger.info("Department saved successfully, Department Details="+dep);
    }
 
    @Override
    public void updateDep(Department dep) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(dep);
        logger.info("Department updated successfully, Department Details="+dep);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Department> listDeps() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Department> depsList = session.createQuery("from Department").list();
        for(Department dep : depsList){
            logger.info("Department List::"+dep);
        }
        return depsList;
    }
 
    @Override
    public Department getDepbyId(int dept_id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Department dep = (Department) session.load(Department.class, new Integer(dept_id));
        logger.info("epartment loaded successfully, Department details="+dep);
        return dep;
    }
 
    @Override
    public void removeDep(int dept_id) {
        Session session = this.sessionFactory.getCurrentSession();
        Department dep = (Department) session.load(Department.class, new Integer(dept_id));
        if(null != dep){
            session.delete(dep);
        }
        logger.info("Department deleted successfully, Department details="+dep);
    }

}

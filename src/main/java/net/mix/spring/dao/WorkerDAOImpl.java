package net.mix.spring.dao;
 
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
 
import net.mix.spring.model.Worker;
 
@Repository
public class WorkerDAOImpl implements WorkerDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(WorkerDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addWorker(Worker w) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(w);
        logger.info("Worker saved successfully, Worker Details="+w);
    }
 
    @Override
    public void updateWorker(Worker w) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(w);
        logger.info("Worker updated successfully, Worker Details="+w);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Worker> listWorkers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Worker> workersList = session.createQuery("from Worker").list();
        for(Worker w : workersList){
            logger.info("Worker List::"+w);
        }
        return workersList;
    }
 
    @Override
    public Worker getWorkerById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Worker w = (Worker) session.load(Worker.class, new Integer(id));
        logger.info("Worker loaded successfully, Worker details="+w);
        return w;
    }
 
    @Override
    public void removeWorker(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Worker w = (Worker) session.load(Worker.class, new Integer(id));
        if(null != w){
            session.delete(w);
        }
        logger.info("Worker deleted successfully, Worker details="+w);
    }
 
}
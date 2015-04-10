package net.mix.spring.service;
 
import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

import net.mix.spring.dao.WorkerDAO;
import net.mix.spring.model.Worker;
 
@Service
public class WorkerServiceImpl implements WorkerService {
     
    @Autowired
	private WorkerDAO workerDAO;
 
    /*public void setWorkerDAO(WorkerDAO workerDAO) {
        this.workerDAO = workerDAO;
    }  */
 
    @Override
    @Transactional
    public void addWorker(Worker w) {
        this.workerDAO.addWorker(w);
    }
 
    @Override
    @Transactional
    public void updateWorker(Worker w) {
        this.workerDAO.updateWorker(w);
    }
 
    @Override
    @Transactional
    public List<Worker> listWorkers() {
        return this.workerDAO.listWorkers();
    }
 
    @Override
    @Transactional
    public Worker getWorkerById(int id) {
        return this.workerDAO.getWorkerById(id);
    }
 
    @Override
    @Transactional
    public void removeWorker(int id) {
        this.workerDAO.removeWorker(id);
    }
 
}
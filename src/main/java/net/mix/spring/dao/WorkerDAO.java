package net.mix.spring.dao;
 
import java.util.List;
 
import net.mix.spring.model.Worker;
 
public interface WorkerDAO {
 
    public void addWorker(Worker w);
    public void updateWorker(Worker w);
    public List<Worker> listWorkers();
    public Worker getWorkerById(int id);
    public void removeWorker(int id);
}
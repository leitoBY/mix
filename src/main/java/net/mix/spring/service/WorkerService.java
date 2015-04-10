package net.mix.spring.service;
 
import java.util.List;

import net.mix.spring.dto.WorkerDTO;
 
public interface WorkerService {
 
    public void saveWorker(WorkerDTO workerDTO);
    public void editWorker(WorkerDTO workerDTO);
    public List<WorkerDTO> listWorkers();
    public WorkerDTO getWorker(int workerId);
    public void deleteWorker(int workerId);
     
}
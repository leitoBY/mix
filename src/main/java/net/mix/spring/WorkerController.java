package net.mix.spring;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import net.mix.spring.model.Worker;
import net.mix.spring.service.WorkerService;
 
@Controller
public class WorkerController {
     
    private WorkerService workerService;
     
    @Autowired(required=true)
    @Qualifier(value="workerService")
    public void setWorkerService(WorkerService ws){
        this.workerService = ws;
    }
     
    @RequestMapping(value = "/workers", method = RequestMethod.GET)
    public String listWorkers(Model model) {
        model.addAttribute("worker", new Worker());
        model.addAttribute("listWorkers", this.workerService.listWorkers());
        return "worker";
    }
     
    //For add and update person both
    @RequestMapping(value= "/worker/add", method = RequestMethod.POST)
    public String addWorker(@ModelAttribute("worker") Worker w){
         
        if(w.getId() == 0){
            //new person, add it
            this.workerService.addWorker(w);
        }else{
            //existing person, call update
            this.workerService.updateWorker(w);
        }
         
        return "redirect:/workerss";
         
    }
     
    @RequestMapping("/remove/{id}")
    public String removeWorker(@PathVariable("id") int id){
         
        this.workerService.removeWorker(id);
        return "redirect:/workers";
    }
  
    @RequestMapping("/edit/{id}")
    public String editWorker(@PathVariable("id") int id, Model model){
        model.addAttribute("worker", this.workerService.getWorkerById(id));
        model.addAttribute("listWorkers", this.workerService.listWorkers());
        return "worker";
    }
     
}
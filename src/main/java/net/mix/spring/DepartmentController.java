package net.mix.spring;

import net.mix.spring.model.Department;
import net.mix.spring.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String listDeps(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("listDeps", this.departmentService.listDeps());
        return "department";
    }
     
    //For add and update person both
    @RequestMapping(value= "/department/add", method = RequestMethod.POST)
    public String addDep(@ModelAttribute("department") Department dep){
         
        if(dep.getDept_id() == 0){
            //new person, add it
            this.departmentService.addDep(dep);
        }else{
            //existing person, call update
            this.departmentService.updateDep(dep);
        }
         
        return "redirect:/departments";
         
    }
     
    @RequestMapping("/remove/{dept_id}")
    public String removeDep(@PathVariable("dept_id") int dept_id){
         
        this.departmentService.removeDep(dept_id);
        return "redirect:/departments";
    }
  
    @RequestMapping("/edit/{dept_id}")
    public String editDep(@PathVariable("dept_id") int dept_id, Model model){
        model.addAttribute("department", this.departmentService.getDepbyId(dept_id));
        model.addAttribute("listDeps", this.departmentService.listDeps());
        return "department";
    }
	
	
}

package edu.cours.springboot.coursspringboot.controleur;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.cours.springboot.coursspringboot.module.CoursModel;
import edu.cours.springboot.coursspringboot.service.ModelService;


@RestController
public class ModuleControler {

    @Autowired

    // INSTANCE OF ModelService
    private ModelService moduleService;

    // GET ALL MODELS
@RequestMapping("/modules")
    public List<CoursModel> getModules() {
        return moduleService.getAllModules();
    }

    // ADD MODEL
@RequestMapping(method=RequestMethod.POST, value="/modules")
    public void ajouterModule(@RequestBody CoursModel module) {
        moduleService.ajouterModule(module);
    }

    // GET MODEL
@RequestMapping("/modules/{id}")
    public Optional<CoursModel> getModule(@PathVariable Integer id){
    return moduleService.getModule(id);
    }

    // UPDATE MODEL
@RequestMapping(method=RequestMethod.PUT, value="/modules/{id}")
    public void modifierModule(@RequestBody CoursModel module, @PathVariable Integer id) {
        moduleService.modifierModule(id, module);
    }

    // DELETE MODEL
@RequestMapping(method=RequestMethod.DELETE, value="/modules/{id}")
    public void supprimerModule(@PathVariable Integer id) {
        moduleService.supprimerModule(id);
}

    
}
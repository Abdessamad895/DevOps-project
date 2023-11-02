package edu.cours.springboot.coursspringboot.controleur;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.cours.springboot.coursspringboot.module.Module;
import edu.cours.springboot.coursspringboot.service.CoursService;
import edu.cours.springboot.coursspringboot.service.ModelService;
import edu.cours.springboot.coursspringboot.module.Cours;
import edu.cours.springboot.coursspringboot.module.CoursModel;


    //  Pour indiquer que c’est un controller Rest pour gérer les mappings après
@RestController 
public class CoursController {

    //  Pour faire de l’injection de la classe CoursService au niveau du Controller
@Autowired

    private CoursService coursService;    
    private ModelService moduleService;


    // Récupération des cours d'un module {id}
@RequestMapping("/modules/{id}/cours")

    // SELECT ALL COURS WHERE MODULE EQUAL {id}
    public List<Cours> getAllCours(@PathVariable Integer id){
        return coursService.getAllCours(id);
    }

    // Récupération d'un cours {id}
@RequestMapping("/modules/{moduleId}/cours/{id}")
    
    // SELECT COURS BY ID
    public Optional<Cours> getCours(@PathVariable Integer id){
        return coursService.getCours(id);
    }

    // L'insertion d'un cours dans le module {id}
@RequestMapping(method=RequestMethod.POST, value="/modules/{moduleId}/cours")

    // INSERT COURS & CREATE MODULE IF NOT EXIST
    // public void ajouterCours(@RequestBody Cours cours, @PathVariable Integer moduleId) {
    //     cours.setModule(new Module(moduleId,"",""));
    //     coursService.ajouterCours(cours);
    // }
    public Optional<CoursModel> getModule(@PathVariable Integer moduleId){
    return moduleService.getModule(moduleId);
    }

    // La modification du cours {id}
@RequestMapping(method=RequestMethod.PUT, value="/modules/{moduleId}/cours/{id}")

    // UPDATE COURS
    public void modifierCours(@RequestBody Cours cours, @PathVariable Integer moduleId,@PathVariable Integer id) {
        cours.setModule(new Module(moduleId,"",""));
        coursService.modifierCours(cours);
    }

    // Suppression du cours {id}
@RequestMapping(method=RequestMethod.DELETE, value="/modules/{moduleId}/cours/{id}")
        
    // DELETE COURS
    public void supprimerCours(@PathVariable Integer id) {
        coursService.supprimerCours(id);
    }
}
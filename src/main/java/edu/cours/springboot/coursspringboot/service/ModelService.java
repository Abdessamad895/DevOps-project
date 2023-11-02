package edu.cours.springboot.coursspringboot.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cours.springboot.coursspringboot.module.CoursModel;
import edu.cours.springboot.coursspringboot.module.ModelRepository;
@Service
public class ModelService {
     
    @Autowired

    // INSTANCE OF ModelRepository
    private ModelRepository moduleRepository;

    // ALL MODELS
    public List<CoursModel> getAllModules() {
        List<CoursModel> modules = new ArrayList<>();
        moduleRepository.findAll().forEach(modules::add);
        return modules;
    }
    
    // ADD MODEL
    public void ajouterModule(CoursModel module) {
        moduleRepository.save(module);
    }
    
    // GET MODEL
    public Optional<CoursModel> getModule(Integer id) {
        return moduleRepository.findById(id);
    }
      
    // UPDATE MODEL
    public void modifierModule(Integer id, CoursModel module) {
        moduleRepository.save(module);
    }

    // DELETE MODEL
    public void supprimerModule(Integer id) {
        moduleRepository.deleteById(id);
    }
}



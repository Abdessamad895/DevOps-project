package edu.cours.springboot.coursspringboot.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.cours.springboot.coursspringboot.module.CoursRepository;
import edu.cours.springboot.coursspringboot.module.Cours;

@Service
public class CoursService {

    //  Pour l’injection des dépendances et éviter l’appel des new()
    @Autowired 

    private CoursRepository coursRepository;

    // SELECT ALL
    public List<Cours> getAllCours(Integer moduleId) {
        List<Cours> cours=new ArrayList<>();
        coursRepository.findByModuleId(moduleId).forEach(cours::add);
        return cours;
    }

    // SELECT BY ID
    public Optional<Cours> getCours(Integer id) {
        return coursRepository.findById(id);
    }

    // INSERT
    public void ajouterCours(Cours cours) {
        //la méthode save est implémentée dans CourseRepository
        coursRepository.save(cours); 
    }

    // UPDATE
    public void modifierCours(Cours cours) {
        //ici save dans le rôle de la mise à jour
        coursRepository.save(cours); 
    }

    // DELETE
    public void supprimerCours(Integer id) {
        coursRepository.deleteById(id);
    }
}
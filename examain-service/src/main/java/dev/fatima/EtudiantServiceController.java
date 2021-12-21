package dev.fatima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.fatima.etudiantServiceConsumer.Etudiant;
import dev.fatima.etudiantServiceConsumer.EtudiantServiceClient;


@RestController
public class EtudiantServiceController {
	@Autowired ExamainRepository exmRep;
	@Autowired EtudiantServiceClient etClient;
	
	@GetMapping(value = "examains/{id}/etudiants")
	Examain getExamainEtudiants(@PathVariable("id") long id) {
		Examain e = exmRep.findById(id).get();
		
		Etudiant etudiant = etClient.findEtudiantById(e.getEtudiantId());
		e.setEtudiant(etudiant);
		return e;
	}
	
}

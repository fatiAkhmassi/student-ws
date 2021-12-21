package dev.fatima.etudiantServiceConsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="etudiant-service")
public interface EtudiantServiceClient {
	
	@GetMapping(value ="/etudiants/{id}")
	Etudiant findEtudiantById(@PathVariable("id") long id);
	
}
// examain-service/examains/{id}
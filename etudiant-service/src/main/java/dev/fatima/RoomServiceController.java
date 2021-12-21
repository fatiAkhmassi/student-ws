package dev.fatima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.fatima.roomServiceConsumer.Room;
import dev.fatima.roomServiceConsumer.RoomServiceClient;

@RestController
public class RoomServiceController {
	
	@Autowired EtudiantRepository etdRepo;
	@Autowired RoomServiceClient rsClient ;
	
	@GetMapping(value = "etudiants/{id}/rooms")
    Etudiant getEtudiantRooms(@PathVariable("id") long id){
		Etudiant e = etdRepo.findById(id).get();
		//  sir sewel 3la room li id dyalha == e.roomId
		Room r = rsClient.findRoomById(e.getRoomId());
		e.setRoom(r);
		return e;
	}
	
}

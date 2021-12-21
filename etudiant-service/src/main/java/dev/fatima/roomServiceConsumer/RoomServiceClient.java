package dev.fatima.roomServiceConsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="room-service")
public interface RoomServiceClient {
	
	@GetMapping(value = "/rooms/{id}")
	Room findRoomById(@PathVariable("id") long id);
	
}
// room-service/rooms/{id}
package in.co.devicetalk.documentsharing;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public User getUserById(Long id) throws RecordNotFoundException 
    {
        Optional<User> event = repository.findById(id);
         
        if(event.isPresent()) {
            return event.get();
        } else {
            throw new RecordNotFoundException("No User exist for given id");
        }
    }
     
    public User createOrUpdateUser(User entity) throws RecordNotFoundException 
    {
    	return repository.save(entity);
    } 
     
    public ResponseEntity<?> deleteUserById(Long id) throws RecordNotFoundException 
    {
        Optional<User> user = repository.findById(id);
         
        if(user.isPresent()) 
        {
           repository.deleteById(id);
           return ResponseEntity.ok().build();
        } else {
            throw new RecordNotFoundException("No User exist for given id");
        }
    } 

}

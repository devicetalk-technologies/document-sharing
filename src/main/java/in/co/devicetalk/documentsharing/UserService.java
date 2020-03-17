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
	public User findUser(User user) throws RecordNotFoundException 
    {
        Optional<User> event = repository.findUser(user.getStudent().getEmailId(),user.getPassword());
         
        if(event.isPresent()) {
            return event.get();
        } else {
            throw new RecordNotFoundException("No User exist for given id");
        }
    }
	public LoginResponseDto loginUser(LoginDto dto) throws RecordNotFoundException 
    {
        Optional<User> event = repository.findUser(dto.getUserName(),dto.getPassword());
        
        LoginResponseDto response = new LoginResponseDto();
        if(event.isPresent()) {
        	 response.setLoginStatus(true);
             response.setRoleId(event.get().getRole().getId());
             response.setRole(event.get().getRole().getRole());
             return response;
        } else {
            response.setLoginStatus(false);
            return response;
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

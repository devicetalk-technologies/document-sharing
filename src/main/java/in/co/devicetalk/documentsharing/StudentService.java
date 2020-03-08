package in.co.devicetalk.documentsharing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	 public List<Student> getAllStudents()
	    {
	        List<Student> students = studentRepository.findAll();
	         
	        if(students.size() > 0) {
	            return students;
	        } else {
	            return new ArrayList<Student>();
	        }
	    }
	 
	 public Student getStudentById(Long id) throws RecordNotFoundException 
	    {
	        Optional<Student> event = studentRepository.findById(id);
	         
	        if(event.isPresent()) {
	            return event.get();
	        } else {
	            throw new RecordNotFoundException("No student exist for given id");
	        }
	    }
	     
	    public Student createOrUpdateStudent(StudentRegistrationRequest entity) throws RecordNotFoundException 
	    {
	    	 studentRepository.save(entity.getStudent());
	    	 User user = new User();
	    	 user.setPassword(entity.getPassword());
	    	 user.setStudent(entity.getStudent());
	    	 Role role = new Role();
	    	 role.setId(1L);
	    	 user.setRole(role);
	    	 userRepository.save(user);
	    	 return studentRepository.save(entity.getStudent());
	    	 
	    } 
	     
	    public ResponseEntity<?> deleteStudentById(Long id) throws RecordNotFoundException 
	    {
	        Optional<Student> employee = studentRepository.findById(id);
	         
	        if(employee.isPresent()) 
	        {
	           studentRepository.deleteById(id);
	           return ResponseEntity.ok().build();
	        } else {
	            throw new RecordNotFoundException("No student exist for given id");
	        }
	    } 

}

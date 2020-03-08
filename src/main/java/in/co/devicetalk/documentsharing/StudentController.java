package in.co.devicetalk.documentsharing;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
    StudentService service;
 
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> list = service.getAllStudents();
 
        return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
    	Student entity = service.getStudentById(id);
 
        return new ResponseEntity<Student>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Student> createOrUpdateStudent(@Valid @RequestBody StudentRegistrationRequest object)
                                                    throws RecordNotFoundException {
    	Student updated = service.createOrUpdateStudent(object);
        return new ResponseEntity<Student>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
    	return service.deleteStudentById(id);
    }

}

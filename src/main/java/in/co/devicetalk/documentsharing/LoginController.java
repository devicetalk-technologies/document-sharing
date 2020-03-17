package in.co.devicetalk.documentsharing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	UserService userService;
	 @PostMapping()
	    public ResponseEntity<LoginResponseDto> getStudent( @RequestBody LoginDto user) throws RecordNotFoundException {
		 LoginResponseDto entity = userService.loginUser(user);
	 
	        return new ResponseEntity<LoginResponseDto>(entity, new HttpHeaders(), HttpStatus.OK);
	    }

}

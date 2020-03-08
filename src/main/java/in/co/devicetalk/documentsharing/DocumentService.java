package in.co.devicetalk.documentsharing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
	@Autowired
	DocumentRepository documentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	 public List<Document> getAllDocuments()
	    {
	        List<Document> students = documentRepository.findAll();
	         
	        if(students.size() > 0) {
	            return students;
	        } else {
	            return new ArrayList<Document>();
	        }
	    }
	 
	 public Document getDocumentById(Long id) throws RecordNotFoundException 
	    {
	        Optional<Document> document = documentRepository.findById(id);
	         
	        if(document.isPresent()) {
	            return document.get();
	        } else {
	            throw new RecordNotFoundException("No Document exist for given id");
	        }
	    }
	     
	    public Document createOrUpdateDocument(Document entity) throws RecordNotFoundException 
	    {
	    	return documentRepository.save(entity);
	    	 
	    } 
	    
	    public List<Document> createOrUpdateDocuments(List<Document> entities) throws RecordNotFoundException 
	    {
	    	return documentRepository.saveAll(entities);
	    } 
	     
	    public ResponseEntity<?> deleteDocumentById(Long id) throws RecordNotFoundException 
	    {
	        Optional<Document> document = documentRepository.findById(id);
	         
	        if(document.isPresent()) 
	        {
	           documentRepository.deleteById(id);
	           return ResponseEntity.ok().build();
	        } else {
	            throw new RecordNotFoundException("No Document exist for given id");
	        }
	    } 


}

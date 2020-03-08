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
@RequestMapping("/documents")
public class DocumentController {
	@Autowired
    DocumentService documentService;
 
    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> list = documentService.getAllDocuments();
 
        return new ResponseEntity<List<Document>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
    	Document entity = documentService.getDocumentById(id);
 
        return new ResponseEntity<Document>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<List<Document>> createOrUpdateDocuments(@Valid @RequestBody List<Document> object)
                                                    throws RecordNotFoundException {
    	System.out.print("Document : "+object);
    	List<Document> updated = documentService.createOrUpdateDocuments(object);
        return new ResponseEntity<List<Document>>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDocumentById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
    	return documentService.deleteDocumentById(id);
    }


}

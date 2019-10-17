package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.TrafficDocumentDTO;
import ftn.ac.rs.diplomski.demo.entity.TrafficDocument;
import ftn.ac.rs.diplomski.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/document")
@CrossOrigin(value = "http://localhost:4200")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<TrafficDocumentDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<TrafficDocument> documents = (Page<TrafficDocument>) documentService.findAllPaged(page, size);
        Page<TrafficDocumentDTO> documentDTOS = documents.map(TrafficDocumentDTO::new);

        return new ResponseEntity<Page<TrafficDocumentDTO>>(documentDTOS, HttpStatus.OK);
    }
}

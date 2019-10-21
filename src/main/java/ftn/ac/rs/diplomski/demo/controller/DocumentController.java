package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.DocumentItemDTO;
import ftn.ac.rs.diplomski.demo.dto.TrafficDocumentDTO;
import ftn.ac.rs.diplomski.demo.entity.TrafficDocument;
import ftn.ac.rs.diplomski.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/document")
@CrossOrigin(value = "http://localhost:4200")
public class DocumentController {

    @Autowired
    private TrafficDocumentService documentService;

    @Autowired
    private BussinesYearServise yearServise;

    @Autowired
    private BussinesPartnerService partnerService;

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<TrafficDocumentDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<TrafficDocument> documents = (Page<TrafficDocument>) documentService.findAllPaged(page, size);
        Page<TrafficDocumentDTO> documentDTOS = documents.map(TrafficDocumentDTO::new);

        return new ResponseEntity<Page<TrafficDocumentDTO>>(documentDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TrafficDocumentDTO> getOne(@PathVariable("id") Integer id){
        TrafficDocument document = documentService.getDocument(id);
        TrafficDocumentDTO dto = new TrafficDocumentDTO(document);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}/item")
    public ResponseEntity<List<DocumentItemDTO>> getItems(@PathVariable("id") Integer id){
        List<DocumentItemDTO> items = documentService.getItem(id);

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TrafficDocumentDTO> addDocument(@RequestBody TrafficDocumentDTO trafficDocumentDTO){
        System.out.println("Docuimeeeeeeeeent " + trafficDocumentDTO.toString());
        TrafficDocument trafficDocument = new TrafficDocument();
        trafficDocument.setTypeOfDocument(trafficDocumentDTO.getType());
        trafficDocument.setNumber(trafficDocumentDTO.getId());
        trafficDocument.setFormatDate(trafficDocumentDTO.getCreateDate());
        trafficDocument.setDatumKnjizenja(trafficDocumentDTO.getBookingDate());
        trafficDocument.setStatus(trafficDocumentDTO.getStatus());
        trafficDocument.setBussinessPartner(partnerService.findOne(trafficDocumentDTO.getBusinessPartner().getId()));
        trafficDocument.setYear(yearServise.findOne(trafficDocumentDTO.getBusinessYear().getId()));
        trafficDocument.setWarehouse(warehouseService.findOne(trafficDocumentDTO.getWarehouse().getId()));

        trafficDocument = documentService.save(trafficDocument);

        return new ResponseEntity<>(new TrafficDocumentDTO(trafficDocument), HttpStatus.CREATED);
    }

    @PostMapping(value = "/proknjizi")
    public ResponseEntity<TrafficDocumentDTO> proknjizi(@RequestBody TrafficDocumentDTO trafficDocumentDTO){
        System.out.println("DOKUMENTTT JEBENI  " + trafficDocumentDTO.toString());
        if(documentService.proknjiziDokument(trafficDocumentDTO)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/storniraj")
    public ResponseEntity<TrafficDocumentDTO> storniraj(@RequestBody TrafficDocumentDTO trafficDocumentDTO){
        if(documentService.storniraj(trafficDocumentDTO)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

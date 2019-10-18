package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.TrafficDocumentDTO;
import ftn.ac.rs.diplomski.demo.entity.TrafficDocument;
import ftn.ac.rs.diplomski.demo.service.*;
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
}

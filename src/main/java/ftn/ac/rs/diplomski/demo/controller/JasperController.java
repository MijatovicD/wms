package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.entity.User;
import ftn.ac.rs.diplomski.demo.service.ReportService;
import ftn.ac.rs.diplomski.demo.service.UsersService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/report")
@CrossOrigin(origins = "http://localhost:4200")
public class JasperController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private UsersService usersService;

    static final DateFormat dd_MM_gggg = new SimpleDateFormat("dd-MM-yyyy");

    @GetMapping(value = "/{reportName}")
    public ResponseEntity getReportName(@PathVariable("reportName") String reportName){
        ByteArrayResource resource = reportService.exportToPdf(reportName);

        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @GetMapping(value = "/{reportName}", params = {"cardId", "startDate", "endDate"})
    public ResponseEntity getByCardId(@PathVariable("reportName") String reportName, @RequestParam("cardId") Integer cardId,
                                      @RequestParam("startDate") String startDateString, @RequestParam("endDate") String endDateString) throws JRException {

        Date startDate;
        Date endDate;

        try{

            startDate = dd_MM_gggg.parse(startDateString);
            endDate = dd_MM_gggg.parse(endDateString);

        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }


        Map<String, Object> parameters = new HashMap<>();
        parameters.put("cardId", cardId);
        parameters.put("startDate", startDate);
        parameters.put("endDate", endDate);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "attachment; filename=\""+ reportName + "-" + cardId.toString() + "-od-" + startDateString + "-do-" + endDateString + ".pdf\"");


        byte[] report = reportService.exportToPdfParameterized(reportName, parameters);
        System.out.println("bytees " + report);
        ByteArrayResource resource = new ByteArrayResource(report);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ reportName + "-" + cardId.toString() + "-od-" + startDateString + "-do-" + endDateString + ".pdf\"")
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf; charset=utf-8")
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition")
                .contentLength(report.length)
                .body(resource);
    }


    @GetMapping(value = "/{reportName}", params = {"username"})
    public ResponseEntity getByShoppingCartId(@PathVariable("reportName") String reportName, @RequestParam("username") String username) throws JRException {



        Map<String, Object> parameters = new HashMap<>();
        User u = usersService.findByUsername(username);
        parameters.put("userId", u.getId());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "attachment; filename=\""+ reportName + "-" + username.toString() + ".pdf\"");


        byte[] report = reportService.exportToPdfCartParameterized(reportName, parameters);
        System.out.println("bytees " + report);
        ByteArrayResource resource = new ByteArrayResource(report);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ reportName + "-" + username.toString() + ".pdf\"")
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf; charset=utf-8")
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition")
                .contentLength(report.length)
                .body(resource);
    }
}

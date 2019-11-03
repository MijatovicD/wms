package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.User;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.ByteArrayOutputStream;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private UsersService usersService;

    public ByteArrayResource exportToPdf(String reportName){
        try {

            Resource resource = resourceLoader.getResource("classpath:jasper/" + reportName + ".jasper");

            JasperPrint jasperPrint = JasperFillManager.fillReport(resource.getInputStream(), null, dataSource.getConnection());

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            byte[] report = outputStream.toByteArray();

            return new ByteArrayResource(report);

        }catch (Exception e){
            return null;
        }
    }

    public byte[] exportToPdfParameterized(String reportName, Map<String, Object> parameters) throws JRException{
        try {
            String filename = "/jasper/" + reportName + ".jasper";
            Resource resource = resourceLoader.getResource("classpath:jasper/" + reportName + ".jasper");

            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    resource.getInputStream(),
                    parameters,
                    dataSource.getConnection()
            );

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            byte[] report = outputStream.toByteArray();

            return JasperExportManager.exportReportToPdf(jasperPrint);
        }catch (Exception e){
            return null;
        }
    }

    public byte[] exportToPdfCartParameterized(String reportName, Map<String, Object> parameters) throws JRException{
        try {

            String filename = "/jasper/" + reportName + ".jasper";
            Resource resource = resourceLoader.getResource("classpath:jasper/" + reportName + ".jasper");

            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    resource.getInputStream(),
                    parameters,
                    dataSource.getConnection()
            );



            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            byte[] report = outputStream.toByteArray();

            return JasperExportManager.exportReportToPdf(jasperPrint);
        }catch (Exception e){
            return null;
        }
    }
}

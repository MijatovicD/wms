package ftn.ac.rs.diplomski.demo.entity;

import ftn.ac.rs.diplomski.demo.dto.TrafficDocumentDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trafficDocument")
public class TrafficDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "typeOfDocument", nullable = false)
    private String typeOfDocument;

    @Column(name = "number")
    private Integer number;

    @Column(name = "formatDate")
    private Date formatDate;

    @Column(name = "datumKnjizenja")
    private Date datumKnjizenja;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "bussinessPartner_id", referencedColumnName = "id", nullable = false)
    private BussinessPartner bussinessPartner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "year_id", referencedColumnName = "id")
    private BusinessYear year;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private Warehouse warehouse;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "trafficDocument")
    private List<DocumentItem> items = new ArrayList<>();

    public TrafficDocument(){

    }

    public TrafficDocument(String typeOfDocument, Integer number, Date formatDate, Date datumKnjizenja, String status, BussinessPartner bussinessPartner, BusinessYear year, Warehouse warehouse, List<DocumentItem> items) {
        this.typeOfDocument = typeOfDocument;
        this.number = number;
        this.formatDate = formatDate;
        this.datumKnjizenja = datumKnjizenja;
        this.status = status;
        this.bussinessPartner = bussinessPartner;
        this.year = year;
        this.warehouse = warehouse;
        this.items = items;
    }

    public TrafficDocument(TrafficDocumentDTO documentDTO){
        this.id = documentDTO.getId();
        this.typeOfDocument = documentDTO.getType();
        this.number = documentDTO.getSerialNumber();
        this.formatDate = documentDTO.getCreateDate();
        this.datumKnjizenja = documentDTO.getBookingDate();
        this.status = documentDTO.getStatus();
        this.bussinessPartner = new BussinessPartner(documentDTO.getBusinessPartner());
        this.year = new BusinessYear(documentDTO.getBusinessYear());
        this.warehouse = new Warehouse(documentDTO.getWarehouse());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfDocument() {
        return typeOfDocument;
    }

    public void setTypeOfDocument(String typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(Date formatDate) {
        this.formatDate = formatDate;
    }

    public Date getDatumKnjizenja() {
        return datumKnjizenja;
    }

    public void setDatumKnjizenja(Date datumKnjizenja) {
        this.datumKnjizenja = datumKnjizenja;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BussinessPartner getBussinessPartner() {
        return bussinessPartner;
    }

    public void setBussinessPartner(BussinessPartner bussinessPartner) {
        this.bussinessPartner = bussinessPartner;
    }

    public BusinessYear getYear() {
        return year;
    }

    public void setYear(BusinessYear year) {
        this.year = year;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<DocumentItem> getItems() {
        return items;
    }

    public void setItems(List<DocumentItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "TrafficDocument{" +
                "id=" + id +
                ", typeOfDocument='" + typeOfDocument + '\'' +
                ", number=" + number +
                ", formatDate=" + formatDate +
                ", datumKnjizenja=" + datumKnjizenja +
                ", status='" + status + '\'' +
                ", bussinessPartner=" + bussinessPartner +
                ", year=" + year +
                ", warehouse=" + warehouse +
                ", items=" + items +
                '}';
    }
}

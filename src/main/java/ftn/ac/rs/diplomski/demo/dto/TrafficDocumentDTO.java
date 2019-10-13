package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.TrafficDocument;

import java.util.Date;

public class TrafficDocumentDTO {

    private Integer id;
    private Integer serialNumber;
    private Date createDate;
    private Date bookingDate;
    private String status;
    private String type;
    private BussinessPartnerDTO businessPartner;
    private WarehouseDTO warehouse;
    private BussinessYearDTO businessYear;

    public TrafficDocumentDTO(){
        super();
    }

    public TrafficDocumentDTO(Integer id, Integer serialNumber, Date createDate, Date bookingDate, String status, String type, BussinessPartnerDTO businessPartner, WarehouseDTO warehouse, BussinessYearDTO businessYear) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.createDate = createDate;
        this.bookingDate = bookingDate;
        this.status = status;
        this.type = type;
        this.businessPartner = businessPartner;
        this.warehouse = warehouse;
        this.businessYear = businessYear;
    }

    public TrafficDocumentDTO(TrafficDocument document){
        this(document.getId(), document.getNumber(), document.getFormatDate(), document.getDatumKnjizenja(),
                document.getStatus(), document.getTypeOfDocument(), new BussinessPartnerDTO(document.getBussinessPartner()),
                new WarehouseDTO(document.getWarehouse()), new BussinessYearDTO(document.getYear()));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BussinessPartnerDTO getBusinessPartner() {
        return businessPartner;
    }

    public void setBusinessPartner(BussinessPartnerDTO businessPartner) {
        this.businessPartner = businessPartner;
    }

    public WarehouseDTO getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseDTO warehouse) {
        this.warehouse = warehouse;
    }

    public BussinessYearDTO getBusinessYear() {
        return businessYear;
    }

    public void setBusinessYear(BussinessYearDTO businessYear) {
        this.businessYear = businessYear;
    }
}

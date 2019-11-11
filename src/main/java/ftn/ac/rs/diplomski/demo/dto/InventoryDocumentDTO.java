package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.InventoryDocument;

import java.util.Date;

public class InventoryDocumentDTO {

    private Integer id;
    private Date createDate;
    private Date bookingDate;
    private String status;
    private WarehouseDTO warehouse;
    private BussinessYearDTO businessYear;

    public InventoryDocumentDTO(){
        super();
    }

    public InventoryDocumentDTO(Integer id, Date createDate, Date bookingDate, String status, WarehouseDTO warehouse, BussinessYearDTO businessYear) {
        this.id = id;
        this.createDate = createDate;
        this.bookingDate = bookingDate;
        this.status = status;
        this.warehouse = warehouse;
        this.businessYear = businessYear;
    }

    public InventoryDocumentDTO(InventoryDocument inventoryDocument){
        this(inventoryDocument.getId(), inventoryDocument.getFormatDate(), inventoryDocument.getBookingDate(), inventoryDocument.getStatus(), new WarehouseDTO(inventoryDocument.getWarehouse()), new BussinessYearDTO(inventoryDocument.getYear()));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
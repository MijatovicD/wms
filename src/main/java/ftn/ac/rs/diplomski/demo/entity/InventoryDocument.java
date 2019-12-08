package ftn.ac.rs.diplomski.demo.entity;

import ftn.ac.rs.diplomski.demo.dto.InventoryDocumentDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inventoryDocument")
public class InventoryDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "formatDate")
    private Date formatDate;

    @Column(name = "bookingDate")
    private Date bookingDate;

    @Column(name = "status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "inventoryDocument")
    private List<InventoryItem> inventoryItems = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "inventoryDocument")
    private List<InventoryCommission> commissions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "year_id", referencedColumnName = "id")
    private BusinessYear year;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "document")
    private List<InventoryCommissionDocument> documents = new ArrayList<>();


    public InventoryDocument(){

    }

    public InventoryDocument(Date formatDate, Date bookingDate, String status, List<InventoryItem> inventoryItems, List<InventoryCommission> commissions, Warehouse warehouse, BusinessYear year) {
        this.formatDate = formatDate;
        this.bookingDate = bookingDate;
        this.status = status;
        this.inventoryItems = inventoryItems;
        this.commissions = commissions;
        this.warehouse = warehouse;
        this.year = year;
    }

    public InventoryDocument(InventoryDocumentDTO documentDTO){
        this.id = documentDTO.getId();
        this.formatDate = documentDTO.getCreateDate();
        this.bookingDate = documentDTO.getBookingDate();
        this.status = documentDTO.getStatus();
        this.warehouse = new Warehouse(documentDTO.getWarehouse());
        this.year = new BusinessYear(documentDTO.getBusinessYear());
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(Date formatDate) {
        this.formatDate = formatDate;
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

    public List<InventoryItem> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(List<InventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    public List<InventoryCommission> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<InventoryCommission> commissions) {
        this.commissions = commissions;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public BusinessYear getYear() {
        return year;
    }

    public void setYear(BusinessYear year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "InventoryDocument{" +
                "id=" + id +
                ", formatDate=" + formatDate +
                ", bookingDate=" + bookingDate +
                ", status='" + status + '\'' +
                ", inventoryItems=" + inventoryItems +
                ", commissions=" + commissions +
                ", warehouse=" + warehouse +
                ", year=" + year +
                '}';
    }
}

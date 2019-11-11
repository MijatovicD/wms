package ftn.ac.rs.diplomski.demo.entity;

import ftn.ac.rs.diplomski.demo.dto.BussinessYearDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "businessYear")
public class BusinessYear implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "year", columnDefinition = "VARCHAR(4)", length = 4, nullable = false)
    private String year;

    @Column(name = "close", unique = false, nullable = false)
    private boolean close;

    //veza sa robnom karticom
    @OneToMany(mappedBy = "year")
    private List<ProductCard> productCards = new ArrayList<>();

    //veza sa prometnim dokumentom
    @OneToMany(mappedBy = "year")
//	@JoinColumn(name = "prometni_dokument_id", referencedColumnName = "id")
    private List<TrafficDocument> documents = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "year")
    private List<InventoryDocument> inventoryDocuments = new ArrayList<>();


    public BusinessYear(){

    }

    public BusinessYear(String year, boolean close, List<ProductCard> productCards, List<TrafficDocument> documents, Company company) {
        this.year = year;
        this.close = close;
        this.productCards = productCards;
        this.documents = documents;
        this.company = company;
    }

    public BusinessYear(BussinessYearDTO yearDTO){
        this.id = yearDTO.getId();
        this.year = yearDTO.getYear();
        this.close = yearDTO.isClosed();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isClose() {
        return close;
    }

    public void setClose(boolean close) {
        this.close = close;
    }

    public List<ProductCard> getProductCards() {
        return productCards;
    }

    public void setProductCards(List<ProductCard> productCards) {
        this.productCards = productCards;
    }

    public List<TrafficDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<TrafficDocument> documents) {
        this.documents = documents;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "BusinessYear{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", close=" + close +
                ", company=" + company +
                '}';
    }
}

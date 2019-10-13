package ftn.ac.rs.diplomski.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "partner")
public class BussinessPartner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", unique = false, nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String name;

    @Column(name = "pib", unique = true, nullable = false, columnDefinition = "VARCHAR(12)", length = 12)
    private String PIB;

    @Column(name = "address", unique = false, nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String address;


    @ManyToOne()
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToOne()
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place place;

//    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bussinessPartner")
    private List<TrafficDocument> documents = new ArrayList<>();

    public BussinessPartner(){

    }

    public BussinessPartner(String name, String PIB, String address, Company company, Place place, List<TrafficDocument> documents) {
        this.name = name;
        this.PIB = PIB;
        this.address = address;
        this.company = company;
        this.place = place;
        this.documents = documents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public List<TrafficDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<TrafficDocument> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "BussinessPartner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", PIB='" + PIB + '\'' +
                ", address='" + address + '\'' +
                ", company=" + company +
                ", place=" + place +
                ", documents=" + documents +
                '}';
    }
}

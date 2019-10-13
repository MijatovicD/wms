package ftn.ac.rs.diplomski.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouse")
public class Warehouse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)", length = 50, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @OneToMany(mappedBy = "warehouse")
//	@JoinColumn(name = "robna_kartica_id", referencedColumnName = "kartica_id")
    private List<ProductCard> productCards = new ArrayList<>();

    @OneToMany(mappedBy = "warehouse")
//	@JoinColumn(name = "prometni_dokument_id", referencedColumnName = "id")
    private List<TrafficDocument> trafficDocuments = new ArrayList<>();


    public Warehouse(){

    }

    public Warehouse(String name, Company company, List<ProductCard> productCards, List<TrafficDocument> trafficDocuments) {
        this.name = name;
        this.company = company;
        this.productCards = productCards;
        this.trafficDocuments = trafficDocuments;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<ProductCard> getProductCards() {
        return productCards;
    }

    public void setProductCards(List<ProductCard> productCards) {
        this.productCards = productCards;
    }

    public List<TrafficDocument> getTrafficDocuments() {
        return trafficDocuments;
    }

    public void setTrafficDocuments(List<TrafficDocument> trafficDocuments) {
        this.trafficDocuments = trafficDocuments;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", productCards=" + productCards +
                ", trafficDocuments=" + trafficDocuments +
                '}';
    }
}

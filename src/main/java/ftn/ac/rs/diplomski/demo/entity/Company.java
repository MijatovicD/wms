package ftn.ac.rs.diplomski.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", unique = false, nullable = false,  columnDefinition = "VARCHAR(50)", length = 50)
    private String name;

    @Column(name = "pib", unique = true, nullable = false,  columnDefinition = "VARCHAR(12)", length = 12)
    private String PIB;

    @Column(name = "address", unique = false, nullable = false,  columnDefinition = "VARCHAR(50)", length = 50)
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<Warehouse> warehouses = new HashSet<>();

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
//    private Set<Radnik> radnici = new HashSet<Radnik>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<ProductGroup> groups = new HashSet<ProductGroup>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<BussinessPartner> partners = new HashSet<BussinessPartner>();

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place place;

    public Company(){

    }

    public Company(Integer id, String name, String PIB, String address) {
        this.id = id;
        this.name = name;
        this.PIB = PIB;
        this.address = address;
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

    public Set<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(Set<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public Set<ProductGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<ProductGroup> groups) {
        this.groups = groups;
    }

    public Set<BussinessPartner> getPartners() {
        return partners;
    }

    public void setPartners(Set<BussinessPartner> partners) {
        this.partners = partners;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", PIB='" + PIB + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

package ftn.ac.rs.diplomski.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "place")
public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)", length = 50, unique = true, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "place")
    private Set<Company> companies = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "place")
    private Set<BussinessPartner> partners = new HashSet<BussinessPartner>();

    public Place(){

    }

    public Place(String name, Set<Company> companies, Set<BussinessPartner> partners) {
        this.name = name;
        this.companies = companies;
        this.partners = partners;
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

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<BussinessPartner> getPartners() {
        return partners;
    }

    public void setPartners(Set<BussinessPartner> partners) {
        this.partners = partners;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companies=" + companies +
                ", partners=" + partners +
                '}';
    }
}

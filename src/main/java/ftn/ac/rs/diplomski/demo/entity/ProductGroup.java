package ftn.ac.rs.diplomski.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productGroup")
public class ProductGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "groupProductCompany", referencedColumnName = "id")
    private Company company;

    public ProductGroup(){

    }

    public ProductGroup(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

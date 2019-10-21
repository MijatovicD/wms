package ftn.ac.rs.diplomski.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "units")
public class MeasurementUnit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(20)", length = 20, nullable = false)
    private String name;

    @OneToMany(mappedBy = "measurementUnit")
    private List<Product> products = new ArrayList<>();

    public MeasurementUnit(){

    }

    public MeasurementUnit(String name) {
        this.name = name;
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


    @Override
    public String toString() {
        return "MeasurementUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.Warehouse;

public class WarehouseDTO {

    private Integer id;
    private String name;
    private CompanyDTO companyDTO;

    public WarehouseDTO(){
        super();
    }

    public WarehouseDTO(Integer id, String name, CompanyDTO companyDTO) {
        this.id = id;
        this.name = name;
        this.companyDTO = companyDTO;
    }

    public WarehouseDTO(Warehouse warehouse){
        this(warehouse.getId(), warehouse.getName(), new CompanyDTO(warehouse.getCompany()));
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

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }
}

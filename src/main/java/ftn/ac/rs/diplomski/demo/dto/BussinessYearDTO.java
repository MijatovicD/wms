package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.BusinessYear;

public class BussinessYearDTO {

    private Integer id;
    private String year;
    private boolean isClosed;

    public BussinessYearDTO(){
        super();
    }

    public BussinessYearDTO(Integer id, String year, boolean isClosed) {
        this.id = id;
        this.year = year;
        this.isClosed = isClosed;
    }

    public BussinessYearDTO(BusinessYear year){
        this(year.getId(), year.getYear(), year.isClose());
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

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}

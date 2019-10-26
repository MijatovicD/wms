package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.User;

public class UserDTO {

    private Integer id;
    private String username;

    public UserDTO(){

    }

    public UserDTO(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserDTO(User user){
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

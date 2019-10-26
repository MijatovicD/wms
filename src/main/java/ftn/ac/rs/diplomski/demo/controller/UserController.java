package ftn.ac.rs.diplomski.demo.controller;

import java.util.Map;
import java.util.Optional;

import ftn.ac.rs.diplomski.demo.dto.LoginDTO;
import ftn.ac.rs.diplomski.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO loginDTO) {
        System.out.println("USSSSSSSSSSSSEEER " + loginDTO.toString());
        return Optional.ofNullable(usersService.login(loginDTO))
                .map(cookie -> new ResponseEntity<Map<String, Object>>(cookie, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
    }
}

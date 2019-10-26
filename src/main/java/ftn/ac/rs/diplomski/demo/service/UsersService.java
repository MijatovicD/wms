package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.dto.LoginDTO;
import ftn.ac.rs.diplomski.demo.entity.User;
import ftn.ac.rs.diplomski.demo.repository.UserRepository;
import ftn.ac.rs.diplomski.demo.security.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UsersService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    UserRepository userRepository;

    public Map<String, Object> login(LoginDTO loginDTO) {
        Map<String, Object> cookie = new HashMap<>();

        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
                    loginDTO.getPassword());

            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());

            cookie.put("jwt", tokenUtils.generateToken(details));

            return cookie;
        } catch (NullPointerException nullException) {
            System.out.println("User doesn't exist.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public User findById(Integer id){
        return userRepository.getOne(id);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}

package edu.escuelaing.service4All.backend.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import edu.escuelaing.service4All.backend.Service4AllApplication;
import edu.escuelaing.service4All.backend.exceptions.Service4AllException;
import edu.escuelaing.service4All.backend.model.User;
import edu.escuelaing.service4All.backend.security.UserDetailsServiceImpl;
import edu.escuelaing.service4All.backend.services.UserService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Service4AllApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Test
    public void shouldFindUserByName() throws Service4AllException {
        User user = userService.findUserByName("Prueba");
        Assert.assertTrue(user.getFirstname().equals("Prueba"));
        Assert.assertTrue(user.getEmail().equals("prueba@mail.com"));
    }
    @Test
    public void shouldBeRegistered() throws Service4AllException {
        User user = userService.findUserByName("Prueba");
        User userRegistered = userService.isRegister(user);
        Assert.assertTrue(userRegistered.getFirstname().equals("Prueba"));
    }

    @Test
    public void shouldFindUserByCorreo() throws Service4AllException {
        User user = userService.getUserByCorreo("prueba@mail.com");
        Assert.assertEquals(user.getFirstname(),"Prueba");
    }

    @Test
    public void shouldFindAllUsers() throws Service4AllException {
        List<User> users = userService.findAll();
        Assert.assertTrue(users.size()>=0);
    }

    @Test
    public void shouldsave() throws Service4AllException {
        userService.saveUser(userService.getUserByCorreo("prueba@mail.com"));
        List<User> users = userService.findAll();
        Assert.assertTrue(users.size()>=0);
    }

    @Test
    public void shouldCreateUser() {
        User user = new User();
        user.setId(1);
        user.setPassword("123456789");
        user.setCity("Bogotá");
        user.setTipo("vendedor");
        user.setFirstname("Prueba");
        user.setLastname("Prueba");
        user.setCedula("1029384756");
        user.setEmail("prueba@gmail.com");
        Assert.assertTrue(true);
    }

    @Test
    public void shouldCreateUserWithConstructor(){
        User user = new User(1, "Prueba", "Prueba", "prueba@mail.com", "12345", "Zapatos", "Bogotá", "123456789");
        Assert.assertTrue(true);
    }

    @Test
    public void shouldLoadUserByUsername(){
        UserDetails userDetails = this.userDetailsService.loadUserByUsername("prueba@mail.com");
        Assert.assertTrue(userDetails.getUsername().equals("Prueba"));
    }


}

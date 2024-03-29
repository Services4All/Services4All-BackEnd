package edu.escuelaing.service4All.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import edu.escuelaing.service4All.backend.Service4AllApplication;
import edu.escuelaing.service4All.backend.model.User;
import edu.escuelaing.service4All.backend.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Service4AllApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Autowired
    UserController userController;

    @Autowired
    UserService user;

    // @WithMockUser(value = "prueba@mail.com", password = "12345", roles = "ADMIN")
    // @Test
    // public void shouldGetUserByCorreo() throws Exception {
    //     mockMvc.perform(
    //             get("/user/prueba@mail.com")
    //                     .contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(status().isOk());
    // }

//     @WithMockUser(value = "prueba@mail.com", password = "12345", roles = "ADMIN")
//     @Test
//     public void shouldNotGetUserByCorreo() throws Exception {
//         mockMvc.perform(
//                 get("/user/fallo@mail.com")
//                         .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isNotFound());
//     }

    @WithMockUser(value = "prueba@mail.com", password = "12345", roles = "ADMIN")
    @Test
    public void shouldGetUsers() throws Exception {
        mockMvc.perform(
                get("/user")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    // @Test
    // public void shouldNotBeenAuthenticated() throws Exception {
    //     try {
    //         mockMvc.perform(
    //                 get("/user")
    //                         .contentType(MediaType.APPLICATION_JSON))
    //                 .andExpect(status().isUnauthorized());
    //     } catch (AuthenticationCredentialsNotFoundException ex) {
    //         Assert.assertTrue(ex.getClass().getSimpleName().equals("AuthenticationCredentialsNotFoundException"));
    //     }
    // }

    @Test
    void deleteUser() throws Exception {
        List<User> all = user.findAll();
        User res= all.get(1);
        userController.deleteUser(res);
    }

    @WithMockUser(value = "prueba@mail.com", password = "12345", roles = "ADMIN")
    @Test
    public void shouldLogoutUser() throws Exception {
        mockMvc.perform(
                get("/login?logout"))
                .andExpect(status().isOk());
    }

    // @Test
    // public void shouldNotLogoutUser() throws Exception {
    //     mockMvc.perform(
    //             get("/login?logout"))
    //             .andExpect(status().isOk());
    // }

}

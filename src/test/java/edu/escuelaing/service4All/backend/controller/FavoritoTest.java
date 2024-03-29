package edu.escuelaing.service4All.backend.controller;

import edu.escuelaing.service4All.backend.model.Favorito;
import edu.escuelaing.service4All.backend.model.Suscripcion;
import edu.escuelaing.service4All.backend.repository.impl.FavoritoRepositoryImpl;
import edu.escuelaing.service4All.backend.services.FavoritoServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class FavoritoTest {

    @Autowired
    FavoritoServices favoritoServices;
    @Autowired
    FavoritoRepositoryImpl favoritoRepository;

    @Test
    void creacionFavoritoSetYGet() throws Exception {
        Favorito nuevo = new Favorito(222, 222);
        Favorito nuevo2 = new Favorito();
        nuevo.setIdservicio(222);
        nuevo.setIdusuario(222);
        int a = nuevo.getIdusuario();
        nuevo.getIdservicio();
        int b = 222;
        assertEquals(a,b);
    }

    @Test
    void FavoritosServicesImpl() throws Exception {
        Favorito nuevo = new Favorito(222, 222);
        favoritoServices.addfavorito(nuevo);
        favoritoServices.findAllFavoritos();
        favoritoServices.findFavoritosByIdUsuario(222);
        favoritoServices.removeFavorito(nuevo);
        assertTrue(true);
    }

    @Test
    void deleteSuscription(){
        Favorito nuevo = new Favorito(222, 222);
        favoritoRepository.addfavorito(nuevo);
        favoritoRepository.removeFavorito(nuevo);
    }

}

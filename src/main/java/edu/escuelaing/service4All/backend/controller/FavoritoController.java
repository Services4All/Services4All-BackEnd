package edu.escuelaing.service4All.backend.controller;

import com.google.gson.Gson;
import edu.escuelaing.service4All.backend.services.FavoritoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/favoritos")
public class FavoritoController {

    @Autowired
    FavoritoServices favoritosServices;

    @GetMapping()
    public ResponseEntity<String> getAllFavoritos(){
        try{
            return new ResponseEntity<>(new Gson().toJson(favoritosServices.findAllFavoritos()), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<String> getServicesByCategory(@PathVariable int id){
        try{
            return new ResponseEntity<>(new Gson().toJson(favoritosServices.findFavoritosByIdUsuario(id)), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Error Not Found 404", HttpStatus.NOT_FOUND);
        }
    }
}
package edu.escuelaing.service4All.backend.controller;

import com.google.gson.Gson;
import edu.escuelaing.service4All.backend.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.service4All.backend.services.ServiciosServices;

@RestController
public class ServiceController {
    @Autowired
	ServiciosServices serviciosService;
    
    @GetMapping("/service")
    public String index() {
        return "services!";
    }

    @GetMapping("/services")
    public List<Servicio> getAllServices() {
        return serviciosService.findAllServices();
    }

    private String notfound="HTTP 404 Not Found";

    @GetMapping("/service/{id}")
    public ResponseEntity<String> getServiceById(@PathVariable int id){
        try{
            return new ResponseEntity<>(new Gson().toJson(serviciosService.findServiceById(id)), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(notfound, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/services/{value}")
    public ResponseEntity<String> getAllServicesIfContainAKeyValueInName(@PathVariable String value){
        try{
            return new ResponseEntity<>(new Gson().toJson(serviciosService.findAllServicesIfContainAKeyValueInName(value)), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(notfound, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/services/categories/{categoria}")
    public ResponseEntity<String> getServicesByCategory(@PathVariable String categoria){
        try{
            return new ResponseEntity<>(new Gson().toJson(serviciosService.findAllServicesByCategory(categoria)), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(notfound, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/services/categories")
    public ResponseEntity<String> getAllCategories(){
        try{
            return new ResponseEntity<>(new Gson().toJson(serviciosService.findAllCategories()), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(notfound, HttpStatus.NOT_FOUND);
        }
    }
    //para usar el put en el request mandar solo id y descripcion nueva en JSON
    @PutMapping(value = "/services/putservice")
    public ResponseEntity<?> putService(@RequestBody Servicio servi) {
        try {
            serviciosService.update(servi);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
           // Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //para usar delete pasar solo el id en JSON
    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteService(@RequestBody Servicio servi) {
        try {
            serviciosService.deleteServicio(servi.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
           // Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

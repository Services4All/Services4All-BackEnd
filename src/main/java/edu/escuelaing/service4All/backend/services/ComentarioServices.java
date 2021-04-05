package edu.escuelaing.service4All.backend.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.service4All.backend.model.Comentario;
import edu.escuelaing.service4All.backend.repository.impl.ComentarioRepositoryImpl;



@Service
public class ComentarioServices {
	@Autowired
	ComentarioRepositoryImpl comentarioRepositoryImpl;
	
	public List<Comentario> findAllComentarios(){
        return comentarioRepositoryImpl.findAllComentarios();
    }
	public void saveComentario(Comentario c){
		comentarioRepositoryImpl.saveComentario(c);
	}
	
	public Optional<Comentario> findAllComentariosById(int id) {
        return comentarioRepositoryImpl.findAllComentariosById(id);
	}
}
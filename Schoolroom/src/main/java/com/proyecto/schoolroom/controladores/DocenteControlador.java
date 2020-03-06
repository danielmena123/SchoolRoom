package com.proyecto.schoolroom.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.schoolroom.entidades.Docente;
import com.proyecto.schoolroom.repositorios.DocenteRepository;

@RestController
@RequestMapping("/docentes/")
public class DocenteControlador {
	
	@Autowired
	DocenteRepository repo;
	
	//Elegir Docente
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Docente> elegirdocente(@PathVariable int id){
		
		Docente docente = repo.findById(id).get();
		
		if (docente != null) {
			return new ResponseEntity<>(docente, HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Lista Docentes
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<Docente> listadocente(){
		return repo.findAll();
	}
	
	//Crear Docente
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Docente> creardocente(@RequestBody Docente docente){
		repo.save(docente);
		return new ResponseEntity<>(docente, HttpStatus.OK);
	}
	
	//Actualizar Docente
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Docente> actualizardocente(@PathVariable int id,@RequestBody Docente update){
		Docente docente = repo.findById(id).get();
		if (docente != null) {
			repo.save(update);
			return new ResponseEntity<>(docente, HttpStatus.OK);
		}		
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		}
	}
	
	//Eliminar Docente
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Docente> eliminardocente(@PathVariable int id){
		Docente docente = repo.findById(id).get();
		
		if (docente != null) {
			repo.delete(docente);
			return new ResponseEntity<>(docente, HttpStatus.OK);			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

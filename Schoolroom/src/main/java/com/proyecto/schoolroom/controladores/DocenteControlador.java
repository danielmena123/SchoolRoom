package com.proyecto.schoolroom.controladores;

import java.util.Collection;

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
public class DocenteControlador {
	
	DocenteRepository repo;
	
	//Elegir Docente
	@RequestMapping(value = "/docente/{id}", method = RequestMethod.GET)
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
	@RequestMapping(value = "/docente/", method = RequestMethod.GET)
	public Collection<Docente> listadocente(){
		return repo.findAll();
	}
	
	//Crear Docente
	@RequestMapping(value = "/docente/", method = RequestMethod.POST)
	public ResponseEntity<Docente> creardocente(@RequestBody Docente docente){
		repo.save(docente);
		return new ResponseEntity<>(docente, HttpStatus.OK);
	}
	
	//Actualizar Docente
	@RequestMapping(value = "/docente/", method = RequestMethod.PUT)
	public ResponseEntity<Docente> actualizardocente(@RequestBody Docente docente){
		repo.save(docente);
		return new ResponseEntity<>(docente, HttpStatus.OK);
	}
	
	//Eliminar Docente
	@RequestMapping(value = "/docente/{id}", method = RequestMethod.DELETE)
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
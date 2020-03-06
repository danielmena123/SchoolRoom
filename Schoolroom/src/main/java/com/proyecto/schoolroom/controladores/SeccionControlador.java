package com.proyecto.schoolroom.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.schoolroom.entidades.Seccion;
import com.proyecto.schoolroom.repositorios.SeccionRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/secciones/")
public class SeccionControlador {

	@Autowired
	SeccionRepository repo;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Seccion> elegirseccion(@PathVariable int id){
		Seccion seccion = repo.findById(id).get();
		if (seccion != null) {
			return new ResponseEntity<>(seccion, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Seccion> listaseccion(){
		return repo.findAll();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Seccion> crearseccion(@RequestBody Seccion seccion){
		repo.save(seccion);
		return new ResponseEntity<>(seccion, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Seccion> actualizarseccion(@PathVariable int id , @RequestBody Seccion update){
		Seccion seccion = repo.findById(id).get();
		if (seccion != null) {
			repo.save(update);
			return new ResponseEntity<>(update, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Seccion> eliminarseccion(@PathVariable int id){
		Seccion seccion = repo.findById(id).get();
		if (seccion != null) {
			repo.deleteById(id);
			return new ResponseEntity<>(seccion, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

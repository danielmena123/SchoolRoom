package com.proyecto.schoolroom.controladores;

 
import java.util.Date;
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

import com.proyecto.schoolroom.entidades.InscripcionD;
import com.proyecto.schoolroom.repositorios.InscripcionDRepository;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/inscripcionesD/")
public class InscripcionDControlador {

	@Autowired
	InscripcionDRepository repo;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<InscripcionD> elegirinscripcionD(@PathVariable int id){
		InscripcionD inscripcion = repo.findById(id).get();
		if (inscripcion != null) {
			return new ResponseEntity<>(inscripcion, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<InscripcionD> listainscripcion(){
		return repo.findAll();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)		
	public ResponseEntity<InscripcionD> crearinscripcion(@RequestBody InscripcionD inscripcion){
		if (inscripcion != null) {
			repo.save(inscripcion);
			return new ResponseEntity<>(inscripcion, HttpStatus.OK);			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<InscripcionD> actualizarinscripcion(@PathVariable int id, @RequestBody InscripcionD update){
		InscripcionD inscripcion = repo.findById(id).get();
		if (inscripcion != null) {
			repo.save(update);
			return new ResponseEntity<>(update, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<InscripcionD> eliminarinscripcion(@PathVariable int id){
		InscripcionD inscripcion = repo.findById(id).get();
		if (inscripcion != null) {
			repo.deleteById(id);
			return new ResponseEntity<>(inscripcion, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

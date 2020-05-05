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

import com.proyecto.schoolroom.entidades.InscripcionE;
import com.proyecto.schoolroom.repositorios.InscripcionERepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/inscripcionesE/")
public class InscripcionEControlador {

	@Autowired
	InscripcionERepository repo;
	
	
	//Elegir Inscripcion
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<InscripcionE> elegirinscripcionE(@PathVariable int id){
		InscripcionE inscripcion = repo.findById(id).get();
		if (inscripcion != null) {
			return new ResponseEntity<>(inscripcion, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Listar Inscripciones
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<InscripcionE> listainscripcion(){
		return repo.findAll();
	}
	
	//Nueva Inscripcion
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<InscripcionE> crearinscripcion(@RequestBody InscripcionE inscripcion){
		repo.save(inscripcion);
		return new ResponseEntity<>(inscripcion, HttpStatus.OK);
	}
	
	//Editar Inscripcion
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<InscripcionE> actualizarinscripcion(@PathVariable int id, @RequestBody InscripcionE update){
		InscripcionE inscripcion = repo.findById(id).get();
		if (inscripcion != null) {
			repo.save(update);
			return new ResponseEntity<>(update, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Eliminar Inscripcion
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<InscripcionE> eliminarinscripcion(@PathVariable int id){
		InscripcionE inscripcion = repo.findById(id).get();
		if (inscripcion != null) {
			repo.deleteById(id);
			return new ResponseEntity<>(inscripcion, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

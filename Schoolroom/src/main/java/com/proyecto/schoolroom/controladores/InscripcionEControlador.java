package com.proyecto.schoolroom.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		InscripcionE i = repo.findById(id).get();
		if (i != null) {
			return ResponseEntity.ok(i);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Listar Inscripciones
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<InscripcionE> listainscripcion(){
		return repo.findAll();
	}
	
	//Nueva Inscripcion
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<InscripcionE> crearinscripcion(@RequestBody InscripcionE i){
		if (i != null) {			
			repo.save(i);
			return ResponseEntity.ok(i);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//Editar Inscripcion
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<InscripcionE> actualizarinscripcion(@PathVariable int id, @RequestBody InscripcionE i){
		InscripcionE n = repo.findById(id).get();
		if (n != null) {
			repo.save(i);
			return ResponseEntity.ok(i);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Eliminar Inscripcion
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<InscripcionE> eliminarinscripcion(@PathVariable int id){
		InscripcionE i = repo.findById(id).get();
		if (i != null) {
			repo.deleteById(id);
			return ResponseEntity.ok(i);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}

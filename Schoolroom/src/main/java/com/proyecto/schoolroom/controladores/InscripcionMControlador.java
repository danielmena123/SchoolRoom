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

import com.proyecto.schoolroom.entidades.InscripcionM;
import com.proyecto.schoolroom.repositorios.InscripcionMRepository;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/inscripcionesM/")
public class InscripcionMControlador {

	@Autowired
	InscripcionMRepository repo;
	
	//Elegir Inscripcion
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<InscripcionM> elegirinscripcionD(@PathVariable int id){
		InscripcionM inscripcion = repo.findById(id).get();
		if (inscripcion != null) {
			return new ResponseEntity<>(inscripcion, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Listar Inscripciones
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<InscripcionM> listainscripcion(){
		return repo.findAll();
	}
	
	//Nueva Inscripcion
	@RequestMapping(value = "/", method = RequestMethod.POST)		
	public ResponseEntity<InscripcionM> crearinscripcion(@RequestBody InscripcionM inscripcion){
		if (inscripcion != null) {
			repo.save(inscripcion);
			return new ResponseEntity<>(inscripcion, HttpStatus.OK);			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}	
	
	//Editar Inscripcion
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<InscripcionM> actualizarinscripcion(@PathVariable int id, @RequestBody InscripcionM update){
		InscripcionM inscripcion = repo.findById(id).get();
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
	public ResponseEntity<InscripcionM> eliminarinscripcion(@PathVariable int id){
		InscripcionM inscripcion = repo.findById(id).get();
		if (inscripcion != null) {
			repo.deleteById(id);
			return new ResponseEntity<>(inscripcion, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

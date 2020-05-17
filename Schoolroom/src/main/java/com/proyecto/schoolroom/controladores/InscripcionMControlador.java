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
		InscripcionM i = repo.findById(id).get();
		if (i != null) {
			return ResponseEntity.ok(i);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Listar Inscripciones
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<InscripcionM> listainscripcion(){
		return repo.findAll();
	}
	
	//Nueva Inscripcion
	@RequestMapping(value = "/", method = RequestMethod.POST)		
	public ResponseEntity<InscripcionM> crearinscripcion(@RequestBody InscripcionM i){
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
	public ResponseEntity<InscripcionM> actualizarinscripcion(@PathVariable int id, @RequestBody InscripcionM i){
		InscripcionM n = repo.findById(id).get();
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
	public ResponseEntity<InscripcionM> eliminarinscripcion(@PathVariable int id){
		InscripcionM i = repo.findById(id).get();
		if (i != null) {
			repo.deleteById(id);
			return ResponseEntity.ok(i);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}

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

import com.proyecto.schoolroom.entidades.Tarea;
import com.proyecto.schoolroom.repositorios.TareaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/tareas/")
public class TareaControlador {

	@Autowired
	TareaRepository repo;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Tarea> elegirtarea(@PathVariable int id){
		Tarea tarea = repo.findById(id).get();
		if (tarea != null) {
			return new ResponseEntity<>(tarea, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Tarea> listatarea(){
		return repo.findAll();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Tarea> creartarea(@RequestBody Tarea tarea){
		repo.save(tarea);
		return new ResponseEntity<>(tarea, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Tarea> actualizartarea(@PathVariable int id , @RequestBody Tarea update){
		Tarea tarea = repo.findById(id).get();
		if (tarea != null) {
			repo.save(update);
			return new ResponseEntity<>(update, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Tarea> eliminartarea(@PathVariable int id){
		Tarea tarea = repo.findById(id).get();
		if (tarea != null) {
			repo.deleteById(id);
			return new ResponseEntity<>(tarea, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

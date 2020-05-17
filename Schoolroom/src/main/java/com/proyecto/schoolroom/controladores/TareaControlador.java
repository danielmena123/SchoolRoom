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

import com.proyecto.schoolroom.entidades.Tarea;
import com.proyecto.schoolroom.repositorios.TareaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/tareas/")
public class TareaControlador {

	@Autowired
	TareaRepository repo;
	
	//Elegir Tarea
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Tarea> elegirtarea(@PathVariable int id){
		Tarea t = repo.findById(id).get();
		if (t != null) {
			return ResponseEntity.ok(t);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Listar Tarea
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Tarea> listatarea(){
		return repo.findAll();
	}
	
	//Nueva Tarea
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Tarea> creartarea(@RequestBody Tarea t){
		if (t != null) {	
			repo.save(t);
			return ResponseEntity.ok(t);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//Editar Tarea
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Tarea> actualizartarea(@PathVariable int id , @RequestBody Tarea t){
		Tarea n = repo.findById(id).get();
		if (n != null) {
			repo.save(t);
			return ResponseEntity.ok(t);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Eliminar Tarea
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Tarea> eliminartarea(@PathVariable int id){
		Tarea t = repo.findById(id).get();
		if (t != null) {
			repo.deleteById(id);
			return ResponseEntity.ok(t);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}

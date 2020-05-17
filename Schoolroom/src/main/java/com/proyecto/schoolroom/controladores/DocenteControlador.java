package com.proyecto.schoolroom.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.schoolroom.entidades.Docente;
import com.proyecto.schoolroom.repositorios.DocenteRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/docentes/")
public class DocenteControlador {
	
	@Autowired
	DocenteRepository repo;
	
	//Elegir Docente
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Docente> elegirdocente(@PathVariable int id){
		Docente d = repo.findById(id).get();		
		if (d != null) {
			return ResponseEntity.ok(d);
		}
		else {
			return ResponseEntity.notFound().build();
		}		
	}
	
	//Listar Docentes
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<Docente> listadocente(){
		return repo.findAll();
	}
	
	//Crear Docente
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Docente> creardocente(@RequestBody Docente d){
		if (d != null) {
			repo.save(d);
			return ResponseEntity.ok(d);			
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//Actualizar Docente
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Docente> actualizardocente(@PathVariable int id,@RequestBody Docente d){
		Docente n = repo.findById(id).get();
		if (n != null) {
			repo.save(d);
			return ResponseEntity.ok(d);
		}		
		else {
			return ResponseEntity.notFound().build();			
		}
	}
	
	//Eliminar Docente
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Docente> eliminardocente(@PathVariable int id){
		Docente d = repo.findById(id).get();		
		if (d != null) {
			repo.deleteById(id);;
			return ResponseEntity.ok(d);			
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}

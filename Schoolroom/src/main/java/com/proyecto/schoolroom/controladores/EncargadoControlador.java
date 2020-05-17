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

import com.proyecto.schoolroom.entidades.Encargado;
import com.proyecto.schoolroom.repositorios.EncargadoRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/encargados/")
public class EncargadoControlador {

	@Autowired
	EncargadoRepository repo;
	
	//Elegir Encargado
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Encargado> elegirencargado(@PathVariable int id){
		Encargado e = repo.findById(id).get();		
		if (e  != null) {
			return ResponseEntity.ok(e);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Listar Encargados
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<Encargado> listaencargado(){
		return repo.findAll();
	}
	
	//Crear Encargado
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Encargado> crearencargado(@RequestBody Encargado e){
		if (e != null ) {
			repo.save(e);
			return ResponseEntity.ok(e);			
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//Actualizar Encargado
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Encargado> actualizarencargado(@PathVariable int id, @RequestBody Encargado e){
		Encargado n = repo.findById(id).get();
		if (n != null) {
			repo.save(e);		
			return ResponseEntity.ok(e);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Eliminar Encargado
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Encargado> eliminarencargado(@PathVariable int id){
		Encargado e = repo.findById(id).get();		
		if (e != null) {
			repo.deleteById(id);
			return ResponseEntity.ok(e);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}

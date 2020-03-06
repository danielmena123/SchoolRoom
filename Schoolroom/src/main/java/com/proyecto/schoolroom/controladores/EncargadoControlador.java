package com.proyecto.schoolroom.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		Encargado encargado = repo.findById(id).get();
		
		if (encargado != null) {
			return new ResponseEntity<>(encargado, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Lista Encargados
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<Encargado> listaencargado(){
		return repo.findAll();
	}
	
	//Crear Encargado
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Encargado> crearencargado(@RequestBody Encargado encargado){
		repo.save(encargado);
		return new ResponseEntity<>(encargado, HttpStatus.OK);
	}
	
	//Actualizar Encargado
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Encargado> actualizarencargado(@PathVariable int id, @RequestBody Encargado update){
		Encargado encargado = repo.findById(id).get();
		if (encargado != null) {
			repo.save(update);		
			return new ResponseEntity<>(encargado, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Eliminar Encargado
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Encargado> eliminarencargado(@PathVariable int id){
		Encargado encargado = repo.findById(id).get();
		
		if (encargado != null) {
			repo.delete(encargado);
			return new ResponseEntity<>(encargado, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(encargado, HttpStatus.NOT_FOUND);
		}
	}
}

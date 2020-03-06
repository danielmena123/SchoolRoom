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

import com.proyecto.schoolroom.entidades.DetalleGrado;
import com.proyecto.schoolroom.repositorios.DetalleGradoRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/detallegrados/")
public class DetalleGradoControlador {
	
	@Autowired
	DetalleGradoRepository repo;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DetalleGrado> elegirdetalle(@PathVariable int id){
		DetalleGrado detalle = repo.findById(id).get();
		if (detalle != null) {
			return new ResponseEntity<>(detalle, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<DetalleGrado> listadetalle(){
		return repo.findAll();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<DetalleGrado> creardetalle(@RequestBody DetalleGrado detalle){
		repo.save(detalle);
		return new ResponseEntity<>(detalle, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<DetalleGrado> actualizardetalle(@PathVariable int id , @RequestBody DetalleGrado update){
		DetalleGrado detalle = repo.findById(id).get();
		if (detalle != null) {
			repo.save(update);
			return new ResponseEntity<>(update, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<DetalleGrado> eliminarseccion(@PathVariable int id){
		DetalleGrado detalle = repo.findById(id).get();
		if (detalle != null) {
			repo.deleteById(id);
			return new ResponseEntity<>(detalle, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

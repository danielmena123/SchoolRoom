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

import com.proyecto.schoolroom.entidades.Grado;
import com.proyecto.schoolroom.repositorios.GradoRepository;
import com.proyecto.schoolroom.servicios.GenerarCodigo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/grados/")
public class GradoControlador {

	@Autowired
	GradoRepository repo;
	
	//Elegir Grado
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Grado> elegirgrado(@PathVariable int id){
		Grado grado = repo.findById(id).get();
		
		if (grado != null) {
			return new ResponseEntity<>(grado, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Listar Grados
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<Grado> listagrado(){
		return repo.findAll();
	}
	
	//Nuevo Grados
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Grado> creargrado(@RequestBody Grado grado){
		if (grado != null) {
			repo.save(grado);
			return new ResponseEntity<>(grado, HttpStatus.OK);			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Actualizar Grado
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Grado> actualizargrado(@PathVariable int id, @RequestBody Grado update){
		Grado grado = repo.findById(id).get();
		
		if (grado != null) {
			repo.save(update);
			return new ResponseEntity<>(update, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Eliminar Grado
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Grado> eliminargrado(@PathVariable int id){
		Grado grado = repo.findById(id).get();
		
		if (grado != null) {
			repo.deleteById(id);
			return new ResponseEntity<>(grado, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Generar Codigo
	@RequestMapping(value = "/codigo/", method = RequestMethod.GET)
	public ResponseEntity<String> generarCodigo() {
		String cadena = "";
		GenerarCodigo g = new GenerarCodigo();
		cadena = g.Aleatorio();
		
		return ResponseEntity.ok(cadena);
	}
}

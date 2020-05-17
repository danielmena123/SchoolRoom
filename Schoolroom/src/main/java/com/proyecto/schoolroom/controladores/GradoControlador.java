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
		Grado g = repo.findById(id).get();		
		if (g != null) {
			return ResponseEntity.ok(g);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Listar Grados
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<Grado> listagrado(){
		return repo.findAll();
	}
	
	//Listar Grados por Seccion
	@RequestMapping(value="/seccion/{id}", method = RequestMethod.GET)
	public Collection<String> findByGrado(@PathVariable int id){
		return repo.findBynum_grado(id);
	}
	
	//Nuevo Grados
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Grado> creargrado(@RequestBody Grado g){
		if (g != null) {
			repo.save(g);
			return ResponseEntity.ok(g);			
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//Actualizar Grado
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Grado> actualizargrado(@PathVariable int id, @RequestBody Grado g){
		Grado n = repo.findById(id).get();		
		if (n != null) {
			repo.save(g);
			return ResponseEntity.ok(g);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Eliminar Grado
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Grado> eliminargrado(@PathVariable int id){
		Grado g = repo.findById(id).get();		
		if (g != null) {
			repo.deleteById(id);
			return ResponseEntity.ok(g);
		}
		else {
			return ResponseEntity.notFound().build();
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

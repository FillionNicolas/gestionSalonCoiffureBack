package com.mgestion_rdv.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgestion_rdv.configurations.ApplicationPropertiesConfiguration;
import com.mgestion_rdv.entity.Salon;
import com.mgestion_rdv.service.ISalonService;

@CrossOrigin
@RestController
public class SalonController {
	@Autowired
	ISalonService salonService;
	
	@Autowired
	ApplicationPropertiesConfiguration applicationPropertiesConfiguration;

	@GetMapping("/salons")
	public List<Salon> findAll() {
		List<Salon> salons=salonService.findAll();
		List<Salon> listeLimitee=salons.subList(0, applicationPropertiesConfiguration.getLimitDeSalons());	
		return listeLimitee;
	}

	@GetMapping("/salons/{idSalon}")
	public Optional<Salon> findOne(@PathParam("idSalon")Long id) {
		return salonService.findOne(id);
	}
	
	@PostMapping("/salons")
	public Salon saveSalon(@RequestBody Salon salon) {
		return salonService.saveSalon(salon);
	}
	
	@DeleteMapping("/salons/{idSalon}")
	public void deleteSalon(Salon salon) {
		salonService.deleteSalon(salon);
		
	}
}
package com.iurizar.xivqtapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iurizar.xivqtapi.dao.InstanceDAO;
import com.iurizar.xivqtapi.models.Instance;

@RestController
@RequestMapping("instances")
public class InstanceController {
	
	@Autowired
	private InstanceDAO instanceDAO;
	
	public ResponseEntity<List<Instance>> getInstances() {
		List<Instance> instances = instanceDAO.findAll();
		return ResponseEntity.ok(instances);
	}
	
	@RequestMapping(value= "{instance_id}")
	public ResponseEntity<Instance> getInstaceById(@PathVariable("instance_id") Long instance_id) {
		Optional<Instance> optionalInstance = instanceDAO.findById(instance_id);
		if(optionalInstance.isPresent()) {
			return ResponseEntity.ok(optionalInstance.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	
}

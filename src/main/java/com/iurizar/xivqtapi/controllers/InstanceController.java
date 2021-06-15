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
	public ResponseEntity<Instance> getInstanceById(@PathVariable("instance_id") Long instanceId) {
		Optional<Instance> optionalInstance = instanceDAO.findById(instanceId);
		if(optionalInstance.isPresent()) {
			return ResponseEntity.ok(optionalInstance.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value= "{instance_name}")
	public ResponseEntity<Instance> getInstanceByName(@PathVariable("instance_name") String name) {
		Optional<Instance> optionalInstance = instanceDAO.findByName(name);
		if(optionalInstance.isPresent()) {
			return ResponseEntity.ok(optionalInstance.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}

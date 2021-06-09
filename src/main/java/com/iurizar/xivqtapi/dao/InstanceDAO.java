package com.iurizar.xivqtapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iurizar.xivqtapi.models.Instance;

public interface InstanceDAO extends JpaRepository<Instance,Long> {
	Instance findByName(String name);
	Instance findByEncounter(String encounter);
}
package com.iurizar.xivqtapi.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="encounter")
public class Encounter {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long encounter_id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@OneToMany(mappedBy="encounter", targetEntity=Mechanic.class)
	private List<Mechanic> mechanics;
	
	@ManyToOne
	@JoinColumn(name="instance_id",nullable=false)
	private Instance instance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Mechanic> getMechanics() {
		return mechanics;
	}

	public void setMechanics(List<Mechanic> mechanics) {
		this.mechanics = mechanics;
	}

	public Instance getInstance() {
		return instance;
	}

	public void setInstance(Instance instance) {
		this.instance = instance;
	}

	public Long getEncounter_id() {
		return encounter_id;
	}

	public void setEncounter_id(Long encounter_id) {
		this.encounter_id = encounter_id;
	}

	public Encounter(Long encounter_id, String name, List<Mechanic> mechanics, Instance instance) {
		super();
		this.encounter_id = encounter_id;
		this.name = name;
		this.mechanics = mechanics;
		this.instance = instance;
	}
	
}

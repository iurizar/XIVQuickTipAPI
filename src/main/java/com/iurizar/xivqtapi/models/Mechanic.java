package com.iurizar.xivqtapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mechanic")
public class Mechanic {
	
	//Properties
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mechanic_id;
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="phase_num", nullable=true)
	private Integer phase_num;
	
	@ManyToOne
	@JoinColumn(name="encounter_id",nullable=false)
	private Encounter encounter;
	
	
	//Getters and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPhase_num() {
		return phase_num;
	}

	public void setPhase_num(Integer phase_num) {
		this.phase_num = phase_num;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public Long getMechanic_id() {
		return mechanic_id;
	}

	public void setMechanic_id(Long mechanic_id) {
		this.mechanic_id = mechanic_id;
	}

	public Mechanic(Long mechanic_id, String name, String description, Integer phase_num, Encounter encounter) {
		super();
		this.mechanic_id = mechanic_id;
		this.name = name;
		this.description = description;
		this.phase_num = phase_num;
		this.encounter = encounter;
	}
}

package com.iurizar.xivqtapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="mechanic")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mechanic {
	
	//Properties
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mechanicId;
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="description", columnDefinition="TEXT", nullable=false)
	private String description;
	
	@Column(name="phase_num", nullable=true)
	private Integer phase_num;
	
	@ManyToOne
	@JoinColumn(name="encounter_id",nullable=false)
	@JsonIgnore
	private Encounter encounter;

	public Mechanic(String name, String description, Integer phase_num, Encounter encounter) {
		super();
		this.name = name;
		this.description = description;
		this.phase_num = phase_num;
		this.encounter = encounter;
	}
}


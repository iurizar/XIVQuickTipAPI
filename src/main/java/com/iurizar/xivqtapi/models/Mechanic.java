package com.iurizar.xivqtapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="mechanic")
@Data
@AllArgsConstructor
public class Mechanic {
	
	//Properties
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mechanicId;
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="phase_num", nullable=true)
	private Integer phase_num;
	
	@ManyToOne
	@JoinColumn(name="encounter_id",nullable=false)
	private Encounter encounter;
}


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

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="encounter")
@Data
@AllArgsConstructor
public class Encounter {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long encounterId;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@OneToMany(mappedBy="encounter", targetEntity=Mechanic.class)
	private List<Mechanic> mechanics;
	
	@ManyToOne
	@JoinColumn(name="instance_id",nullable=false)
	private Instance instance;
}

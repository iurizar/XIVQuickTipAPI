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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="encounter")
@Data
@NoArgsConstructor
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
	@JsonIgnore
	private Instance instance;

	public Encounter(String name, List<Mechanic> mechanics, Instance instance) {
		super();
		this.name = name;
		this.mechanics = mechanics;
		this.instance = instance;
	}
}

package com.iurizar.xivqtapi.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name="instance")
@Data
@AllArgsConstructor
public class Instance {
	//Properties
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long instanceId;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="tier", nullable=true)
	private String tier;
	
	@Column(name="difficulty", nullable=false)
	private String difficulty;
	
	@OneToMany(mappedBy="instance", targetEntity=Encounter.class)
	private List<Encounter> encounters;
	
	@Column(name="expansion", nullable=false)
	private String expansion;
	
	@Column(name="patch_name", nullable=false)
	private String patch_name;
	
	@Column(name="patch_num", nullable=false)
	private String patch_num;
}

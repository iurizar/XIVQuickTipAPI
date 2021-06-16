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
import lombok.NoArgsConstructor;


@Entity
@Table(name="instance")
@Data
@NoArgsConstructor
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

	public Instance(String name, String tier, String difficulty, List<Encounter> encounters, String expansion,
			String patch_name, String patch_num) {
		super();
		this.name = name;
		this.tier = tier;
		this.difficulty = difficulty;
		this.encounters = encounters;
		this.expansion = expansion;
		this.patch_name = patch_name;
		this.patch_num = patch_num;
	}
}

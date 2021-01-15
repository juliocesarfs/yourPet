package model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class Pet {
	
	private Integer id;
	private String name;
	private String race;
	private String specie;
	private Date birth;
	private String gender;
	
	public Pet() {
		
	}
	
	public Pet(String name, String race, String specie, Date birth, String gender) {
		this.name = name;
		this.race = race;
		this.specie = specie;
		this.birth = birth;
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + name + ", especie=" + specie + ", raça=" + race + ", sexo=" + gender + ", nascimento=" + birth + "]";
	}
}

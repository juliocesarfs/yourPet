package Model;

import java.sql.Date;

import lombok.Data;

public @Data class Pet {
	
	private Integer id;
	private String name;
	private String race;
	private String specie;
	private Date birth;
	private String gender;
	
	public Pet() {
		
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + name + ", especie=" + specie + ", raça=" + race + ", sexo=" + gender + ", nascimento=" + birth + "]";
	}
}

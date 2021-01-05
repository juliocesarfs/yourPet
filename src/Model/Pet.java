package Model;

import java.sql.Date;

public class Pet {
	
	private Integer id;
	private String name;
	private String race;
	private String specie;
	private Date birth;
	private String gender;
	
	public Pet() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRace() {
		return race;
	}
	
	public void setRace(String race) {
		this.race = race;
	}
	
	public String getSpecie() {
		return specie;
	}
	
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	
	public Date getBirth() {
		return birth;
	}
	
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + name + ", especie=" + specie + ", raça=" + race + ", sexo=" + gender + ", nascimento=" + birth + "]";
	}
}

package model;

import java.sql.Date;
import java.util.Calendar;

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
	
	public Integer getAge() {
		
	    Calendar dob = Calendar.getInstance();
	    Calendar today = Calendar.getInstance();
	    
	    String date = this.birth.toString();
		String dateArray[] = date.split("-");

	    dob.set(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[2])); 

	    Integer age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

	    if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
	        age--; 
	    }
	    
	    if (age == -1) age++;

	    return age;  
	}
}

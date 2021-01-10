package Controller;

import Exception.PersistenceException;
import Model.Pet;
import Persistence.DAOPet;

public class ControlPet {
	public DAOPet dao;
		
	public ControlPet() {
		dao = DAOPet.getInstance();
	}
	
	public void include (Pet pet) {
		try {
			dao.include(pet);
		} catch (PersistenceException e) {
			
		}
	}
}

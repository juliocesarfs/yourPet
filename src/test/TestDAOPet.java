package test;

import model.Pet;
import persistence.DAOPet;

public class TestDAOPet {
	public static void main(String[] args) {
		DAOPet dao = DAOPet.getInstance();
		
		Pet pet = dao.getPetById(1);
		
		if (pet == null) {
			System.out.println("Pet n�o encontrado");
		} else {
			System.out.println(pet);
		}
		
	}
}

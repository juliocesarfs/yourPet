package controller;

import java.util.List;

import exception.PersistenceException;
import model.Pet;
import persistence.DAOPet;
import utils.Return;

public class ControlPet {
	public DAOPet dao;
		
	public ControlPet() {
		dao = DAOPet.getInstance();
	}
	
	public Return include(Pet pet) {
		Pet result = null;
		try {
			Return ret = this.validate(pet);
			
			if (!ret.isSucess()) return ret;
			
			result = dao.include(pet);
		} catch (PersistenceException e) {
			return new Return(false, e.getMessage(), pet);
		} catch (Exception e) {
			return this.unknownError(e, pet);
		}
		
		return new Return(true, "Inclusão realizada com sucesso", result);
	}
	
	public Return update(Pet pet) {
		Pet result = null;
		try {
			Return ret = this.validate(pet);
			
			if (!ret.isSucess()) return ret;
			
			result = dao.update(pet);
		} catch (PersistenceException e) {
			return new Return(false, e.getMessage(), pet);
		} catch (Exception e) {
			return this.unknownError(e, pet);
		}
		
		return new Return(true, "Alteração realizada com sucesso", result);
	}
	
	public Return delete(Pet pet) {
		Pet result = null;
		
		try {
			Return ret = this.validate(pet);
			
			if (!ret.isSucess()) return ret;
			
			result = dao.delete(pet);
		} catch (PersistenceException e) {
			return new Return(false, e.getMessage(), pet);
		} catch (Exception e) {
			return this.unknownError(e, pet);
		}
		
		return new Return(true, "Pet deletado com sucesso", result);
	}
	
	public Return listAll() {
		List<Pet> list = null;
		try {
			list = this.dao.listAll();
		} catch (PersistenceException e) {
			return new Return(false, "Erro ao listar. Detalhes: "+e.getMessage(), null);
		} catch (Exception e) {
			return this.unknownError(e, null);
		}
		
		return new Return(true, "Listagem efetuada com sucesso", list);
	}
	
	public Return getPetById(Integer id) {
		Pet pet = null;
		try {
			pet = this.dao.getPetById(id);
			
		} catch (PersistenceException e) {
			return new Return(false, "Erro ao buscar. Detalhes: "+e.getMessage(), null);
		} catch (Exception e) {
			return this.unknownError(e, null);
		}

		
		return new Return(true, "Pet buscado com sucesso", pet);
	}
	
	private Return unknownError(Exception e, Pet obj) {
		return new Return(false, "Erro desconhecido. Detalhes: "+e.getMessage(), obj);
	}
	
	private Return validate(Pet pet) {
		Return ret = new Return(true, "OK", pet);
		if (pet == null) {
			ret.setSucess(false);
			ret.setMessage("informe um pet");
		} else if (pet.getName() == null || pet.getName().equals("") ||
				pet.getRace() == null || pet.getRace().equals("") ||
				pet.getSpecie() == null || pet.getSpecie().equals("") ||
				pet.getGender() == null || pet.getGender().equals("") ||
				pet.getBirth() == null) {
			ret.setSucess(false);
			ret.setMessage("Preencha todos os dados");
		}
		
		return ret;
		
	}
}

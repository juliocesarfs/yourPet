package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import exception.PersistenceException;
import model.Pet;


//SINGLETON
public class DAOPet {
	private static final String SQL_SELECT = "select * from pet";
	private static final String JDBC_PASSWORD = "";
	private static final String JDBC_USER = "postgres";
	private static final String JDBC_URL = 
			// tipo:driver://servidor:porta/banco
			"jdbc:postgresql://localhost:5433/crud";
	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	
	private static DAOPet dao;
	
	private Connection con;
	
	private DAOPet() {
		this.initDriverJDBC();
		this.initConection();
	}
	
	private void initConection() {
		try {
			this.con = DriverManager.getConnection(
					JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			System.out.println("Conectado com o Banco");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar");
			e.printStackTrace();
			throw new PersistenceException("Erro na Conexão com Banco(método initConection() ):", e);
		}
	}
	
	private void initDriverJDBC() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException("Erro no Driver(método: initDriverJDBC() )", e);
		}
	}
	
	public static DAOPet getInstance() {
		if (dao == null)
			dao = new DAOPet();
		
		return dao;
	}

	
	public Pet getPetById(Integer id) {
		Pet pet = null;
		
		String sql = SQL_SELECT+" where id=?";
		PreparedStatement pst;
		
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,  id);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next())
				pet = getPetByResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Erro ao consultar o banco(método getPetById() ):", e);
		}
		return pet;
	}
	
	public List<Pet> listAll() {
		return this.listOrSearch(null);
	}
	
	public List<Pet> findByName(String nome){
		return this.listOrSearch(nome);
	}
	
	private List<Pet> listOrSearch(String name) {
		List<Pet> list = new ArrayList<>();
		
		Pet pet = null;
		String sql = SQL_SELECT;
		
		if (name != null && !name.equals("")) {
			sql = sql +"where name like ?";
		}
		PreparedStatement pst;
		
		try {
			pst = con.prepareStatement(sql);
			//2)
			if (name!=null && !name.equals("")) {
				pst.setString(1, name+"%");
			}
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				pet = getPetByResultSet(rs);
				list.add(pet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Erro ao consultar o Banco(método getPetById() ):", e);
		}
		
		return list;
	}
	
	
	private Pet getPetByResultSet(ResultSet rs) throws SQLException {
		Pet pet;
		pet = new Pet();
		pet.setId(rs.getInt("id"));
		pet.setName(rs.getString("name"));
		pet.setRace(rs.getString("race"));
		pet.setSpecie(rs.getString("specie"));
		pet.setBirth(rs.getDate("birth"));
		pet.setGender(rs.getString("gender"));
		
		return pet;
	}
	
	public Pet include(Pet pet) {
		String sql = "insert into pet(name, race, specie, birth, gender) " + "values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = this.con.prepareStatement(sql, 
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, pet.getName());
			ps.setString(2, pet.getRace());
			ps.setString(3, pet.getSpecie());
			ps.setDate(4, pet.getBirth());
			ps.setString(5, pet.getGender());
			
			ps.executeUpdate();
			
			ResultSet generatedkeys = ps.getGeneratedKeys();
			
			if (generatedkeys.next()) {
				pet.setId(generatedkeys.getInt(1));
			}
			else {
				throw new SQLException("Erro ao criar amigo, ID não retornado");
			}
		} catch (SQLException e) {
			throw new PersistenceException("Erro ao Incluir: "+e.getMessage(), e);
		}
		
		return pet;
	}
	
	public Pet update(Pet pet) {
		String sql = "update pet set name=?, race=?, specie=?, birth=?, gender=?, where id=?";
		
		PreparedStatement ps;
		int affected = 0;
		try {
			ps = this.con.prepareStatement(sql);
			ps.setString(1, pet.getName());
			ps.setString(2, pet.getRace());
			ps.setString(3, pet.getSpecie());
			ps.setDate(4, pet.getBirth());
			ps.setString(5, pet.getGender());
			ps.setInt(6, pet.getId());
			
			affected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Erro ao atualizar: "+e.getMessage(), e);
		}
		
		switch (affected) {
		case 0:
			return null;
		case 1:
			return pet;
		default:
			throw new PersistenceException("Multiplos registros atualizados: ", null);
		}
	}
	
	public Pet delete(Pet pet) {
		String sql = "delete from pet where id=?";
		
		PreparedStatement ps;
		int affected;
		try {
			ps = this.con.prepareStatement(sql);
			ps.setInt(1, pet.getId());
			
			affected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Erro ao remover: "+e.getMessage(), e);
		}
		
		switch (affected) {
		case 0:
			return null;
		case 1:
			return pet;
		default:
			throw new PersistenceException("Multiplos registros removidos: ", null);
		}
	}
}

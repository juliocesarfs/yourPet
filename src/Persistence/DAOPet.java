package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.PersistenceException;
import Model.Pet;


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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

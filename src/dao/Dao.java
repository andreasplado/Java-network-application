package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javabean.Unit;

public class Dao extends AbstractDao {

	public void insertionOfUnit(Unit unit) {
		System.out.println("insertionOfUnit(Unit unit)");
		System.out.println("Inset unit(name and code (javabean)) given in parameter to the database");
		String sql = "INSERT INTO unit" + "(id,name, code) VALUES" + "(NEXT VALUE FOR seq1,?,?)";
		try {
			pst = getConnection().prepareStatement(sql);
			pst.setString(1, unit.getName());
			pst.setString(2, unit.getCode());

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void deleteUnitById(int id) {
		System.out.println("deleteUnitById(int id)");
		System.out.println("delete units by id");
		String sql = "DELETE FROM unit WHERE id = ?";
		try {
			pst = getConnection().prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public List<Unit> findAllUnits(String searchString) {
		System.out.println("findAllUnits(String searchString)");
		System.out.println("finds all units given in parameters");
		List<Unit> units = new ArrayList<Unit>();
		try {
			if (searchString != null && !searchString.isEmpty()) {
				System.out.println("");
				pst = getConnection().prepareStatement("SELECT * FROM unit " + "WHERE UPPER(name) like ?");
				pst.setString(1, "%" + searchString.toUpperCase() + "%");
				rs = pst.executeQuery();
			} else {
				System.out.println("User didn't insert searchstring");
				System.out.println("special information will be prompted");
				st = getConnection().createStatement();
				rs = st.executeQuery("select * from unit");
			}
			while (rs.next()) {
				Unit unit = new Unit();
				unit.setId(rs.getString(1));
				unit.setName(rs.getString(2));
				unit.setCode(rs.getString(3));
				units.add(unit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return units;
	}
	
	public void deleteAllUnits() {
		System.out.println("deleteAllUnits()");
		System.out.println("Method deletes all units");
		String sql = "DELETE FROM unit";
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
}

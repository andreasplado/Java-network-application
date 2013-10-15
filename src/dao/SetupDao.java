package dao;

import java.io.File;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;

public class SetupDao extends AbstractDao {

	public void createSchema() {
		System.out.println("Creating schema of the table");
		if (!tableExists()) {
			System.out.println("Table does not exist");
			executeSqlFromFile(getClassPathFile("schema.sql"));
			insertDefaultData();
		} else {
			System.out.println("table exists");
		}
	}

	private boolean tableExists() {
		try {
			String tableName = "unit";
			DatabaseMetaData metaData = getConnection().getMetaData();
			rs = metaData.getTables(null, null, tableName.toUpperCase(), null);
			return rs.next();
		} catch (SQLException e) {}finally {
			closeResources();
		}
		return false;
	}

	public void insertDefaultData() {
		System.out.println("Insert default data form the file 'defaultdata.sql'");
		executeSqlFromFile(getClassPathFile("defaultdata.sql"));
	}
	private String getClassPathFile(String fileName) {
		return getClass().getClassLoader().getResource(fileName).getFile();
	}
	private void executeSqlFromFile(String sqlFilePath) {
		Project project = new Project();
		project.init();
		SQLExec e = new SQLExec();
		e.setProject(project);
		e.setTaskType("sql");
		e.setTaskName("sql");
		e.setSrc(new File(sqlFilePath));
		e.setDriver("org.hsqldb.jdbcDriver");
		e.setUserid("sa");
		e.setPassword("");
		e.setUrl(DB_URL);
		e.execute();
	}
}

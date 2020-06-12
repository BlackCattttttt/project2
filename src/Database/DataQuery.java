package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DataQuery {
	private Connection con;
	
	public DataQuery () {
		con = DataConection.getConnection();
	}
	public ResultSet view(String table, String [] cols){
        ResultSet resultSet = null;
        try {
            Statement statement = (Statement) con.createStatement();
            String sql = "SELECT ";
            if(cols == null || cols.length == 0){
                sql += "* FROM";
            }else{
                for(int i = 0 ; i < cols.length; i++){
                    sql += "`" + cols[i] + "`, ";
                }
                sql += ";";
                sql = sql.replace("`, ;", "` FROM");
            }
            sql += " " + table;
            if (table.equals("highscore")) sql += " ORDER BY time";
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }
	public boolean insert (String table, Vector<Object> vector) {
		try {
			Statement statement = (Statement) con.createStatement();
			
			String sql = "insert into " + table;
			if (table.equals("highscore")) sql += "(`name`, `time`) value(";
			else if (table.equals("savegame")) sql += "(`name`, `hp`, `mn`, `exp`, `level`, `atk/def`, "
					+ "`crit/arp`, `hat`, `armor`, `scepter`, `shoe`, `item`, `mission`, `time`, `map`, `row/col`) value(";
			for (int i = 0;i < vector.size();i++) {
				sql += "'" + vector.elementAt(i).toString() + "',";
			}
			sql += ")";
			sql = sql.replace("',)", "')");
			
			if (statement.executeUpdate(sql)>=1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(String table, String[] cols, Vector<Object> value, String[] colsWhere, Vector<Object> valueWhere){
        try {
            Statement statement = (Statement) con.createStatement();
            String sql = "update " + table + " set ";
            for(int i = 0 ; i < cols.length; i++){
                sql += "`" + cols[i] + "` = '" + value.elementAt(i) + "', ";
            }
            sql += ";";
            sql = sql.replace("', ;", "' WHERE ");
             
            for(int i = 0 ; i < colsWhere.length; i++){
                sql += "`" + colsWhere[i] + "` = '" + valueWhere.elementAt(i) + "' and ";
            }
            sql += ";";
            sql = sql.replace("' and ;", "'");
            System.out.print(sql);
            statement.executeUpdate(sql);
 
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	public boolean delete(String table, String[] colsWhere, Vector<Object> valueWhere){
        try {
            Statement statement = (Statement) con.createStatement();
            String sql = "DELETE FROM " + table;
             
            if( colsWhere.length > 0){
                sql += " WHERE ";
                for(int i = 0 ; i < colsWhere.length; i++){
                    sql += "`" + colsWhere[i] + "` = '" + valueWhere.elementAt(i).toString() + "' and ";
                }
                sql += ";";
                sql = sql.replace("' and ;", "'");
            }
            statement.executeUpdate(sql);
 
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
        return false;
    }
}

package David_Luca_tema1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {
	String error;
	Connection con;
	// Conectarea la baza de date
	public DBOperations() {}
	public void connect() throws ClassNotFoundException, SQLException, Exception 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/david_luca?useSSL=false", "root", "StelutaDeMare12!");
		} 
		catch (ClassNotFoundException cnfe) 
		{
			error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
			throw new ClassNotFoundException(error);
		} 
		catch (SQLException cnfe) 
		{
			error = "SQLException: Nu se poate conecta la baza de date.";
			throw new SQLException(error);
		} 
		catch (Exception e) 
		{
			error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
			throw new Exception(error);
		}
	}
	// end connect()
	
	public ResultSet vedeTabel(String tabel) throws SQLException, Exception 
	{
		ResultSet rs = null;
		try 
		{
			String queryString = ("select * from `david_luca`.`" + tabel + "`;");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
		} 
		catch (SQLException sqle) 
		{
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} 
		catch (Exception e) 
		{
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	}
	// end vedeTabel()
	
	public void disconnect() throws SQLException 
	{
		try 
		{
			if (con != null) 
			{
				con.close();
			}
		} 
		catch (SQLException sqle) 
		{
			error = ("SQLException: Nu se poate inchide conexiunea la baza de date.");
			throw new SQLException(error);
		}
	} 
	// disconnect()
	
	public void adaugaJudecator(String Nume, String Prenume) throws SQLException, Exception 
	{
		if(con != null)
			try 
			{
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("insert into `david_luca`.`judecatori`(nume_judecator, prenume_judecator) values('" + Nume + "', '" + Prenume + "');");
			} 
			catch (SQLException sqle) 
			{
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		else
		{
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	}

	public void adaugaProces(String NumeR, String PrenumeR, String NumeP, String PrenumeP, String Data, String Obiectul) throws SQLException, Exception
	{
		if(con != null)
		{
			try 
			{
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("insert into `david_luca`.`procese`(nume_reclamant, prenume_reclamant, nume_parat, prenume_parat, data_proces, obiectul_cauzei) values('" + NumeR + "', '" + PrenumeR + "', '" + NumeP + "', '" + PrenumeP + "', '" + Data + "', '" + Obiectul + "');");
			} 
			catch (SQLException sqle) 
			{
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		}
		else
		{
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
		
	}
	
	public void adaugaDosar(Integer id_p, Integer id_j, String Nr, String Denumire, String Status) throws SQLException, Exception 
	{
		if(con != null)
			try 
			{
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("insert into `david_luca`.`dosar`(idproces, idjudecator, nr_dosar, denumire_dosar, status) values('" + id_p + "', '" + id_j + "', '" + Nr + "', '" + Denumire + "', '" + Status + "');");
			} 
			catch (SQLException sqle) 
			{
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		else
		{
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	}
	
	public void stergeTabela(String tabela, String denumirePK, Integer id) throws SQLException, Exception 
	{
		if (con != null) 
		{
			try 
			{
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("delete from " + tabela + " where " + denumirePK + " = '" + id + "';");
			} 
			catch (SQLException sqle)
			{
				error = "ExceptieSQL: Stergere nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} 
		else 
		{
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of stergeTabela()

	public void schimbare(String sql)throws SQLException, Exception 
	{
		if(con != null)
		{
			try
			{
				Statement stmt = con.createStatement();
				stmt.execute(sql);
			}
			catch (SQLException sqle) 
			{
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		}
		else
		{
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	}
	

	public void modificaTabela(String tabela, String primarykey, Integer ID, String[] campuri, String[] valori) throws SQLException, Exception 
	{
		String update = "update " + tabela + " set ";
		String temp = "";
		if (con != null) 
		{
			try 
			{
				for (int i = 0; i < campuri.length; i++) 
				{
					if (i != (campuri.length - 1)) 
					{
						temp = temp + campuri[i] + "='" + valori[i] + "', ";
					} 
					else 
					{
						temp = temp + campuri[i] + "='" + valori[i] + "' where " + primarykey + " = '" + ID + "';";
					}
				}
				update = update + temp;
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate(update);
			} 
			catch (SQLException sqle) 
			{
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} 
		else 
		{
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of modificaTabela()

	public void afisare(ResultSet rs) throws ClassNotFoundException, SQLException, Exception
	{
		int idjudecator;
		String Nume, Prenume;
		while(rs.next())
		{
			idjudecator = rs.getInt("atribut_idjudecator");
			Nume = rs.getString("atribut_numeJ");
			Prenume = rs.getString("atribut_prenumeJ");
			System.out.println("idjudecator = " + idjudecator + ", Nume = " + Nume + ", Prenume = " + Prenume);
		}
	}
}

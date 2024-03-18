package David_Luca_tema1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Dosar {
	private final IntegerProperty IDdosar;
	private final IntegerProperty IDjudecator;
	private final IntegerProperty IDproces;
	private final StringProperty Nr_dosar;
	private final StringProperty Denumire;
	private final StringProperty Status;
	
	public Dosar(Integer iddosar, Integer idjudecator, Integer idproces, String nr_dosar, String denumire, String status)
	{
		this.IDdosar = new SimpleIntegerProperty(iddosar);
		this.IDjudecator = new SimpleIntegerProperty(idjudecator);
		this.IDproces = new SimpleIntegerProperty(idproces);
		this.Nr_dosar = new SimpleStringProperty(nr_dosar);
		this.Denumire = new SimpleStringProperty(denumire);
		this.Status = new SimpleStringProperty(status);
	}
	
	public Integer getIDdosar()
	{
		return IDdosar.get();
	}
	public void setIDdosar(Integer valoare)
	{
		IDdosar.set(valoare);
	}
	public IntegerProperty IDdosarProperty()
	{
		return IDdosar;
	}
	////////////////////////////////////////
	public Integer getIDjudecator()
	{
		return IDjudecator.get();
	}
	public void setIDjudecator(Integer valoare)
	{
		IDjudecator.set(valoare);
	}
	public IntegerProperty IDjudecatorProperty()
	{
		return IDjudecator;
	}
	////////////////////////////////////////////////
	public Integer getIDproces()
	{
		return IDproces.get();
	}
	public void setIDproces(Integer valoare)
	{
		IDproces.set(valoare);
	}
	public IntegerProperty IDprocesProperty()
	{
		return IDproces;
	}
	///////////////////////////////////////////
	public String getNr_dosar()
	{
		return Nr_dosar.get();
	}
	public void setNr_dosar(String valoare)
	{
		Nr_dosar.set(valoare);
	}
	public StringProperty Nr_dosarProperty()
	{
		return Nr_dosar;
	}
	/////////////////////////////////////////
	public String getDenumire()
	{
		return Denumire.get();
	}
	public void setDenumire(String valoare)
	{
		Denumire.set(valoare);
	}
	public StringProperty DenumireProperty()
	{
		return Denumire;
	}
	/////////////////////////////////////////
	public String getStatus()
	{
		return Status.get();
	}
	public void setStatus(String valoare)
	{
		Status.set(valoare);
	}
	public StringProperty StatusProperty()
	{
		return Status;
	}
}

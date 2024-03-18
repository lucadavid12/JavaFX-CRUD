package David_Luca_tema1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Procese {
	private final IntegerProperty IDproces;
	private final StringProperty NumeR;
	private final StringProperty PrenumeR;
	private final StringProperty NumeP;
	private final StringProperty PrenumeP;
	private final StringProperty Data;
	private final StringProperty Obiectul;
	
	public Procese(Integer idproces, String numeR, String prenumeR, String numeP, String prenumeP, String data, String obiectul) 
	{
		this.IDproces = new SimpleIntegerProperty(idproces);
		this.NumeR = new SimpleStringProperty(numeR);
		this.PrenumeR = new SimpleStringProperty(prenumeR);
		this.NumeP = new SimpleStringProperty(numeP);
		this.PrenumeP = new SimpleStringProperty(prenumeP);
		this.Data = new SimpleStringProperty(data);
		this.Obiectul = new SimpleStringProperty(obiectul);
	}
	
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
	/////////////////////////////////
	public String getNumeR()
	{
		return NumeR.get();
	}
	public void setNumeR(String valoare)
	{
		NumeR.set(valoare);
	}
	public StringProperty NumeRProperty()
	{
		return NumeR;
	}
	/////////////////////////////////
	public String getPrenumeR()
	{
		return PrenumeR.get();
	}
	public void setPrenumeR(String valoare)
	{
		PrenumeR.set(valoare);
	}
	public StringProperty PrenumeRProperty()
	{
		return PrenumeR;
	}
	///////////////////////////////
	public String getNumP()
	{
		return NumeP.get();
	}
	public void setNumeP(String valoare)
	{
		NumeR.set(valoare);
	}
	public StringProperty NumePProperty()
	{
		return NumeP;
	}	
	////////////////////////////////
	public String getPrenumeP()
	{
		return PrenumeP.get();
	}
	public void setPrenumeP(String valoare)
	{
		PrenumeP.set(valoare);
	}
	public StringProperty PrenumePProperty()
	{
		return PrenumeP;
	}
	////////////////////////////////
	public String getData()
	{
		return Data.get();
	}
	public void setData(String valoare)
	{
		Data.set(valoare);
	}
	public StringProperty DataProperty()
	{
		return Data;
	}
	/////////////////////////////////////
	public String getObiectul()
	{
		return Obiectul.get();
	}
	public void setObiectul(String valoare)
	{
		Obiectul.set(valoare);
	}
	public StringProperty ObiectulProperty()
	{
		return Obiectul;
	}
}

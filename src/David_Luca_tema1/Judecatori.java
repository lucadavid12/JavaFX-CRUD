package David_Luca_tema1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Judecatori {
	private final IntegerProperty idjudecator;
	private final SimpleStringProperty nume_judecator;
	private final SimpleStringProperty prenume_judecator;

	public Judecatori(Integer idjudecator, String Nume, String Prenume)
	{
		this.idjudecator = new SimpleIntegerProperty(idjudecator);
		this.nume_judecator = new SimpleStringProperty(Nume);
		this.prenume_judecator = new SimpleStringProperty(Prenume);
	}

	public Integer getidjudecator()
	{
		return idjudecator.get();
	}
	public void setidjudecator(Integer valoare)
	{
		idjudecator.set(valoare);
	}
	public IntegerProperty idjudecatorProperty()
	{
		return idjudecator;
	}
	//////////////////////////////////////////
	
	
	public String getnume_judecator()
	{
		return nume_judecator.get();
	}
	public void setnume_judecator(String valoare)
	{
		nume_judecator.set(valoare);
	}
	public StringProperty nume_judecatorProperty()
	{
		return nume_judecator;
	}
	
	/////////////////////////////////////////
	
	public String getprenume_judecator()
	{
		return prenume_judecator.get();
	}
	public void setprenume_judecator(String valoare)
	{
		prenume_judecator.set(valoare);
	}
	public StringProperty prenume_judecatorProperty()
	{
		return prenume_judecator;
	}
}
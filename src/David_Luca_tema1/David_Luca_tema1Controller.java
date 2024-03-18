package David_Luca_tema1;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;


public class David_Luca_tema1Controller implements Initializable{

	@FXML
    private TableColumn<Judecatori, Integer> atribut_idjudecator;
	
	@FXML
    private TableColumn<Judecatori, String> atribut_numeJ;
	
	@FXML
    private TableColumn<Judecatori, String> atribut_prenumeJ;
	
	@FXML
    private TextField atribut_inputNumeJ;

    @FXML
    private TextField atribut_inputPrenumeJ;
	
	//////////////////////////////////////////////////////////////
	
	@FXML
    private TableColumn<Procese, Integer> atribut_idproces;
	
	@FXML
    private TableColumn<Procese, String> atribut_numeR;
    
    @FXML
    private TableColumn<Procese, String> atribut_prenumeR;
    
     @FXML
    private TableColumn<Procese, String> atribut_numeP;
    
    @FXML
    private TableColumn<Procese, String> atribut_prenumeP;

    @FXML
    private TableColumn<Procese, String> atribut_dataproces;

    @FXML
    private TableColumn<Procese, String> atribut_obiectulcauzei;
  
    ////////////////////////////////////////////////////////

    @FXML
    private TableColumn<Dosar, Integer> atribut_iddosar;
    
    @FXML
    private TableColumn<Dosar, Integer> atribut_idjudecator1;

    @FXML
    private TableColumn<Dosar, Integer> atribut_idproces1;

    
    @FXML
    private TableColumn<Dosar, Integer> atribut_nrD;

    @FXML
    private TableColumn<Dosar, String> atribut_denumireD;

    @FXML
    private TableColumn<Dosar, String> atribut_status;
    
    
    @FXML
    private Button buton_refreshP;
    
    @FXML
    private TextField inputIDP_D;
    
    @FXML
    private TextField inputIDJ_D;
    
    @FXML
    private TextField inputData;

    @FXML
    private TextField inputNumeP;
    
    @FXML
    private TextField inputNrDosar;
    
    @FXML
    private TextField inputStatus;
    
    @FXML
    private TextField inputDenumireDosar;

    @FXML
    private TextField inputNumeR;

    @FXML
    private TextField inputObiect;

    @FXML
    private TextField inputPrenumeP;

    @FXML
    private TextField inputPrenumeR;

    @FXML
    private Button buton_IncarcaProces;

    @FXML
    private Button buton_refreshJ;
    
    @FXML
    private Button buton_IncarcareDosar;

    @FXML
    private Button buton_IncarcareJudecator;

    @FXML
    private Button buton_ModificaJudecator;

    @FXML
    private Button buton_ModificaProces;

    @FXML
    private Button buton_ModificareDosar;

    @FXML
    private Button buton_StergeJudecator;

    @FXML
    private Button buton_StergeProces;

    @FXML
    private Button buton_StergereDosar;

    @FXML
    private Tab tab_Dosar;

    @FXML
    private Tab tab_Judecatori;

    @FXML
    private Tab tab_Procese;

    @FXML
    private TableView<Judecatori> tabela_Judecatori;
    
    @FXML
    private TableView<Procese> tabela_Procese;
    
    @FXML
    private TableView<Dosar> tabela_Dosar;
    
    
    private ObservableList<Judecatori> dateJudecatori;
    private ObservableList<Procese> dateProcese;
    private ObservableList<Dosar> dateDosar;
    private DBOperations jb;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    	jb = new DBOperations();
		try
		{
			jb.connect();
			dateJudecatori = FXCollections.observableArrayList();
			ResultSet rs = jb.vedeTabel("judecatori");
			while(rs.next())
			{
				dateJudecatori.add(new Judecatori(rs.getInt("idjudecator"),
													rs.getString("nume_judecator"),
													rs.getString("prenume_judecator")));
			}
			
			atribut_idjudecator.setCellValueFactory(new PropertyValueFactory<>("idjudecator"));
			atribut_numeJ.setCellValueFactory(new PropertyValueFactory<>("nume_judecator"));
			atribut_prenumeJ.setCellValueFactory(new PropertyValueFactory<>("prenume_judecator"));
			
			tabela_Judecatori.setItems(null);
			tabela_Judecatori.setItems(dateJudecatori);
			
			jb.disconnect();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		try
		{
			jb.connect();

			dateProcese = FXCollections.observableArrayList();
			
			ResultSet rs = jb.vedeTabel("procese");
			while(rs.next())
			{
				dateProcese.add(new Procese(rs.getInt("idproces"),
											rs.getString("nume_reclamant"),
											rs.getString("prenume_reclamant"),
											rs.getString("nume_parat"),
											rs.getString("prenume_parat"),
											rs.getString("data_proces"),
											rs.getString("obiectul_cauzei")));
			}
			atribut_idproces.setCellValueFactory(new PropertyValueFactory<>("IDproces"));
			atribut_numeR.setCellValueFactory(new PropertyValueFactory<>("NumeR"));
			atribut_prenumeR.setCellValueFactory(new PropertyValueFactory<>("PrenumeR"));
			atribut_numeP.setCellValueFactory(new PropertyValueFactory<>("NumeP"));
			atribut_prenumeP.setCellValueFactory(new PropertyValueFactory<>("PrenumeP"));
			atribut_dataproces.setCellValueFactory(new PropertyValueFactory<>("Data"));
			atribut_obiectulcauzei.setCellValueFactory(new PropertyValueFactory<>("Obiectul"));
			
			tabela_Procese.setItems(null);
			tabela_Procese.setItems(dateProcese);
			jb.disconnect();
		}
    	catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		try
		{
			jb.connect();
			dateDosar = FXCollections.observableArrayList();
			
			ResultSet rs = jb.vedeTabel("dosar");
			while(rs.next())
			{
				dateDosar.add(new Dosar(rs.getInt("iddosar"),
										rs.getInt("idproces"),
										rs.getInt("idjudecator"),
										rs.getString("nr_dosar"),
										rs.getString("denumire_dosar"),
										rs.getString("status")));
			}
			
			atribut_iddosar.setCellValueFactory(new PropertyValueFactory<>("IDdosar"));
			atribut_idproces1.setCellValueFactory(new PropertyValueFactory<>("IDproces"));
			atribut_idjudecator1.setCellValueFactory(new PropertyValueFactory<>("IDjudecator"));
			atribut_nrD.setCellValueFactory(new PropertyValueFactory<>("Nr_dosar"));
			atribut_denumireD.setCellValueFactory(new PropertyValueFactory<>("Denumire"));
			atribut_status.setCellValueFactory(new PropertyValueFactory<>("Status"));
			
			tabela_Dosar.setItems(null);
			tabela_Dosar.setItems(dateDosar);
			jb.disconnect();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
    	
    }
    
    @FXML
	private void adaugaJudecator() throws SQLException, Exception {
		String nume = atribut_inputNumeJ.getText();
		String prenume = atribut_inputPrenumeJ.getText();
		jb.connect();
		jb.adaugaJudecator(nume, prenume);
		jb.disconnect();
	}
    
    @FXML
    void incarcaJudecator()throws SQLException, Exception
    {
		dateJudecatori = FXCollections.observableArrayList();
	
		jb.connect();

		ResultSet rs = jb.vedeTabel("judecatori");
		while(rs.next())
		{
			dateJudecatori.add(new Judecatori(rs.getInt("idjudecator"),
												rs.getString("nume_judecator"),
												rs.getString("prenume_judecator")));
		}
		
		atribut_idjudecator.setCellValueFactory(new PropertyValueFactory<>("idjudecator"));
		atribut_numeJ.setCellValueFactory(new PropertyValueFactory<>("nume_judecator"));
		atribut_prenumeJ.setCellValueFactory(new PropertyValueFactory<>("prenume_judecator"));
		
		tabela_Judecatori.setItems(null);
		tabela_Judecatori.setItems(dateJudecatori);
		
		jb.disconnect();
		
		
    }
    
    @FXML
    void stergeJudecatori()throws SQLException, Exception
    {
    	jb.connect();
		Judecatori item = tabela_Judecatori.getSelectionModel().getSelectedItem();
		jb.stergeTabela("`david_luca`.`judecatori`","idjudecator", item.getidjudecator());
		jb.disconnect();
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Atentie");
        
        alert.setHeaderText("Linia selectata va fi eliminata din baza de date.");
        alert.setContentText("Stergere finalizata!");
        alert.showAndWait();
    	
    }
    
    
    @FXML
    void schimbaJud() throws SQLException, Exception
    {
    	jb.connect();
    	Judecatori item = tabela_Judecatori.getSelectionModel().getSelectedItem();
    	Integer myindex = item.getidjudecator();
    	
    	String sql = "update `david_luca`.`judecatori` set nume_judecator = '" + atribut_inputNumeJ.getText() + "', prenume_judecator = '" + atribut_inputPrenumeJ.getText() + "' where idjudecator = '" + myindex + "';";
    	jb.schimbare(sql);
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Atentie");
        
        alert.setHeaderText("Datele de pe linia selectata vor fi modificate!");
        alert.setContentText("Modificare finalizata!");
        alert.showAndWait();
    	jb.disconnect();
    }
    
    
    @FXML
    void incarcaProces()throws SQLException, Exception {
		jb.connect();
		dateProcese = FXCollections.observableArrayList();
		
		ResultSet rs = jb.vedeTabel("procese");
		while(rs.next())
		{
			dateProcese.add(new Procese(rs.getInt("idproces"),
										rs.getString("nume_reclamant"),
										rs.getString("prenume_reclamant"),
										rs.getString("nume_parat"),
										rs.getString("prenume_parat"),
										rs.getString("data_proces"),
										rs.getString("obiectul_cauzei")));
		}
		atribut_idproces.setCellValueFactory(new PropertyValueFactory<>("IDproces"));
		atribut_numeR.setCellValueFactory(new PropertyValueFactory<>("NumeR"));
		atribut_prenumeR.setCellValueFactory(new PropertyValueFactory<>("PrenumeR"));
		atribut_numeP.setCellValueFactory(new PropertyValueFactory<>("NumeP"));
		atribut_prenumeP.setCellValueFactory(new PropertyValueFactory<>("PrenumeP"));
		atribut_dataproces.setCellValueFactory(new PropertyValueFactory<>("Data"));
		atribut_obiectulcauzei.setCellValueFactory(new PropertyValueFactory<>("Obiectul"));
		
		tabela_Procese.setItems(null);
		tabela_Procese.setItems(dateProcese);
		jb.disconnect();
    }
    
    @FXML
    void adaugaProces() throws SQLException, Exception {
		String numeR = inputNumeR.getText();
		String prenumeR = inputPrenumeR.getText();
		String numeP = inputNumeP.getText();
		String prenumeP = inputPrenumeP.getText();
		String data = inputData.getText();
		String obiect = inputObiect.getText();
		jb.connect();
		jb.adaugaProces(numeR, prenumeR, numeP, prenumeP, data, obiect);
		jb.disconnect();
	}
    
    @FXML
    void stergeProces()throws SQLException, Exception
    {
    	jb.connect();
		Procese item = tabela_Procese.getSelectionModel().getSelectedItem();
		jb.stergeTabela("`david_luca`.`procese`","idproces", item.getIDproces());
		jb.disconnect();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Atentie");
        
        alert.setHeaderText("Linia selectata va fi eliminata din baza de date.");
        alert.setContentText("Stergere finalizata!");
        alert.showAndWait();
    }
    
    @FXML
    void modificaProces()throws SQLException, Exception
    {
    	jb.connect();
    	Procese item = tabela_Procese.getSelectionModel().getSelectedItem();
    	Integer myindex = item.getIDproces();
    	
    	String sql = "update `david_luca`.`procese` set nume_reclamant = '" + inputNumeR.getText() + "', prenume_reclamant = '" + inputPrenumeR.getText() + "', nume_parat = '" + inputNumeP.getText() + "', prenume_parat = '" + inputPrenumeP.getText() + "', data_proces = '" + inputData.getText() + "', obiectul_cauzei = '" + inputObiect.getText() + "' where idproces = '" + myindex + "';";
    	jb.schimbare(sql);
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Atentie");
        
        alert.setHeaderText("Datele de pe linia selectata vor fi modificate!");
        alert.setContentText("Modificare finalizata!");
        alert.showAndWait();
    	jb.disconnect();
    }
    
    
    
    @FXML
    void incarcaDosar()throws SQLException, Exception {
		jb.connect();
		dateDosar = FXCollections.observableArrayList();
		
		ResultSet rs = jb.vedeTabel("dosar");
		while(rs.next())
		{
			dateDosar.add(new Dosar(rs.getInt("iddosar"),
									rs.getInt("idproces"),
									rs.getInt("idjudecator"),
									rs.getString("nr_dosar"),
									rs.getString("denumire_dosar"),
									rs.getString("status")));
		}
		
		atribut_iddosar.setCellValueFactory(new PropertyValueFactory<>("IDdosar"));
		atribut_idproces1.setCellValueFactory(new PropertyValueFactory<>("IDproces"));
		atribut_idjudecator1.setCellValueFactory(new PropertyValueFactory<>("IDjudecator"));
		atribut_nrD.setCellValueFactory(new PropertyValueFactory<>("Nr_dosar"));
		atribut_denumireD.setCellValueFactory(new PropertyValueFactory<>("Denumire"));
		atribut_status.setCellValueFactory(new PropertyValueFactory<>("Status"));
		
		tabela_Dosar.setItems(null);
		tabela_Dosar.setItems(dateDosar);
		jb.disconnect();
    }
    
    @FXML
    void adaugaDosar() throws SQLException, Exception {
    	String text1 = inputIDP_D.getText();
    	Integer id_p = Integer.parseInt(text1);
    	
    	String text2 = inputIDJ_D.getText();
    	Integer id_j = Integer.parseInt(text2);
    	
    	String nr = inputNrDosar.getText();
		String denumire = inputDenumireDosar.getText();
		String status = inputStatus.getText();
		
		jb.connect();
		jb.adaugaDosar(id_p, id_j , nr, denumire, status);
		jb.disconnect();
	}
    
    @FXML
    void stergeDosar()throws SQLException, Exception
    {
    	jb.connect();
		Dosar item = tabela_Dosar.getSelectionModel().getSelectedItem();
		jb.stergeTabela("`david_luca`.`dosar`","iddosar", item.getIDdosar());
		jb.disconnect();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Atentie");
        
        alert.setHeaderText("Linia selectata va fi eliminata din baza de date.");
        alert.setContentText("Stergere finalizata!");
        alert.showAndWait();
    }
    
    @FXML
    void modificaDosar()throws SQLException, Exception
    {
    	jb.connect();
    	Dosar item = tabela_Dosar.getSelectionModel().getSelectedItem();
    	Integer myindex = item.getIDdosar();
    	
    	String sql = "update `david_luca`.`dosar` set idproces = '" + Integer.parseInt(inputIDP_D.getText()) + "', idjudecator = '" + Integer.parseInt(inputIDJ_D.getText()) + "', nr_dosar = '" + inputNrDosar.getText() + "', denumire_dosar = '" + inputDenumireDosar.getText() + "', status = '" + inputStatus.getText() + "' where iddosar = '" + myindex + "';";
    	jb.schimbare(sql);
    	
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Atentie");
        
        alert.setHeaderText("Datele de pe linia selectata vor fi modificate!");
        alert.setContentText("Modificare finalizata!");
        alert.showAndWait();
    	jb.disconnect();
    }
}


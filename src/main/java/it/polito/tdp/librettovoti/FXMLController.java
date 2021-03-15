package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

public class FXMLController {
	
	private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEsame;

    @FXML
    private TextField txtVoto;

   // @FXML
   // private TextField txtData;
    
    @FXML
    private DatePicker pickerEsame;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	//leggi e controlla i dati
    	String nomeEsame= this.txtEsame.getText();
    	if (nomeEsame.length()==0) {
    		this.txtResult.setText("Errore: nome esame vuoto"); //ci vorrebe una label di info errori. non va stampato in txtResult
    		return;
    	}
    	String votoEsame= this.txtVoto.getText();
    	int votoInt=0;
    	try {
    		votoInt= Integer.parseInt(votoEsame);
    	} catch (NumberFormatException e) {
    		this.txtResult.setText("Errore: il voto deve essere numerico");
    		return;
    	}
    	if (votoInt<18 || votoInt>30) {
    		this.txtResult.setText("Il voto deve essere compreso tra 18 e 30");
    		return;
    	}
    	LocalDate data= this.pickerEsame.getValue();
    	if (data==null) {
    		this.txtResult.setText("Errore: data e' errata o mancante");
    		return;
    	}
    	/*String dataEsame= this.txtData.getText();
    	LocalDate data;
    	try {
    		data=LocalDate.parse(dataEsame);
    	} catch (DateTimeParseException dtpe) {
    		this.txtResult.setText("Formato della data non valido");
    		return;
    	}*/
    	
    	//esegui l'azione
    	Voto voto= new Voto(nomeEsame,votoInt,data);
    	model.add(voto);
    	
    	//aggiorna i risultati nella view
    	this.txtResult.setText(model.toString());
    	//this.txtData.clear();
    	this.txtEsame.clear();
    	this.txtVoto.clear();
    	this.pickerEsame.setValue(null);
    }

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        //assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert pickerEsame != null : "fx:id=\"pickerEsame\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Libretto model) {
    	this.model=model;
    }
}

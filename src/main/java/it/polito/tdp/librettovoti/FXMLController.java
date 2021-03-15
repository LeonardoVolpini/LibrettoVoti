package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

    @FXML
    private TextField txtData;

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
    	int votoInt= Integer.parseInt(votoEsame);
    	String dataEsame= this.txtData.getText();
    	LocalDate data= LocalDate.parse(dataEsame);
    	// TODO: aggiungere controlli sul formato inserito ecc
    	
    	//esegui l'azione
    	Voto voto= new Voto(nomeEsame,votoInt,data);
    	model.add(voto);
    	
    	//aggiorna i risultati nella view
    	this.txtResult.setText(model.toString());
    }

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Libretto model) {
    	this.model=model;
    }
}

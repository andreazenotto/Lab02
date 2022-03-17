package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dizionario;
import it.polito.tdp.alien.model.Traduzione;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Dizionario model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtOutput;

    @FXML
    private TextField txtParole;
    
    @FXML
    private Label txtErrore;

    @FXML
    void doClearText(ActionEvent event) {
    	this.txtOutput.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	if(this.txtParole.getText().equals("")) {
    		this.txtErrore.setText("ERRORE: devi inserire una parola");
    		return;
    	}
    	String[] input = this.txtParole.getText().split(" ");
    	this.txtParole.clear();
    	if(input.length>2) {
    		this.txtErrore.setText("ERRORE: formato di inserimento errato");
    		return;
    	}
    	if(input.length==1) {
    		String traduzione = this.model.getTraduzione(input[0]);
    		if(!traduzione.equals("")) {
    			if(this.txtOutput.getText().contains(traduzione.toString())) {
    				this.txtErrore.setText("ERRORE: traduzione gia presente in output");
        			return;
    			}
    			this.txtOutput.appendText(traduzione);
    			this.txtErrore.setText("");
    			return;
    		}
    		this.txtErrore.setText("ERRORE: parola non presente nel dizionario");
    		return;
    	}
    	this.model.addTraduzione(input[0], input[1]);
    	this.txtErrore.setText("");    	
    }

    @FXML
    void initialize() {
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'Scene.fxml'.";
        
        this.txtOutput.clear();
    }

	public void setModel(Dizionario dizionario) {
		this.model = dizionario;
		
	}

}
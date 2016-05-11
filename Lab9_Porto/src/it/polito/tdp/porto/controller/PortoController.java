package it.polito.tdp.porto.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.porto.model.Autore;
import it.polito.tdp.porto.model.PortoModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class PortoController {

	PortoModel model;
	
	public void setModel(PortoModel porto){
		this.model=porto;
		model.caricaGrafo();
		BoxAuth1.getItems().addAll(model.getAutori());
		BoxAuth2.getItems().addAll(model.getAutori());
		
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ComboBox<Autore> BoxAuth1;

    @FXML
    private ComboBox<Autore> BoxAuth2;

    @FXML
    private Button btnCoautori;

    @FXML
    private Button btnCluster;

    @FXML
    private Button btnArticoli;

    @FXML
    private TextArea txtOutput;

    @FXML
    void doArticoli(ActionEvent event) {

    }

    @FXML
    void doCluster(ActionEvent event) {

    }

    @FXML
    void doCoautori(ActionEvent event) {
    	String s="";
    	for(Autore a:model.visualizzaCoautori(BoxAuth1.getValue()))
    		s+=(a.toString()+"\n");
    	txtOutput.setText(s);
    }

    @FXML
    void initialize() {
    	assert BoxAuth1 != null : "fx:id=\"BoxAuth1\" was not injected: check your FXML file 'Porto.fxml'.";
        assert BoxAuth2 != null : "fx:id=\"BoxAuth2\" was not injected: check your FXML file 'Porto.fxml'.";
        assert btnCoautori != null : "fx:id=\"btnCoautori\" was not injected: check your FXML file 'Porto.fxml'.";
        assert btnCluster != null : "fx:id=\"btnCluster\" was not injected: check your FXML file 'Porto.fxml'.";
        assert btnArticoli != null : "fx:id=\"btnArticoli\" was not injected: check your FXML file 'Porto.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Porto.fxml'.";

    }
}

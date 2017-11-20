package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_compararContenido
				call_compararContenido();
			
				
			}
		};
		//Cuando alguien pulse se llamar� al codigo de this.call_compararContenido()
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_buscarPalabra
				call_buscarPalabra();
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
	}

	private int call_compararContenido() {
		boolean r = model.compararContenido(view.getFichero1().getText(), view.getFichero2().getText());
		view.getTextArea().setText("Los ficheros son " + r);
		// TODO: Llamar a la funci�n compararContenido de GestionDatos
		// TODO: Gestionar excepciones
		return 1;
	}

	private int call_buscarPalabra() {
		try {
			int resultado;
			//Si vale true devuelve la primera y si vale false me devuelve la ultima repetida
			resultado=model.buscarPalabra(view.getFichero1().getText(),view.getPalabra().getText(), view.getPrimera().isSelected());
			//Mostramos en pantalla Java
			view.getTextArea().setText("Se ha encontrado en la l�nea: " + resultado);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			view.showError("Error");
			
		}
		// TODO: Llamar a la funci�n buscarPalabra de GestionDatos
		// TODO: Gestionar excepciones
		return 1;
	}

}

package br.com.WebBroker.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.WebBroker.domain.PFatSelec;
import br.com.WebBroker.domain.ListaFatura;
import br.com.WebBroker.factory.ConexaoFactory;

@ManagedBean(name = "Fatselec")
@RequestScoped
public class mBeansData {
	
	private PFatSelec fatselec = new PFatSelec();
	FacesContext context = FacesContext.getCurrentInstance();
	

	public PFatSelec getFatSelec() {
		return fatselec;
	}
	public void setFatSelec(PFatSelec fatselec) {
		this.fatselec = fatselec;
	}		
	
	
}

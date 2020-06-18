package br.com.WebBroker.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.WebBroker.dao.AngariadorcomboDAO;
import br.com.WebBroker.dao.PjuridicaDAO;
import br.com.WebBroker.dao.SegmentoDAO;
import br.com.WebBroker.domain.Pjuridica;
import br.com.WebBroker.factory.ConexaoFactory;
import br.com.WebBroker.util.JSFUtil;
@RequestScoped
@ManagedBean(name = "MBCep")
public class CEPBean {
// 
//	private  Pjuridica j = new Pjuridica();
//	private BuscaCep cep = new BuscaCep();
	String myTextField;
	FacesContext context = FacesContext.getCurrentInstance();

//	public void localizar() {
//
//		PjuridicaDAO dao = new PjuridicaDAO();
// 
//		try {
//			dao.listar(j);
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//			JSFUtil.adicionarMensagemErro(e.getMessage());
//		}
//	}	
	
//	public Pjuridica getCep() {
//		return cep;
//	}
//
//	public void setCep(Pjuridica cep) {
//		this.cep = cep;
//	}
//	public BuscaCep getCep() {
//		return cep;
//	}
//
//	public void setCep(BuscaCep cep) {
//		this.cep = cep;
//	}
	
	public String getMyTextField() {
		return myTextField;
	}
	public void setMyTextField(String myTextField) {
		this.myTextField = myTextField;
	}

}

package br.com.WebBroker.util;

import java.io.File;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.WebBroker.dao.PcarregarDAO;

@ManagedBean
public class FileUploadView {
	
	public void handleFileUploadBank(FileUploadEvent event) {
		
		PcarregarDAO dao = new PcarregarDAO();
		String sFullPath = null;
		UploadedFile arq = event.getFile();
		File file = new File(arq.getFileName());
		sFullPath = file.getAbsolutePath().replace("\\", "/");
		try {
			dao.importBankAccount(sFullPath);
			dao.salvarBankData(sFullPath);
			FacesMessage message = new FacesMessage("Succesful", file
					+ " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (SQLException e) {

			e.printStackTrace();
			FacesMessage message = new FacesMessage("Non-Succesful", event
					.getFile().getFileName() + " was Failed.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	public void handleFileUpload(FileUploadEvent event) {

		PcarregarDAO dao = new PcarregarDAO();
		String sFullPath = null;
		UploadedFile arq = event.getFile();
		File file = new File(arq.getFileName());
		sFullPath = file.getAbsolutePath().replace("\\", "/");
		try {
			dao.importData(sFullPath);
			dao.salvar(sFullPath);
					
			FacesMessage message = new FacesMessage("Succesful", sFullPath
					+ " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (SQLException e) {

			e.printStackTrace();
			FacesMessage message = new FacesMessage("Non-Succesful", event
					.getFile().getFileName() + " was Failed.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void handleFileUploadFull(FileUploadEvent event) {

		PcarregarDAO dao = new PcarregarDAO();
		String sFullPath = null;
		UploadedFile arq = event.getFile();
		File file = new File(arq.getFileName());
		sFullPath = file.getAbsolutePath().replace("\\", "/");
		try {
			dao.importDataFull(sFullPath);
//			dao.salvarFull(sFullPath);
			FacesMessage message = new FacesMessage("Succesful", sFullPath
					+ " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (SQLException e) {

			e.printStackTrace();
			FacesMessage message = new FacesMessage("Non-Succesful", event
					.getFile().getFileName() + " was Failed.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
}
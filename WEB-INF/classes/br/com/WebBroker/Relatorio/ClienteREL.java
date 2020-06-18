package br.com.WebBroker.Relatorio;

import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import br.com.WebBroker.domain.Report_001;
public class ClienteREL 
{

	private String path; //Caminho base
	
	private String pathToReportPackage; 
	

	public ClienteREL() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "br/com/WebBroker/jasper/";
		System.out.println(path);
	}


	public void imprimir(List<Report_001> report001 ) throws Exception	
	{
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Fechamento.jrxml");
		
		JasperPrint print = JasperFillManager.fillReport(report,null, new JRBeanCollectionDataSource(report001));
 
//		JasperExportManager.exportReportToPdfFile(print, "D:/Particular/eclipse/workspace/WebBroker/Relatorio_de_Clientes.pdf");
		
		JasperViewer viewer = new JasperViewer( print , false );
		viewer.setVisible(true);
		viewer.toFront();

	}
 
	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
	
	public String getPath() {
		return this.path;
	}
}
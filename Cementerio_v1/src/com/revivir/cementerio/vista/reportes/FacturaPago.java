package com.revivir.cementerio.vista.reportes;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.revivir.cementerio.persistencia.entidades.Pago;
import com.revivir.cementerio.vista.util.Formato;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FacturaPago
{
	private JasperReport reporte;
	private JasperViewer reporteViewer;
	private JasperPrint	reporteLleno;
	private Logger log = Logger.getLogger(FacturaPago.class);

	public FacturaPago(List<Pago> pagos)
    {
    	Map <String, Object> totalPersonas = new HashMap<String, Object>();
    	Pago pago = pagos.get(0);
    	totalPersonas.put("fecha", pago.getFecha());
    	totalPersonas.put("cliente", pago.getCliente());
    	totalPersonas.put("descripcion",pago.getCargo());
    	totalPersonas.put("monto", pago.getImporte());
    	totalPersonas.put("observaciones", pago.getObservaciones());
    
    	/*String compiledReport = System.getProperty( "user.dir" + "\\Cementerio_v1\\reportes\\FacturaPago.jasper");

    	//String compiledReport = new File(".").getCanonicalPath() + "\\Cementerio_v1\\reportes\\FacturaPago.jasper";
    	
    	try		{
    		
    		JasperCompileManager.compileReportToFile(
                    "\\Cementerio_v1\\reportes\\FacturaPago.jrxml",//the path to the jrxml file to compile
                    "\\Cementerio_v1\\reportes");//the path and name we want to save the compiled file to
                    
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile(compiledReport );
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, totalPersonas, 
					new JRBeanCollectionDataSource(pagos));
    		System.out.println("Se cargo correctamente la factura de pago.");
		}
		catch( JRException ex ) 
		{
			System.out.println("Ocurrio un error mientras se cargaba el archivo FacturaPago.Jasper \n "+ex);
		}
    }       */
    	try	{
			reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "FacturaPago.jasper" );
			reporteLleno = JasperFillManager.fillReport(reporte, totalPersonas, new JRBeanCollectionDataSource(pagos));
    		log.info("Se cargó correctamente el reporte");
		}
		catch( JRException ex ) {
			log.error("Ocurrió un error mientras se cargaba el archivo porMes.Jasper", ex);
		}
    }       
    	
    
    public void mostrar()
	{
		this.reporteViewer = new JasperViewer(this.reporteLleno,false);
		this.reporteViewer.setVisible(true);
	}
   
}	
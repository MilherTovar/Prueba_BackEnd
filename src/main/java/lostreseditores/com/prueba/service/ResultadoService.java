package lostreseditores.com.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.design.JasperDesign;

import lostreseditores.com.prueba.modelo.Resultado;
import lostreseditores.com.prueba.repository.ResultadoRepository;

@Service
public class ResultadoService {

	@Autowired
	private ResultadoRepository resultadoRepository;
	
	public Resultado create (Resultado resultado) {
		return resultadoRepository.save(resultado);
	}
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "E:\\Report";
        List<Resultado> resultados = resultadoRepository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:resultados.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(resultados);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Los Tres Editores");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\resultados.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\resultados.pdf");
        }

        return "report generated in path : " + path;
    }
}

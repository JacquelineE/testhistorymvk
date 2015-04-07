package com.searcheveryaspect.backend;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 
 * Create an ESDocument	
 * @author Jacqueline Eriksson
 *
 */

public class ESDocumentBuilder {
	
	
	// tar ett GovDocumentLite 
	public ESDocument createESDocument(GovDocumentLite doc){
				
		//m�ste se till att date i doc id har r�tt format	
		String docId = doc.getId();
		
		String publishedTimestamp = doc.getDate(); //fast vill ju inte ha datumet i st�ng format 
			
		LocalDate localDate = new LocalDate();		 
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		String fetchedTimestamp = formatter.print(localDate);
		
		String title = doc.getTitle();
		
		String[] category = new String[]{"Unknown"};
		
		//categhory-> h�mtas ur NLP // Vill man hitta caqtegorier innaan man skapar JSON, skapas JSON doc i ES documentbuilder f�r att 
		//sedan skickas in i databsen i ElasticSearchPut? vad anv�nds i s� fall ESDocument till? S�tt till unknown s� l�nge 
		
		//party ->hur f�r jag ut partiet? tittar jag p� vilka personer som skrivit motionen f�r att d�refter g� in och titta p� 
		//vilket parti dessa personer �r ifr�n. 
		
		String party = "Unknown";
		
		ESDocument eSDoc = new ESDocument(docId, publishedTimestamp, fetchedTimestamp, title, category, party);
		
		return eSDoc;
		
	}

}
	


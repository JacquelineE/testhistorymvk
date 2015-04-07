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
				
		//TODO check that date in the GovDocumentLite object has "yyyy-MM-dd" format 
		String docId = doc.getId();
		
		String publishedTimestamp = doc.getDate(); //fast vill ju inte ha datumet i st�ng format 
			
		LocalDate localDate = new LocalDate();		 
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		String fetchedTimestamp = formatter.print(localDate);
		
		String title = doc.getTitle();
		
		
		//TODO implement NLP to get category 
		
		String[] category = new String[]{"Unknown"};
		
		//party ->hur f�r jag ut partiet? tittar jag p� vilka personer som skrivit motionen f�r att d�refter g� in och titta p� 
		//vilket parti dessa personer �r ifr�n. 
		
		//TODO party != Unknown
		
		String party = "Unknown";
		
		ESDocument eSDoc = new ESDocument(docId, publishedTimestamp, fetchedTimestamp, title, category, party);
		
		return eSDoc;
		
	}

}
	


package com.cognizant.pensionmanagement.csv;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.cognizant.pensionmanagement.model.PensionDetails;


public class CSVPensionerReader {

	
	
	
   
    public  List<PensionDetails> readBooksFromCSV(String fileName) throws ParseException {
        List<PensionDetails> records = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                PensionDetails record = createBook(attributes);
                
                // adding book into ArrayList
                records.add(record);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return records;
    }

    public PensionDetails createBook(String[] metadata) throws ParseException {
    	
    	
    	
    	
        String name = metadata[0];
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
        Date date=formatter1.parse(metadata[1]); 
        String pan = metadata[2];
        Long aadharNumber = Long.parseLong(metadata[3]);
        String selfOrFamilyPension = metadata[4];
        Double salary = Double.parseDouble(metadata[5]);
        Double allowances = Double.parseDouble(metadata[6]);
        String bankName = metadata[7];
        Integer accNo = Integer.parseInt(metadata[8]);
        String bankType = metadata[9];
        
       
        // create and return book of this metadata
        return new PensionDetails(aadharNumber,name,date,pan,selfOrFamilyPension,salary,allowances,accNo,bankName,bankType);
    }

	

}
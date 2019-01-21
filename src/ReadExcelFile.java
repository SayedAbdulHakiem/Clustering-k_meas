import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

class ReadExcelFile{
	//1-this class reads an excel(csv) file into an arraylist of arrayStrings.
List<List<Integer>> allData=new ArrayList<List<Integer>>(); 
public List<List<Integer>> readCSV() { 
	
	try { 
		// Create csvReader object and skip first line
	        FileReader filereader = new FileReader("Course Evaluation.csv");
	        CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
	    // Read all data in the csv and set each line in string[i]= 11;22;33
	        
	        List<String[]> allDataStrings = new ArrayList<>();
	        allDataStrings = csvReader.readAll();
	       
	        for(int i=0;i<allDataStrings.size();i++)
	        {
	        	String currentLine=Arrays.toString(allDataStrings.get(i));
	        	// the string currentLine carries now "[1;2;3;4;5]" 
	        	String currentLineNew =
	        			currentLine.substring(currentLine.indexOf('[')+1 , 
	        					currentLine.lastIndexOf(']'));
	        	// the string currentLineNew carries now "1;2;3;4;5" 
	        	String [] valuesOfEachLine=currentLineNew.split(";");  
	        	/*
	        	 *  now you have for each line an array of the values
	        	 *  of each column with current line as strings 
	        	 *  so to convert this string to integers we will write the following block of code
	        	 */	        	
	        	List<Integer> buffer=new ArrayList<Integer>();
	        	for(int j=0;j<valuesOfEachLine.length;j++)
	        	{   
	        		int tempInt=Integer.parseInt(valuesOfEachLine[j]);
	        		
	        		buffer.add(tempInt);
	        	}
	        	allData.add(buffer);
	        }
	        csvReader.close();
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    }
	    return allData;
	}
	
}
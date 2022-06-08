
/**
 * Write a description of method2check here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class method2check {
public void countryInfo(CSVParser par,String coun)
{
    String info="";
    for(CSVRecord r1:par)
    {
        String country=r1.get("Country");
        
        if(country.contains(coun))
        {
         System.out.println(r1.get("Country")+": "+r1.get("Exports")+": "+r1.get("Value (dollars)"));   
        
        }}
        }
public void tester(String my_coun)
{
     
    FileResource f1=new FileResource();
    CSVParser p1=f1.getCSVParser();
    countryInfo(p1,my_coun);
    
     System.out.println("new function used");
    /* resetting previously defined parser object p1 before use of a different function
    p1=f1.getCSVParser();
    System.out.println(listExportersTwoProducts(p1,my_export2,my_export3));
    System.out.println("new function used");
    p1=f1.getCSVParser();//again resetting the parser object before using a method
    System.out.println(getcountry(p1,my_export)); 
    ,String my_export,String my_export2,String my_export3*/
    
    
   
}
}


/**
 * Write a description of method3check here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class method3check {
public void listExportersTwoProducts(CSVParser p2,String exportItem1,String exportItem2)
{
    
    for(CSVRecord r2:p2)
    {
        String export2=r2.get("Exports");
        if(export2.contains(exportItem1) && export2.contains(exportItem2))
        {
            System.out.println(r2.get("Country"));
        }
    }
}
public void tester(String my_export2,String my_export3)
{
     
    FileResource f1=new FileResource();
    CSVParser p1=f1.getCSVParser();
    /*countryInfo(p1,my_coun);
    
     System.out.println("new function used");
    // resetting previously defined parser object p1 before use of a different function*/
    listExportersTwoProducts(p1,my_export2,my_export3);
    
    /*System.out.println("new function used");
    p1=f1.getCSVParser();//again resetting the parser object before using a method
    System.out.println(getcountry(p1,my_export)); */
    
    
   
}
}

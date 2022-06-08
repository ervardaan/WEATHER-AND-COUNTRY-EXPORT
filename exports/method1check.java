
/**
 * Write a description of method1check here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class method1check {
public int getcountry(CSVParser pp,String exp1)
{
    
    int count=0;
    for (CSVRecord r:pp)
    {
        String export1=r.get("Exports");
        int ref=export1.indexOf(exp1);
        if(ref!=-1){
            System.out.println(r.get("Country"));
        count+=1;// returns no of countries exporting a single export item
    }}
return count;}
public void tester(String my_export)
{
     
    FileResource f1=new FileResource();
    CSVParser p1=f1.getCSVParser();
    /* String req_country=countryInfo(p1,my_coun);
    System.out.println(req_country);
     System.out.println("new function used");
    // resetting previously defined parser object p1 before use of a different function
    p1=f1.getCSVParser();
    System.out.println(listExportersTwoProducts(p1,my_export2,my_export3));
    System.out.println("new function used");
    p1=f1.getCSVParser();//again resetting the parser object before using a method 
    ,String my_export2,String my_export3,String my_coun*/
    System.out.println(getcountry(p1,my_export)); 
    
    
   
}
}

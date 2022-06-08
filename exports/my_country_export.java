
/**
 * Write a description of my_country_export here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class my_country_export {
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
/* THE BELOW FUNCTION CHECKS THE LENGTH OF THE STRINGS TO CHECK FOR GREATNESS IN  VALUE-WHICH IS ACTUALLY FLAWED
 * FOR EXAMPLE, "$41000999"="$3100999" IN THIS METHOD
 * IT ONLY GIVES THE CORRECT OUTPUT FOR VALUES WHICH HAVE MORE DIGITS THAN THE OTHER STRING
 */
public void bigExporters(CSVParser p3,String am)
{
    String check_am="";
    for(CSVRecord r3:p3)
    {
        check_am=r3.get("Value (dollars)");
        if(check_am.length()>am.length())
        {
            System.out.println(r3.get("Country"));
    }}}
      

public void tester(String my_coun,String my_export,String my_export2,String my_export3,String amount)
{
     
    FileResource f1=new FileResource();
    CSVParser p1=f1.getCSVParser();
    countryInfo(p1,my_coun);
    
     System.out.println("new function used");
    // resetting previously defined parser object p1 before use of a different function
    p1=f1.getCSVParser();
    listExportersTwoProducts(p1,my_export2,my_export3);
    System.out.println("new function used");
    p1=f1.getCSVParser();//again resetting the parser object before using a method
    System.out.println(getcountry(p1,my_export)); 
    System.out.println("new function used");
    p1=f1.getCSVParser();//again resetting the parser object
    bigExporters(p1,amount);
   
}}

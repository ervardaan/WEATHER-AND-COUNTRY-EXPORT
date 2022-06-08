
/**
 * Write a description of method4check here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.lang.*;
import edu.duke.*;
import org.apache.commons.csv.*;
public class method4check {
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
public void tester(String amount)
{
    FileResource f1=new FileResource();
    CSVParser p1=f1.getCSVParser();
    bigExporters(p1,amount);
}}

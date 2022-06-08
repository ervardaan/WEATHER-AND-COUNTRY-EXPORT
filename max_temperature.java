
/**
 * Write a description of max_temperature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class max_temperature {
public void find_max_temp(CSVParser p1)
{
   int max_temp1=0;int count_row=0;int c=0;
    for(CSVRecord r1:p1)
    {
        c+=1;
        String temp1=r1.get("TemperatureF");
        int convert_temp1=Integer.parseInt(temp1);
        if(convert_temp1>=max_temp1)
        {
            max_temp1=convert_temp1;
            count_row=c;
        }
}
System.out.println(max_temp1 +" "+count_row);
}
public void checkmethod()
{
    FileResource f=new FileResource();
    CSVParser p=f.getCSVParser();
    find_max_temp(p);
}}

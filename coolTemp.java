
/**
 * Write a description of coolTemp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;
public class coolTemp {
public CSVRecord find_temp(CSVParser p)
{
    CSVRecord max_temp=null;
    for(CSVRecord r:p)
    {
       max_temp=compare2values(max_temp,r); 
}
return max_temp;
}
public CSVRecord compare2values(CSVRecord max_temp,CSVRecord r)
{
    if(max_temp==null)
        {
            max_temp=r;
        }
        else
        {
            double temp=Double.parseDouble(r.get("TemperatureF"));
        double maxt=Double.parseDouble(max_temp.get("TemperatureF"));
        if(maxt<temp)
        {
            max_temp=r;
        }
    }
    return max_temp;
}
public CSVRecord testmethod()
{
    CSVRecord max_row=null;
    DirectoryResource dr=new DirectoryResource();
    for(File f:dr.selectedFiles())//take a fle name out of an iterable of file names
    {
        FileResource fr=new FileResource(f);
        CSVParser p1=fr.getCSVParser();
        CSVRecord cur_row=find_temp(p1);
        max_row=compare2values(max_row,cur_row);
    }
    return max_row;
}
public void runmethod()
{
  CSVRecord maximumrow=testmethod();
  System.out.println(maximumrow.get("TemperatureF") +"       "+maximumrow.get("DateUTC"));
}
}

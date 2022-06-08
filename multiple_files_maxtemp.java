
/**
 * Write a description of multiple_files_maxtemp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;
public class multiple_files_maxtemp {
public CSVRecord find_temp(CSVParser p)
{
    CSVRecord max_temp=null;
    for(CSVRecord r:p)
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
    }}
    return max_temp;
}

public CSVRecord testmethod()
{
    CSVRecord max_row=null;
    DirectoryResource dr=new DirectoryResource();double mtemp=0.0;double cur_mtemp=0.0;
    for(File f:dr.selectedFiles())//take a fle name out of an iterable of file names
    {
        FileResource fr=new FileResource(f);
        CSVParser p1=fr.getCSVParser();
        CSVRecord cur_row=find_temp(p1);
        if(max_row==null)
        {
            max_row=cur_row;
        }
        else
        {
            mtemp=Double.parseDouble(max_row.get("TemperatureF"));
            cur_mtemp=Double.parseDouble(cur_row.get("TemperatureF"));
            if(mtemp<cur_mtemp)
            {
                max_row=cur_row;
            }
        }
    }
    return max_row;
}
public void runmethod()
{
  CSVRecord maximumrow=testmethod();
  System.out.println(maximumrow.get("TemperatureF") +"       "+maximumrow.get("DateUTC"));
}
}
        
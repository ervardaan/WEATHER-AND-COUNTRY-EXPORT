
/**
 * Write a description of CHECKAGAIN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;
public class checkagain {
public CSVRecord coldestHourInFile(CSVParser p)
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
        if(maxt>temp && temp>-273)//for coldest,we changed the operator to find min temperature and we account for a bogus value -9999
        {
            max_temp=r;
        }
    }
    return max_temp;
}
public String compare2valuesoffiles(CSVRecord max_temp,CSVRecord r,String fnet)
{
    String ourfile="";
    if(max_temp==null)
        {
            max_temp=r;
        }
        else
        {
            double temp=Double.parseDouble(r.get("TemperatureF"));
        double maxt=Double.parseDouble(max_temp.get("TemperatureF"));
        if(maxt>temp && temp>-273)//for coldest,we changed the operator to find min temperature and we account for a bogus value -9999
        {
            ourfile=fnet;
        }
    }
   return ourfile; 
}
public void testcoldestHourInFile()
{
    FileResource fr=new FileResource();
    CSVParser p1=fr.getCSVParser();
    CSVRecord max_temp=coldestHourInFile(p1);
    System.out.println(max_temp.get("TemperatureF")+"       "+max_temp.get("DateUTC"));
}
public String fileWithColdestTemperature()
{
    CSVRecord max_row=null;String get_file="";
    DirectoryResource dr=new DirectoryResource();
    for(File f:dr.selectedFiles())//take a fle name out of an iterable of file names
    {
        FileResource fr=new FileResource(f);
        CSVParser p1=fr.getCSVParser();
        CSVRecord cur_row=coldestHourInFile(p1);
         get_file=f.getName();
        get_file=compare2valuesoffiles(max_row,cur_row,get_file);
    }
    return get_file;
}
public void testfileWithColdestTemperature()
{
String collectmaxfile=fileWithColdestTemperature();
  System.out.println(collectmaxfile);
}
}


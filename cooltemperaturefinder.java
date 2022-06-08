
/**
 * Write a description of cooltemperaturefinder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;
public class cooltemperaturefinder {
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
public void testcoldestHourInFile()
{
    FileResource fr=new FileResource();
    CSVParser p1=fr.getCSVParser();
    CSVRecord max_temp=coldestHourInFile(p1);
    System.out.println(max_temp.get("TemperatureF")+"       "+max_temp.get("DateUTC"));
}
public String fileWithColdestTemperature()
{
    CSVRecord max_row=null;String fcollect="";
    DirectoryResource dr=new DirectoryResource();
    for(File f:dr.selectedFiles())//take a fle name out of an iterable of file names
    {
        FileResource fr=new FileResource(f);
        CSVParser p1=fr.getCSVParser();
        CSVRecord cur_row=coldestHourInFile(p1);
        max_row=compare2values(max_row,cur_row);
    }
    for(File f1:dr.selectedFiles())
    {
        FileResource fr1=new FileResource(f1);
        CSVParser p12=fr1.getCSVParser();
        for(CSVRecord new_row:p12)
        {
            if(new_row==max_row)
            {
                fcollect=f1.getName();
            }}}
               return fcollect;
}
public void testfileWithColdestTemperature()
{
String collectmaxfile=fileWithColdestTemperature();
  System.out.println(collectmaxfile);
}
}

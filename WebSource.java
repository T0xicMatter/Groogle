import java.lang.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class WebSource
{	
	public String getUrlSource(String url) throws IOException
	{
		URL yahoo = new URL(url);
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
		{
            a.append(inputLine);
		}	
        in.close();

        return a.toString();
    }
}	
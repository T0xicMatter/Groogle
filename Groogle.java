import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Groogle
{	
	public static void main(String[] args) throws IOException
	{
		WebSource ws = new WebSource();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEnter Search Query: "); 
		String rawquery = br.readLine();
		StringTokenizer st = new StringTokenizer(rawquery);
		String query="";
		while(st.hasMoreElements())
		{
			query=query+"+"+st.nextElement();
		}
		query=query.substring(1);
		String queryurl = "https://www.wolframalpha.com/input/?i="+query;
		String raw_html = ws.getUrlSource(queryurl);
	
		//Stringified
		String sync = "{\"stringified\":";
		String ans = "";
		char tt='\0',tt1='\0',tt2='\0',tt3='\0',ttage='\0';
		int index;
		for (index = raw_html.indexOf(sync);index >= 0;index = raw_html.indexOf(sync, index + 1))
		{
			for(int i=0;i<1000;i++)
			{
				tt = raw_html.charAt(index+i+16);
				tt1	= raw_html.charAt(index+i+13);
				tt2 = raw_html.charAt(index+i+14);
				tt3 = raw_html.charAt(index+i+15);
				if(tt==':')
				{
					if(tt1 == 'a' && tt2=='g' && tt3 == 'e')
					{
						for(int j=i;j<i+11;j++)
						{
							ttage=raw_html.charAt(index+j+16);
							ans=ans+ttage;
						}
						break;
					}
					break;
				}	
				ans=ans+tt;
			}
			ans=ans+" \n ";
		}	
		
		
		//Answer Formatting:
		String[] del1 = ans.split(",\"mInput\"");
		String ans2 = "";
		
		for(int x= 0; x<del1.length;x++)
		{
			ans2=ans2+" "+del1[x];
		}
		
		System.out.println(ans2);
		
		//String ans3=ans2.replaceAll("(\\)(n)", "~");
		
		//System.out.println(ans3);
	}
}	

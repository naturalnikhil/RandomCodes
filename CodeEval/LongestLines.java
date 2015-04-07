import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)
	{
		new Main(args[0]);
	}
	
	Main(String file)
	{
		InputReader in=new InputReader(file);
		
		int n = in.nextInt();
		
		PriorityQueue<String> pq = new PriorityQueue<String>(n,new Comparator<String>(){
			public int compare(String s1, String s2)
			{
				if(s1.length()<s2.length()) return -1;
				else if(s1.length()>s2.length()) return 1;
				return 0;
			}
		});
		
		String s=null;
		while((s=in.nextLine())!=null)
		{
			if(pq.size()==n)
			{
				if(pq.peek().length()<s.length())
				{
					pq.poll();
				}
				else
					continue;
			}

			pq.add(s);
		}
		
		Stack<String> st = new Stack<String>();
		Iterator<String> it = pq.iterator();
		while(it.hasNext()) st.push(it.next());
		
		PrintWriter out = new PrintWriter(System.out);
		while(!st.isEmpty()) out.println(st.pop());
		
		out.close();
	}
	
	
	private class InputReader{
		
		StringTokenizer tokenizer;
		BufferedReader reader;
		
		@SuppressWarnings("unused")
		InputReader(InputStream in)
		{
			reader = new BufferedReader(new InputStreamReader(in), 32768);
			tokenizer=null;
		}
		
		InputReader(String file)
		{
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)), 32768);
			} catch (FileNotFoundException e) {
				throw new RuntimeException();
			}
			tokenizer=null;
		}

		
		String nextLine()
		{
			try {
				return reader.readLine();
			} catch (IOException e) {
			}
			
			return null;
		}

		
		String next()
		{
			if(tokenizer==null || !tokenizer.hasMoreTokens())
				try {
					tokenizer = new StringTokenizer(reader.readLine(),"\\n+");
				} catch (Exception e) {
					return null;
				}
			
			return tokenizer.nextToken();
		}
		
		Integer nextInt()
		{
			return Integer.parseInt(next());
		}
	}

}

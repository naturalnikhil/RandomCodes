package com.codeeval;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)
	{
		new Main("test.txt");//args[0]);
	}
	
	Main(String file)
	{
		InputReader in=new InputReader(file);
		PrintWriter out = new PrintWriter(System.out);
		
		String line=null;
		while((line=in.nextLine())!=null)
		{
			LinkedList<Character> list = new LinkedList<Character>();
			for(char ch : line.toCharArray())
				list.add(ch);
			
			Collections.sort(list);
			
			ArrayList<LinkedList<Character>> res = new ArrayList<LinkedList<Character>>();
			
			permute(list,res,0);
			
			for(int i=0;i<res.size();++i)
			{
				LinkedList<Character> ll = res.get(i); 
				for(Character ch : ll)
					out.print(ch);
				
				if(i+1<res.size()) out.print(',');
			}
			
			out.println();
		}
		
		out.close();
	}
	
	@SuppressWarnings("unchecked")
	void permute(LinkedList<Character> list, ArrayList<LinkedList<Character>> res, int pos)
	{
		if(pos==list.size())
		{
			res.add((LinkedList<Character>) list.clone());
			return;
		}
		
		permute(list, res, pos+1);
		
		for(int i=pos+1;i<list.size();++i)
		{
			list.add(pos, list.remove(i));
			
			permute(list,res,pos+1);
			
			list.add(i, list.remove(pos));
		}
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
					tokenizer = new StringTokenizer(reader.readLine());
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

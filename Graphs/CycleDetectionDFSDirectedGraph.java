package com.practice.onlinejudge.aizu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class CycleDetection {

	int V, E;

	List<Integer>[] adj;

	boolean[] visited, completed;

	public static void main(String[] args)
	{
		new CycleDetection();
	}

	@SuppressWarnings("unchecked")
	public CycleDetection()
	{
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);

		V=in.nextInt();
		E=in.nextInt();

		adj = new LinkedList[V];
		for(int i=0; i<V; ++i)
			adj[i]=new LinkedList<Integer>();

		for(int i=0;i<E;++i)
			adj[in.nextInt()].add(in.nextInt());

		boolean flag = isCycle();

		if(flag) out.println("1");
		else out.println("0");

		out.close();
	}

	boolean isCycle()
	{
		visited= new boolean[V];
		completed = new boolean[V];

		boolean flag=false;
		for(int i=0;i<V;++i)
			if(!visited[i])
				if((flag=dfs(i))==true) 
					return true;

		return flag;
	}

	boolean dfs(int u)
	{
		visited[u]=true;

		for(int v : adj[u])
		{
			if(!visited[v]) 
			{
				if(dfs(v)==true)
					return true;
			}
			else if(visited[v] && !completed[v])
				return true;
		}

		completed[u]=true;

		return false;
	}

	private class InputReader{

		private StringTokenizer tokenizer;
		private BufferedReader reader;

		InputReader(InputStream in)
		{
			reader = new BufferedReader(new InputStreamReader(in), 32768);
		}

		String next()
		{
			if(tokenizer==null || !tokenizer.hasMoreTokens())
			{
				try {
					tokenizer=new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return tokenizer.nextToken();
		}

		int nextInt()
		{
			return Integer.parseInt(next());
		}
	}
}

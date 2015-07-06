package com.practice.onlinejudge.aizu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class TPS {

	int V, E;

	List<Integer>[] adj;

	boolean[] visited;
	
	LinkedList<Integer> res;

	public static void main(String[] args)
	{
		new TPS();
	}

	@SuppressWarnings("unchecked")
	public TPS()
	{
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);

		V=in.nextInt();
		E=in.nextInt();

		res = new LinkedList<Integer>();
		
		// init adj
		adj = new LinkedList[V];
		for(int i=0; i<V; ++i)
			adj[i]=new LinkedList<Integer>();

		// fill graph
		for(int i=0;i<E;++i)
			adj[in.nextInt()].add(in.nextInt());

		// do TPS
		tps();

		// print ordering
		for(Integer i : res)
			out.println(i);

		out.close();
	}
	
	void tps()
	{
		visited=new boolean[V];
		for(int i=0;i<V;++i)
			if(!visited[i])
				dfs(i);
	}
	
	void dfs(int u)
	{
		visited[u]=true;
		
		for(int v : adj[u])
			if(!visited[v])
				dfs(v);
		
		res.addFirst(u);
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

package com.practice.onlinejudge.aizu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MST {
	
	int V, E;
	
	PriorityQueue<Edge> pq;
	
	int[] p;

	public static void main(String[] args)
	{
		new MST();
	}
	
	public MST()
	{
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		V=in.nextInt();
		E=in.nextInt();
		
		pq = new PriorityQueue<Edge>(E+1, new Comparator<Edge>(){
			public int compare(Edge a, Edge b)
			{
				if(a.w<b.w) return -1;
				if(a.w>b.w) return 1;
				return 0;
			}
		});
		
		for(int i=0;i<E;++i)
			pq.add(new Edge(in.nextInt(),in.nextInt(),in.nextInt()));
		
		out.println(kruskal());
		
		out.close();
	}
	
	int kruskal()
	{
		int sum=0, nE=0;
		
		p = new int[V];
		for(int i=0;i<V;++i)
			p[i]=i;
		
		while(!pq.isEmpty() || nE<V-1)
		{
			Edge tmp = pq.poll();
			
			// check formation of cycle
			if(connected(tmp.u, tmp.v)) continue;
			
			sum+=tmp.w;
			
			union(tmp.u, tmp.v);
			
			++nE;
		}
		
		return sum;
	}
	
	void union(int u, int v)
	{
		int root1=find(u), root2=find(v);
		
		if(root1<root2) p[root2]=root1;  // union by rank
		else p[root1]=root2;
	}
	
	boolean connected(int u, int v)
	{
		if(find(u)==find(v)) return true;
		
		return false;
	}
	
	int find(int u)
	{
		while(p[u]!=u)
		{
			int tmp=p[u];
			p[u]=p[p[u]];  // path compression
			u=tmp;
		}
		
		return u;
	}
	
	private class Edge{
		
		public int u, v, w;
		
		Edge(int u, int v, int w)
		{
			this.u=u;
			this.v=v;
			this.w=w;
		}
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

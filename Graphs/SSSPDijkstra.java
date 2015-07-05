package com.practice.onlinejudge.aizu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// validated at:
// http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_A

public class SSSP {
	
	int V, E, src;
	
	List<Node>[] adj;
	
	int[] dist;

	public static void main(String[] args)
	{
		new SSSP();
	}
	
	@SuppressWarnings("unchecked")
	public SSSP()
	{
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		V=in.nextInt();
		E=in.nextInt();
		src=in.nextInt();
		
		// create & init adj-list
		adj = new LinkedList[V];
		for(int i=0;i<V;++i)
			adj[i]=new LinkedList<Node>();
		
		// fill graph
		for(int i=0;i<E;++i)
			adj[in.nextInt()].add(new Node(in.nextInt(), in.nextInt()));
		
		// init dist of all vertices
		dist=new int[V];
		for(int i=0;i<V;++i)
			dist[i]=Integer.MAX_VALUE;
		
		dist[src]=0;
		
		// call dijkstra
		dijkstra();
		
		// print path of vertices
		for(int i=0;i<V;++i)
			if(dist[i]==Integer.MAX_VALUE) out.println("INF");
			else out.println(dist[i]);
		
		out.close();
	}
	
	
	void dijkstra()
	{
		PriorityQueue<Node> pq = new PriorityQueue<Node>(V, new Comparator<Node>(){
			@Override
			public int compare(Node a, Node b) {
				
				if(a.w<b.w) return -1;
				if(a.w>b.w) return 1;
			
				return 0;
			}
		});
		
		
		pq.add(new Node(src, dist[src]));
		
		while(!pq.isEmpty())
		{
			Node tmp = pq.poll();
			
			if(tmp.w > dist[tmp.v]) continue;
			
			for(Node n : adj[tmp.v])
			{
				if(dist[n.v] > dist[tmp.v] + n.w)
				{
					dist[n.v]=dist[tmp.v]+n.w;
					pq.add(new Node(n.v, dist[n.v]));
				}
			}
		}
	}
	
	private class Node{
		
		public int v,w;
		
		Node(int v, int w)
		{
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

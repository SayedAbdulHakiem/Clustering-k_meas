import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Clustering c=new Clustering();
		Scanner s= new Scanner(System.in);
		System.out.println("Enter The Number Of Cluster :");
		int n=s.nextInt();
		System.out.println("Enter the maximum distance available:");
		float maxDistance=s.nextFloat();
		s.close();
		
		c.setNumberOfClusters(n);
		c.setMaxDistance(maxDistance);
		c.setInitialCentroids();
		List<List<Integer>>finalClustered=new ArrayList<List<Integer>>();
		List<List<Float>>  finalCentroids=new ArrayList<List<Float>>();
		finalCentroids=c.getFinalCentroid();
		finalClustered=c.getClusteredScores(finalCentroids,true);
		// true because it is the final clustering
		int NumFinalClustered=finalClustered.size();
		int NumFinalCentroids=finalCentroids.size();
		
		System.out.println("finalCentroids ");
		for(int i=0;i<NumFinalCentroids;i++)
			System.out.println(c.initialCentroid.get(i));
		
		System.out.println(" \n 	F i n a l  C l u s t e r e d  \n");
		for(int row=0;row<NumFinalClustered;row++)
			System.out.println(finalClustered.get(row));
	
		c.printOutlieres();
	
		
	}

}

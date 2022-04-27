ATechDaily


 

Hill Climbing Program in Java
[22388 views]


What is Hill Climbing?
Hill Climbing Algorithm is an optimization strategy used to find the "local optimum solution" to a mathematical problem. It starts with a solution that is poor compared to the optimal solution and then iteratively improves. This is being done by generating "neighbor" solutions which are relatively a step better than the current existing solution, it then picks the best and repeats the process until it comes with the most optimal solution because it can no longer find any improvements after that.


Hill Climbing Algorithm:

Step 1 : Evaluate the Initial state. If the first state is a goal state then stop and return success. Else, make the Initial state as Current state. 

Step 2 : Loop until the Solution state is found or if there are no new operators present which can be applied to current state.

a) Select a state that has not yet been applied to the current state and then apply it to produce a New state.

b) Perform these steps to evaluate New state:
    i. If the current state is the Goal state, then Stop and return success.
    ii. If the New state is better than the current state, then make it the Current state and proceed further.
    iii. If the New state is not better than the current state, then continue the iteration until a solution is found.

Step 3 : Exit.
hillClimbing.java
import java.util.Scanner;

public class hillClimbing {

	
	public static void main(String[] args) {
		int n,i,j;
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of nodes in graph");
		n=sc.nextInt();
		
			
		int[][] graph=new int[n][n];
		
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				graph[i][j]=0;
						
		for(i=0;i<n;i++)
		{
			for(j=i+1;j<n;j++)
			{
				System.out.println("Is "+i+" is connected to "+ j);	
				graph[i][j]=sc.nextInt();
			}
		}
		System.out.println("The adjacency matrix is:");
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{		System.out.print(graph[i][j]+ "\t");
			}
			System.out.println();
		}
		
		}

}

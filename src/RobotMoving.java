//Adam Baldwin R00176025

public class RobotMoving {

		public static void robotMoving(double[] costArray,  int n) {
			//new matrix created to store the lowest cost to get to a position
			double costMatrix[][] = new double[n][n];
			
			for(int i=0; i<n;i++) {
				for(int j=0; j<n; j++) {
					//If i==0 and j==0, this is the origin point and there is not movement cost
					if(i==0 && j==0) {
						costMatrix[i][j] = 0;
					}
					
					//If i==0 this means we are on the first row. The variable j determines what position we are at on this row
					//We set the value at this index to be the previous value plus the cost of moving to the right which is stored at costArray[0]
					if(i==0 && j>0) {
						costMatrix[i][j] = costArray[0] + costMatrix[i][j-1];
					}
					
					//If j==0 this means we are on the first column. The variable i determines what position we are at on this column
					//We set the value at this index to be the previous value plus the cost of moving down which is stored at costArray[1]
					if(i>0 && j==0) {
						costMatrix[i][j] = costArray[1] + costMatrix[i-1][j];
					}
					
					//This is for when we aren't on the first row or column. The lowest cost is determined using the Math.min function twice to get the lowest cost of the 3 possible costs
					if(i>0 && j>0) {
						costMatrix[i][j] = Math.min(costArray[0] + costMatrix[i][j-1], Math.min(costArray[1] + costMatrix[i-1][j], costArray[2] + costMatrix[i-1][j-1]));
					}
				}
			}
			
			//Prints the costMatrix
			for(int k=0;k<n;k++) {
				for(int l=0;l<n;l++) {
					System.out.printf("%.1f" + " ", costMatrix[k][l]);
				}
				System.out.println();
			}
			//Prints the minimum cost to get to the farthest point
			System.out.println("Minimum Cost: " + costMatrix[n-1][n-1]);
			System.out.println();
	}
		
		
		public static void main(String[] args) {
		    
		    double cost1[] = {1.1, 1.3, 2.5};
		    double cost2[] = {1.5, 1.2, 2.3};
		    
		    System.out.println("Cost Array1");
		    robotMoving(cost1, 10);
		    System.out.println("Cost Array2");
		    robotMoving(cost2, 10);

		  }
}

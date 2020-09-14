//Adam Baldwin R00176025

public class PaperRollCuttingBottomUp {

	
	  public static void bottomUpRodCutting(double p[], int len) {
		    //cutList is the list of optimal cuts
		    int [] cutList = new int[len+1];
		    // r[i] is the optimal cut for a rod of length i
	        double[] r = new double[len+1];
	        //set the r[0] to 0 because length 0 of paper is worthless
	        r[0] = 0;
	        
	        for (int j = 1; j < r.length; j++) {
	            // q is used to represent an unknown value
	        	//known values are always non negative, which is why we use negative infinity to denote an unknown value
	            double q = Double.NEGATIVE_INFINITY;

	            //This loop checks to find the best value cut for the current length
	            for (int i = 1; i <= Math.min(j, p.length - 1); i++) {   
	            	if(q<p[i] + r[j-i]) {
	            		q = Math.max(q, p[i] + r[j-i]);
	            		cutList[j] = i;
	                }
	            }
	            
	            r[j] = q;
	        }

	        // print the best possible revenue for that length of paper
	        System.out.println("Best Revenue:" + r[len]);
	        
	        // prints the length of the optimal cuts made
	        int l = len;
	        System.out.println("Cut Lengths:");
	        while(l>0) {
	        	int cut = cutList[l];
	        	System.out.println(cut);
	        	l -= cut;
	        }
	              
	  }
	  
	  
	  public static void main(String[] args) {
	    // array starting from 1, element at index 0 is fake
	    double prices[] = {0, 1.2, 3.0, 5.8, 0,  10.1};
	    bottomUpRodCutting(prices, 7);

	  }
	}


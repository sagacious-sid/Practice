
public class RainTrapping {

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		trap(height);
		int[] height1 = {2,0,2};
		System.out.println(trap(height1));
	}
	
	 public static int trap(int[] height) {
	        final int n = height.length;
	        if (n == 0) {
	            return 0;
	        }
	        
			// Holds the maximum height till a given index to the left
	        int[] maxL = new int[n];
			// Holds the maximum height till a given index to the right
			int[] maxR = new int[n];
		/*
		 * maxL[0] = 0; maxR[n - 1] = 0;
		 */
	        
	        for (int i = 1; i < n; i++) {
	            int j = n - i - 1;
	            maxL[i] = Math.max(height[i - 1], maxL[i - 1]);
	            maxR[j] = Math.max(height[j + 1], maxR[j + 1]);
	        }
	        
	        int total = 0;
	        for (int i = 0; i < n; i++) {
	            int h = Math.min(maxL[i], maxR[i]);
	            if (h > height[i]) {
	                total += h - height[i];
	            }
	        }
	        return total;      
	 }
}

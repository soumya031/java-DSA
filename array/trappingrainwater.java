package array;

public class trappingrainwater {
        public static void main(String[] args) {
            int[] height = {0,1,0,2,1,0,1,};
            int n = height.length;
            int leftMax[] = new int[n];
            leftMax[0] = height[0];
            for(int i=1; i<n; i++) {
                leftMax[i] = Math.max(height[i],leftMax[i-1]);
            }
            int rightMax[] = new int[n];
            rightMax[n-1] = height[n-1];
            for(int i=n-2; i>=0; i--) { 
                rightMax[i] = Math.max(height[i], rightMax[i+1]);
            }
            int trappedWater = 0;
            for(int i=0; i<n; i++) {
                int waterLevel = Math.min(leftMax[i], rightMax[i]);
                trappedWater += waterLevel - height[i];   
            }
               return trappedWater;
  
    }
}
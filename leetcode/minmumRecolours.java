package leetcode;

public class minmumRecolours {
    public int minimumRecolors(String blocks, int k) {
        int left = 0, numW = 0, numR = Integer.MAX_VALUE;
        for(int right = 0; right < blocks.length(); right++){
            if(blocks.charAt(right) == 'W'){
                numW++;
            }
            if(right - left + 1 == k){
                numR = Math.min(numR , numW);
                if(blocks.charAt(left) == 'W') numW--;
                left++;
            }
        }
        return numR;
    
}
}

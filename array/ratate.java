package array;

public class ratate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] rotation = new int[n];
        for(int i = 0; i < n; i++){
            rotation[(i + k) % n] = nums[i];
        }
        for(int i = 0; i < n; i++){
            nums[i] = rotation[i];
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3; // changable 
        new ratate().rotate(nums, k);
        // Print the rotated array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

/*
PS C:\Users\ADMIN\Desktop\java DSA>  & 'C:\Users\ADMIN\AppData\Local\Programs\Eclipse Adoptium\jdk-21.0.5.11-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\ADMIN\AppData\Roaming\Code\User\workspaceStorage\8aeb4658b8865427f517e4c76102c167\redhat.java\jdt_ws\java DSA_635d0ce6\bin' 'array.ratate' 
5 6 7 1 2 3 4 // when k = 3
PS C:\Users\ADMIN\Desktop\java DSA>  c:; cd 'c:\Users\ADMIN\Desktop\java DSA'; & 'C:\Users\ADMIN\AppData\Local\Programs\Eclipse Adoptium\jdk-21.0.5.11-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\ADMIN\AppData\Roaming\Code\User\workspaceStorage\8aeb4658b8865427f517e4c76102c167\redhat.java\jdt_ws\java DSA_635d0ce6\bin' 'array.ratate' 
4 5 6 7 1 2 3  // when k = 4
PS C:\Users\ADMIN\Desktop\java DSA>  c:; cd 'c:\Users\ADMIN\Desktop\java DSA'; & 'C:\Users\ADMIN\AppData\Local\Programs\Eclipse Adoptium\jdk-21.0.5.11-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\ADMIN\AppData\Roaming\Code\User\workspaceStorage\8aeb4658b8865427f517e4c76102c167\redhat.java\jdt_ws\java DSA_635d0ce6\bin' 'array.ratate' 
3 4 5 6 7 1 2  // when k = 5
PS C:\Users\ADMIN\Desktop\java DSA>  c:; cd 'c:\Users\ADMIN\Desktop\java DSA'; & 'C:\Users\ADMIN\AppData\Local\Programs\Eclipse Adoptium\jdk-21.0.5.11-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\ADMIN\AppData\Roaming\Code\User\workspaceStorage\8aeb4658b8865427f517e4c76102c167\redhat.java\jdt_ws\java DSA_635d0ce6\bin' 'array.ratate' 
2 3 4 5 6 7 1  // when k = 6
 */
import java.util.Arrays;


public class MaximumGap_164 {
	
	//Bucket Sort
	public static int maximumGap(int[] nums) {
        //base case 
        if(nums == null || nums.length < 2) return 0;
        int[] bucketMax = new int[nums.length-1];
        int[] bucketMin = new int[nums.length-1];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        //get the maximum gap between each bucket
        int gap = (int) Math.ceil((double)(max - min)/(nums.length-1));
        for(int num : nums){
            if(num == min || num == max) continue;
            int idx = (num - min)/gap;
            //System.out.println(idx);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
            bucketMin[idx] = Math.min(bucketMin[idx], num);
        }
        
        int maxGap = 0;
        int previous = min;
        
        for(int i = 0; i<bucketMax.length; i++){
            if(bucketMax[i] == Integer.MIN_VALUE || bucketMin[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(bucketMin[i] - previous, maxGap);
            previous = bucketMax[i];
        }
        maxGap = Math.max(max - previous, maxGap);
        return maxGap;
    }
	
	//Radix Sort
	public static int maximumGap2(int[] nums) {
        //base case
        if(nums == null || nums.length < 2) return 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(num, max);
        }
        int exp = 1;
        int[] aux = new int[nums.length];
        while(max / exp > 0){
            int[] count = new int[10];
            for(int i = 0; i<nums.length; i++){
                count[(nums[i]/exp)%10]++;
            }
            for(int i = 1; i<count.length; i++){
                count[i] = count[i]+count[i-1];
            }
            for(int i = nums.length-1; i>=0; i--){
                int idx = (--count[(nums[i]/exp)%10]);
                aux[idx] = nums[i];
            }
            //for(int i = 0; i<nums.length; i++) nums[i] = aux[i];
            System.arraycopy(aux, 0, nums, 0, nums.length);
            exp *= 10;
        }
        
        //System.out.println(aux[1]);
        int maxGap = 0;
        for(int i = 1; i<aux.length; i++){
            maxGap = Math.max(maxGap, aux[i]-aux[i-1]);
        }
        return maxGap;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

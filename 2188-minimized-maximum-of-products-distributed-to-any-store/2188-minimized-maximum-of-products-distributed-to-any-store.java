class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = quantities[0];
        for(int i=1;i< quantities.length;i++){
            if(quantities[i] > max)
                max = quantities[i];
        }
        int si = 1;
        int ei = max;
        while(si<=ei){
            int mid = si+(ei-si)/2;
            if(isPossible(mid,quantities,n))
                ei = mid-1;
            else
                si = mid+1;
        }
        return si;
    }
    public static boolean isPossible(int p,int[] arr,int n){
        int count = 0;
        for(int i=0;i< arr.length;i++){
            if(p != 0){
                if(arr[i]%p == 0)
                    count += arr[i]/p;
                else
                    count += arr[i]/p + 1;
            }
            if(count > n)
                return false;
        }
        return true;
    }
}
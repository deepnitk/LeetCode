public class Solution {
    public int books(int[] A, int B) {
        if(B > A.length) return -1;
        int res = -1;
        int low = A[0];
        int high = 0;
        for(int el: A) {
            low = Math.min(low, el);
            high += el;
        }
        
        while (low <= high) {
            int mid = (low + high) >> 1;
            if( ifPossible(A, mid, B) ) {
                res = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }  
        }
        return res;
    }
    
    boolean ifPossible(int[] A, int barrier, int B) {
        
        int allocatedStud = 0;
        int noOfPages = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > barrier) {
                return false;
            }
            
            if (noOfPages + A[i]  > barrier) {
                allocatedStud++;
                noOfPages = A[i];
            }
            else {
                noOfPages += A[i];
            }
        }
        if (allocatedStud < B) {
            return true;
        }
        return false;
    }
}

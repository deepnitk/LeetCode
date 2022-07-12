class Solution {
    public void sortColors(int[] a) {
        int lo = 0;
        int mid = 0;
        int hi = a.length - 1;
        
        while ( mid <= hi ){
            switch(a[mid]) {
                case 0: {
                    int temp = a[mid];
                    a[mid] = a[lo];
                    a[lo] = temp;
                    mid++;
                    lo++;
                    break;
                }
                    
                case 1: {
                    mid++;
                    break;
                }
                    
                case 2: {
                    int temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
                }    
            }
        }
    }
}

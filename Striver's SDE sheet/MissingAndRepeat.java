// Summation approach | Mathematics

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        int len = A.length;
        long s = (len * (len + 1))/2;
        long p = (len * (len + 1) * (2*len + 1))/6;
        long missingNumber = 0, repeat = 0;
        for(int i = 0; i< len; i++) {
            s -= (long)A[i];
            p -= (long)A[i] * (long)A[i];
        }
        
        missingNumber = (s + p/s)/2;
        repeat = missingNumber - s;
        int[] res = new int[2];
        res[1] = (int)missingNumber;
        res[0] = (int)repeat;
        
        return res;
    }
}

//Xor concept
//TC:O(N)
static void getTwoElements(int arr[], int n)
    {
        /* Will hold xor of all elements
       and numbers from 1 to n  */
        int xor1;
 
        /* Will have only single set bit of xor1 */
        int set_bit_no;
 
        int i;
        x = 0;
        y = 0;
 
        xor1 = arr[0];
 
        /* Get the xor of all array elements  */
        for (i = 1; i < n; i++)
            xor1 = xor1 ^ arr[i];
 
        /* XOR the previous result with numbers from
       1 to n*/
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;
 
        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = xor1 & ~(xor1 - 1);
 
        /* Now divide elements into two sets by comparing
    rightmost set bit of xor1 with the bit at the same
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements. The
    following two for loops serve the purpose */
        for (i = 0; i < n; i++) {
            if ((arr[i] & set_bit_no) != 0)
                /* arr[i] belongs to first set */
                x = x ^ arr[i];
 
            else
                /* arr[i] belongs to second set*/
                y = y ^ arr[i];
        }
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0)
                /* i belongs to first set */
                x = x ^ i;
 
            else
                /* i belongs to second set*/
                y = y ^ i;
        }
        
        // at last do a linear check which amont x and y is missing or repeating 
 
        /* *x and *y hold the desired output elements */
    }

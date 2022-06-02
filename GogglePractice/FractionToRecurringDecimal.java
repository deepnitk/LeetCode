//TC:O(n)

class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
        //edge case
		if (numerator == 0) {
			return "0";
		}
        
		long dividend = Math.abs((long) numerator);
		long divisor = Math.abs((long) denominator);

		StringBuilder sb = new StringBuilder();
        //add "-" symbol if one of dividend or divisor is < 0
		if ((numerator < 0 && denominator > 0 )|| (numerator > 0 && denominator < 0)) {
			sb.append("-");
        }
                                                                          
		long remainder = dividend % divisor;
        // add quotient to res
        sb.append(dividend / divisor);

        if (remainder == 0) {
            //case 2/1 = 2
            return sb.toString();
        }
        
        //remainder != 0 means res = x.y
        sb.append(".");
        // Map to store remainder, len(sb) so that when we find the remainder in sb we can insert a '( )'
        HashMap<Long, Integer> map = new HashMap();
        while (remainder != 0) {
            if(map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / divisor);
            remainder %= divisor;

        }

        return sb.toString();
    }
}

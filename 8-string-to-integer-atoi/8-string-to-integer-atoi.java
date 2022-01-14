public class Solution {
	public int myAtoi(String str) {
		if (str.isEmpty())
			return 0;
		str = str.trim();//remove spaces from start and end
        if(str.length()==0) return 0;
		int i = 0, ans = 0, sign = 1, len = str.length();
		if (str.charAt(i) == '-' || str.charAt(i) == '+'){
			sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }
		for (; i < len; i++) {
			int tmp = str.charAt(i) - '0';
			if (tmp < 0 || tmp > 9)
				break;// as asked in point 3 of que -> read util next non digit char
			if (ans > Integer.MAX_VALUE / 10
					|| (ans == Integer.MAX_VALUE / 10 && tmp > Integer.MAX_VALUE % 10))
                //checking if till now ans is greater than 2^31-1 / 10 i.e 2147483647/10 which is 214748364 then our ans > 2^31-1 (eg->214748365_) _ can be any but number is greater than 2^31-1 and next is if ans==214748364 then checking if last char is greater than 7 or not
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			else
				ans = ans * 10 + tmp;
		}
		return sign * ans;
	}
}
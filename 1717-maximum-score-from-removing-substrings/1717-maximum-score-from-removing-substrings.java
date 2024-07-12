class Solution {
public int maximumGain(String s, int x, int y) {
	Stack<Character> stack = new Stack<>(), stack2 = new Stack<>();
	int result = 0, max=Math.max(x,y), min =Math.min(x,y);
	char first= (x>y)?'a':'b', second=(x>y)?'b':'a';
	for(char c: s.toCharArray()) 
		if(!stack.isEmpty() && stack.peek() == first && c == second) {
			stack.pop(); 
			result +=max;
		} else stack.push(c);
	while(!stack.isEmpty()) {
		char c = stack.pop();
		if(!stack2.isEmpty() && stack2.peek() == first && c == second) {
			stack2.pop(); 
			result +=min;
		} else stack2.push(c);
	}
	return result;
}
}
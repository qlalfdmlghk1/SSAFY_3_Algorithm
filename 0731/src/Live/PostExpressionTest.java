package Live;

import java.util.Stack;

import javax.sql.rowset.serial.SQLOutputImpl;

public class PostExpressionTest {

	public static void main(String[] args) {
		
		String expression = "6528-*2/+";
		System.out.println(expression);
		
		Stack<Integer> stack = new Stack<>(); // 피연산자 저장
		
		for (int i = 0, size = expression.length(); i < size; i++) {
			char temp = expression.charAt(i);
			// 피연산자면 스택에 넣기
			if (Character.isDigit(temp)) {  // '0' <= temp <= '9'
				stack.push(temp - '0');
			//연산자이면 두 피연산자 꺼내어 연산 후 스택에 넣기
			} else {
				int val2 = stack.pop();
				int val1 = stack.pop();
				switch (temp) {
				case '+':
					stack.push(val1 + val2);
					break;
				case '-':
					stack.push(val1 - val2);
					break;
				case '*':
					stack.push(val1 * val2);
					break;
				case '/':
					stack.push(val1 / val2);
					break;
				}
			} // end if
		} // end for
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
	} 
}

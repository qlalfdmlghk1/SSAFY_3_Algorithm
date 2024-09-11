package Live;

public class Output {

	// 문자열의 조작을 지원하는 클래스
	// 자바에서 상수로 취급되는 문자열을 조작 시마다 새로운 문자열이 생성되는 것을 방지해줌
	// append(), toString()
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("Hello ");
		sb.append("SSAFY").append("!!");
		System.out.println(sb.toString());  // Hello SSAFY!!
		
		sb.setLength(sb.length()-2);
		System.out.println(sb.toString());  // Hello SSAFY
	}

}

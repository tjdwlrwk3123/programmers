package programmers;

import java.util.Arrays;

public class Week4 {
	/*
	정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

	제한 사항
	n은 0 이상 3000이하인 정수입니다.
	입출력 예
	n	return
	12	28
	5	6
	 */
	public int day23_1(int n) {
        int answer = 1;
        for(int i=2;i<=n;i++){
            if(n%i==0){
                answer+=i;
            }
        }
        if(n==0){
            return 0;
        }else{
            return answer;
        }
    }
	/*
	최대공약수와 최소공배수
	
	두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 
	배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 
	예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

	제한 사항
	두 수는 1이상 1000000이하의 자연수입니다.
	입출력 예
	n	m	return
	3	12	[3, 12]
	2	5	[1, 10]
	 */
	public int[] day23_2(int n, int m) {
        int[] answer = new int[2];
        for(int i=1;i<=n && i<=m;i++){ //최대공약수 구하기
            if(n%i==0 && m%i==0){
                answer[0]=i;
            }
        }
        answer[1]=n*m/answer[0]; //최소공배수 구하기(두 수의 곱을 최대공약수로 나눈수)
        return answer;
    }
	/*
	///////////////////////소수 찾기//////////////////
	
	1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

	소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
	(1은 소수가 아닙니다.)
	
	제한 조건
	n은 2이상 1000000이하의 자연수입니다.
	
	입출력 예
	n	result
	10	4
	5	3
	 */
	public int day24_1(int n) {
        int answer = 0;
        
        for(int j=2;j<=n;j++){
            boolean isPrime=true;
            int num=j;
            for(int i=2;i<=Math.sqrt(num);i++){ //num이 2거나 3인경우는 for문이 돌지 않고 나가지만 둘다 소수이기 때문에 괜찮다.
                if(num%i==0){ //루트 num까지 가기 전에 나누어 떨어지는 수가 하나라도 나오면 소수가 아니다.
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                answer++;
            }
        }
        return answer;
    }
	/*
	 * 
	문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
	s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
	
	제한 사항
	str은 길이 1 이상인 문자열입니다.
	입출력 예
	s			return
	"Zbcdefg"	"gfedcbZ"
	
	 */
	public String day24_2(String s) {
        String answer ="";
        
        char[] letters=s.toCharArray();
        Arrays.sort(letters); //char배열도 Arrays.sort를 쓸 수 있다.
        
        StringBuilder sb=new StringBuilder();
        sb.append(letters); //어펜드로 char배열을 넣을 수 있다.
        answer=sb.reverse().toString();
        
        return answer;
    }
}

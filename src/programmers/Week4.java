package programmers;

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
}

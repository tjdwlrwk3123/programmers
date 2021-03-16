package programmers;

public class Day13 {
	/*
	프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
	전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, 
	solution을 완성해주세요.
	
	제한 조건
	s는 길이 4 이상, 20이하인 문자열입니다.
	입출력 예
	phone_number	return
	"01033334444"	"*******4444"
	"027778888"		"*****8888"
	 */
	public String solution1(String phone_number) {
        String answer="";
        for(int i=0;i<phone_number.length()-4;i++){
            answer+="*";
        }
        answer+=phone_number.substring(phone_number.length()-4);
        return answer;
    }
	/*
	주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
	숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, 
	nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

	제한사항
	nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
	nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
	입출력 예
	nums	result
	[1,2,3,4]	1
	[1,2,7,6,4]	4
	 */
	public int solution2(int[] nums) {
        int answer = 0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int number=nums[i]+nums[j]+nums[k];
                    boolean isPrime=true;
                    for(int l=2;l<=Math.sqrt(number);l++){ //2부터 루트number까지만 나눠봐도 소수 판별이 가능하다
                        if(number%l==0){
                            isPrime=false;
                            break;
                        }
                    }
                    if(isPrime){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
	/*
	 * 에라토스테네스의 채
	 * 모든 자연수는 소수들의 곱으로 표현이 된다
	 * 2부터 N-1까지의 수 중에서 2의 배수를 채로 거르고 3의 배수를 거르고 ... 루트N의 배수까지 걸러지지 않은
	 * 모든 수들이 소수가 된다.
	 * 
	 */
}

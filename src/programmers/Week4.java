package programmers;

import java.util.ArrayList;
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
	/*
	당신은 폰켓몬을 잡기 위한 오랜 여행 끝에, 홍 박사님의 연구실에 도착했습니다. 
	홍 박사님은 당신에게 자신의 연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다.
	홍 박사님 연구실의 폰켓몬은 종류에 따라 번호를 붙여 구분합니다. 따라서 같은 종류의 폰켓몬은 같은 번호를 가지고 있습니다. 
	예를 들어 연구실에 총 4마리의 폰켓몬이 있고, 
	각 폰켓몬의 종류 번호가 [3번, 1번, 2번, 3번]이라면 이는 3번 폰켓몬 두 마리, 1번 폰켓몬 한 마리, 2번 폰켓몬 한 마리가 있음을 나타냅니다. 
	이때, 4마리의 폰켓몬 중 2마리를 고르는 방법은 다음과 같이 6가지가 있습니다.
	
	당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에, 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다. 
	N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, 
	N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 
	그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.

	제한사항
	nums는 폰켓몬의 종류 번호가 담긴 1차원 배열입니다.
	nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어집니다.
	폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다.
	가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.
	입출력 예
	nums			result
	[3,1,2,3]		2
	[3,3,3,2,2,4]	3
	[3,3,3,2,2,2]	2
	
	
	****다른사람의 풀이 : 해쉬셋에 담으면 중복이 제거되기 때문에 그 후 사이즈를 비교하여 리턴****
	
	 */
	public int day25(int[] nums) {
        int answer = 0;
        if(nums.length==2){ //2마리일 경우는 무조건 1마리만 가져가게 됨.
            return 1;
        }
        Arrays.sort(nums);
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(nums[0]);
        int s=0;
        for(int i=1;i<nums.length;i++){
            if(list.get(s)==nums[i]){
                continue;
            }else{
                list.add(nums[i]);
                s++;
            }
            if(list.size()==nums.length/2){
                break;
            }
        }
        answer=list.size();
        return answer;
    }
}

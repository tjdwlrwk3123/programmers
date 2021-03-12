package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Day7 {
	/*
	////////////////////나누어 떨어지는 숫자 배열/////////////////
	
	array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
	divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
	
	제한사항
	arr은 자연수를 담은 배열입니다.
	정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
	divisor는 자연수입니다.
	array는 길이 1 이상인 배열입니다.
	
	입출력 예
	arr				divisor		return
	[5, 9, 7, 10]	5			[5, 10]
	[2, 36, 1, 3]	1			[1, 2, 3, 36]
	[3,2,6]			10			[-1]
	
	 */
	public int[] solution(int[] arr, int divisor) {
        int cnt=0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0){
                list.add(arr[i]);
                cnt++;
            }
        }
        if(cnt==0){
            int[] answer=new int[1];
            answer[0]=-1;
            return answer;
        }else{
            Collections.sort(list);
            int[] answer=new int[cnt];
            for(int i=0;i<cnt;i++){
                answer[i]=list.get(i);
            }
            return answer;
        }
    }
	/*
	///////////////3진법 뒤집기/////////////////
	
	자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 
	이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

	제한사항
	n은 1 이상 100,000,000 이하인 자연수입니다.
	
	입출력 예 #1

	답을 도출하는 과정은 다음과 같습니다.
	n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
	45			1200	0021			7
	따라서 7을 return 해야 합니다.
	
	입출력 예 #2
	
	답을 도출하는 과정은 다음과 같습니다.
	n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
	125			11122	22111			229
	따라서 229를 return 해야 합니다.
	
	 */
	public int solution2(int n) {
        String changeNum="";
        while(n>0){ //3진법으로 바꾸기 (앞에 갖다 붙이는것이기 때문에 String으로 선언해야함)
            changeNum= (n%3)+changeNum;
            n/=3;
        }
        StringBuffer sb=new StringBuffer(changeNum); //문자열 뒤집기 위한 버퍼
        String rev=sb.reverse().toString();
        /*
        int threeNum=Integer.parseInt(changeNum);
        int reverse=0;
        while(threeNum>0){ //숫자를 뒤집기 (앞자리는 계속 10을 곱해줘가야하고 뒷자리는 나머지를 구해야함) <-안되는 이유?
            reverse=(reverse*10)+(threeNum%10);
            threeNum/=10;
        }
         */
        int answer = Integer.parseInt(rev,3); //3진수를 10진수로 바꾸기
        return answer;
    }
}

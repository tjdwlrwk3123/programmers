package programmers;

import java.util.ArrayList;

public class Day8 {
	/*
	배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
	이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
	단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 
	예를 들면,
	arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
	arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
	배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
	
	제한사항
	배열 arr의 크기 : 1,000,000 이하의 자연수
	배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
	입출력 예
	arr					answer
	[1,1,3,3,0,1,1]		[1,3,0,1]
	[4,4,4,3,3]			[4,3]
	
	 */
	public int[] solution1(int[] arr) {
        int cnt=1;
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                cnt++;
                list.add(arr[i]);
            }
        }
        int[] answer = new int[cnt];
        for(int i=0;i<answer.length;i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
	/*
	두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
	예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
	
	제한 조건
	a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
	a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
	a와 b의 대소관계는 정해져있지 않습니다.
	입출력 예
	a	b	return
	3	5	12
	3	3	3
	5	3	12
	 */
	public long solution2(int a, int b) {
        long answer = 0;
        if(a==b){
            answer=a;
            return answer;
        }else if(a>b){
            int temp=0;
            temp=a;
            a=b;
            b=temp;
        }
        while(a<=b){
            answer+=a;
            a++;
        }
        return answer;
    }
}

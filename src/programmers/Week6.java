package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Week6 {
	/*
	어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

	예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
	
	문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
	number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
	
	제한 조건
	number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
	k는 1 이상 number의 자릿수 미만인 자연수입니다.
	입출력 예
	number			k	return
	"1924"			2	"94"
	"1231234"		3	"3234"
	"4177252841"	4	"775841"
	 */
	public static void main(String[] args) {
		String number="1231234";
		String aa=day37(number,3);
		System.out.println(aa);
	}
	static ArrayList<String> answerList=new ArrayList<>();
    public static String day37(String number, int k) {
        String[] list=number.split("");
        int n=number.length();
        int r=number.length()-k;
        boolean[] visited=new boolean[n];
        combination(list,visited,0,n,r);
        
        Collections.sort(answerList);
        
        return answerList.get(answerList.size()-1);
    }
    public static void combination(String[] list, boolean[] visited,int start, int n, int r){
    	if (r == 0) {
    		String l="";
    		for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    l+=list[i];
                }
            }
    		answerList.add(l);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(list, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    //풀긴 했으나 시간이 오래걸려서 비효율, 테스크케이스 실패.
    
    /*
	로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다. 하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다. 
	당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.
	알아볼 수 없는 번호를 0으로 표기하기로 하고, 민우가 구매한 로또 번호 6개가 44, 1, 0, 0, 31 25라고 가정해보겠습니다. 
	당첨 번호 6개가 31, 10, 45, 1, 6, 19라면, 당첨 가능한 최고 순위와 최저 순위의 한 예는 아래와 같습니다.
	
	당첨 번호	31	10	45	1	6	19	결과
	최고 순위 번호	31	0→10	44	1	0→6	25	4개 번호 일치, 3등
	최저 순위 번호	31	0→11	44	1	0→7	25	2개 번호 일치, 5등
	
	순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정됩니다.
	알아볼 수 없는 두 개의 번호를 각각 10, 6이라고 가정하면 3등에 당첨될 수 있습니다.
	3등을 만드는 다른 방법들도 존재합니다. 하지만, 2등 이상으로 만드는 것은 불가능합니다.
	알아볼 수 없는 두 개의 번호를 각각 11, 7이라고 가정하면 5등에 당첨될 수 있습니다.
	5등을 만드는 다른 방법들도 존재합니다. 하지만, 6등(낙첨)으로 만드는 것은 불가능합니다.
	
	민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다. 
	이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
     */
    public int[] week6_2(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(win_nums);
        Arrays.sort(lottos);
        int count=0;
        int plus=0;
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0){
                plus++;
                continue;
            }
            for(int j=0;j<win_nums.length;j++){
                if(win_nums[j]==lottos[i]){
                    count++;
                    break;
                }
            }
        }
        switch(count+plus){
            case 0 :
            case 1 : answer[0]=6; break;
            case 2 : answer[0]=5; break;
            case 3 : answer[0]=4; break;
            case 4 : answer[0]=3; break;
            case 5 : answer[0]=2; break;
            case 6 : answer[0]=1; break;
        }
        switch(count){
            case 0 :
            case 1 : answer[1]=6; break;
            case 2 : answer[1]=5; break;
            case 3 : answer[1]=4; break;
            case 4 : answer[1]=3; break;
            case 5 : answer[1]=2; break;
            case 6 : answer[1]=1; break;
        }
        return answer;
    }
}

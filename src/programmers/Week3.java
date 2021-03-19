package programmers;

import java.util.Arrays;

public class Week3 {
	/*
	/////////////////////////비밀지도///////////////////////
	
	네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 
	그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다. 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.

	1.지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
	2.전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자. 
	지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
	3."지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
	4.암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
	
	원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력하라.
	
	입출력 예제
	매개변수	값
	n		5
	arr1	[9, 20, 28, 18, 11]
	arr2	[30, 1, 21, 17, 28]
	출력		["#####","# # #", "### #", "# ##", "#####"]
	
	 */
	public String[] day15(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<arr1.length;i++){
            String bin=Integer.toBinaryString(arr1[i]); //2진수 문자열로 바꾸기
            bin=bin.format("%0"+n+"d",Long.parseLong(bin)); //Long형으로 바꾼후 앞에 자릿수 채우기 (1001->01001)
            answer[i]="";
            for(int j=0;j<bin.length();j++){
                if(bin.substring(j,j+1).equals("1")){
                    answer[i]+="#";
                }else{
                    answer[i]+=" ";
                }
            }
            
        }
        for(int i=0;i<arr2.length;i++){
            String bin=Integer.toBinaryString(arr2[i]);
            bin=bin.format("%0"+n+"d",Long.parseLong(bin));
            StringBuilder ans=new StringBuilder(answer[i]); //문자열을 치환하기 위해서 스트링빌더 클래스 사용
            for(int j=0;j<bin.length();j++){
                if(bin.substring(j,j+1).equals("1")){
                    ans.setCharAt(j,'#'); //스트링빌더의 메소드(j번째 인덱스의 char를 '#'로 바꾸기)
                }
            }
            answer[i]=ans.toString(); //StringBuilder를 스트링으로 형변환
        }
        return answer;
    }
	/*
	/////////////////////하샤드의 수//////////////////
	
	양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 
	예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 
	자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.

	제한 조건
	x는 1 이상, 10000 이하인 정수입니다.
	
	입출력 예
	arr	return
	10	true
	12	true
	11	false
	13	false
	 */
	public boolean day16_1(int x) {
        boolean answer = true;
        String num=x+"";
        int harsa=0;
        for(int i=0;i<num.length();i++){
            harsa+=Integer.parseInt(num.substring(i,i+1));
        }
        if(x%harsa!=0){
            answer=false;
        }
        return answer;
    }
	/*
	////////////////////제일 작은 수 제거하기///////////////////
	
	정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 
	단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
	예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

	제한 조건
	arr은 길이 1 이상인 배열입니다.
	인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
	입출력 예
	arr			return
	[4,3,2,1]	[4,3,2]
	[10]		[-1]
	 */
	public int[] day16_2(int[] arr) {
        int[] answer={};
        if(arr.length==1){
            answer=new int[1];
            answer[0]=-1;
        }else{
            int[] arr2=arr.clone();
            Arrays.sort(arr2);
            answer=new int[arr.length-1];
            boolean find=false;
            for(int i=0;i<answer.length;i++){
                if(find){
                    answer[i]=arr[i+1];
                }else{
                    if(arr[i]==arr2[0]){
                        answer[i]=arr[i+1];
                        find=true;
                        continue;
                    }
                    answer[i]=arr[i];
                }
            }
        }
        
        return answer;
    }
}

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
            int[] arr2=arr.clone(); //깊은복사(원본을 변경해도 바뀌지 복사본이 바뀌지 않음)
            Arrays.sort(arr2);
            answer=new int[arr.length-1];
            boolean find=false;
            for(int i=0;i<answer.length;i++){
                if(find){
                    answer[i]=arr[i+1];
                }else{
                    if(arr[i]==arr2[0]){ //가장 작은수를 찾았으면
                        answer[i]=arr[i+1];
                        find=true; //find를 true로 바꿔서 이 다음부터는 answer[i]=arr[i+1]이 되게 함
                        continue;
                    }
                    answer[i]=arr[i]; //가장 작은수를 찾기전
                }
            }
        }
        
        return answer;
    }
	/*
	//////////////////////////콜라츠 추측/////////////////////////
	
	1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다. 
	작업은 다음과 같습니다.

	1-1. 입력된 수가 짝수라면 2로 나눕니다. 
	1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
	2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
	예를 들어, 입력된 수가 6이라면 6→3→10→5→16→8→4→2→1 이 되어 총 8번 만에 1이 됩니다. 
	위 작업을 몇 번이나 반복해야하는지 반환하는 함수, solution을 완성해 주세요. 단, 작업을 500번을 반복해도 1이 되지 않는다면 –1을 반환해 주세요.
	
	제한 사항
	입력된 수, num은 1 이상 8000000 미만인 정수입니다.
	입출력 예
	n		result
	6		8
	16		4
	626331	-1
	 */
	public int day17_1(int num) {
        int answer = 0;
        long n=(long)num; //3배를 하는중에 int범위를 넘어가게 됨
        if(n==1){ //num이 1일경우 바로 끝
            return 0;
        }
        for(int i=1;i<=500;i++){
            if(n%2==0){
                n/=2;
                if(n==1){ //짝수일때만 1이 될 가능성이 생기기때문에 1인지를 여기서 테스트
                    return i;
                }
            }else{
                n=n*3+1;
            }
        }
        answer=-1;
        return answer;
    }
	/*
	/////////////////자릿수 더하기/////////////////////
	 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
	예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
	
	제한사항
	N의 범위 : 100,000,000 이하의 자연수
	입출력 예
	N		answer
	123		6
	987		24
	 */
	public int day18_1(int n) {
        int answer = 0;
        
        String num=n+"";
        for(int i=0;i<num.length();i++){
            answer+=Integer.parseInt(num.substring(i,i+1));
        }
        return answer;
    }
	/*
	문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
	각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

	제한 사항
	문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
	첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
	입출력 예
	s					return
	"try hello world"	"TrY HeLlO WoRlD"
	 */
	public String day18_2(String s) {
        String answer = "";
        String[] words=s.split(" ",-1); //음수로 주면 모든 공백을 배열에 집어넣는다('hello world      '같은것도 처리가 가능해진다)
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                if(j==0 || j%2==0){
                    answer+=words[i].substring(j,j+1).toUpperCase();
                }else{
                    answer+=words[i].substring(j,j+1).toLowerCase();
                }
            }
            answer+=" ";
        }
        answer=answer.substring(0,answer.length()-1);
        return answer;
    }
	/*
	함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 
	다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

	제한 조건
	x는 -10000000 이상, 10000000 이하인 정수입니다.
	n은 1000 이하인 자연수입니다.
	입출력 예
	x		n		answer
	2		5		[2,4,6,8,10]
	4		3		[4,8,12]
	-4		2		[-4, -8]
	 */
	public long[] day19_1(int x, int n) {
        long k=(long)x; //x의 조건이 int의 범위를 벗어났기 때문에 long형으로 변환해야함(int와 int를 연산하면 결과도 int가 됨)
        long[] answer = new long[n];
        for(int i=0;i<n;i++){
            answer[i]=k*(i+1);
        }
        return answer;
    }
	/*
	행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 
	2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

	제한 조건
	행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
	입출력 예
	arr1	arr2	return
	[[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
	[[1],[2]]	[[3],[4]]	[[4],[6]]
	 */
	public int[][] day19_2(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[i].length;j++){
                answer[i][j]=arr1[i][j]+arr2[i][j];
            }
        }
        return answer;
    }
	/*
	자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

	제한 조건
	n은 10,000,000,000이하인 자연수입니다.
	입출력 예
	n		return
	12345	[5,4,3,2,1]
	 */
	public int[] day19_3(long n) {
        String numbers=n+"";
        int[] answer = new int[numbers.length()];
        for(int i=0;i<answer.length;i++){
            answer[i]=Integer.parseInt(Character.toString(numbers.charAt(answer.length-1-i)));
        }
        return answer;
    }
	/*
	임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
	n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
	
	제한 사항
	n은 1이상, 50000000000000 이하인 양의 정수입니다.
	입출력 예
	n		return
	121		144
	3		-1
	 */
	public long day19_4(long n) {
        long answer = 0;
        long root=(long)Math.sqrt(n); //sqrt : 제곱근을 구하는 함수
        if(root*root==n){
            answer=(root+1)*(root+1);
        }else{
            answer=-1;
        }
        return answer;
    }
}

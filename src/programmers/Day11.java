package programmers;

public class Day11 {
	/*
	이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
	맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.
	
	엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
	왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
	오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
	가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
	4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
	순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 
	각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
	
	[제한사항]
	numbers 배열의 크기는 1 이상 1,000 이하입니다.
	numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
	hand는 "left" 또는 "right" 입니다.
	"left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
	왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
	입출력 예
	numbers								hand		result
	[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"		"LRLLLRLLRRL"
	[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"		"LRLLRRLLLRR"
	[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]		"right"		"LLRLLRLLRL"
	 */
	
	public String solution(int[] numbers, String hand) {
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0){
                numbers[i]=11; //숫자 0을 11로 바꾸기
            }
        }
        String answer = "";
        int currLeft=10; //최초 위치를 10과 12로 설정 (*,# 대체)
        int currRight=12;
        
        
        for(int i=0; i<numbers.length;i++){
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                answer+="L";
                currLeft=numbers[i];
            }else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                answer+="R";
                currRight=numbers[i];
            }else{ //위치가 2,5,8,11(0)일때
            	/* 
            	 * 현재 왼손의 위치,오른손에 위치에서 2,5,8,0 위치의 거리를 계산하기 위해서
            	 * 위 아래로 움직일때는 3의 차이 왼쪽,오른쪽은 1차이가 나기 때문에
            	 * 두 위치의 숫자를 뺀 후(절대값) 3으로 나눈 몫이 거리 1이며, 3으로 나눈 나머지값도 거리 1이 된다.
            	 * 몫과 거리를 더하면 왼손,오른손의 위치에서 2,5,8,0의 위치가 된다.
            	*/
                int x=Math.abs(numbers[i]-currLeft);
                int y=Math.abs(numbers[i]-currRight);
                //오른손 또는 왼손의 위치가 눌러야하는 위치 위에 있으면 0이됨.
                int leftDistance=0;
                int rightDistance=0;
                if(x!=0){
                    leftDistance=x/3+x%3;
                }
                if(y!=0){
                    rightDistance=y/3+y%3;
                }
                
                if(leftDistance==rightDistance){
                    if(hand.equals("right")){
                        answer+="R";
                        currRight=numbers[i];
                    }else{
                        answer+="L";
                        currLeft=numbers[i];
                    }
                }else if(leftDistance>rightDistance){
                    answer+="R";
                    currRight=numbers[i];
                }else{
                    answer+="L";
                    currLeft=numbers[i];
                }
            }
        }
        return answer;
    }
}

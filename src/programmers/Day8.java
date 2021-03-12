package programmers;

import java.util.ArrayList;

public class Day8 {
	/*
	/////////////////같은 숫자는 싫어///////////////////
	
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
	//////////////두 정수 사이의 합///////////////////
	
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
	/*
	//////////////////크레인 인형뽑기 게임(카카오 겨울 인턴십)//////////////////
	게임 화면은 "1 x 1" 크기의 칸들로 이루어진 "N x N" 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다. 
	각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다. 
	모든 인형은 "1 x 1" 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다. 
	게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다. 
	집어 올린 인형은 바구니에 쌓이게 되는 데, 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.
	
	만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다.
	
	크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다. 
	또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다.
	
	게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때, 
	크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.
	
	[제한사항]
	board 배열은 2차원 배열로 크기는 "5 x 5" 이상 "30 x 30" 이하입니다.
	board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
	0은 빈 칸을 나타냅니다.
	1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
	moves 배열의 크기는 1 이상 1,000 이하입니다.
	moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.
	
	입출력 예
	board															moves				result
	[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	4
	
	 
	 */
	public static int solution3(int[][] board, int[] moves) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<moves.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[j][moves[i]-1]!=0){
                    list.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1]=0;
                    break;
                }
            }
        }
        int answer = 0;
        for(int i=1;i<list.size();i++){
            if(list.get(i)==list.get(i-1)){
                list.remove(i);
                list.remove(i-1);
                answer+=2;
                i=0; //i를 1로 하면 for문이 끝나면서 i가 올라가기때문에 0으로 해주고 바로 1로 시작하게 만듦
            }
        }
        return answer;
    }
	public static void main(String[] args) {
		int[][] board={{0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 2, 1, 0, 0}, {0, 2, 1, 0, 0}, {0, 2, 1, 0, 0}};
		int[] moves={1, 2, 3, 3, 2, 3, 1};
		int a=solution3(board,moves);
		System.out.println(a);
	}
}

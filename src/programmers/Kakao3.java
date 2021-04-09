package programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/*
 * 
문제 설명
1부터 n까지 번호가 하나씩 붙어있는 n개의 역이 철로로 연결되어 있습니다.
철로는 양방향 통행이 가능하며, 임의의 두 역을 직접 연결하는 철로는 최대 하나입니다.
또, 서로 다른 두 역 사이의 이동 경로는 딱 한 가지며, 임의의 두 역 사이에 이동 불가능한 경우는 없습니다.

출발역과 종착역 사이를 왕복하는 열차를 운행하려 합니다. 출발역은 1번 역이며, 
전체 역 중 한 곳을 종착역으로 정해야 합니다. 단, 열차가 출발역에서 종착역까지 갈 때 모든 역을 방문할 필요는 없으며, 
같은 역을 두 번 이상 방문하면 안 됩니다.

종착역을 정하기 위해 각 역의 일일 이용객 수를 조사했습니다. 
이때, 열차가 방문하는 역의 일일 이용객 수의 합이 최대가 되도록 종착역을 지정하면 됩니다.
만약 일일 이용객 수의 합이 최대가 되는 역이 여러개라면, 그 중 번호가 큰 역을 선택하면 됩니다.

전체 역의 개수 n, 1번부터 n번 역까지 일일 이용객 수 passenger, 역 사이의 철로 연결 정보 train이 매개변수로 주어질 때, 
종착역으로 지정할 역 번호와 그때의 이용객 수 합을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 2 이상 100,000 이하인 자연수입니다.
passenger의 길이는 n입니다.
passenger의 원소는 1 이상 10,000 이하인 자연수입니다.
passenger[i]는 i + 1번 역의 일일 이용객 수 입니다.
train의 세로(행) 길이는 n - 1 입니다.
train의 가로(열) 길이는 2입니다.
train의 원소는 [A, B] 형태입니다.
A, B는 철로가 연결하는 두 역의 번호입니다.
A, B는 1 이상 n 이하인 자연수이며, A와 B가 같은 경우는 없습니다.
같은 철로에 대한 정보가 중복해서 들어있지 않습니다.
입출력 예
n	passenger			train								result
6	[1,1,1,1,1,1]		[[1,2],[1,3],[1,4],[3,5],[3,6]]		[6,3]
4	[2,1,2,2]			[[1,2],[1,3],[2,4]]					[4,5]
5	[1,1,2,3,4]			[[1,2],[1,3],[1,4],[1,5]]			[5,5]
입출력 예 설명
입출력 예 #1

train_2.png

5번 역을 종착역으로 정하면 열차는 1번 역 → 3번 역 → 5번 역 → 3번 역 → 1번 역 → ... 과 같이 움직입니다. 1번, 3번, 5번 역의 일일 이용객 수의 합은 3명입니다.
6번 역을 종착역으로 정하면 열차는 1번 역 → 3번 역 → 6번 역 → 3번 역 → 1번 역 → ... 과 같이 움직입니다. 1번, 3번, 6번 역의 일일 이용객 수의 합은 3명입니다.
일일 이용객 수의 합이 최대인 경우가 여러 개라면 그중 번호가 큰 역을 선택해야 합니다. 따라서 6번 역을 종착역으로 정합니다.

입출력 예 #2

4번 역을 종착역으로 정하면 열차는 1번 역 → 2번 역 → 4번 역 → 2번 역 → 1번 역 → ... 과 같이 움직입니다. 세 역의 일일 이용객 수의 합은 5명이 되고, 이때가 최대입니다.

입출력 예 #3

5번 역을 종착역으로 정하면 열차는 1번 역 → 5번 역 → 1번 역 → ... 과 같이 움직입니다. 1번, 5번 역의 일일 이용객 수의 합은 5명이고, 이때가 최대입니다.
 */
class Kakao3 {
	static Queue<DpsList> q=new LinkedList<>(); //역과 인원수가 들어갈 큐 리스트 생성
	
	public static void main(String[] args) {
		int n=5;
		int[] passenger= {1,1,2,3,4};
		int[][] train= {{1,2},{1,3},{1,4},{1,5}};
		int[] aa=checkTrain(n,passenger,train);
		System.out.println(aa[0]);
		System.out.println(aa[1]);
	}
	
	public static int[] checkTrain(int n, int[] passenger, int[][] train) {
		int[] answer= new int[2];
		
		Stack<Integer> stack=new Stack<Integer>(); //깊이탐색 스택생성
		boolean visited[]=new boolean[n+1]; //해당 역을 방문 했는지 안했는지 확인하는 부울린배열
		int[][] adjArray=new int[n+1][n+1]; //두 역사이가 연결되어있는지 아닌지 확인하는 배열
		//역의 개수 +1을 해야하는 이유??
		for(int i=0;i<train.length;i++) {
			int v1=train[i][0];
			int v2=train[i][1];
			adjArray[v1][v2]=1; //두 역사이는 서로 연결되어있음
			adjArray[v2][v1]=1; //양방향으로 연결
		}
		
		
		
		for(int i=2;i<=n;i++) { //2번역부터 n번역까지 반복해서 실행
			getDps(1,i,stack,adjArray,visited,passenger);
			//(시작역,끝역,스택,두사이가 연결된 선 배열(연결시 1),역을 지나갔는지 확인하는 배열,승객배열)
		}
		
		int maxCount=0;
		int station=0;
		while(!q.isEmpty()) { //큐가 빌때까지 계속 반복
			if(q.peek().passenger>=maxCount) { //가장 승객이 많은 경로 찾기
				maxCount=q.peek().passenger;
				station=q.peek().station;
				q.poll();
			}else {
				q.poll();
			}
		}
		answer[0]=station;
		answer[1]=maxCount;
		return answer;
	}
	public static void getDps(int start,int end,Stack<Integer> stack,int[][] adjArray,boolean[] visited,int[] passenger) {
		visited[start]=true; //시작역을 지나갔다는 표시
		stack.push(start); //스택에 시작역을 저장
		
		if(start==end) { //반복해서 이어진 역을 지나가서 끝역이 되면
			int allPassenger=0;
			for(int i=0;i<stack.size();i++) {
				allPassenger+=passenger[stack.elementAt(i)-1]; //스택에 들어있는 역들에 해당하는 승객들의 합
			}
			DpsList dl=new DpsList(stack.elementAt(stack.size()-1), allPassenger);
			System.out.println("승객:"+dl.passenger+",역:"+dl.station);
			q.add(dl); //큐에 끝역과 승객들의 합을 저장
			
		}
		for(int i=1; i<=adjArray.length-1;i++) {
			if(adjArray[start][i]==1 && !visited[i]) { //다음에 연결된 역이 있고, 그 역을 방문하지 않았으면
				getDps(i,end,stack,adjArray,visited,passenger); //시작역을 i로 잡고 다시 반복
				visited[i]=false; //모든 역을 다시 빠져나오면서 false로 바꿈
			}
		}
		stack.pop(); //모든 역을 다시 빠져나오면서 역 정보를 없애기
	}
	static class DpsList{
		int station;
		int passenger;
		DpsList(int station,int passenger) {
			this.station=station;
			this.passenger=passenger;
		}
	}
}


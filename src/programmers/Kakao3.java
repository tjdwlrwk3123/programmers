package programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/*
 * 
���� ����
1���� n���� ��ȣ�� �ϳ��� �پ��ִ� n���� ���� ö�η� ����Ǿ� �ֽ��ϴ�.
ö�δ� ����� ������ �����ϸ�, ������ �� ���� ���� �����ϴ� ö�δ� �ִ� �ϳ��Դϴ�.
��, ���� �ٸ� �� �� ������ �̵� ��δ� �� �� ������, ������ �� �� ���̿� �̵� �Ұ����� ���� �����ϴ�.

��߿��� ������ ���̸� �պ��ϴ� ������ �����Ϸ� �մϴ�. ��߿��� 1�� ���̸�, 
��ü �� �� �� ���� ���������� ���ؾ� �մϴ�. ��, ������ ��߿����� ���������� �� �� ��� ���� �湮�� �ʿ�� ������, 
���� ���� �� �� �̻� �湮�ϸ� �� �˴ϴ�.

�������� ���ϱ� ���� �� ���� ���� �̿밴 ���� �����߽��ϴ�. 
�̶�, ������ �湮�ϴ� ���� ���� �̿밴 ���� ���� �ִ밡 �ǵ��� �������� �����ϸ� �˴ϴ�.
���� ���� �̿밴 ���� ���� �ִ밡 �Ǵ� ���� ���������, �� �� ��ȣ�� ū ���� �����ϸ� �˴ϴ�.

��ü ���� ���� n, 1������ n�� ������ ���� �̿밴 �� passenger, �� ������ ö�� ���� ���� train�� �Ű������� �־��� ��, 
���������� ������ �� ��ȣ�� �׶��� �̿밴 �� ���� ������� �迭�� ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.

���ѻ���
n�� 2 �̻� 100,000 ������ �ڿ����Դϴ�.
passenger�� ���̴� n�Դϴ�.
passenger�� ���Ҵ� 1 �̻� 10,000 ������ �ڿ����Դϴ�.
passenger[i]�� i + 1�� ���� ���� �̿밴 �� �Դϴ�.
train�� ����(��) ���̴� n - 1 �Դϴ�.
train�� ����(��) ���̴� 2�Դϴ�.
train�� ���Ҵ� [A, B] �����Դϴ�.
A, B�� ö�ΰ� �����ϴ� �� ���� ��ȣ�Դϴ�.
A, B�� 1 �̻� n ������ �ڿ����̸�, A�� B�� ���� ���� �����ϴ�.
���� ö�ο� ���� ������ �ߺ��ؼ� ������� �ʽ��ϴ�.
����� ��
n	passenger			train								result
6	[1,1,1,1,1,1]		[[1,2],[1,3],[1,4],[3,5],[3,6]]		[6,3]
4	[2,1,2,2]			[[1,2],[1,3],[2,4]]					[4,5]
5	[1,1,2,3,4]			[[1,2],[1,3],[1,4],[1,5]]			[5,5]
����� �� ����
����� �� #1

train_2.png

5�� ���� ���������� ���ϸ� ������ 1�� �� �� 3�� �� �� 5�� �� �� 3�� �� �� 1�� �� �� ... �� ���� �����Դϴ�. 1��, 3��, 5�� ���� ���� �̿밴 ���� ���� 3���Դϴ�.
6�� ���� ���������� ���ϸ� ������ 1�� �� �� 3�� �� �� 6�� �� �� 3�� �� �� 1�� �� �� ... �� ���� �����Դϴ�. 1��, 3��, 6�� ���� ���� �̿밴 ���� ���� 3���Դϴ�.
���� �̿밴 ���� ���� �ִ��� ��찡 ���� ����� ���� ��ȣ�� ū ���� �����ؾ� �մϴ�. ���� 6�� ���� ���������� ���մϴ�.

����� �� #2

4�� ���� ���������� ���ϸ� ������ 1�� �� �� 2�� �� �� 4�� �� �� 2�� �� �� 1�� �� �� ... �� ���� �����Դϴ�. �� ���� ���� �̿밴 ���� ���� 5���� �ǰ�, �̶��� �ִ��Դϴ�.

����� �� #3

5�� ���� ���������� ���ϸ� ������ 1�� �� �� 5�� �� �� 1�� �� �� ... �� ���� �����Դϴ�. 1��, 5�� ���� ���� �̿밴 ���� ���� 5���̰�, �̶��� �ִ��Դϴ�.
 */
class Kakao3 {
	static Queue<DpsList> q=new LinkedList<>();
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
		
		Stack<Integer> stack=new Stack<Integer>(); //����Ž�� ���û���
		boolean visited[]=new boolean[n+1];
		int[][] adjArray=new int[n+1][n+1];
		for(int i=0;i<train.length;i++) {
			int v1=train[i][0];
			int v2=train[i][1];
			adjArray[v1][v2]=1;
			adjArray[v2][v1]=1;
		}
		int maxCount=0;
		int station=0;
		for(int i=2;i<=n;i++) {
			getDps(1,i,stack,adjArray,visited,passenger);
		}
		while(!q.isEmpty()) {
			if(q.peek().passenger>=maxCount) {
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
		visited[start]=true;
		stack.push(start);
		
		if(start==end) {
			int allPassenger=0;
			for(int i=0;i<stack.size();i++) {
				allPassenger+=passenger[stack.elementAt(i)-1];
			}
			DpsList dl=new DpsList(stack.elementAt(stack.size()-1), allPassenger);
			System.out.println("�°�:"+dl.passenger+",��:"+dl.station);
			q.add(dl);
			
		}
		for(int i=1; i<=adjArray.length-1;i++) {
			if(adjArray[start][i]==1 && !visited[i]) {
				getDps(i,end,stack,adjArray,visited,passenger);
				visited[i]=false;
			}
		}
		stack.pop();
		
		
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


package programmers;

import java.util.ArrayList;

public class Day08 {
	/*
	/////////////////���� ���ڴ� �Ⱦ�///////////////////
	
	�迭 arr�� �־����ϴ�. �迭 arr�� �� ���Ҵ� ���� 0���� 9������ �̷���� �ֽ��ϴ�.
	�̶�, �迭 arr���� ���������� ��Ÿ���� ���ڴ� �ϳ��� ����� ���� �����Ϸ��� �մϴ�. 
	��, ���ŵ� �� ���� ������ ��ȯ�� ���� �迭 arr�� ���ҵ��� ������ �����ؾ� �մϴ�. 
	���� ���,
	arr = [1, 1, 3, 3, 0, 1, 1] �̸� [1, 3, 0, 1] �� return �մϴ�.
	arr = [4, 4, 4, 3, 3] �̸� [4, 3] �� return �մϴ�.
	�迭 arr���� ���������� ��Ÿ���� ���ڴ� �����ϰ� ���� ������ return �ϴ� solution �Լ��� �ϼ��� �ּ���.
	
	���ѻ���
	�迭 arr�� ũ�� : 1,000,000 ������ �ڿ���
	�迭 arr�� ������ ũ�� : 0���� ũ�ų� ���� 9���� �۰ų� ���� ����
	����� ��
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
	//////////////�� ���� ������ ��///////////////////
	
	�� ���� a, b�� �־����� �� a�� b ���̿� ���� ��� ������ ���� �����ϴ� �Լ�, solution�� �ϼ��ϼ���.
	���� ��� a = 3, b = 5�� ���, 3 + 4 + 5 = 12�̹Ƿ� 12�� �����մϴ�.
	
	���� ����
	a�� b�� ���� ���� �� �� �ƹ� ���� �����ϼ���.
	a�� b�� -10,000,000 �̻� 10,000,000 ������ �����Դϴ�.
	a�� b�� ��Ұ���� ���������� �ʽ��ϴ�.
	����� ��
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
	//////////////////ũ���� �����̱� ����(īī�� �ܿ� ���Ͻ�)//////////////////
	���� ȭ���� "1 x 1" ũ���� ĭ��� �̷���� "N x N" ũ���� ���簢 �����̸� ���ʿ��� ũ������ �ְ� �����ʿ��� �ٱ��ϰ� �ֽ��ϴ�. 
	�� ���� ĭ���� �پ��� ������ ��� ������ ������ ���� ĭ�� ��ĭ�Դϴ�. 
	��� ������ "1 x 1" ũ���� ���� �� ĭ�� �����ϸ� ������ ���� �Ʒ� ĭ���� �������� �׿� �ֽ��ϴ�. 
	���� ����ڴ� ũ������ �¿�� �������� ���� ��ġ���� ���� ���� �ִ� ������ ���� �ø� �� �ֽ��ϴ�. 
	���� �ø� ������ �ٱ��Ͽ� ���̰� �Ǵ� ��, �̶� �ٱ����� ���� �Ʒ� ĭ���� ������ ������� ���̰� �˴ϴ�.
	
	���� ���� ����� ���� �� ���� �ٱ��Ͽ� �����ؼ� ���̰� �Ǹ� �� ������ �Ͷ߷����鼭 �ٱ��Ͽ��� ������� �˴ϴ�.
	
	ũ���� �۵� �� ������ �������� �ʴ� ���� ������ ���� ������ ���� ������ ũ������ �۵���Ű�� ��쿡�� �ƹ��� �ϵ� �Ͼ�� �ʽ��ϴ�. 
	���� �ٱ��ϴ� ��� ������ �� �� ���� ��ŭ ����� ũ�ٰ� �����մϴ�.
	
	���� ȭ���� ������ ���°� ��� 2���� �迭 board�� ������ ���� ���� ũ������ �۵���Ų ��ġ�� ��� �迭 moves�� �Ű������� �־��� ��, 
	ũ������ ��� �۵���Ų �� ��Ʈ���� ����� ������ ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.
	
	[���ѻ���]
	board �迭�� 2���� �迭�� ũ��� "5 x 5" �̻� "30 x 30" �����Դϴ�.
	board�� �� ĭ���� 0 �̻� 100 ������ ������ ����ֽ��ϴ�.
	0�� �� ĭ�� ��Ÿ���ϴ�.
	1 ~ 100�� �� ���ڴ� ���� �ٸ� ������ ����� �ǹ��ϸ� ���� ���ڴ� ���� ����� ������ ��Ÿ���ϴ�.
	moves �迭�� ũ��� 1 �̻� 1,000 �����Դϴ�.
	moves �迭 �� ���ҵ��� ���� 1 �̻��̸� board �迭�� ���� ũ�� ������ �ڿ����Դϴ�.
	
	����� ��
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
                i=0; //i�� 1�� �ϸ� for���� �����鼭 i�� �ö󰡱⶧���� 0���� ���ְ� �ٷ� 1�� �����ϰ� ����
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
package programmers;

import java.util.ArrayList;

public class Day8 {
	/*
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
}

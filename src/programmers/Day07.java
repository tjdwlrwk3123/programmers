package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Day07 {
	/*
	////////////////////������ �������� ���� �迭/////////////////
	
	array�� �� element �� divisor�� ������ �������� ���� ������������ ������ �迭�� ��ȯ�ϴ� �Լ�, solution�� �ۼ����ּ���.
	divisor�� ������ �������� element�� �ϳ��� ���ٸ� �迭�� -1�� ��� ��ȯ�ϼ���.
	
	���ѻ���
	arr�� �ڿ����� ���� �迭�Դϴ�.
	���� i, j�� ���� i �� j �̸� arr[i] �� arr[j] �Դϴ�.
	divisor�� �ڿ����Դϴ�.
	array�� ���� 1 �̻��� �迭�Դϴ�.
	
	����� ��
	arr				divisor		return
	[5, 9, 7, 10]	5			[5, 10]
	[2, 36, 1, 3]	1			[1, 2, 3, 36]
	[3,2,6]			10			[-1]
	
	 */
	public int[] solution(int[] arr, int divisor) {
        int cnt=0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0){
                list.add(arr[i]);
                cnt++;
            }
        }
        if(cnt==0){
            int[] answer=new int[1];
            answer[0]=-1;
            return answer;
        }else{
            Collections.sort(list);
            int[] answer=new int[cnt];
            for(int i=0;i<cnt;i++){
                answer[i]=list.get(i);
            }
            return answer;
        }
    }
	/*
	///////////////3���� ������/////////////////
	
	�ڿ��� n�� �Ű������� �־����ϴ�. n�� 3���� �󿡼� �յڷ� ������ ��, 
	�̸� �ٽ� 10�������� ǥ���� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.

	���ѻ���
	n�� 1 �̻� 100,000,000 ������ �ڿ����Դϴ�.
	
	����� �� #1

	���� �����ϴ� ������ ������ �����ϴ�.
	n (10����)	n (3����)	�յ� ����(3����)	10�������� ǥ��
	45			1200	0021			7
	���� 7�� return �ؾ� �մϴ�.
	
	����� �� #2
	
	���� �����ϴ� ������ ������ �����ϴ�.
	n (10����)	n (3����)	�յ� ����(3����)	10�������� ǥ��
	125			11122	22111			229
	���� 229�� return �ؾ� �մϴ�.
	
	 */
	public int solution2(int n) {
        String changeNum="";
        while(n>0){ //3�������� �ٲٱ� (�տ� ���� ���̴°��̱� ������ String���� �����ؾ���)
            changeNum= (n%3)+changeNum;
            n/=3;
        }
        StringBuffer sb=new StringBuffer(changeNum); //���ڿ� ������ ���� ����
        String rev=sb.reverse().toString();
        /*
        int threeNum=Integer.parseInt(changeNum);
        int reverse=0;
        while(threeNum>0){ //���ڸ� ������ (���ڸ��� ��� 10�� �����డ���ϰ� ���ڸ��� �������� ���ؾ���) <-�ȵǴ� ����?
            reverse=(reverse*10)+(threeNum%10);
            threeNum/=10;
        }
         */
        int answer = Integer.parseInt(rev,3); //3������ 10������ �ٲٱ�
        return answer;
    }
}

package programmers;

public class Day11 {
	/*
	�� ��ȭ Ű�е忡�� �޼հ� �������� �����հ������� �̿��ؼ� ���ڸ��� �Է��Ϸ��� �մϴ�.
	�� ó�� �޼� �����հ����� * Ű�е忡 ������ �����հ����� # Ű�е� ��ġ���� �����ϸ�, �����հ����� ����ϴ� ��Ģ�� ������ �����ϴ�.
	
	�����հ����� �����¿� 4���� �������θ� �̵��� �� ������ Ű�е� �̵� �� ĭ�� �Ÿ��� 1�� �ش��մϴ�.
	���� ���� 3���� ���� 1, 4, 7�� �Է��� ���� �޼� �����հ����� ����մϴ�.
	������ ���� 3���� ���� 3, 6, 9�� �Է��� ���� ������ �����հ����� ����մϴ�.
	��� ���� 4���� ���� 2, 5, 8, 0�� �Է��� ���� �� �����հ����� ���� Ű�е��� ��ġ���� �� ����� �����հ����� ����մϴ�.
	4-1. ���� �� �����հ����� �Ÿ��� ���ٸ�, ���������̴� ������ �����հ���, �޼����̴� �޼� �����հ����� ����մϴ�.
	������� ���� ��ȣ�� ��� �迭 numbers, �޼��������� ������������ ���� ��Ÿ���� ���ڿ� hand�� �Ű������� �־��� ��, 
	�� ��ȣ�� ���� �����հ����� �޼��� �� �������� ���� ��Ÿ���� ���ӵ� ���ڿ� ���·� return �ϵ��� solution �Լ��� �ϼ����ּ���.
	
	[���ѻ���]
	numbers �迭�� ũ��� 1 �̻� 1,000 �����Դϴ�.
	numbers �迭 ������ ���� 0 �̻� 9 ������ �����Դϴ�.
	hand�� "left" �Ǵ� "right" �Դϴ�.
	"left"�� �޼�����, "right"�� ���������̸� �ǹ��մϴ�.
	�޼� �����հ����� ����� ���� L, ������ �����հ����� ����� ���� R�� ������� �̾�ٿ� ���ڿ� ���·� return ���ּ���.
	����� ��
	numbers								hand		result
	[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"		"LRLLLRLLRRL"
	[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"		"LRLLRRLLLRR"
	[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]		"right"		"LLRLLRLLRL"
	 */
	
	public String solution(int[] numbers, String hand) {
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0){
                numbers[i]=11; //���� 0�� 11�� �ٲٱ�
            }
        }
        String answer = "";
        int currLeft=10; //���� ��ġ�� 10�� 12�� ���� (*,# ��ü)
        int currRight=12;
        
        
        for(int i=0; i<numbers.length;i++){
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                answer+="L";
                currLeft=numbers[i];
            }else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                answer+="R";
                currRight=numbers[i];
            }else{ //��ġ�� 2,5,8,11(0)�϶�
            	/* 
            	 * ���� �޼��� ��ġ,�����տ� ��ġ���� 2,5,8,0 ��ġ�� �Ÿ��� ����ϱ� ���ؼ�
            	 * �� �Ʒ��� �����϶��� 3�� ���� ����,�������� 1���̰� ���� ������
            	 * �� ��ġ�� ���ڸ� �� ��(���밪) 3���� ���� ���� �Ÿ� 1�̸�, 3���� ���� ���������� �Ÿ� 1�� �ȴ�.
            	 * ��� �Ÿ��� ���ϸ� �޼�,�������� ��ġ���� 2,5,8,0�� ��ġ�� �ȴ�.
            	*/
                int x=Math.abs(numbers[i]-currLeft);
                int y=Math.abs(numbers[i]-currRight);
                //������ �Ǵ� �޼��� ��ġ�� �������ϴ� ��ġ ���� ������ 0�̵�.
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

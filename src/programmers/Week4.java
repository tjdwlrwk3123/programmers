package programmers;

public class Week4 {
	/*
	���� n�� �Է¹޾� n�� ����� ��� ���� ���� �����ϴ� �Լ�, solution�� �ϼ����ּ���.

	���� ����
	n�� 0 �̻� 3000������ �����Դϴ�.
	����� ��
	n	return
	12	28
	5	6
	 */
	public int day23_1(int n) {
        int answer = 1;
        for(int i=2;i<=n;i++){
            if(n%i==0){
                answer+=i;
            }
        }
        if(n==0){
            return 0;
        }else{
            return answer;
        }
    }
	/*
	�ִ������� �ּҰ����
	
	�� ���� �Է¹޾� �� ���� �ִ������� �ּҰ������ ��ȯ�ϴ� �Լ�, solution�� �ϼ��� ������. 
	�迭�� �� �տ� �ִ�����, �״��� �ּҰ������ �־� ��ȯ�ϸ� �˴ϴ�. 
	���� ��� �� �� 3, 12�� �ִ������� 3, �ּҰ������ 12�̹Ƿ� solution(3, 12)�� [3, 12]�� ��ȯ�ؾ� �մϴ�.

	���� ����
	�� ���� 1�̻� 1000000������ �ڿ����Դϴ�.
	����� ��
	n	m	return
	3	12	[3, 12]
	2	5	[1, 10]
	 */
	public int[] day23_2(int n, int m) {
        int[] answer = new int[2];
        for(int i=1;i<=n && i<=m;i++){ //�ִ����� ���ϱ�
            if(n%i==0 && m%i==0){
                answer[0]=i;
            }
        }
        answer[1]=n*m/answer[0]; //�ּҰ���� ���ϱ�(�� ���� ���� �ִ������� ������)
        return answer;
    }
}

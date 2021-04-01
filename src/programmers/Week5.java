package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Week5 {
	/*
	�Ϲ����� �����ʹ� �μ� ��û�� ���� ������� �μ��մϴ�. �׷��� ������ �߿��� ������ ���߿� �μ�� �� �ֽ��ϴ�. 
	�̷� ������ �����ϱ� ���� �߿䵵�� ���� ������ ���� �μ��ϴ� �����͸� �����߽��ϴ�. �� ���Ӱ� ������ �����ʹ� �Ʒ��� ���� ������� �μ� �۾��� �����մϴ�.

	1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� �����ϴ�.
	2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� �ֽ��ϴ�.
	3. �׷��� ������ J�� �μ��մϴ�.
	���� ���, 4���� ����(A, B, C, D)�� ������� �μ� ����Ͽ� �ְ� �߿䵵�� 2 1 3 2 ��� C D A B ������ �μ��ϰ� �˴ϴ�.
	
	���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� �˰� �ͽ��ϴ�. ���� ������ C�� 1��°��, A�� 3��°�� �μ�˴ϴ�.
	
	���� ����Ͽ� �ִ� ������ �߿䵵�� ������� ��� �迭 priorities�� 
	���� �μ⸦ ��û�� ������ ���� ������� � ��ġ�� �ִ����� �˷��ִ� location�� �Ű������� �־��� ��, 
	���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���ѻ���
	���� ����Ͽ��� 1�� �̻� 100�� ������ ������ �ֽ��ϴ�.
	�μ� �۾��� �߿䵵�� 1~9�� ǥ���ϸ� ���ڰ� Ŭ���� �߿��ϴٴ� ���Դϴ�.
	location�� 0 �̻� (���� ����Ͽ� �ִ� �۾� �� - 1) ������ ���� ������ ������� ���� �տ� ������ 0, �� ��°�� ������ 1�� ǥ���մϴ�.
	����� ��
	priorities				location		return
	[2, 1, 3, 2]				2			1
	[1, 1, 9, 1, 1, 1]			0			5
	 */
	public int day27(int[] priorities, int location) {
        int answer = 0;
        Queue<Printer> queue=new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            queue.offer(new Printer(i,priorities[i])); //ť�� Printer��� Ŭ������ �߰�
        }
        while(!queue.isEmpty()){ //ť�� �������� �ݺ�
            boolean isBig=true;
            int num=queue.peek().prior; //peek:����
            for(Printer p:queue){
                if(num<p.prior){ //�� ū ���ڰ� �ִ°��
                    isBig=false;
                }
            }
            if(!isBig){
                queue.offer(queue.poll()); //�� ū ���ڰ� ������ ť�� �� ���� �� �ڷ� ������
            }else{
                if (queue.poll().location == location) { //poll:������ , �����鼭 location�� ���� ��ġ���� Ȯ��
					answer = priorities.length - queue.size(); //������ �ش� ��ġ�� ã�� ���� �迭�� ���̿��� ť�� ���̸�ŭ ����
				}
            }
        }
        return answer;
    }
	class Printer{ //ť�� ���� �� ���� (�ؽø��� �ƴϾ ��. Ŭ���� ���� ����)
	    int location;
	    int prior;
	    Printer(int location,int prior){
	        this.location=location;
	        this.prior=prior;
	    }
	}
}

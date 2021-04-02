package programmers;

import java.util.ArrayList;
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
	/*
	 * 
	///////////Queue���� -> ��ɰ���//////////////
	���α׷��ӽ� �������� ��� ���� �۾��� ���� ���Դϴ�. �� ����� ������ 100%�� �� ���񽺿� �ݿ��� �� �ֽ��ϴ�.

	��, �� ����� ���߼ӵ��� ��� �ٸ��� ������ �ڿ� �ִ� ����� �տ� �ִ� ��ɺ��� ���� ���ߵ� �� �ְ�, 
	�̶� �ڿ� �ִ� ����� �տ� �ִ� ����� ������ �� �Բ� �����˴ϴ�.
	
	���� �����Ǿ�� �ϴ� ������� �۾��� ������ ���� ���� �迭 progresses�� �� �۾��� ���� �ӵ��� ���� ���� �迭 speeds�� �־��� �� 
	�� �������� �� ���� ����� �����Ǵ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
	
	���� ����
	�۾��� ����(progresses, speeds�迭�� ����)�� 100�� �����Դϴ�.
	�۾� ������ 100 �̸��� �ڿ����Դϴ�.
	�۾� �ӵ��� 100 ������ �ڿ����Դϴ�.
	������ �Ϸ翡 �� ���� �� �� ������, �Ϸ��� ���� �̷�����ٰ� �����մϴ�. ���� ��� �������� 95%�� �۾��� ���� �ӵ��� �Ϸ翡 4%��� ������ 2�� �ڿ� �̷�����ϴ�.
	����� ��
	progresses					speeds				return
	[93, 30, 55]				[1, 30, 5]			[2, 1]
	[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
	 */
	public int[] day28(int[] progresses, int[] speeds) {
        Queue<Progress> queue=new LinkedList<>();
        ArrayList<Integer> finishList=new ArrayList<>();
        for(int i=0;i<progresses.length;i++){
            queue.add(new Progress(progresses[i],speeds[i])); //ť�� ��� �۾����� �߰�
        }
        int day=0;
        while(!queue.isEmpty()){
            int p= queue.peek().progress;
            int s= queue.peek().speed;
            int finished=0; //�迭�� �� �Ϸ� ��ϵ�
            p+=s*day; //2��°���� ���ĺ��ʹ� ������ �ϼ���ŭ �۾����� ���������
            while(p<100){ //100���� ���������� �ݺ�(100�� ���Ƶ� �ٷ� ��)
                p+=s;
                day++;
            }
            queue.poll();
            finished++;
            while(!queue.isEmpty()){ //�� �����۾��� �������� ������ ���鼭 Ȯ��(���� ť�� ������ Ż��)
                int p2=queue.peek().progress;
                int s2=queue.peek().speed;
                p2+=s2*day;
                if(p2>=100){
                    queue.poll();
                    finished++;
                }else{
                    break;
                }
            }
            finishList.add(finished); //�Ϸ��� ������ ��̸���Ʈ�� �߰�
        }
        int[] answer=new int[finishList.size()];
        for(int i=0;i<finishList.size();i++){
            answer[i]=finishList.get(i); //��̸���Ʈ �迭�� �ٽ� �⺻ �迭�� �ű��
        }
        return answer;
    }
	class Progress{
	    int progress;
	    int speed;
	    Progress(int progress,int speed){
	        this.progress=progress;
	        this.speed=speed;
	    }
	}
}


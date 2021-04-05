package programmers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	/*
	0 �Ǵ� ���� ������ �־����� ��, ������ �̾� �ٿ� ���� �� �ִ� ���� ū ���� �˾Ƴ� �ּ���.

	���� ���, �־��� ������ [6, 10, 2]��� [6102, 6210, 1062, 1026, 2610, 2106]�� ���� �� �ְ�, ���� ���� ū ���� 6210�Դϴ�.
	
	0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��, 
	������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���ڿ��� �ٲپ� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���� ����
	numbers�� ���̴� 1 �̻� 100,000 �����Դϴ�.
	numbers�� ���Ҵ� 0 �̻� 1,000 �����Դϴ�.
	������ �ʹ� Ŭ �� ������ ���ڿ��� �ٲپ� return �մϴ�.
	����� ��
	numbers	return
	[6, 10, 2]	"6210"
	[3, 30, 34, 5, 9]	"9534330"
	 */
	//1��Ǯ�� : ����Լ��� �̿��Ͽ� ��� ���� ������ �� ��(�ð����⵵�� �ʹ� Ŀ�� ��ȿ����)
	static ArrayList<String> numList=new ArrayList<String>();
    
    public static String day31_1(int[] numbers) {
        String answer = "";
        ArrayList<String> arr=new ArrayList<String>();
        for(int i=0;i<numbers.length;i++){
            arr.add(numbers[i]+"");
        }
        ArrayList<String> result=new ArrayList<String>();
        
        ArrayList<String> list=reculsion(arr,result,arr.size());
        BigInteger a=new BigInteger(list.get(0));
        for(int i=1;i<list.size();i++){
            BigInteger b=new BigInteger(list.get(i));
            if(b.compareTo(a)==1){
                a=b;
            }
        }
        answer=a.toString();
        return answer;
    }
    
    public static ArrayList<String> reculsion(ArrayList<String> arr,ArrayList<String> result,int n){
        if( n == 0 ) {
            String num="";
            for(int i=0;i<result.size();i++){
                num+=result.get(i);
            }
            numList.add(num);
        }
        for( int i=0; i<n; i++){
            result.add(arr.remove(i));
            reculsion(arr, result, n - 1);
			arr.add(i, result.remove(result.size() - 1));
        }
        return numList;
    }
    //2��Ǯ��(compare �������̵�)
    public static String day31_2(int[] numbers) {
    	String answer="";
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	for (int i=0;i<numbers.length;i++) {
    		list.add(numbers[i]);
    	}
    	Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String a=o1+"";
				String b=o2+"";
				System.out.println(a+"/"+b);
				if(o1>o2) {
					System.out.println(a.substring(0, b.length()));
					o1=Integer.parseInt(a.substring(0, b.length()));
					if(o1>o2) {
						return -1;
					}else if(o1<o2) {
						return 1;
					}else {
						if(Long.parseLong(a+b)>Long.parseLong(b+a)) {
							return -1;
						}else {
							return 1;
						}
					}
				}else if(o1<o2) {
					o2=Integer.parseInt(b.substring(0, a.length()));
					if(o1>o2) {
						return -1;
					}else if(o1<o2) {
						return 1;
					}else {
						if(Long.parseLong(a+b)>Long.parseLong(b+a)) {
							return -1;
						}else {
							return 1;
						}
					}
				}else {
					return 0;
				}
			}
		});
    	
    	for(int i=0;i<list.size();i++) {
    		answer+=list.get(i)+"/";
    	}
    	if(answer.substring(0,1).equals("0")) {
    		return "0";
    	}
    	return answer;
    }
}


package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Week6 {
	/*
	� ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���ڸ� ���Ϸ� �մϴ�.

	���� ���, ���� 1924���� �� �� ���� �����ϸ� [19, 12, 14, 92, 94, 24] �� ���� �� �ֽ��ϴ�. �� �� ���� ū ���ڴ� 94 �Դϴ�.
	
	���ڿ� �������� ���� number�� ������ ���� ���� k�� solution �Լ��� �Ű������� �־����ϴ�. 
	number���� k ���� ���� �������� �� ���� �� �ִ� �� �� ���� ū ���ڸ� ���ڿ� ���·� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
	
	���� ����
	number�� 1�ڸ� �̻�, 1,000,000�ڸ� ������ �����Դϴ�.
	k�� 1 �̻� number�� �ڸ��� �̸��� �ڿ����Դϴ�.
	����� ��
	number			k	return
	"1924"			2	"94"
	"1231234"		3	"3234"
	"4177252841"	4	"775841"
	 */
	public static void main(String[] args) {
		String number="1231234";
		String aa=day37(number,3);
		System.out.println(aa);
	}
	static ArrayList<String> answerList=new ArrayList<>();
    public static String day37(String number, int k) {
        String[] list=number.split("");
        int n=number.length();
        int r=number.length()-k;
        boolean[] visited=new boolean[n];
        combination(list,visited,0,n,r);
        
        Collections.sort(answerList);
        
        return answerList.get(answerList.size()-1);
    }
    public static void combination(String[] list, boolean[] visited,int start, int n, int r){
    	if (r == 0) {
    		String l="";
    		for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    l+=list[i];
                }
            }
    		answerList.add(l);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(list, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    //Ǯ�� ������ �ð��� �����ɷ��� ��ȿ��, �׽�ũ���̽� ����.
    
    /*
	�ζǸ� ������ �ο�� ��÷ ��ȣ ��ǥ���� �м�����ϰ� �־����ϴ�. ������, �ο��� ������ �ζǿ� ������ �Ͽ�, �Ϻ� ��ȣ�� �˾ƺ� �� ���� �Ǿ����ϴ�. 
	��÷ ��ȣ ��ǥ ��, �ο�� �ڽ��� �����ߴ� �ζǷ� ��÷�� �����ߴ� �ְ� ������ ���� ������ �˾ƺ��� �;� �����ϴ�.
	�˾ƺ� �� ���� ��ȣ�� 0���� ǥ���ϱ�� �ϰ�, �ο찡 ������ �ζ� ��ȣ 6���� 44, 1, 0, 0, 31 25��� �����غ��ڽ��ϴ�. 
	��÷ ��ȣ 6���� 31, 10, 45, 1, 6, 19���, ��÷ ������ �ְ� ������ ���� ������ �� ���� �Ʒ��� �����ϴ�.
	
	��÷ ��ȣ	31	10	45	1	6	19	���
	�ְ� ���� ��ȣ	31	0��10	44	1	0��6	25	4�� ��ȣ ��ġ, 3��
	���� ���� ��ȣ	31	0��11	44	1	0��7	25	2�� ��ȣ ��ġ, 5��
	
	������ �������, ������ �ζǿ� ��÷ ��ȣ�� ��ġ�ϴ� ��ȣ�� ������ ���� �ɷ� �����˴ϴ�.
	�˾ƺ� �� ���� �� ���� ��ȣ�� ���� 10, 6�̶�� �����ϸ� 3� ��÷�� �� �ֽ��ϴ�.
	3���� ����� �ٸ� ����鵵 �����մϴ�. ������, 2�� �̻����� ����� ���� �Ұ����մϴ�.
	�˾ƺ� �� ���� �� ���� ��ȣ�� ���� 11, 7�̶�� �����ϸ� 5� ��÷�� �� �ֽ��ϴ�.
	5���� ����� �ٸ� ����鵵 �����մϴ�. ������, 6��(��÷)���� ����� ���� �Ұ����մϴ�.
	
	�ο찡 ������ �ζ� ��ȣ�� ���� �迭 lottos, ��÷ ��ȣ�� ���� �迭 win_nums�� �Ű������� �־����ϴ�. 
	�̶�, ��÷ ������ �ְ� ������ ���� ������ ���ʴ�� �迭�� ��Ƽ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
     */
    public int[] week6_2(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(win_nums);
        Arrays.sort(lottos);
        int count=0;
        int plus=0;
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0){
                plus++;
                continue;
            }
            for(int j=0;j<win_nums.length;j++){
                if(win_nums[j]==lottos[i]){
                    count++;
                    break;
                }
            }
        }
        switch(count+plus){
            case 0 :
            case 1 : answer[0]=6; break;
            case 2 : answer[0]=5; break;
            case 3 : answer[0]=4; break;
            case 4 : answer[0]=3; break;
            case 5 : answer[0]=2; break;
            case 6 : answer[0]=1; break;
        }
        switch(count){
            case 0 :
            case 1 : answer[1]=6; break;
            case 2 : answer[1]=5; break;
            case 3 : answer[1]=4; break;
            case 4 : answer[1]=3; break;
            case 5 : answer[1]=2; break;
            case 6 : answer[1]=1; break;
        }
        return answer;
    }
}

package programmers;

import java.util.ArrayList;
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
}

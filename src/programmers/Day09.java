package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Day09 {
	/*
	/////////////////���ڿ� �� ������� �����ϱ�///////////////////
	
	���ڿ��� ������ ����Ʈ strings��, ���� n�� �־����� ��, �� ���ڿ��� �ε��� n��° ���ڸ� �������� �������� �����Ϸ� �մϴ�. 
	���� ��� strings�� ["sun", "bed", "car"]�̰� n�� 1�̸� �� �ܾ��� �ε��� 1�� ���� "u", "e", "a"�� strings�� �����մϴ�.

	���� ����
	strings�� ���� 1 �̻�, 50������ �迭�Դϴ�.
	strings�� ���Ҵ� �ҹ��� ���ĺ����� �̷���� �ֽ��ϴ�.
	strings�� ���Ҵ� ���� 1 �̻�, 100������ ���ڿ��Դϴ�.
	��� strings�� ������ ���̴� n���� Ů�ϴ�.
	�ε��� 1�� ���ڰ� ���� ���ڿ��� ���� �� ���, ���������� �ռ� ���ڿ��� ���ʿ� ��ġ�մϴ�.
	����� ��
	strings					n	return
	["sun", "bed", "car"]	1	["car", "bed", "sun"]
	["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
		
	 */
	public static String[] solution1(String[] strings, int n) {
        ArrayList<String> list=new ArrayList<String>();
        for(int i=0; i<strings.length;i++){
            String alp=strings[i].substring(n,n+1); //���ĺ� n��° �ε����� ��������
            list.add(alp+strings[i]); //�ش� ���ĺ��� �� �տ� �ٿ��� �� �ܾ� �����
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            String ans=list.get(i).substring(1); //0��°�� ���� ���� �����ϱ� ������ �ε��� 1����
            answer[i]=ans;
        }
        return answer;
    }
	public static void main(String[] args) {
		String[] strings={"sun", "bed", "car"};
		String[] a=solution1(strings,1);
		for(String ans:a) {
			System.out.println(ans);
		}
	}
	/*
	////////////////////////////���� ��ȣ/////////////////////////
	
	� ������ �� ���ĺ��� ������ �Ÿ���ŭ �о �ٸ� ���ĺ����� �ٲٴ� ��ȣȭ ����� ���� ��ȣ��� �մϴ�. 
	���� ��� "AB"�� 1��ŭ �и� "BC"�� �ǰ�, 3��ŭ �и� "DE"�� �˴ϴ�. "z"�� 1��ŭ �и� "a"�� �˴ϴ�. 
	���ڿ� s�� �Ÿ� n�� �Է¹޾� s�� n��ŭ �� ��ȣ���� ����� �Լ�, solution�� �ϼ��� ������.

	���� ����
	������ �ƹ��� �о �����Դϴ�.
	s�� ���ĺ� �ҹ���, �빮��, �������θ� �̷���� �ֽ��ϴ�.
	s�� ���̴� 8000�����Դϴ�.
	n�� 1 �̻�, 25������ �ڿ����Դϴ�.
	����� ��
	s		n	result
	"AB"	1	"BC"
	"z"		1	"a"
	"a B z"	4	"e F d"
	
	 */
	public String solution2(String s, int n) {
        String answer = "";
        for(int i=0;i<s.length();i++){
            char alp=s.charAt(i);
            int newInt=0;
            if(alp==' '){ //������ �ƹ��� �о ����
                newInt=(int)alp;
            }else{ //������ �ƴҶ�
                newInt=(int)alp+n;
            }
            if(alp>='a' && alp<='z'){ //���� ���ĺ��� a~z�϶�
                if(newInt>(int)'z'){ //���ڸ� ���� �� ���ĺ��� z�� ������
                    newInt=(int)'a'+(newInt-(int)'z')-1; //�ٽ� a�� �ͼ� ���
                }
            }else if(alp>='A' && alp<='Z'){ //���� ���ĺ��� A~Z�϶�
                if(newInt>(int)'Z'){
                    newInt=(int)'A'+(newInt-(int)'Z')-1;
                }
            }
            answer+=Character.toString((char)newInt);
        }
        return answer;
    }
}

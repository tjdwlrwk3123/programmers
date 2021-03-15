package programmers;

import java.util.regex.Pattern;

public class Day12 {
	/*
	���ڿ� s�� ���̰� 4 Ȥ�� 6�̰�, ���ڷθ� �������ִ��� Ȯ�����ִ� �Լ�, solution�� �ϼ��ϼ���. 
	���� ��� s�� "a234"�̸� False�� �����ϰ� "1234"��� True�� �����ϸ� �˴ϴ�.

	���� ����
	s�� ���� 1 �̻�, ���� 8 ������ ���ڿ��Դϴ�.
	����� ��
	s	return
	"a234"	false
	"1234"	true
	
	 */
	public boolean solution(String s) {
        boolean answer = true;
        if(s.length()==4 || s.length()==6){
        	/*
        	 * ^	: ���ڿ��� ����
        	 * []	: ������ �����̳� ����
        	 * *	: �� ���ڰ� �������� �ְ� ������ �������� ����
        	 * $	: ���ڿ��� ����
        	 * {4}|{6} : ���̰˻絵 ����
        	 * {}	: Ƚ�� �Ǵ� ������ ��Ÿ��
        	 * |	: ���� �ȿ��� or������ ����
        	 */
            if(Pattern.matches("^[0-9]*$",s)){ //����ǥ����
                answer=true;
            }else{
                answer=false;
            }
        }else{
            answer=false;
        }
        return answer;
    }
}

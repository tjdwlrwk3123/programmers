package programmers;
/*
�빮�ڿ� �ҹ��ڰ� �����ִ� ���ڿ� s�� �־����ϴ�. 
s�� 'p'�� ������ 'y'�� ������ ���� ������ True, �ٸ��� False�� return �ϴ� solution�� �ϼ��ϼ���. 
'p', 'y' ��� �ϳ��� ���� ���� �׻� True�� �����մϴ�. ��, ������ ���� �� �빮�ڿ� �ҹ��ڴ� �������� �ʽ��ϴ�.

���� ��� s�� "pPoooyY"�� true�� return�ϰ� "Pyy"��� false�� return�մϴ�.

���ѻ���
���ڿ� s�� ���� : 50 ������ �ڿ���
���ڿ� s�� ���ĺ����θ� �̷���� �ֽ��ϴ�.
����� ��
s	answer
"pPoooyY"	true
"Pyy"	false

 */
class Day10{
	boolean solution(String s) {
	        s=s.toLowerCase();
	        int pcnt=0;
	        int ycnt=0;
	        for(int i=0;i<s.length();i++){
	            if(s.substring(i,i+1).equals("p")){
		            pcnt++;
	            }else if(s.substring(i,i+1).equals("y")){
	                ycnt++;
	            }
	         }
	        if(pcnt==ycnt){
	            return true;
		}else{
	            return false;
		}
	}
}

package programmers;

import java.util.Arrays;
import java.util.Collections;
/*
������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.

�����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��, 
�������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
�������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
������ �߿��� ���������� ���� �� �ֽ��ϴ�.

participant / completion / return
["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"

 */

//����� �ڵ�(sort�� ����ؼ� for���� �ѹ��� ����)
class Day2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        boolean last=true;
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0; i<participant.length-1;i++){
            if(!participant[i].equals(completion[i])){
                answer=participant[i];
                last=false;
                break;
            }
        }
        if(last==true){
            answer=participant[participant.length-1];
        }
        return answer;
    }
}
//ȿ�������� ������ �ڵ�(�ð��ʰ�)
class fail2{
	 public String solution(String[] participant, String[] completion) {
	        for(int i=0;i<completion.length;i++){
	            for(int j=0;j<participant.length;j++){
	               if(completion[i].equals(participant[j])){
	                   completion[i]="";
	                   participant[j]="";
	                   break;
	               }
	            }
	        }
	        String answer = "";
	        Arrays.sort(participant,Collections.reverseOrder());
	        answer=participant[0];
	        return answer;
	 }
}
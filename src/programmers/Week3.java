package programmers;

import java.util.Arrays;

public class Week3 {
	/*
	/////////////////////////�������///////////////////////
	
	�׿��� ��� ���ε��� ������ ���ܳ��� ��Ҹ� �˷��� ��������� �տ� �־���. 
	�׷��� �� ��������� ���ڷ� ��ȣȭ�Ǿ� �־� ��ġ�� Ȯ���ϱ� ���ؼ��� ��ȣ�� �ص��ؾ� �Ѵ�. ������ ���� ��ȣ�� �ص��� ����� ������� �޸� �Բ� �߰��ߴ�.

	1.������ �� ���� ���̰� n�� ���簢�� �迭 ���·�, �� ĭ�� "����"(" ") �Ǵ� "��"("#") �� ������ �̷���� �ִ�.
	2.��ü ������ �� ���� ������ ���ļ� ���� �� �ִ�. ���� "���� 1"�� "���� 2"��� ����. 
	���� 1 �Ǵ� ���� 2 �� ��� �ϳ��� ���� �κ��� ��ü ���������� ���̴�. ���� 1�� ���� 2���� ��� ������ �κ��� ��ü ���������� �����̴�.
	3."���� 1"�� "���� 2"�� ���� ���� �迭�� ��ȣȭ�Ǿ� �ִ�.
	4.��ȣȭ�� �迭�� ������ �� �����ٿ��� �� �κ��� 1, ���� �κ��� 0���� ��ȣȭ���� �� ������� �������� �ش��ϴ� ���� �迭�̴�.
	
	������ ��������� �ص��Ͽ� '#', �������� ������ ���ڿ� �迭�� ����϶�.
	
	����� ����
	�Ű�����	��
	n		5
	arr1	[9, 20, 28, 18, 11]
	arr2	[30, 1, 21, 17, 28]
	���		["#####","# # #", "### #", "# ##", "#####"]
	
	 */
	public String[] day15(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<arr1.length;i++){
            String bin=Integer.toBinaryString(arr1[i]); //2���� ���ڿ��� �ٲٱ�
            bin=bin.format("%0"+n+"d",Long.parseLong(bin)); //Long������ �ٲ��� �տ� �ڸ��� ä��� (1001->01001)
            answer[i]="";
            for(int j=0;j<bin.length();j++){
                if(bin.substring(j,j+1).equals("1")){
                    answer[i]+="#";
                }else{
                    answer[i]+=" ";
                }
            }
            
        }
        for(int i=0;i<arr2.length;i++){
            String bin=Integer.toBinaryString(arr2[i]);
            bin=bin.format("%0"+n+"d",Long.parseLong(bin));
            StringBuilder ans=new StringBuilder(answer[i]); //���ڿ��� ġȯ�ϱ� ���ؼ� ��Ʈ������ Ŭ���� ���
            for(int j=0;j<bin.length();j++){
                if(bin.substring(j,j+1).equals("1")){
                    ans.setCharAt(j,'#'); //��Ʈ�������� �޼ҵ�(j��° �ε����� char�� '#'�� �ٲٱ�)
                }
            }
            answer[i]=ans.toString(); //StringBuilder�� ��Ʈ������ ����ȯ
        }
        return answer;
    }
	/*
	/////////////////////�ϻ����� ��//////////////////
	
	���� ���� x�� �ϻ��� ���̷��� x�� �ڸ����� ������ x�� ���������� �մϴ�. 
	���� ��� 18�� �ڸ��� ���� 1+8=9�̰�, 18�� 9�� ������ �������Ƿ� 18�� �ϻ��� ���Դϴ�. 
	�ڿ��� x�� �Է¹޾� x�� �ϻ��� ������ �ƴ��� �˻��ϴ� �Լ�, solution�� �ϼ����ּ���.

	���� ����
	x�� 1 �̻�, 10000 ������ �����Դϴ�.
	
	����� ��
	arr	return
	10	true
	12	true
	11	false
	13	false
	 */
	public boolean day16_1(int x) {
        boolean answer = true;
        String num=x+"";
        int harsa=0;
        for(int i=0;i<num.length();i++){
            harsa+=Integer.parseInt(num.substring(i,i+1));
        }
        if(x%harsa!=0){
            answer=false;
        }
        return answer;
    }
	/*
	////////////////////���� ���� �� �����ϱ�///////////////////
	
	������ ������ �迭, arr ���� ���� ���� ���� ������ �迭�� �����ϴ� �Լ�, solution�� �ϼ����ּ���. 
	��, �����Ϸ��� �迭�� �� �迭�� ��쿣 �迭�� -1�� ä�� �����ϼ���. 
	������� arr�� [4,3,2,1]�� ���� [4,3,2]�� ���� �ϰ�, [10]�� [-1]�� ���� �մϴ�.

	���� ����
	arr�� ���� 1 �̻��� �迭�Դϴ�.
	�ε��� i, j�� ���� i �� j�̸� arr[i] �� arr[j] �Դϴ�.
	����� ��
	arr			return
	[4,3,2,1]	[4,3,2]
	[10]		[-1]
	 */
	public int[] day16_2(int[] arr) {
        int[] answer={};
        if(arr.length==1){
            answer=new int[1];
            answer[0]=-1;
        }else{
            int[] arr2=arr.clone(); //��������(������ �����ص� �ٲ��� ���纻�� �ٲ��� ����)
            Arrays.sort(arr2);
            answer=new int[arr.length-1];
            boolean find=false;
            for(int i=0;i<answer.length;i++){
                if(find){
                    answer[i]=arr[i+1];
                }else{
                    if(arr[i]==arr2[0]){ //���� �������� ã������
                        answer[i]=arr[i+1];
                        find=true; //find�� true�� �ٲ㼭 �� �������ʹ� answer[i]=arr[i+1]�� �ǰ� ��
                        continue;
                    }
                    answer[i]=arr[i]; //���� �������� ã����
                }
            }
        }
        
        return answer;
    }
}

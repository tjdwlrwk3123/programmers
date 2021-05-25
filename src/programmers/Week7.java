package programmers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Week7 {
	public static void main(String[] args) {
		int aa=chocolateFeast_week7_2(12,4,4);
		System.out.println(aa);
	}
	/*
	 * ���ڷ� �� �ð� h�� �� m�� �־����� �̸� ���ĺ� �ð����� ��ȯ�Ͽ� ����ϱ�
	 * ���� 00���� ���� o' clock����,
	 * 15���� ��� quarter past hour,
	 * 30���� ��� half past hour,
	 * 45���� ���  quarter to hour�� ǥ���Ѵ�.
	 * �� �ܿ��� m<30�ϰ��  (eleven minutes past five)�� ���� ǥ���ϰ�
	 * m>30�϶��� �� �����ð��� ������ (twenty six minutes to six)�� ���� ǥ���Ͽ� ����Ͽ��� �Ѵ�.
	 */
	public static String timeInWords_week7_1(int h, int m) {
        // Write your code here
        String hour="";
        String Minute="";
        int pORt = 0; //past���� to���� ���߿� �߰����ֱ� ���� ���� (0�ϰ���  past,to�� �� �ƴҶ�)
        if(m==0){
            Minute=" o\' clock";
        }else if(m==15){
            Minute="quarter past ";
        }else if(m==30){
            Minute="half past ";
        }else if(m==45){
            Minute="quarter to ";
            h++;
        }else if(m<30){
            pORt=1;
        }else{ //30�� �ʰ��϶�
            m=60-m;
            h++;
            pORt=2;
        }
        switch(m){ //past�� to ��� �� ���� ���� ���ĺ��� ����� �� �ִ�.
            case 1 : Minute="one minute "; break;
            case 2 : Minute="two minutes "; break;
            case 3 : Minute="three minutes "; break;
            case 4 : Minute="four minutes "; break;
            case 5 : Minute="five minutes "; break;
            case 6 : Minute="six minutes "; break;
            case 7 : Minute="seven minutes "; break;
            case 8 : Minute="eight minutes "; break;
            case 9 : Minute="nine minutes "; break;
            case 10 : Minute="ten minutes "; break;
            case 11 : Minute="eleven minutes "; break;
            case 12 : Minute="twelve minutes "; break;
            case 13 : Minute="thirteen minutes "; break;
            case 14 : Minute="fourteen minutes "; break;
            case 16 : Minute="sisteen minutes "; break;
            case 17 : Minute="seventeen minutes "; break;
            case 18 : Minute="eighteen minutes "; break;
            case 19 : Minute="nineteen minutes "; break;
            case 20 : Minute="twenty minutes "; break;
            case 21 : Minute="twenty one minutes "; break;
            case 22 : Minute="twenty two minutes "; break;
            case 23 : Minute="twenty three minutes "; break;
            case 24 : Minute="twenty four minutes "; break;
            case 25 : Minute="twenty five minutes "; break;
            case 26 : Minute="twenty six minutes "; break;
            case 27 : Minute="twenty seven minutes "; break;
            case 28 : Minute="twenty eight minutes "; break;
            case 29 : Minute="twenty nine minutes "; break;
        }
        if(pORt==1){
            Minute+="past ";
        }else if(pORt==2){
            Minute+="to ";
        }
        switch(h){
            case 1 : hour="one"; break;
            case 2 : hour="two"; break;
            case 3 : hour="three"; break;
            case 4 : hour="four"; break;
            case 5 : hour="five"; break;
            case 6 : hour="six"; break;
            case 7 : hour="seven"; break;
            case 8 : hour="eight"; break;
            case 9 : hour="nine"; break;
            case 10 : hour="ten"; break;
            case 11 : hour="eleven"; break;
            case 12 : hour="twelve"; break;
        }
        String answer="";
        if(m==0){ //o' clock�ϰ��� ��ġ�� �ݴ�
            answer=hour+Minute;
        }else{
            answer=Minute+hour;
        }
        return answer;
    }
	/*
	 * ���� ���� �� n�� ���ݸ��� ���� c�� �־�����.
	 * ���� ���ݸ��� ���ΰ� �ִ� ���ݸ� ������ m�� ������ �� ��� ���ݸ� �� ���� ��ȯ�� �����ϴ�.
	 * �� �� �ִ�� ���� �� �ִ� ���ݸ��� ������ ��ȯ�Ͽ��� �Ѵ�. 
	 * 
	 * ����
	 * n=15,c=3,m=2�ϰ��
	 * ���ݸ��� ó���� 5���� �� ��, ���� 4���� �� ��� ���ݸ� 2���� �� ���� �� �ִ�.
	 * ���� 2���� ������ �ٽ� ���ݸ� �Ѱ��� ���� �� �ְ�,
	 * ó���� ���� ���� �Ѱ��� ��� ���� ���ݸ� �Ѱ��� �� �ٽ� ���ݸ� �Ѱ��� ���� �� �ִ�.
	 * 5 + 2 + 1 + 1 = 9���� �ִ�� ���� �� �ִ�.
	 */
	public static int chocolateFeast_week7_2(int n, int c, int m) {
        // Write your code here
        int eatC = n/c; //���� ���ݸ� ����
        int wrap = n/c; //�԰� ���� ���ݸ� ������ ����
        
        while(wrap>=m){
            eatC+=wrap/m; //������ ���ݸ����� ��ȯ�Ѹ�ŭ ���ϱ�
            wrap=wrap%m+wrap/m; //���� ���� + ���� ��ȯ�� ���ݸ��� ����
        }
        return eatC;
    }
	/*
	 * ������ ���ڿ��� �̷���� n���� �������� ���ڿ��� ������ "-"�� ġȯ�� ��
	 * ������ ������ ���ڿ��� ������ �������� �����ؼ� ���ڿ��� �̾�ٿ��� ����ؾ��Ѵ�.
	 * 
	 */
	public static void countSort_week7_3(List<List<String>> arr) {
        // Write your code here
        for(int i=0;i<arr.size()/2;i++){ //����Ʈ�� �ʹ� ������ -�� ġȯ
            arr.get(i).set(1,"-");
        }
        Collections.sort(arr,new Comparator<List<String>>(){ //compare�Լ��� �̿��ؼ� ����Ʈ�� ���� ������������ ����
            @Override
            public int compare(List<String> arg0,List<String> arg1){ //����Ʈ ���� ����Ʈ�̱� ������ compare�̿�
                int a=Integer.parseInt(arg0.get(0));
                int b=Integer.parseInt(arg1.get(0));
                
                if(a>b){
                    return 1;
                }else if(a==b){
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        String answer="";
        for(int i=0;i<arr.size();i++){
            answer+=arr.get(i).get(1)+" ";
        }
        System.out.println(answer);
    }
	//�׽�Ʈ���̽��� ���������, �ð�ȿ���������� ��� ����
	
	/*
	 * Ļ�ŷ� A�� Ļ�ŷ� B�� ���� x1�� ��ġ�� x2�� ��ġ�� �ִ�.
	 * Ļ�ŷ� A�� �ѹ� �۶� v1�� �Ÿ��� �����̰� Ļ�ŷ� B�� v2�� �Ÿ��� �����δ�.
	 * Ļ�ŷ� A�� Ļ�ŷ� B�� �ѹ� �̻� �� �� ���� ���� ��ġ�� ������ ��찡 �ִ��� Ȯ���ؾ��Ѵ�.
	 * ���ÿ� ���� ��ġ�� �ִ� ��찡 ������ YES�� ��ȯ�ϰ�, ������ NO�� ��ȯ�϶�.
	 * 
	 * ����
	 * 0 3 4 2 => YES
	 * 0 2 5 3 => NO
	 * 
	 */
	public static String kangaroo_week7_4(int x1, int v1, int x2, int v2) {
        // Write your code here
        int big = 0;
        int shortD = 0;
        int small = 0;
        int longD = 0;
        if(x1>x2){
            big=x1;
            small=x2;
            longD=v1;
            shortD=v2;
        }else{
            big=x2;
            small=x1;
            longD=v2;
            shortD=v1;
        }
        while(true){
            big+=longD;
            small+=shortD;
            if(big==small){
                return "YES";
            }else if(big<small){ //���� ��ġ�� �ʰ� �Ÿ��� �۾Ҵ� ���� Ŀ���� ������ ���� ���� ������ ��ġ�� �ʴ´�.
                return "NO";
            }
        }
    }
}

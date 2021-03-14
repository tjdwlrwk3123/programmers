package programmers;

/*

//////////////////2016��//////////////////

2016�� 1�� 1���� �ݿ����Դϴ�. 2016�� a�� b���� ���� �����ϱ��? 
�� �� a ,b�� �Է¹޾� 2016�� a�� b���� ���� �������� �����ϴ� �Լ�, solution�� �ϼ��ϼ���. 
������ �̸��� �Ͽ��Ϻ��� ����ϱ��� ���� SUN,MON,TUE,WED,THU,FRI,SAT

�Դϴ�. ���� ��� a=5, b=24��� 5�� 24���� ȭ�����̹Ƿ� ���ڿ� "TUE"�� ��ȯ�ϼ���.

���� ����
2016���� �����Դϴ�.
2016�� a�� b���� ������ �ִ� ���Դϴ�. (13�� 26���̳� 2�� 45�ϰ��� ��¥�� �־����� �ʽ��ϴ�)
 */


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.lang.Exception;

class Day05 {
    public String solution(int a, int b) {
        String date="2016-"+a+"-"+b;
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date ndate=df.parse(date);
            Calendar cal=Calendar.getInstance();
            cal.setTime(ndate);
            int day=cal.get(Calendar.DAY_OF_WEEK);
            String answer = "";
            switch(day){
                case 1:answer="SUN"; break;
                case 2:answer="MON"; break;
                case 3:answer="TUE"; break;
                case 4:answer="WED"; break;
                case 5:answer="THU"; break;
                case 6:answer="FRI"; break;
                case 7:answer="SAT"; break;
            }
            return answer;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //�ٸ������ Ǯ��(���̺귯�� ����)
    public String getDayName(int a, int b)
    {
     String answer = " ";
        int[] monthDay={31,29,31,30,31,30,31,31,30,31,30,31};
        for (int i = 1; i < a; i++) {
            b+=monthDay[i-1];
        }
        switch(b%7){
        case 3:answer="SUN";break;
        case 4:answer="MON";break;
        case 5:answer="TUE";break;
        case 6:answer="WED";break;
        case 0:answer="THU";break;
        case 1:answer="FRI";break;
        case 2:answer="SAT";break;
        }



        return answer;
    }
}
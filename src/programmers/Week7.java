package programmers;

public class Week7 {
	/*
	 * 숫자로 된 시간 h와 분 m이 주어질때 이를 알파벳 시간으로 변환하여 출력하기
	 * 만약 00분일 경우는 o' clock으로,
	 * 15분일 경우 quarter past hour,
	 * 30분일 경우 half past hour,
	 * 45분일 경우  quarter to hour로 표기한다.
	 * 그 외에는 m<30일경우  (eleven minutes past five)와 같이 표시하고
	 * m>30일때는 그 다음시간의 이전인 (twenty six minutes to six)와 같이 표시하여 출력하여야 한다.
	 */
	public static String timeInWords_week7_1(int h, int m) {
        // Write your code here
        String hour="";
        String Minute="";
        int pORt = 0; //past인지 to인지 나중에 추가해주기 위한 변수 (0일경우는  past,to둘 다 아닐때)
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
        }else{ //30분 초과일때
            m=60-m;
            h++;
            pORt=2;
        }
        switch(m){ //past와 to 모두 그 앞은 같은 알파벳을 사용할 수 있다.
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
        if(m==0){ //o' clock일경우는 위치가 반대
            answer=hour+Minute;
        }else{
            answer=Minute+hour;
        }
        return answer;
    }
}

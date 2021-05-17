package programmers;

public class Week7 {
	public static void main(String[] args) {
		int aa=chocolateFeast_week7_2(12,4,4);
		System.out.println(aa);
	}
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
	/*
	 * 현재 가진 돈 n과 초콜릿의 가격 c가 주어진다.
	 * 또한 초콜릿을 감싸고 있는 초콜릿 봉지를 m개 가져다 줄 경우 초콜릿 한 개와 교환이 가능하다.
	 * 이 때 최대로 먹을 수 있는 초콜릿의 개수를 반환하여야 한다. 
	 * 
	 * 예시
	 * n=15,c=3,m=2일경우
	 * 초콜릿은 처음에 5개를 산 후, 봉지 4개를 줄 경우 초콜릿 2개를 더 먹을 수 있다.
	 * 또한 2개의 봉지로 다시 초콜릿 한개를 먹을 수 있고,
	 * 처음에 남은 봉지 한개와 방금 얻은 초콜릿 한개로 또 다시 초콜릿 한개를 얻을 수 있다.
	 * 5 + 2 + 1 + 1 = 9개를 최대로 먹을 수 있다.
	 */
	public static int chocolateFeast_week7_2(int n, int c, int m) {
        // Write your code here
        int eatC = n/c; //먹은 초콜릿 개수
        int wrap = n/c; //먹고 남은 초콜릿 봉지의 개수
        
        while(wrap>=m){
            eatC+=wrap/m; //봉지를 초콜릿으로 교환한만큼 더하기
            wrap=wrap%m+wrap/m; //남은 봉지 + 새로 교환한 초콜릿의 봉지
        }
        return eatC;
    }
}

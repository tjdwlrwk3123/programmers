package programmers;

import java.util.regex.Pattern;

public class Day12 {
	/*
	문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
	예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

	제한 사항
	s는 길이 1 이상, 길이 8 이하인 문자열입니다.
	입출력 예
	s	return
	"a234"	false
	"1234"	true
	
	 */
	public boolean solution(String s) {
        boolean answer = true;
        if(s.length()==4 || s.length()==6){
        	/*
        	 * ^	: 문자열의 시작
        	 * []	: 문자의 집합이나 범위
        	 * *	: 앞 문자가 없을수도 있고 무한정 많을수도 있음
        	 * $	: 문자열의 종료
        	 * {4}|{6} : 길이검사도 가능
        	 * {}	: 횟수 또는 범위를 나타냄
        	 * |	: 패턴 안에서 or연산을 수행
        	 */
            if(Pattern.matches("^[0-9]*$",s)){ //정규표현식
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

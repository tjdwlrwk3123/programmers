package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Day09 {
	/*
	/////////////////문자열 내 마음대로 정렬하기///////////////////
	
	문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
	예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.

	제한 조건
	strings는 길이 1 이상, 50이하인 배열입니다.
	strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
	strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
	모든 strings의 원소의 길이는 n보다 큽니다.
	인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
	입출력 예
	strings					n	return
	["sun", "bed", "car"]	1	["car", "bed", "sun"]
	["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
		
	 */
	public static String[] solution1(String[] strings, int n) {
        ArrayList<String> list=new ArrayList<String>();
        for(int i=0; i<strings.length;i++){
            String alp=strings[i].substring(n,n+1); //알파벳 n번째 인덱스값 가져오기
            list.add(alp+strings[i]); //해당 알파벳을 맨 앞에 붙여서 새 단어 만들기
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            String ans=list.get(i).substring(1); //0번째에 붙인 값은 빼야하기 때문에 인덱스 1부터
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
	////////////////////////////시저 암호/////////////////////////
	
	어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 
	예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 
	문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

	제한 조건
	공백은 아무리 밀어도 공백입니다.
	s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
	s의 길이는 8000이하입니다.
	n은 1 이상, 25이하인 자연수입니다.
	입출력 예
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
            if(alp==' '){ //공백은 아무리 밀어도 공백
                newInt=(int)alp;
            }else{ //공백이 아닐때
                newInt=(int)alp+n;
            }
            if(alp>='a' && alp<='z'){ //기존 알파벳이 a~z일때
                if(newInt>(int)'z'){ //숫자를 더한 새 알파벳이 z를 넘으면
                    newInt=(int)'a'+(newInt-(int)'z')-1; //다시 a로 와서 출발
                }
            }else if(alp>='A' && alp<='Z'){ //기존 알파벳이 A~Z일때
                if(newInt>(int)'Z'){
                    newInt=(int)'A'+(newInt-(int)'Z')-1;
                }
            }
            answer+=Character.toString((char)newInt);
        }
        return answer;
    }
}

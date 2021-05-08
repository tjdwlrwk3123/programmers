package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Week6 {
	/*
	어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

	예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
	
	문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
	number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
	
	제한 조건
	number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
	k는 1 이상 number의 자릿수 미만인 자연수입니다.
	입출력 예
	number			k	return
	"1924"			2	"94"
	"1231234"		3	"3234"
	"4177252841"	4	"775841"
	 */
	public static void main(String[] args) {
		/*
		 * String number="1231234"; String aa=day37(number,3); System.out.println(aa);
		 */
		String[] record= {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] aa=week6_3(record);
		System.out.println(aa);
		
	}
	static ArrayList<String> answerList=new ArrayList<>();
    public static String day37(String number, int k) {
        String[] list=number.split("");
        int n=number.length();
        int r=number.length()-k;
        boolean[] visited=new boolean[n];
        combination(list,visited,0,n,r);
        
        Collections.sort(answerList);
        
        return answerList.get(answerList.size()-1);
    }
    public static void combination(String[] list, boolean[] visited,int start, int n, int r){
    	if (r == 0) {
    		String l="";
    		for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    l+=list[i];
                }
            }
    		answerList.add(l);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(list, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    //풀긴 했으나 시간이 오래걸려서 비효율, 테스크케이스 실패.
    
    /*
	로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다. 하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다. 
	당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.
	알아볼 수 없는 번호를 0으로 표기하기로 하고, 민우가 구매한 로또 번호 6개가 44, 1, 0, 0, 31 25라고 가정해보겠습니다. 
	당첨 번호 6개가 31, 10, 45, 1, 6, 19라면, 당첨 가능한 최고 순위와 최저 순위의 한 예는 아래와 같습니다.
	
	당첨 번호	31	10	45	1	6	19	결과
	최고 순위 번호	31	0→10	44	1	0→6	25	4개 번호 일치, 3등
	최저 순위 번호	31	0→11	44	1	0→7	25	2개 번호 일치, 5등
	
	순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정됩니다.
	알아볼 수 없는 두 개의 번호를 각각 10, 6이라고 가정하면 3등에 당첨될 수 있습니다.
	3등을 만드는 다른 방법들도 존재합니다. 하지만, 2등 이상으로 만드는 것은 불가능합니다.
	알아볼 수 없는 두 개의 번호를 각각 11, 7이라고 가정하면 5등에 당첨될 수 있습니다.
	5등을 만드는 다른 방법들도 존재합니다. 하지만, 6등(낙첨)으로 만드는 것은 불가능합니다.
	
	민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다. 
	이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
     */
    public int[] week6_2(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(win_nums);
        Arrays.sort(lottos);
        int count=0;
        int plus=0;
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0){
                plus++;
                continue;
            }
            for(int j=0;j<win_nums.length;j++){
                if(win_nums[j]==lottos[i]){
                    count++;
                    break;
                }
            }
        }
        switch(count+plus){
            case 0 :
            case 1 : answer[0]=6; break;
            case 2 : answer[0]=5; break;
            case 3 : answer[0]=4; break;
            case 4 : answer[0]=3; break;
            case 5 : answer[0]=2; break;
            case 6 : answer[0]=1; break;
        }
        switch(count){
            case 0 :
            case 1 : answer[1]=6; break;
            case 2 : answer[1]=5; break;
            case 3 : answer[1]=4; break;
            case 4 : answer[1]=3; break;
            case 5 : answer[1]=2; break;
            case 6 : answer[1]=1; break;
        }
        return answer;
    }
    
    /*
     * 
	신입사원인 김크루는 카카오톡 오픈 채팅방을 개설한 사람을 위해, 다양한 사람들이 들어오고, 나가는 것을 지켜볼 수 있는 관리자창을 만들기로 했다. 
	채팅방에 누군가 들어오면 다음 메시지가 출력된다.

	"[닉네임]님이 들어왔습니다."
	
	채팅방에서 누군가 나가면 다음 메시지가 출력된다.
	
	"[닉네임]님이 나갔습니다."
	
	채팅방에서 닉네임을 변경하는 방법은 다음과 같이 두 가지이다.
	
	채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다.
	채팅방에서 닉네임을 변경한다.
	닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경된다.
	
	채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 
	모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.
	
	record					
	["Enter uid1234 Muzi", 
	"Enter uid4567 Prodo",
	"Leave uid1234",
	"Enter uid1234 Prodo",
	"Change uid4567 Ryan"]
							result
							["Prodo님이 들어왔습니다.", 
							"Ryan님이 들어왔습니다.", 
							"Prodo님이 나갔습니다.", 
							"Prodo님이 들어왔습니다."]
	
     */
    public static String[] week6_3(String[] record) {
    	//uid와 닉네임을 담는 해시맵 생성(해시맵은 키값중복이 불가하므로 닉네임이 바뀔때마다 값이 바뀌어서 들어감)
        HashMap<String,String> map=new HashMap<String,String>(); 
        //채팅창 목록을 담는 리스트 생성
        ArrayList<String> list=new ArrayList<String>();
        for(int i=0;i<record.length;i++){
            String[] rs=record[i].split(" ");
            try {
            	map.put(rs[1],rs[2]);
            }catch(ArrayIndexOutOfBoundsException ae) { //rs[2](닉네임)이 나타나지 않는경우(Leave일때)에러처리
            	continue;
            }
        }
        for(int i=0;i<record.length;i++){
            String[] rs=record[i].split(" ");
            if(rs[0].equals("Enter")){
                list.add(rs[1]+" E");
            }else if(rs[0].equals("Leave")){
                list.add(rs[1]+" L");
            }
        }
        String[] answer=new String[list.size()];
        for(int i=0;i<list.size();i++){
            String[] rs=list.get(i).split(" ");
            if(rs[1].equals("E")){
                answer[i]=map.get(rs[0])+"님이 들어왔습니다.";
            }else if(rs[1].equals("L")){
                answer[i]=map.get(rs[0])+"님이 나갔습니다.";
            }
        }
        return answer;
    }
    /*
	짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다. 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다. 
	그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다. 이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다.
	문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요. 
	성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.

	예를 들어, 문자열 S = baabaa 라면
	b aa baa → bb aa → aa →
	의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
     */
    public int week6_4(String s){
        int answer = pair(s);
        return answer;
    }
    public static int pair(String s){
        while(true){
            boolean isPair = false;
            if(s.length()==0){
                return 1;
            }
            for(int i=0;i<s.length()-1;i++){
                if(s.substring(i,i+1).equals(s.substring(i+1,i+2))){
                    s.replace(s.substring(i,i+1),"");
                    s.replace(s.substring(i+1,i+2),"");
                    isPair=true;
                }
            }
            if(!isPair){
                return 0;
            }
        }
    }
}

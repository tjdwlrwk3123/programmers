package programmers;

/*
///////////////////체육복(탐욕법)///////////////////

점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

제한사항
전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 
남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.

입출력 예
n	lost	reserve		return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]			4
3	[3]		[1]			2

 */
public class Day6 {
	public int solution1(int n, int[] lost, int[] reserve) {
        int firstLost=n-lost.length; //체육복을 가지고있는 사람의 수
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
            	//체육복을 잃어버린 사람이 여벌을 가지고 있는지 확인
                if(reserve[j]!=0 && lost[i]!=0 && reserve[j]==lost[i]){ 
                    reserve[j]=0;
                    lost[i]=0;
                    firstLost+=1;
                }
            }
        }
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
            	//체육복을 잃어버린 사람 앞,뒤 번호의 여벌확인
                if(reserve[j]!=0 && lost[i]!=0 && (reserve[j]-1==lost[i] || reserve[j]+1==lost[i])){
                    reserve[j]=0;
                    lost[i]=0;
                    firstLost+=1;
                }
            }
        }
        int answer = firstLost;
        return answer;
    }
/*

단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

제한사항
s는 길이가 1 이상, 100이하인 스트링입니다.

입출력 예
s		return
"abcde"	"c"
"qwer"	"we"
 */
	public String solution2(String s) {
        String answer = "";
        if(s.length()%2==0){
            int start=s.length()/2-1;
            answer=s.substring(start,start+2);
        }else{
            int start=s.length()/2;
            answer=s.substring(start,start+1);
        }
        return answer;
    }
}

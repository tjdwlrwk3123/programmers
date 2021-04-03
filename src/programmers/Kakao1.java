package programmers;

public class Kakao1 {
	/*
	 * 각 열의 합을 구한후 가장 많은 r개만큼 뽑은후 인덱스번호를 구함(각 열의 합 5,4,2 중 가장 많은 2개의 인덱스번호 0,1)
	 * 새로운 배열에 가장 많은 r개 인덱스 번호를 1로 주고 아닌곳을 0으로 줌(1,1,0)
	 * 만약 0인 배열인덱스일때(쓰지 않는 부품번호) needs에서 해당 인덱스번호의 부품이 1이 존재하면 그 로봇은 만들 수 없음
	 * 전체 로봇개수에서 못만드는 로봇 개수를 빼기
	 */
	public static int solution(int[][] needs, int r) {
        int answer = needs.length; //전체 로봇개수
        int[] wholeNeeds=new int[needs.length]; //새로운 배열
        for(int i=0;i<needs[0].length;i++){
            int plus=0;
            for(int j=0;j<needs.length;j++){
                plus+=needs[j][i]; //각 열의 합을 구해서 새로운 배열에 넣기
            }
            wholeNeeds[i]=plus;
        }
        int[] useBot=new int[needs[0].length]; //int배열의 초기값은 0
        while(r>0){
            int most=0;
            for(int i=0;i<wholeNeeds.length;i++){
                if(most<=wholeNeeds[i]){
                    most=wholeNeeds[i]; //가장 많이 쓴 부품을 구하기
                }
            }
            for(int i=0;i<wholeNeeds.length;i++){
                if(most==wholeNeeds[i]){
                    useBot[i]=1; //가장 많이 쓴 부품의 인덱스를 1로 주고
                    wholeNeeds[i]=0; //기존 배열에서는 삭제(0으로 줘서 다시 뽑히지 않게)
                    break;
                }
            }
            r--; //r이 0이 될때까지 계속(가장 많은 부품 r개 추출)
        }
        for(int i=0;i<useBot.length;i++){
            if(useBot[i]==0){ //만약 useBot의 인덱스번호가 0이면(r개에 해당하지 않는 부품들)
                for(int j=0;j<needs.length;j++){
                    if(needs[j][i]==1){ //needs의 해당 열에 부품을 쓰고있으면(만들지 못하는 로봇)
                        answer--; //총 로봇 개수에서 하나씩 빼기
                    }
                }
            }
        }
        return answer;
    }
	public static void main(String[] args) {
		int[][] needs= {{1, 0, 0},{1, 1, 0},{1, 1, 0},{1, 0, 1},{1, 1, 0},{0, 1, 1}};
		int r=2;
		int aa=solution(needs,r);
		System.out.println(aa+"개");
	}
}

package programmers;

import java.util.HashMap;
import java.util.Stack;

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
	
	public static void main(String[] args) { int[] gift_cards = {4, 5, 3, 2, 1};
	int[] wants = {2, 4, 4, 5, 1};
	
	int aa=howMany(gift_cards,wants); System.out.println(aa); }
	
	
	/*
	 * 
	문제 설명
	받을 수 있는 상품 번호가 적혀있는 상품권을 사람들이 각자 하나씩 가지고 있습니다. 
	사람들은 각자 받고 싶은 상품이 있는데, 자신이 가지고 있는 상품권의 번호가 자신이 받고 싶은 상품의 번호가 아니라면 다른 사람과 교환할 수 있습니다.
	이때, 원하지 않는 상품을 받는 사람 수를 최소로 해야 합니다.

	예를 들어 상품권을 가진 사람이 5명이고, 첫 번째 사람부터 가지고 있는 상품권에 적힌 번호가 [4, 5, 3, 2, 1],
	각 사람이 받고 싶어 하는 상품 번호가 순서대로 [2, 4, 4, 5, 1]라고 하겠습니다.

	이 경우 다섯 번째 사람은 가지고 있는 상품권에 적힌 번호(1번)가 받고 싶은 상품 번호(1번)와 일치하기 때문에 다른 사람과 교환하지 않아도 됩니다.

	또, 첫 번째, 두 번째, 네 번째 사람의 경우 아래와 같이 상품권을 교환하면 각자 받고 싶은 상품의 번호가 적힌 상품권을 가질 수 있습니다.

	첫 번째 사람과 네 번째 사람의 번호를 교환합니다. (4번 ↔ 2번)
	다시, 두 번째 사람과 네 번째 사람의 번호를 교환합니다. (5번 ↔ 4번)
	이제 각 사람이 가지고 있는 상품권에 적힌 번호는 아래와 같습니다.

	[2, 4, 3, 5, 1]
	세 번째 사람은 4번 상품을 받고 싶지만, 더 교환할 사람이 없습니다. 따라서 원하는 상품을 받을 수 없는 사람은 최소 1명이 됩니다.

	사람들이 가지고 있는 상품권에 적힌 번호가 순서대로 들어있는 배열 gift_cards와 각 사람이 받고 싶어 하는 상품 번호가 순서대로 들어있는 배열 wants가 매개변수로 주어질 때,
	원하는 상품을 받지 못하는 사람의 최솟값을 return 하도록 solution 함수를 완성해주세요.

	제한 사항
	gift_cards와 wants의 길이는 1 이상 100,000 이하이며, 두 배열의 길이는 항상 같습니다.
	gift_cards와 wants의 원소는 1 이상 100,000 이하인 자연수입니다.
	모든 상품은 여분없이 각 번호가 적힌 상품권 개수만큼 준비되어 있다고 가정합니다.
	입출력 예
	gift_cards		wants			result
	[4, 5, 3, 2, 1]	[2, 4, 4, 5, 1]	1
	[5, 4, 5, 4, 5]	[1, 2, 3, 5, 4]	3
	입출력 예 설명
	입출력 예 #1
	문제의 설명과 같습니다.

	입출력 예 #2
	네 번째, 다섯 번째 사람만 교환을 통해 자신이 원하는 상품을 받을 수 있으며, 나머지 세 명은 원하는 상품을 받을 수 없습니다.
	 */
	
	public static int howMany(int[] gift_cards, int[] wants	) {
		int answer=gift_cards.length;
		
		for(int i=0;i<gift_cards.length;i++) {
			if(gift_cards[i]!=wants[i]) {
				for(int j=i+1;j<wants.length;j++) {
					if(gift_cards[j]==wants[i]) {
						int temp=gift_cards[i];
						gift_cards[i]=gift_cards[j];
						gift_cards[j]=temp;
					}
				}
			}
		}
		for	(int i=0; i<gift_cards.length; i++ ) {
			if(gift_cards[i]==wants[i]) {
				answer--;
			}
		}
		return answer;
	}
}

package programmers;

/*
정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는
두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
입출력 예 #1

2 = 1 + 1 입니다. (1이 numbers에 두 개 있습니다.)
3 = 2 + 1 입니다.
4 = 1 + 3 입니다.
5 = 1 + 4 = 2 + 3 입니다.
6 = 2 + 4 입니다.
7 = 3 + 4 입니다.
따라서 [2,3,4,5,6,7] 을 return 해야 합니다.
입출력 예 #2

2 = 0 + 2 입니다.
5 = 5 + 0 입니다.
7 = 0 + 7 = 5 + 2 입니다.
9 = 2 + 7 입니다.
12 = 5 + 7 입니다.
따라서 [2,5,7,9,12] 를 return 해야 합니다.
 */
import java.util.ArrayList;

class Day1 {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        int count=0;
        for(int i=0;i<numbers.length-1;i++){
            if(i!=0){
                if(numbers[i]==numbers[i-1]){
                    continue;
                }    
            }
            for(int j=i+1;j<numbers.length;j++){
                boolean tf=true;
                int ck=numbers[i]+numbers[j];
                if(count!=0){
                    for(int k=0;k<=count-1;k++){
                        if(ck==arr.get(k)){
                            tf=false;
                            break;
                        }
                    }
                }
                if(tf){
                    arr.add(ck);
                    count++;
                }
            }
        }
        int cnt=arr.size();
        int[] answer=new int[cnt];
        count=0;
        for(int i=0;i<numbers.length-1;i++){
            if(i!=0){
                if(numbers[i]==numbers[i-1]){
                    continue;
                }    
            }
            for(int j=i+1;j<numbers.length;j++){
                boolean tf=true;
                int ck=numbers[i]+numbers[j];
                if(count!=0){
                    for(int k=0;k<=count-1;k++){
                        if(ck==answer[k]){
                            tf=false;
                            break;
                        }
                    }
                }
                if(tf){
                    answer[count]=ck;
                    count++;
                }
            }
        }
        int temp=0;
        for(int i=0;i<answer.length;i++){
            for(int j=0;j<answer.length-i-1;j++){
                if(answer[j]>answer[j+1]){
                    temp=answer[j];
                    answer[j]=answer[j+1];
                    answer[j+1]=temp;
                }
            }
        }
        for(int i=0;i<answer.length-1;i++){
            if(answer[i]==answer[i+1]){
                for(int j=0;j<answer.length-1;j++){
                    answer[j]=answer[j+1];
                }
            }
        }
        return answer;
    }
}
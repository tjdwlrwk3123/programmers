package programmers;

/*
���� �迭 numbers�� �־����ϴ�. numbers���� ���� �ٸ� �ε����� �ִ�
�� ���� ���� �̾� ���ؼ� ���� �� �ִ� ��� ���� �迭�� ������������ ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
����� �� #1

2 = 1 + 1 �Դϴ�. (1�� numbers�� �� �� �ֽ��ϴ�.)
3 = 2 + 1 �Դϴ�.
4 = 1 + 3 �Դϴ�.
5 = 1 + 4 = 2 + 3 �Դϴ�.
6 = 2 + 4 �Դϴ�.
7 = 3 + 4 �Դϴ�.
���� [2,3,4,5,6,7] �� return �ؾ� �մϴ�.
����� �� #2

2 = 0 + 2 �Դϴ�.
5 = 5 + 0 �Դϴ�.
7 = 0 + 7 = 5 + 2 �Դϴ�.
9 = 2 + 7 �Դϴ�.
12 = 5 + 7 �Դϴ�.
���� [2,5,7,9,12] �� return �ؾ� �մϴ�.
 */
import java.util.ArrayList;

class Day01 {
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
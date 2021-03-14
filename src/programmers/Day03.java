package programmers;

/*
�����ڴ� ������ ������ ����� �ظ��Դϴ�. ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. �����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.

1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, ���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
������ �ִ� 10,000 ������ �����Ǿ��ֽ��ϴ�.
������ ������ 1, 2, 3, 4, 5�� �ϳ��Դϴ�.
���� ���� ������ ���� ����� ������ ���, return�ϴ� ���� �������� �������ּ���.
����� ��
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
����� �� ����
����� �� #1

������ 1�� ��� ������ �������ϴ�.
������ 2�� ��� ������ Ʋ�Ƚ��ϴ�.
������ 3�� ��� ������ Ʋ�Ƚ��ϴ�.
���� ���� ������ ���� ���� ����� ������ 1�Դϴ�.

����� �� #2

��� ����� 2�������� ������ϴ�.
 */



class Day03 {
    public int[] solution(int[] answers) {
        int[] asolv={1,2,3,4,5};
        int[] bsolv={2,1,2,3,2,4,2,5};
        int[] csolv={3,3,1,1,2,2,4,4,5,5};
        int aans=0;
        int bans=0;
        int cans=0;
        for(int i=0;i<answers.length;i++){
            if(answers[i]==asolv[i%5]){
                aans++;
            }
            if(answers[i]==bsolv[i%8]){
                bans++;
            }
            if(answers[i]==csolv[i%10]){
                cans++;
            }
        }
        if(aans>bans && aans>cans){
            int[] answer={1};
            return answer;
        }else if(bans>aans && bans>cans){
            int[] answer={2};
            return answer;
        }else if(cans>aans && cans>bans){
            int[] answer={3};
            return answer;
        }else if(aans==bans && aans>cans){
            int[] answer={1,2};
            return answer;
        }else if(aans==cans && aans>bans){
            int[] answer={1,3};
            return answer;
        }else if(bans==cans && bans>aans){
            int[] answer={2,3};
            return answer;
        }else{
            int[] answer={1,2,3};
            return answer;
        }
    }
}
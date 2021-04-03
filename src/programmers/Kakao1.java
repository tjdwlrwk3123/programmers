package programmers;

public class Kakao1 {
	/*
	 * �� ���� ���� ������ ���� ���� r����ŭ ������ �ε�����ȣ�� ����(�� ���� �� 5,4,2 �� ���� ���� 2���� �ε�����ȣ 0,1)
	 * ���ο� �迭�� ���� ���� r�� �ε��� ��ȣ�� 1�� �ְ� �ƴѰ��� 0���� ��(1,1,0)
	 * ���� 0�� �迭�ε����϶�(���� �ʴ� ��ǰ��ȣ) needs���� �ش� �ε�����ȣ�� ��ǰ�� 1�� �����ϸ� �� �κ��� ���� �� ����
	 * ��ü �κ��������� ������� �κ� ������ ����
	 */
	public static int solution(int[][] needs, int r) {
        int answer = needs.length; //��ü �κ�����
        int[] wholeNeeds=new int[needs.length]; //���ο� �迭
        for(int i=0;i<needs[0].length;i++){
            int plus=0;
            for(int j=0;j<needs.length;j++){
                plus+=needs[j][i]; //�� ���� ���� ���ؼ� ���ο� �迭�� �ֱ�
            }
            wholeNeeds[i]=plus;
        }
        int[] useBot=new int[needs[0].length]; //int�迭�� �ʱⰪ�� 0
        while(r>0){
            int most=0;
            for(int i=0;i<wholeNeeds.length;i++){
                if(most<=wholeNeeds[i]){
                    most=wholeNeeds[i]; //���� ���� �� ��ǰ�� ���ϱ�
                }
            }
            for(int i=0;i<wholeNeeds.length;i++){
                if(most==wholeNeeds[i]){
                    useBot[i]=1; //���� ���� �� ��ǰ�� �ε����� 1�� �ְ�
                    wholeNeeds[i]=0; //���� �迭������ ����(0���� �༭ �ٽ� ������ �ʰ�)
                    break;
                }
            }
            r--; //r�� 0�� �ɶ����� ���(���� ���� ��ǰ r�� ����)
        }
        for(int i=0;i<useBot.length;i++){
            if(useBot[i]==0){ //���� useBot�� �ε�����ȣ�� 0�̸�(r���� �ش����� �ʴ� ��ǰ��)
                for(int j=0;j<needs.length;j++){
                    if(needs[j][i]==1){ //needs�� �ش� ���� ��ǰ�� ����������(������ ���ϴ� �κ�)
                        answer--; //�� �κ� �������� �ϳ��� ����
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
		System.out.println(aa+"��");
	}
}

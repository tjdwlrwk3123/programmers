package programmers;

public class Day13 {
	/*
	���α׷��ӽ� ������� �������� ��ȣ�� ���� �������� ���� �� ������ ��ȭ��ȣ�� �Ϻθ� �����ϴ�.
	��ȭ��ȣ�� ���ڿ� phone_number�� �־����� ��, ��ȭ��ȣ�� �� 4�ڸ��� ������ ������ ���ڸ� ���� *���� ���� ���ڿ��� �����ϴ� �Լ�, 
	solution�� �ϼ����ּ���.
	
	���� ����
	s�� ���� 4 �̻�, 20������ ���ڿ��Դϴ�.
	����� ��
	phone_number	return
	"01033334444"	"*******4444"
	"027778888"		"*****8888"
	 */
	public String solution1(String phone_number) {
        String answer="";
        for(int i=0;i<phone_number.length()-4;i++){
            answer+="*";
        }
        answer+=phone_number.substring(phone_number.length()-4);
        return answer;
    }
	/*
	�־��� ���� �� 3���� ���� ������ �� �Ҽ��� �Ǵ� ����� ������ ���Ϸ��� �մϴ�. 
	���ڵ��� ����ִ� �迭 nums�� �Ű������� �־��� ��, 
	nums�� �ִ� ���ڵ� �� ���� �ٸ� 3���� ��� ������ �� �Ҽ��� �Ǵ� ����� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.

	���ѻ���
	nums�� ����ִ� ������ ������ 3�� �̻� 50�� �����Դϴ�.
	nums�� �� ���Ҵ� 1 �̻� 1,000 ������ �ڿ����̸�, �ߺ��� ���ڰ� ������� �ʽ��ϴ�.
	����� ��
	nums	result
	[1,2,3,4]	1
	[1,2,7,6,4]	4
	 */
	public int solution2(int[] nums) {
        int answer = 0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int number=nums[i]+nums[j]+nums[k];
                    boolean isPrime=true;
                    for(int l=2;l<=Math.sqrt(number);l++){ //2���� ��Ʈnumber������ �������� �Ҽ� �Ǻ��� �����ϴ�
                        if(number%l==0){
                            isPrime=false;
                            break;
                        }
                    }
                    if(isPrime){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
	/*
	 * �����佺�׳׽��� ä
	 * ��� �ڿ����� �Ҽ����� ������ ǥ���� �ȴ�
	 * 2���� N-1������ �� �߿��� 2�� ����� ä�� �Ÿ��� 3�� ����� �Ÿ��� ... ��ƮN�� ������� �ɷ����� ����
	 * ��� ������ �Ҽ��� �ȴ�.
	 * 
	 */
}

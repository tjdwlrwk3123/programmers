package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Week4 {
	/*
	���� n�� �Է¹޾� n�� ����� ��� ���� ���� �����ϴ� �Լ�, solution�� �ϼ����ּ���.

	���� ����
	n�� 0 �̻� 3000������ �����Դϴ�.
	����� ��
	n	return
	12	28
	5	6
	 */
	public int day23_1(int n) {
        int answer = 1;
        for(int i=2;i<=n;i++){
            if(n%i==0){
                answer+=i;
            }
        }
        if(n==0){
            return 0;
        }else{
            return answer;
        }
    }
	/*
	�ִ������� �ּҰ����
	
	�� ���� �Է¹޾� �� ���� �ִ������� �ּҰ������ ��ȯ�ϴ� �Լ�, solution�� �ϼ��� ������. 
	�迭�� �� �տ� �ִ�����, �״��� �ּҰ������ �־� ��ȯ�ϸ� �˴ϴ�. 
	���� ��� �� �� 3, 12�� �ִ������� 3, �ּҰ������ 12�̹Ƿ� solution(3, 12)�� [3, 12]�� ��ȯ�ؾ� �մϴ�.

	���� ����
	�� ���� 1�̻� 1000000������ �ڿ����Դϴ�.
	����� ��
	n	m	return
	3	12	[3, 12]
	2	5	[1, 10]
	 */
	public int[] day23_2(int n, int m) {
        int[] answer = new int[2];
        for(int i=1;i<=n && i<=m;i++){ //�ִ����� ���ϱ�
            if(n%i==0 && m%i==0){
                answer[0]=i;
            }
        }
        answer[1]=n*m/answer[0]; //�ּҰ���� ���ϱ�(�� ���� ���� �ִ������� ������)
        return answer;
    }
	/*
	///////////////////////�Ҽ� ã��//////////////////
	
	1���� �Է¹��� ���� n ���̿� �ִ� �Ҽ��� ������ ��ȯ�ϴ� �Լ�, solution�� ����� ������.

	�Ҽ��� 1�� �ڱ� �ڽ����θ� ���������� ���� �ǹ��մϴ�.
	(1�� �Ҽ��� �ƴմϴ�.)
	
	���� ����
	n�� 2�̻� 1000000������ �ڿ����Դϴ�.
	
	����� ��
	n	result
	10	4
	5	3
	 */
	public int day24_1(int n) {
        int answer = 0;
        
        for(int j=2;j<=n;j++){
            boolean isPrime=true;
            int num=j;
            for(int i=2;i<=Math.sqrt(num);i++){ //num�� 2�ų� 3�ΰ��� for���� ���� �ʰ� �������� �Ѵ� �Ҽ��̱� ������ ������.
                if(num%i==0){ //��Ʈ num���� ���� ���� ������ �������� ���� �ϳ��� ������ �Ҽ��� �ƴϴ�.
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                answer++;
            }
        }
        return answer;
    }
	/*
	 * 
	���ڿ� s�� ��Ÿ���� ���ڸ� ū�ͺ��� ���� ������ ������ ���ο� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
	s�� ���� ��ҹ��ڷθ� �����Ǿ� ������, �빮�ڴ� �ҹ��ں��� ���� ������ �����մϴ�.
	
	���� ����
	str�� ���� 1 �̻��� ���ڿ��Դϴ�.
	����� ��
	s			return
	"Zbcdefg"	"gfedcbZ"
	
	 */
	public String day24_2(String s) {
        String answer ="";
        
        char[] letters=s.toCharArray();
        Arrays.sort(letters); //char�迭�� Arrays.sort�� �� �� �ִ�.
        
        StringBuilder sb=new StringBuilder();
        sb.append(letters); //������ char�迭�� ���� �� �ִ�.
        answer=sb.reverse().toString();
        
        return answer;
    }
	/*
	����� ���ϸ��� ��� ���� ���� ���� ����, ȫ �ڻ���� �����ǿ� �����߽��ϴ�. 
	ȫ �ڻ���� ��ſ��� �ڽ��� �����ǿ� �ִ� �� N ������ ���ϸ� �߿��� N/2������ �������� ���ٰ� �߽��ϴ�.
	ȫ �ڻ�� �������� ���ϸ��� ������ ���� ��ȣ�� �ٿ� �����մϴ�. ���� ���� ������ ���ϸ��� ���� ��ȣ�� ������ �ֽ��ϴ�. 
	���� ��� �����ǿ� �� 4������ ���ϸ��� �ְ�, 
	�� ���ϸ��� ���� ��ȣ�� [3��, 1��, 2��, 3��]�̶�� �̴� 3�� ���ϸ� �� ����, 1�� ���ϸ� �� ����, 2�� ���ϸ� �� ������ ������ ��Ÿ���ϴ�. 
	�̶�, 4������ ���ϸ� �� 2������ ������ ����� ������ ���� 6������ �ֽ��ϴ�.
	
	����� �ִ��� �پ��� ������ ���ϸ��� ������ ���ϱ� ������, �ִ��� ���� ������ ���ϸ��� �����ؼ� N/2������ �����Ϸ� �մϴ�. 
	N���� ���ϸ��� ���� ��ȣ�� ��� �迭 nums�� �Ű������� �־��� ��, 
	N/2������ ���ϸ��� �����ϴ� ��� ��, ���� ���� ������ ���ϸ��� �����ϴ� ����� ã��, 
	�׶��� ���ϸ� ���� ��ȣ�� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.

	���ѻ���
	nums�� ���ϸ��� ���� ��ȣ�� ��� 1���� �迭�Դϴ�.
	nums�� ����(N)�� 1 �̻� 10,000 ������ �ڿ����̸�, �׻� ¦���� �־����ϴ�.
	���ϸ��� ���� ��ȣ�� 1 �̻� 200,000 ������ �ڿ����� ��Ÿ���ϴ�.
	���� ���� ������ ���ϸ��� �����ϴ� ����� ���� ������ ��쿡��, ������ �� �ִ� ���ϸ� ���� ������ �ִ� �ϳ��� return �ϸ� �˴ϴ�.
	����� ��
	nums			result
	[3,1,2,3]		2
	[3,3,3,2,2,4]	3
	[3,3,3,2,2,2]	2
	
	
	****�ٸ������ Ǯ�� : �ؽ��¿� ������ �ߺ��� ���ŵǱ� ������ �� �� ����� ���Ͽ� ����****
	
	 */
	public int day25(int[] nums) {
        int answer = 0;
        if(nums.length==2){ //2������ ���� ������ 1������ �������� ��.
            return 1;
        }
        Arrays.sort(nums);
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(nums[0]);
        int s=0;
        for(int i=1;i<nums.length;i++){
            if(list.get(s)==nums[i]){
                continue;
            }else{
                list.add(nums[i]);
                s++;
            }
            if(list.size()==nums.length/2){
                break;
            }
        }
        answer=list.size();
        return answer;
    }
	/*
	 * 
	��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
	��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.
	
	������ : 119
	���ؿ� : 97 674 223
	������ : 11 9552 4421
	��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution �Լ��� �Ű������� �־��� ��, 
	� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���� ����
	phone_book�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
	�� ��ȭ��ȣ�� ���̴� 1 �̻� 20 �����Դϴ�.
	���� ��ȭ��ȣ�� �ߺ��ؼ� ������� �ʽ��ϴ�.
	����� ����
	phone_book							return
	["119", "97674223", "1195524421"]	false
	["123","456","789"]					true
	["12","123","1235","567","88"]		false
	 */
	public boolean day26(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        A:for(int i=0;i<phone_book.length;i++){
            for(int j=i+1;j<phone_book.length;j++){
                if(phone_book[j].startsWith(phone_book[i])){
                    answer=false;
                    break A;
                }
            }
        }
        return answer;
    }//��Ȯ�� �׽�Ʈ�� ���, ȿ�����׽�Ʈ�� 4���� 2�� ����(�ؽø��� ����ϳ�?)
}
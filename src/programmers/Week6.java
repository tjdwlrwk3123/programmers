package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Week6 {
	/*
	� ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���ڸ� ���Ϸ� �մϴ�.

	���� ���, ���� 1924���� �� �� ���� �����ϸ� [19, 12, 14, 92, 94, 24] �� ���� �� �ֽ��ϴ�. �� �� ���� ū ���ڴ� 94 �Դϴ�.
	
	���ڿ� �������� ���� number�� ������ ���� ���� k�� solution �Լ��� �Ű������� �־����ϴ�. 
	number���� k ���� ���� �������� �� ���� �� �ִ� �� �� ���� ū ���ڸ� ���ڿ� ���·� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
	
	���� ����
	number�� 1�ڸ� �̻�, 1,000,000�ڸ� ������ �����Դϴ�.
	k�� 1 �̻� number�� �ڸ��� �̸��� �ڿ����Դϴ�.
	����� ��
	number			k	return
	"1924"			2	"94"
	"1231234"		3	"3234"
	"4177252841"	4	"775841"
	 */
	public static void main(String[] args) {
		/*
		 * String number="1231234"; String aa=day37(number,3); System.out.println(aa);
		 */
		/*
		 * String[] record= {"Enter uid1234 Muzi",
		 * "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo"
		 * ,"Change uid4567 Ryan"}; String[] aa=week6_3(record); System.out.println(aa);
		 */
		int aa=week6_4("baabaa");
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
    //Ǯ�� ������ �ð��� �����ɷ��� ��ȿ��, �׽�ũ���̽� ����.
    
    /*
	�ζǸ� ������ �ο�� ��÷ ��ȣ ��ǥ���� �м�����ϰ� �־����ϴ�. ������, �ο��� ������ �ζǿ� ������ �Ͽ�, �Ϻ� ��ȣ�� �˾ƺ� �� ���� �Ǿ����ϴ�. 
	��÷ ��ȣ ��ǥ ��, �ο�� �ڽ��� �����ߴ� �ζǷ� ��÷�� �����ߴ� �ְ� ������ ���� ������ �˾ƺ��� �;� �����ϴ�.
	�˾ƺ� �� ���� ��ȣ�� 0���� ǥ���ϱ�� �ϰ�, �ο찡 ������ �ζ� ��ȣ 6���� 44, 1, 0, 0, 31 25��� �����غ��ڽ��ϴ�. 
	��÷ ��ȣ 6���� 31, 10, 45, 1, 6, 19���, ��÷ ������ �ְ� ������ ���� ������ �� ���� �Ʒ��� �����ϴ�.
	
	��÷ ��ȣ	31	10	45	1	6	19	���
	�ְ� ���� ��ȣ	31	0��10	44	1	0��6	25	4�� ��ȣ ��ġ, 3��
	���� ���� ��ȣ	31	0��11	44	1	0��7	25	2�� ��ȣ ��ġ, 5��
	
	������ �������, ������ �ζǿ� ��÷ ��ȣ�� ��ġ�ϴ� ��ȣ�� ������ ���� �ɷ� �����˴ϴ�.
	�˾ƺ� �� ���� �� ���� ��ȣ�� ���� 10, 6�̶�� �����ϸ� 3� ��÷�� �� �ֽ��ϴ�.
	3���� ����� �ٸ� ����鵵 �����մϴ�. ������, 2�� �̻����� ����� ���� �Ұ����մϴ�.
	�˾ƺ� �� ���� �� ���� ��ȣ�� ���� 11, 7�̶�� �����ϸ� 5� ��÷�� �� �ֽ��ϴ�.
	5���� ����� �ٸ� ����鵵 �����մϴ�. ������, 6��(��÷)���� ����� ���� �Ұ����մϴ�.
	
	�ο찡 ������ �ζ� ��ȣ�� ���� �迭 lottos, ��÷ ��ȣ�� ���� �迭 win_nums�� �Ű������� �־����ϴ�. 
	�̶�, ��÷ ������ �ְ� ������ ���� ������ ���ʴ�� �迭�� ��Ƽ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
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
	���Ի���� ��ũ��� īī���� ���� ä�ù��� ������ ����� ����, �پ��� ������� ������, ������ ���� ���Ѻ� �� �ִ� ������â�� ������ �ߴ�. 
	ä�ù濡 ������ ������ ���� �޽����� ��µȴ�.

	"[�г���]���� ���Խ��ϴ�."
	
	ä�ù濡�� ������ ������ ���� �޽����� ��µȴ�.
	
	"[�г���]���� �������ϴ�."
	
	ä�ù濡�� �г����� �����ϴ� ����� ������ ���� �� �����̴�.
	
	ä�ù��� ���� ��, ���ο� �г������� �ٽ� ����.
	ä�ù濡�� �г����� �����Ѵ�.
	�г����� ������ ���� ������ ä�ù濡 ��µǾ� �ִ� �޽����� �г��ӵ� ���� ����ȴ�.
	
	ä�ù濡 ������ �����ų�, �г����� ������ ����� ��� ���ڿ� �迭 record�� �Ű������� �־��� ��, 
	��� ����� ó���� ��, ���������� ���� ������ ����� ���� �Ǵ� �޽����� ���ڿ� �迭 ���·� return �ϵ��� solution �Լ��� �ϼ��϶�.
	
	record					
	["Enter uid1234 Muzi", 
	"Enter uid4567 Prodo",
	"Leave uid1234",
	"Enter uid1234 Prodo",
	"Change uid4567 Ryan"]
							result
							["Prodo���� ���Խ��ϴ�.", 
							"Ryan���� ���Խ��ϴ�.", 
							"Prodo���� �������ϴ�.", 
							"Prodo���� ���Խ��ϴ�."]
	
     */
    public static String[] week6_3(String[] record) {
    	//uid�� �г����� ��� �ؽø� ����(�ؽø��� Ű���ߺ��� �Ұ��ϹǷ� �г����� �ٲ𶧸��� ���� �ٲ� ��)
        HashMap<String,String> map=new HashMap<String,String>(); 
        //ä��â ����� ��� ����Ʈ ����
        ArrayList<String> list=new ArrayList<String>();
        for(int i=0;i<record.length;i++){
            String[] rs=record[i].split(" ");
            try {
            	map.put(rs[1],rs[2]);
            }catch(ArrayIndexOutOfBoundsException ae) { //rs[2](�г���)�� ��Ÿ���� �ʴ°��(Leave�϶�)����ó��
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
                answer[i]=map.get(rs[0])+"���� ���Խ��ϴ�.";
            }else if(rs[1].equals("L")){
                answer[i]=map.get(rs[0])+"���� �������ϴ�.";
            }
        }
        return answer;
    }
    /*
	¦���� �����ϱ��, ���ĺ� �ҹ��ڷ� �̷���� ���ڿ��� ������ �����մϴ�. ���� ���ڿ����� ���� ���ĺ��� 2�� �پ� �ִ� ¦�� ã���ϴ�. 
	�״���, �� ���� ������ ��, �յڷ� ���ڿ��� �̾� ���Դϴ�. �� ������ �ݺ��ؼ� ���ڿ��� ��� �����Ѵٸ� ¦���� �����ϱⰡ ����˴ϴ�.
	���ڿ� S�� �־����� ��, ¦���� �����ϱ⸦ ���������� ������ �� �ִ��� ��ȯ�ϴ� �Լ��� �ϼ��� �ּ���. 
	���������� ������ �� ������ 1��, �ƴ� ��� 0�� �������ָ� �˴ϴ�.

	���� ���, ���ڿ� S = baabaa ���
	b aa baa �� bb aa �� aa ��
	�� ������ ���ڿ��� ��� ������ �� �����Ƿ� 1�� ��ȯ�մϴ�.
     */
    public static int week6_4(String s){
    	StringBuffer str=new StringBuffer(s);
        while(true){
            boolean isPair = false;
            System.out.println(str);
            if(str.length()==0){
                return 1;
            }
            for(int i=0;i<str.length()-1;i++){
                if(str.substring(i,i+1).equals(str.substring(i+1,i+2))){
                    str.delete(i,i+1);
                    str.delete(i,i+1);
                    isPair=true;
                    break;
                }
            }
            if(!isPair){
                return 0;
            }
        }
    }
    //ȿ���� �׽�Ʈ ����...
    
    
    /*
	���� ���̰� Wcm, ���� ���̰� Hcm�� ���簢�� ���̰� �ֽ��ϴ�. 
	���̿��� ����, ���� ����� �����ϰ� ���� ���·� ���� �׾��� ������, ��� ����ĭ�� 1cm x 1cm ũ���Դϴ�. 
	�� ���̸� ���� ���� ���� 1cm �� 1cm�� ���簢������ �߶� ����� �����̾��µ�, �������� �� ���̸� �밢�� ������ 2���� �մ� �������� �߶� ���ҽ��ϴ�. 
	�׷��Ƿ� ���� ���簢�� ���̴� ũ�Ⱑ ���� �����ﰢ�� 2���� �������� �����Դϴ�. 
	���ο� ���̸� ���� �� ���� �����̱� ������, �� ���̿��� ���� ������ ����, ���� ����� �����ϰ� 1cm �� 1cm�� �߶� ����� �� �ִ� ��ŭ�� ����ϱ�� �Ͽ����ϴ�.
	������ ���� W�� ������ ���� H�� �־��� ��, ����� �� �ִ� ���簢���� ������ ���ϴ� solution �Լ��� �ϼ��� �ּ���.

	���ѻ���
	W, H : 1�� ������ �ڿ���
	
	����� ��
	W	H	result
	8	12	80
     */
    public long week6_5(int w, int h) {
        long wei=(long)w;
        long hei=(long)h;
        long answer = 1;
        long gcd=0;
        for(int i=1; i<=wei && i<=hei ; i++){ //�ִ����� ���ϱ�
            if(wei%i==0 && hei%i==0){
                gcd=i;
            }
        }
        answer=wei*hei-(wei+hei-gcd);
        //���� �簢���� ���� = ���� + ���� - (���� ������ �ִ�����)
        /*
         * ���ο� ������ �ִ������� ���� ���μ� w' h'�� ������
         * �밢���� ��ġ�� ���簢���� ���� w'-1�� h'-1�϶����� �߰��ȴ�.
         * ù ���簢������ ���ļ� 1+w'-1+h'-1 = w'+h'-1�� �ȴ�.
         * ���⿡ ó�� �ִ������� �ٽ� ���ϸ� => w + h - gcd(w,h)�� �ȴ�.
         */
        return answer;
    }
}

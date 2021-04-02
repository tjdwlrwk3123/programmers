package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Week5 {
	/*
	일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 
	이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

	1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
	2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
	3. 그렇지 않으면 J를 인쇄합니다.
	예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
	
	내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
	
	현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 
	내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 
	내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
	
	제한사항
	현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
	인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
	location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
	입출력 예
	priorities				location		return
	[2, 1, 3, 2]				2			1
	[1, 1, 9, 1, 1, 1]			0			5
	 */
	public int day27(int[] priorities, int location) {
        int answer = 0;
        Queue<Printer> queue=new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            queue.offer(new Printer(i,priorities[i])); //큐에 Printer라는 클래스를 추가
        }
        while(!queue.isEmpty()){ //큐가 빌때까지 반복
            boolean isBig=true;
            int num=queue.peek().prior; //peek:참조
            for(Printer p:queue){
                if(num<p.prior){ //더 큰 숫자가 있는경우
                    isBig=false;
                }
            }
            if(!isBig){
                queue.offer(queue.poll()); //더 큰 숫자가 있으면 큐에 맨 앞을 맨 뒤로 보내기
            }else{
                if (queue.poll().location == location) { //poll:꺼내기 , 꺼내면서 location과 같은 위치인지 확인
					answer = priorities.length - queue.size(); //맞으면 해당 위치를 찾기 위해 배열의 길이에서 큐의 길이만큼 빼기
				}
            }
        }
        return answer;
    }
	class Printer{ //큐에 넣을 값 생성 (해시맵이 아니어도 됨. 클래스 생성 가능)
	    int location;
	    int prior;
	    Printer(int location,int prior){
	        this.location=location;
	        this.prior=prior;
	    }
	}
	/*
	 * 
	///////////Queue문제 -> 기능개발//////////////
	프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

	또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 
	이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
	
	먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 
	각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
	
	제한 사항
	작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
	작업 진도는 100 미만의 자연수입니다.
	작업 속도는 100 이하의 자연수입니다.
	배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
	입출력 예
	progresses					speeds				return
	[93, 30, 55]				[1, 30, 5]			[2, 1]
	[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
	 */
	public int[] day28(int[] progresses, int[] speeds) {
        Queue<Progress> queue=new LinkedList<>();
        ArrayList<Integer> finishList=new ArrayList<>();
        for(int i=0;i<progresses.length;i++){
            queue.add(new Progress(progresses[i],speeds[i])); //큐에 모든 작업들을 추가
        }
        int day=0;
        while(!queue.isEmpty()){
            int p= queue.peek().progress;
            int s= queue.peek().speed;
            int finished=0; //배열에 들어갈 완료 목록들
            p+=s*day; //2번째루프 이후부터는 지나간 일수만큼 작업량을 더해줘야함
            while(p<100){ //100보다 작을때까지 반복(100과 같아도 바로 폴)
                p+=s;
                day++;
            }
            queue.poll();
            finished++;
            while(!queue.isEmpty()){ //그 다음작업이 끝났는지 루프를 돌면서 확인(만약 큐가 끝나면 탈출)
                int p2=queue.peek().progress;
                int s2=queue.peek().speed;
                p2+=s2*day;
                if(p2>=100){
                    queue.poll();
                    finished++;
                }else{
                    break;
                }
            }
            finishList.add(finished); //완료한 개수를 어레이리스트에 추가
        }
        int[] answer=new int[finishList.size()];
        for(int i=0;i<finishList.size();i++){
            answer[i]=finishList.get(i); //어레이리스트 배열을 다시 기본 배열에 옮기기
        }
        return answer;
    }
	class Progress{
	    int progress;
	    int speed;
	    Progress(int progress,int speed){
	        this.progress=progress;
	        this.speed=speed;
	    }
	}
}


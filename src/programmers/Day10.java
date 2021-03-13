boolean solution(String s) {
        s=s.toLowerCase();
        int pcnt=0;
        int ycnt=0;
        for(int i=0;i<s.length();i++){
            if(s.substring(i,i+1).equals("p")){
	            pcnt++;
            }else if(s.substring(i,i+1).equals("y")){
                ycnt++;
            }
         }
        if(pcnt==ycnt){
            return true;
	}else{
            return false;
	}
}

class Robot {
    int idx=0;
    boolean moved=false;
    List<int[]> pos= new ArrayList<>();
    public Robot(int width, int height) {
        for(int i=0; i<width; i++){
            pos.add(new int[]{i,0,0});
        }
        for(int i=1; i<height; i++){
            pos.add(new int[]{width-1,i,1});
        }
        for(int i=width-2; i>=0; i--){
            pos.add(new int[]{i,height-1,2});
        }
        for(int i=height-2; i>0; i--){
            pos.add(new int[]{0,i,3});
        }

        pos.get(0)[2]=3;
    }
    
    public void step(int num) {
        moved=true;
        idx=(idx+num)%pos.size();
    }
    
    public int[] getPos() {
        return new int[]{pos.get(idx)[0],pos.get(idx)[1]};
    }
    
    public String getDir() {

        if(!moved) return "East";
        int d=pos.get(idx)[2];

        if(d==0) return "East";
        else if(d==1) return "North";
        else if(d==2) return "West";
        else return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
class MinStack {
    ArrayList<Integer> list;
    ArrayList<Integer> mins;
    int minIndex;
    public MinStack() {
        minIndex = 0;
        list = new ArrayList<>();
        mins = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        if (mins.isEmpty()) {
        mins.add(0);
        return;
        }
        int min = mins.get(mins.size() - 1);
        if(list.get(mins.get(mins.size()- 1)) > val){
            min = list.size() -1; 
        }
        mins.add(min);
    }
    
    public void pop() {
        list.remove(list.size() - 1);
        mins.remove(mins.size() - 1);
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        return list.get(mins.get(mins.size() - 1));
    }
}

class Solution {

    public static int smash(int a, int b){
        return a - b;
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap =
    new PriorityQueue<>(Collections.reverseOrder());

    for(int i = 0; i < stones.length; i++){
        heap.offer(stones[i]);
    }

    while(heap.size() > 1){
        int a = heap.poll();
        int b = heap.poll();
        int smashed = (Math.abs(smash(a,b)));
        if(smashed > 0) heap.offer(smashed);
    }
    
    if (heap.size() == 1) return heap.poll();
    else{ return 0; }
    }
}

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) {
//		int[] priorities = {2,1,3,2};
//		int location = 2;
		
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		
		System.out.println(new Solution().solution(priorities, location));
	}

}
class Solution {
	Deque<Integer> queue;
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int curLoc = location;
        queue = new ArrayDeque<Integer>();
        for (int i : priorities)
        	queue.add(i);

        while (!queue.isEmpty()) {
        	if (checkPriority(queue.getFirst())) {
        		queue.remove();
        		answer++;
        		if (curLoc == 0)
        			return answer;
        	} else {
        		queue.addLast(queue.remove());
        	}
        	
        	if (curLoc != 0)
        		curLoc--;
        	else
        		curLoc = queue.size()-1;
        }
		return -1;
    }
    
    boolean checkPriority(int priority) {
    	int max = queue.stream().max(Integer::compare).orElse(-1);
    	if (max == priority)
    		return true;
    	else
    		return false;
    }
}
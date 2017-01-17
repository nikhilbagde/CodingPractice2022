package CrackingTheCodingInterview.Chapter2LinkedList;

import DataStructure.LinkedList.SLLNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil on 1/16/2017 1:48 PM.
 */
public class Question1RemoveDuplicateNodes {
    public static void main(String[] args) {

    }
    // O(N) time
    private static void removeDuplicate(SLLNode node){
        Map<Integer, Boolean> map = new HashMap<>();
        SLLNode previous = null;
        while(node!= null){
            if(!map.containsKey(node.data)){
                map.put(node.data, true);
                previous = node;
            }else{
                assert previous != null;
                previous.next = node.next;          // prev -> SLLNode -> SLLNode's Next
            }
            node = node.next;
        }
    }
}

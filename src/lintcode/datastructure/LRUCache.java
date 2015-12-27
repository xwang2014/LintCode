package lintcode.datastructure;

import java.util.HashMap;

public class LRUCache {
	
    
    class Node {
        int key;
        int value;
        
        Node prev;
        Node next;
        
        public Node(int k, int v) {
            key = k;
            value = v;
            prev = null;
            next = null;
        }
    }

    int cap;
    HashMap<Integer, Node> map = null;
    Node head, tail; // dummy
    
    // @param capacity, an integer
    public LRUCache(int capacity) {
        // write your code here
        cap = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if(map.containsKey(key)) {
            // get the key
            Node cur = map.get(key);
            
            // move the node to head
            if(cur.prev != null) {
                cur.prev.next = cur.next;
            }
            if(cur.next != null) {
               cur.next.prev = cur.prev;
            }
            
            cur.next = head.next;
            head.next.prev = cur;
            cur.prev = head;
            head.next = cur;
    
            return cur.value;
        } else {
            return -1;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if(map.containsKey(key)) {
            Node cur = map.get(key);
            cur.value = value;
            
            // move the node to head
            if(cur.prev != null) {
                cur.prev.next = cur.next;
            }
            if(cur.next != null) {
               cur.next.prev = cur.prev;
            }
            
            cur.next = head.next;
            head.next.prev = cur;
            cur.prev = head;
            head.next = cur;
            
        } else {
            if(map.size() == cap) {
                // delete last node
            	map.remove(tail.prev.key);
            	tail.prev.prev.next = tail;
            	tail.prev = tail.prev.prev;
            	
            }
            
            Node cur = new Node(key, value);
            map.put(key, cur);
            
            cur.next = head.next;
            head.next.prev = cur;
            cur.prev = head;
            head.next = cur;
            
            
        }
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache c = new LRUCache(2);
		
		//set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)
		c.set(2, 1);
		c.set(1, 1);
		System.out.println(c.get(2));
		c.set(4, 1);
		System.out.println(c.get(1));
		System.out.println(c.get(2));
	}

}

package com.ferncircle.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	Map<Integer, LinkedListNode> map;
	DoubleLinkedList list;
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.list = new DoubleLinkedList();
	}

	public int get(int key) {

		if(!map.containsKey(key)) {
			return -1;
		}
		
		LinkedListNode temp = map.get(key);		
		list.remove(temp);
		list.addFirst(temp);

		return temp.val;
				
	}

	public void put(int key, int value) {

		LinkedListNode n = new LinkedListNode(value, key);
		if(map.containsKey(key)) {
			list.remove(map.get(key));
		}
		list.addFirst(n);
		map.put(key, n);
		
		if(map.size() > capacity) {
			map.remove(list.peekLast().key);
			list.removeLast();
			
		}
		
	}   
	
	class LinkedListNode{

		int val;
		int key;
		LinkedListNode next;
		LinkedListNode prev;
		public LinkedListNode(int val, int key){
			this.val = val;
			this.key = key;
		}
	}
	
	class DoubleLinkedList{

		LinkedListNode root;
		LinkedListNode last;
		DoubleLinkedList(){
			root = null;
			last = null;
		}
		
		public void addFirst(LinkedListNode n) {
			if(root == null) {
				n.next = null;
				n.prev = null;
				last = n;
				root = n;
			}else {
				n.next = root;
				root.prev = n;
				n.prev = null;
				root = n;
			}
			
		}
		
		public void remove(LinkedListNode n) {
			
			if(n.prev != null && n.next != null) {
				n.prev.next = n.next;
				n.next.prev = n.prev;
			}else if(n.prev == null && n.next == null) {
				root = null;
				last = null;
			}else if(n.prev == null) {
				n.next.prev = null;
				root = n.next;
			}else if(n.next == null) {
				n.prev.next = null;
				last = n.prev;
			}
			
			
		}
		
		public void removeLast() {
			if(last.prev != null) {
				last.prev.next = null;
				last = last.prev;
			}else {
				last = null;
				root = null;
			}
			
		}
		
		public LinkedListNode peekLast() {
			return last;
		}
		
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		
		cache.get(2); // -1
		cache.put(2, 6);
		System.out.println(cache.get(1)); // -1
		cache.put(1, 5);
		cache.put(1, 2);
		System.out.println(cache.get(1)); //2
		System.out.println(cache.get(2)); //6
	}


}

package com.ferncircle.tree.trie;

public class Trie {

	TrieNode root;
	/** Initialize your data structure here. */
    public Trie() {
    	root = new TrieNode();  	
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
    	TrieNode node = root;
    	for(int i=0; i< word.length(); i++){
    		char curr = word.charAt(i);
    		if(node.get(curr) == null){
    			TrieNode n =new TrieNode();
    			node.put(curr, n);
    		}
    		node = node.get(curr);
    	}
    	node.setEnd(true);
    	
    }  
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	
    	TrieNode node = searchPrefix(word);
    	if(node != null && node.isEnd()){
    		return true;
    	}
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
    	TrieNode node = searchPrefix(prefix);
    	if(node != null){
    		return true;
    	}
    	return false;
    }
    
    private TrieNode searchPrefix(String word){
    	
    	TrieNode node = root;
    	for(int i=0; i< word.length(); i++){
    		char curr = word.charAt(i);
    		if(node.containsKey(curr)){
    			node = node.get(curr);
    		}else{
    			return null;
    		}
    	}
    	return node;
    	
    }
}



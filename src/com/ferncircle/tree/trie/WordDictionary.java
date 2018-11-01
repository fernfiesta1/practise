package com.ferncircle.tree.trie;

public class WordDictionary {
	
	TrieNode root;
	
	 /** Initialize your data structure here. */
    public WordDictionary() {
       root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
       TrieNode node = root;
       for(int i=0; i< word.length(); i++){
    	   char curr = word.charAt(i);
    	   if(node.get(curr) == null){
    		   TrieNode n = new TrieNode();
    		   node.put(curr, n);
    	   }
    	   node = node.get(curr);
       }
       node.setEnd(true);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {       
    	return search(word, root);
    }
    
    private boolean search(String word, TrieNode n){
    	
    	for(int i=0; i< word.length(); i++){
    	   char curr = word.charAt(i);
    	   if(curr == '.'){
    		   for(TrieNode tn : n.getChildren()){
    			   if(tn != null){
    				   if(search(word.substring(i+1), tn)){
    					   return true;
    				   }
    			   }    			   
    		   }
    		   return false;
    	   }else{
    		   if(n.containsKey(curr)){
    			   n = n.get(curr);
    		   }else{
    			   return false;
    		   }
    	   }
       }
    	return n.isEnd();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

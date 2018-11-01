package com.ferncircle.tree.trie;

public class TrieNode {	
	
	private TrieNode[] children;
	private boolean isEnd;
	
	private final int R = 26;
	
	public TrieNode(){
		children = new TrieNode[R];		
	}
	
	public void put(char ch, TrieNode n){
		int index = ch - 'a';
		children[index] = n;		
	}
	
	public TrieNode get(char ch){
		int index = ch - 'a';
		return children[index];
	}
	
	public boolean containsKey(char ch){
		if(children[ch - 'a'] == null){
			return false;
		}
		
		return true;
	}
	
	public TrieNode[] getChildren() {
		return children;
	}
	public void setChildren(TrieNode[] children) {
		this.children = children;
	}
	public boolean isEnd() {
		return isEnd;
	}
	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

}

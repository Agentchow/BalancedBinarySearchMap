package assignment2_f20;

public class TreeMap_imp implements TreeMap { 
  TMCell root;
  int size;
  // add fields as you need to in order to provide the required behavior
  // also you may add private methods to assist you as needed
  // in implementing
  
  
  
  TreeMap_imp () { 
    root = null; 
    // for added fields you can add appropriate initialization code here
  }


  // don't change, we need this for grading
  @Override
  public TMCell getRoot() { return this.root; }
  
  // "height" is a complete implementation 
  // of the public interface method height
  // it is here to illustrate for you how the textbook sets up 
  // the method implementation as recursion
  // you may include this in your project directly

  public int height() { 
  // public interface method signature
  // this method is the public interface method
  // it is not recursive, but it calls a recursive
  // private method and passes it access to the tree cells
    return height_r(this.getRoot());
  }
  private int height_r(TMCell c) { 
  // inner method with different signature
  // this helper method uses recursion to traverse
  // and process the recursive structure of the tree of cells
    if (c==null) return -1;
    int lht = height_r(c.getLeft());
    int rht = height_r(c.getRight());
    return Math.max(lht,rht) + 1;
  }
  
  
	@Override
	public Value put(String k, Value v) {
		if(height() == -1) {
			TMCell temp = new TMCell_imp(k , v);
			root = temp;
			size++;
		}
		if(!hasKey(k)) {
			size++;
			TMCell temp = new TMCell_imp(k , v);
			
			
			return null;
		}
		
		
		return null;
	}
	
	@Override
	public Value get(String k) {
		return null;
	}
	
	@Override
	public void remove(String k) {
		
	}
	
	@Override
	public boolean hasKey(String k) {
	    return hasKey_r(this.getRoot(), k);
	}
	private boolean hasKey_r(TMCell c, String k) {
		if(c == null) {return false;}
		if(c.getKey() == k) {return true;}
		
		boolean left = hasKey_r(c.getLeft(), k);
		boolean right = hasKey_r(c.getRight(), k);		
		
		if (left || right) return true;	
		return false;
	}
	
	@Override
	public int size() {
		return 0;
	}
	
	@Override
	public String maxKey() {
		
		
		return null;
	}
	
	@Override
	public String minKey() {
		return null;
	}
	
	@Override
	public String[] getKeys() {
		return null;
	}
	  
	  
}
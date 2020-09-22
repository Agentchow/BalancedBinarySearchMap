package assignment2_f20;

public class TreeMap_imp implements TreeMap { 
  TMCell root;
  int size;
  String n;
  TMCell remain;
  Value x;
  

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
			size = 1;
		}
		else if(hasKey(k)) {
			Value old = get(k);
			replace_r(this.getRoot(), k, v);
			return old;
		}
		else if(!hasKey(k)) {
			size++;
			put_r(this.getRoot(), k, v);
			return null;
		}
		return null;
	}
	
	private void put_r(TMCell c, String k, Value v) {
		if(c == null) { return; }
		//Current Node is less than the Input
		if(c.getKey().compareTo(k) <= -1 ) { 
			if(c.getRight() == null) {
				TMCell temp = new TMCell_imp(k , v);
				c.setRight(temp);
				return;
			}
			put_r(c.getRight(), k, v);
		}
		//Current Node is greater(or equal) to the Input
		if(c.getKey().compareTo(k) >= 0 ) {
			if(c.getLeft() == null) {
				TMCell temp = new TMCell_imp(k , v);
				c.setLeft(temp);	
				return;
			}
			put_r(c.getLeft(), k, v);	
		}
		return;
	}
	
	private void replace_r(TMCell c, String k, Value v) {
		if(c == null) { return; }
		if (c.getKey() == k) {
			c.setKey(k);
			c.setValue(v);
			return;
		}
		if(c.getKey().compareTo(k) >= 0) {
			replace_r(c.getLeft(), k, v);			
		}
		if(c.getKey().compareTo(k) <= -1) {
		replace_r(c.getRight(), k, v);
		}
		return;
	}

	@Override
	public Value get(String k) {
		if(!hasKey(k) || size == 0 || height() == -1) { return null; }
		return get_r(root, k);
	}
	private Value get_r(TMCell c, String k) {
		if (c == null) { return null; }
		if (c.getKey() == k) {
			return c.getValue();
		}
		if (c.getKey().compareTo(k) >= -1) {};
		
		Value left = get_r(c.getLeft(), k);
		Value right = get_r(c.getRight(), k);	
		
		return left != null ? left : right; 
	}
	
	
	@Override
	/*
	 1.) No children -> Just Delete
	 2.) One Child -> Replace w that child 
	 		 5
	 	   0   6
	        1 
 	       
	 3.) Two Children -> Replace target w Largest Node in left subtree
	 */
	public void remove(String k) {
		if(!this.hasKey(k)) {return;}
		size--;
		remove_r(this.getRoot(), k);
	}
	private void remove_r(TMCell c, String k) {
		if(c == null) { return; }
		//Edge Case: Removing only Node:
		if(size == 0) { root = null; }
		
		//Found the key
		if(c.getKey() == k ) {
			//No children
			if(c.getLeft() == null && c.getRight() == null) {
				helpFind(this.getRoot(), k);
				return;
			}   
			//1 Child
			if(c.getLeft() != null && c.getRight() == null) {
				TMCell tempL = c.getLeft().getLeft();
				TMCell tempR = c.getLeft().getRight();
				//Set Hash
				c.setKey(c.getLeft().getKey());
				c.setValue(c.getLeft().getValue());
				c.setLeft(tempL);
				c.setRight(tempR);
				return;
			}
			else if(c.getLeft() == null && c.getRight() != null) {
				TMCell tempL = c.getRight().getLeft();
				TMCell tempR = c.getRight().getRight();
				//Set Hash
				c.setKey(c.getRight().getKey());
				c.setValue(c.getRight().getValue());
				c.setLeft(tempL);
				c.setRight(tempR);			
				return;
			}
			//2 Children
			if(c.getLeft() != null && c.getRight() != null) {
				TMCell tempL = c.getLeft();
				helpRemove(tempL);
				c.setKey(n);
				c.setValue(x);
				return;
			}
		}
		//Recursive Calls
		if(c.getKey().compareTo(k) >= 0) {
			remove_r(c.getLeft(), k);			
		}
		if(c.getKey().compareTo(k) <= -1) {
			remove_r(c.getRight(), k);
		}
		return;
	}
	private void helpFind(TMCell c, String k) {
		if(c == null || c == null) return;

		if(c.getLeft() != null && c.getLeft().getKey() == k) {
			c.setLeft(null);
			return;
		}

		if(c.getRight() != null && c.getRight().getKey() == k) {
			c.setRight(null);
			return;
		}
		//Recursive Calls
		if(c.getKey().compareTo(k) >= 0) {
			helpFind(c.getLeft(), k);			
		}
		if(c.getKey().compareTo(k) <= -1) {
			helpFind(c.getRight(), k);
		}
		return;
	}
	
	private void helpRemove(TMCell c) {
		if (c.getRight() == null) {
			n = c.getKey();
			x = c.getValue();
			c = c.getLeft();

			remove_r(this.getRoot(),n);
			return;
		} 
		helpRemove(c.getRight());

		return;
	}
	
	@Override
	public boolean hasKey(String k) {
	    return hasKey_r(this.getRoot(), k);
	}
	private boolean hasKey_r(TMCell c, String k) {
		if(c == null || size <= 0) {return false;}
		if(c.getKey() == k) {return true;}

		//if(c.getKey().compareTo(k) >= 0) {
			Boolean left = hasKey_r(c.getLeft(), k);			
		//}
		//if(c.getKey().compareTo(k) <= -1) {
			Boolean right = hasKey_r(c.getRight(), k);			
		//}
		if(left || right) return true;
		return false;	
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String maxKey() {
		if (size == 0) {return null;}
		return maxKey_r(this.getRoot());
	}
	private String maxKey_r(TMCell c) {
		if(c.getRight() == null) {return c.getKey();}
		return maxKey_r(c.getRight());
	}
	@Override
	public String minKey() {
		if (size == 0) { return null; }
		return minKey_r(this.getRoot());
	}
	private String minKey_r(TMCell c) {
		if(c.getLeft() == null) {return c.getKey();}
		return minKey_r(c.getLeft());
	}
	
	@Override
	public String[] getKeys() {
		if(size == 0) {
			String[] temp = new String[0];
			return temp;
		}
	
		String[] keys = new String[size];
		getKeys_r(this.getRoot(), keys, 0);

		return keys;
	}
	private int getKeys_r(TMCell c, String[] keys, int i) {
		if (c==null) {return i;}
		i = getKeys_r(c.getLeft(), keys, i);
		keys[i++] = c.getKey();
		i = getKeys_r(c.getRight(), keys, i);
		return i;
	}

}
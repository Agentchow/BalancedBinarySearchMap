package assignment2_f20;

public class TreeMap_Playground {
/*
 * you will test your own TreeMap implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create TreeMap objects,
 * put data into them, take data out, look for values stored
 * in it, checking size, and looking at the TMCells to see if they 
 * are all linked up correctly as a BST
 * 
*/
  
  public static void main(String[] args) {
    // you should test your TreeMap implementation in here
    // sample tests are shown

    // it is up to you to test it thoroughly and make sure
    // the methods behave as requested above in the interface
  
    // do not simple depend on the oracle test we will give
    // use the oracle tests as a way of checking AFTER you have done
    // your own testing

    // one thing you might find useful for debugging is a print tree method
    // feel free to use the one we have here ... basic and quick, or write one 
    // you like better, one that shows you the tree structure more clearly
    // the one we have here only shows keys, you may wish to add 
    // value fields to the printing

    TreeMap tm = new TreeMap_imp();
    Value v1 = new Value_imp(1, 100, 20);
    Value v2 = new Value_imp(23456, 75.54, 25);
    Value v3 = new Value_imp(34567, 99.013, 19);
    Value v4 = new Value_imp(45678, 55.70, 35);
    
    System.out.println(tm.put("a", v1));
//    System.out.println("Does it have a: " + tm.hasKey("a"));
//    tm.remove("a");
//    System.out.println("Does it have a: " + tm.hasKey("a"));
//
//    
//    tm.put("C", v1); 
//    tm.put("F", v1);
//    tm.put("A", v2); 
//    tm.put("B3", v4);
//    tm.put("1", v2); 
//    tm.put("G", v3); 
//    tm.put("E", v3); 
//    tm.put("D", v3);
//    tm.put("D1", v2);
//    tm.put("D2", v2);
//    tm.put("D3", v2);
//    tm.put("D0", v2);
//    tm.put("E", v3); 
//    tm.put("2", v4);
//    tm.put("3", v4);
//    tm.put("B2", v4);
//    tm.put("B4", v4);
//
//
//    System.out.println(tm.getRoot().getLeft().getRight().getKey());
//    System.out.println("Height: " + tm.height());
//    System.out.println("Does it have A: " + tm.hasKey("A"));
//    System.out.println("Does it have B: " + tm.hasKey("B"));
//    System.out.println("Size: " + tm.size());
//    System.out.println("Get D (34567)(99.013)(19): " + tm.get("D"));
//    System.out.println("Get 1 (23456)(75.54)(25): " + tm.get("1"));// assumes a toString for a Value object
//    System.out.println("Does it have F: " + tm.hasKey("F"));
//    System.out.println("Does it have Turkeys???: " + tm.hasKey("Turkeys"));
//    //System.out.println("Get D: " + tm.get("D"));
//    System.out.println("(G)Max Key: " + tm.maxKey());
//    System.out.println("(1)Min Key: " + tm.minKey());
//    
//
//    
//    //Replacement Tests
//    Value replacement = new Value_imp(6969, 69.69, 69);
//    
//    //Replace C Value and check
//    tm.put("C", replacement); 
//    System.out.println(tm.get("C").toString());
//    //Replace B Value and check
//    tm.put("B", replacement); 
//    System.out.println(tm.get("B").toString());
//    
//    System.out.println(tm.put("C", v2));
    

//    tm.put("b", v1);
//    tm.put("a", v2);    
//    tm.remove("b");
//    System.out.println(tm.put("b", v1));
//
//    System.out.println(tm.getRoot().getValue().toString());
    
//    for (String s : tm.getKeys()) {
//    	System.out.print(s + " ");
//    }
//	System.out.println();
//    prTree(tm.getRoot(),0); 

//	tm.remove("2");
//    tm.remove("1");
//    tm.remove("C");
//    tm.remove("3");
//    tm.remove("D1");
//	tm.remove("B4");
//    tm.remove("F");
//    tm.remove("D");
//    tm.remove("D0");
//    tm.remove("A");
//    tm.remove("G");
//    tm.remove("E");
//    tm.remove("D2");
//    tm.remove("B");
    
    //Print out all keys in order
//    for (String s : tm.getKeys()) {
//    	System.out.print(s + " ");
//    }
	System.out.println();
	


    
    prTree(tm.getRoot(),0); 


  }

  public static void prTree (TMCell c, int off) {
    if (c==null) return;
        
    prTree(c.getRight(), off+3);
    
    for (int i=0; i<off; i++) System.out.print("-");
    System.out.println(c.getKey());
        
    prTree(c.getLeft(), off+3);
  }

}

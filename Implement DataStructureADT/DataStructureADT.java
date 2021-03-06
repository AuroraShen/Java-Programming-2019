/////////////////////////////// 80 COLUMNS WIDE /////////////////////////////// 
//
// Title:           Data Structure 
// Author:          rshen27@wisc.edu
// Lecturer's Name: Andy Kuemmel
//
/////////////////////////////// 80 COLUMNS WIDE /////////////////////////////// 
	
/**
 * This Class is the DataStructure class that I wrote that implements DataStructureADT class
 * I do editing and adding code in this class. This class contains many method such as insert, 
 * remove, contain, get and size to modify or searching the elements in the data structure.
 * 
 * @author Shen
 */
public class DS_My implements DataStructureADT {
	
	/**
	 * This is a inner class that define in the DS_My class to stroing
	 * key and value as a pair in the data structure. This inner class
	 * extends Comparable.
	 */
    private class Pair<K extends Comparable<K>, V> {
    	
        private K key;   // An instance field to store the key
        private V value; // An instance field to store the value
    	
        /**
    	 * This is a private constructor of the Pair inner class.
    	 * 
    	 * @param K where is the type for key
    	 * @param V where is the type for value
    	 */
        private Pair(K key, V value) {
        	this.key = key;
        	this.value = value;
        }
    }
    
    private int size;      //size of the pairs that stored in data structure 
    private Pair[] pairs;  //An array that stores pairs
    
	/**
	 * This is the constructor of the public class DS_My. It initialize size and pairs.
	 */
    public DS_My() {
    	size = 0;                
        pairs = new Pair[1000];  //initialize the oversized array      
    }
    
	/**
	 * This is a override method that working for inserting pairs to our data structure. It add the 
	 * key,value pair to the data structure and increases size. If key is null, throws 
	 * IllegalArgumentException("null key"); If key is already in data structure, throws 
	 * RuntimeException("duplicate key");
	 * 
	 * @param k key
	 * @param v value
	 */
    @Override
    public void insert(Comparable k, Object v) {
        if(k == null) {
        	throw new IllegalArgumentException("null key");
        }
        for (int i = 0; i < size; i++) {
        	if (pairs[i].key.equals(k)) {
        		throw new RuntimeException("duplicate key");
        	}
        	Pair kvpair = new Pair(k,v); //inserting a new key,value pair
        	pairs[size] = kvpair;        //store the new pair into the array at index size
        	size ++;
        } 
    }
    
    /**
	 * This is a override method that working for removing pairs. If key is found, Removes 
	 * the key from the data structure and decreases size. If key is null, throws 
	 * IllegalArgumentException("null key") without decreasing size. If key is not found, returns false.
	 * 
	 * @param k key
	 * 
	 */
    @Override
    public boolean remove(Comparable k) {
       if(k == null) {
    	   throw new IllegalArgumentException("null key");
       }
       for(int i = 0; i <size; i++) {
    	   if(pairs[i].key.equals(k)) {
    		   size--;
    		   for(int j = i; j < size; j++) {
    			   pairs[j] = pairs[j+1];
    		   }
    		   return true;
    	   }
       }
       return false;
    }

    /**
	 * This is a override method that working for searching pairs. Returns true if the key 
	 * is in the data structure. Returns false if key is null or not present
	 * 
	 * @param k key
	 * 
	 */
    @Override
    public boolean contains(Comparable k) {
    	if(k == null)
    		return false;
        for(int i = 0; i <size; i++) {
     	   if(pairs[i].key.equals(k)) {
     		   return true;
     	   }
        }
        return false;
    }

    /**
	 * This is a override method that working for getting key. Returns the value associated 
	 * with the specified key. It does not remove key or decrease size. If key is null, 
	 * throws IllegalArgumentException("null key") 
	 * @param k key
	 * 
	 */
    @Override
    public Object get(Comparable k) {
    	if(k == null) {
     	   throw new IllegalArgumentException("null key");
        }
        for(int i = 0; i <size; i++) {
     	   if(pairs[i].key.equals(k)) {
     		   return pairs[i].value;
     	   }
        }
        return null;
    }

	/**
	 * This is a override method that return number of elements in the data structure
	 */
    @Override
    public int size() {
        return size;
    }

}

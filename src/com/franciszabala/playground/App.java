package com.franciszabala.playground;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.franciszabala.looper.Looper;
import com.franciszabala.looper.LooperImpl;

/**
 * Hello world!
 *
 */
public class App {


	public static void main(String[] args) throws Exception {
		//doRegular();
		//doReflection();
		
        String filePath = new File("").getAbsolutePath();
        System.out.println (filePath);
        long mem0 = Runtime.getRuntime().totalMemory() -
        	      Runtime.getRuntime().freeMemory();
        System.out.println(mem0);

       BufferedReader reader = new BufferedReader(new FileReader(filePath + "/resource/usernames.txt"));
        //InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream ("/DBTextFiles/Administrator.txt"));
        
       //BufferedReader br = new BufferedReader(file);
       String line = "";
       int counter = 1;
       Set<String> usernameSet = new HashSet<String>();
       List<String> usernameArray = new ArrayList<String>();
       while ((line = reader.readLine()) != null) {
         //a1.add(line);
    	   //System.out.println(line);
    	   counter++;
    	   try {
    		   if (usernameSet.add(line)) {
    			   usernameArray.add(line);
    		   }
    	   } catch (Exception e) {
    		   System.out.println(line);
    		   e.printStackTrace();
    	   }
       }
       reader.close();
       
       //String[] normalArray = new String[usernameSet.size()];
       //normalArray = (String[]) usernameSet.toArray(normalArray);
       //normalArray = (String[]) usernameSet.toArray(normalArray);
       //normalArray = (String[]) usernameSet.toArray(normalArray);
       
       System.out.println("number of usernames in file: " +counter);
       System.out.println("numer of usernames on set: " +usernameSet.size());
       
        
        
        long mem1 = Runtime.getRuntime().totalMemory() -
        	      Runtime.getRuntime().freeMemory();
        
        System.out.println(mem1);
       
        
        
        Looper looper3 = new LooperImpl(usernameArray, "HashSet");
        looper3.forEachloopThrough("john");
        mem1 = Runtime.getRuntime().totalMemory() -
      	      Runtime.getRuntime().freeMemory();
      
      System.out.println(mem1);
        
        Looper looper4 = new LooperImpl(usernameArray, "ArrayList");
        looper4.forEachloopThrough("john");
        
        mem1 = Runtime.getRuntime().totalMemory() -
      	      Runtime.getRuntime().freeMemory();
      
      System.out.println(mem1);
        Looper looper1 = new LooperImpl(usernameSet, "HashSet");
        looper1.forEachloopThrough("john");
        mem1 = Runtime.getRuntime().totalMemory() -
      	      Runtime.getRuntime().freeMemory();
      
      System.out.println(mem1);
        
        Looper looper2 = new LooperImpl(usernameSet, "ArrayList");
        looper2.forEachloopThrough("john");
        mem1 = Runtime.getRuntime().totalMemory() -
      	      Runtime.getRuntime().freeMemory();
      
      System.out.println(mem1);
        
        

        
//        List<String> myList2 = new ArrayList<String>(); 
//        start = System.nanoTime();
//        for (String userName: usernameArray) {
//        	//System.out.println(userName.indexOf("john"));
//        	if (userName.indexOf("john") >= 0) {
//        		myList2.add(userName);
//        	}
//        }
//        stop = System.nanoTime();
//        System.out.println("for array: " + (stop-start));
//        
//        start = System.nanoTime();
//        for (String userName: usernameArray) {
//        	//System.out.println(userName.indexOf("john"));
//        	if (userName.indexOf("john") >= 0) {
//        		myList2.add(userName);
//        	}
//        }
//        stop = System.nanoTime();
//        System.out.println("for array: " + (stop-start));
//        
//        
//        start = System.nanoTime();
//        Set<String> myList = new HashSet<String>();
//        for (String userName: usernameSet) {
//        	//System.out.println(userName.indexOf("john"));
//        	if (userName.indexOf("john") >= 0) {
//        		myList.add(userName);
//        	}
//        }
//        stop = System.nanoTime();
//        System.out.println("Using set: " + (stop-start));
        
        //AC.findAll("john", source)
        //List<String> myList3 = new ArrayList<String>(); 
        //start = System.nanoTime();
//        for (int i = 0; i < normalArray.length; i++) {
//        	//System.out.println(userName.indexOf("john"));
//        	if (normalArray[i].indexOf("john") >= 0) {
//        		myList3.add(normalArray[i]);
//        	}
//        }
        
        //for (String userName: normalArray) {
        	//System.out.println(userName.indexOf("john"));
        	//if (userName.indexOf("john") >= 0) {
        		//myList3.add(userName);
        	//}
       // }
      // stop = System.nanoTime();
       // System.out.println("for norma: " + (stop-start));

       
        
        //for (String test: myList) {
        	//System.out.println("joe: " +test);
        //}

//        for (String test: myList2) {
//        	System.out.println("other joe: " +test);
//        }
        
//        Collections.
//        int i= Collections.binarySearch(usernameSet,"Foo") ;
//        while( i < usernameSet.size() && usernameSet.get(i).startsWith("Foo") ) {
//            // Process String forwardList.get(i)
//            i++;
//        }
        
        //AC.compile("john");
        
        
	}

	public static void doRegular() throws Exception {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			A a = new A();
			a.doSomething();
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	public static void doReflection() throws Exception {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			A a = (A) Class.forName("com.franciszabala.playground.A").newInstance();
			a.doSomething();
		}
		System.out.println(System.currentTimeMillis() - start);
	}

}

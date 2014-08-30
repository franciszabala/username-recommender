package com.franciszabala.looper;

import java.util.Collection;

import com.franciszabala.clocks.IClock;
import com.franciszabala.clocks.MiliClock;

public class LooperImpl implements Looper{
    private long start = 0;
    private long stop = 0;
    
    private Collection<String> collection;
    private Collection<String> collectionForStorage;
    
    public LooperImpl(Collection<String> collectionType, String collectionForStorageType) {
    	collection = collectionType;
    	collectionForStorage = CollectionFactory.getMeCollection(collectionForStorageType);
    }

	@Override
	public void forEachloopThrough(String pattern){
		// TODO Auto-generated method stub
		IClock clock = new MiliClock();
        start = clock.startClock();
        //System.out.println(start);
        for (String userName: collection) {
        	if (userName.indexOf(pattern) >= 0) {
        		collectionForStorage.add(userName);
        	}
        }
        stop = clock.stopClock();
        System.out.println(collection.getClass().getName() +"  "+ collectionForStorage.getClass().getName() +" : " + stop + "ms");
		
	}

	@Override
	public void iteratorThrough(Collection<String> collection, String pattern) {
		// TODO Auto-generated method stub
		
	}

}

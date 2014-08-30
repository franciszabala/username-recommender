package com.franciszabala.looper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionFactory {

	private static CollectionFactory instance = null;

	public static CollectionFactory getInstance() {
		if (instance == null) {
			instance = new CollectionFactory();
		}
		return instance;
	}

	protected CollectionFactory() {
		// Exists only to defeat instantiation.
	}
	
	private static Set<String> generateHashSet() {
		return new HashSet<String>();
	}
	
	private static List<String> generateArrayList() {
		return new ArrayList<String>();
	}
	
	public static Collection<String> getMeCollection(String collectionType) {
		if (collectionType.equalsIgnoreCase("ArrayList")) {
			return generateArrayList();
		} else if (collectionType.equalsIgnoreCase("HashSet")) {
			return generateHashSet();
		} else {
			return null;
		}
	}

}

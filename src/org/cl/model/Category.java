package org.cl.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Category {
	
	MAIN("MAIN"),
	SECONDARY("SECONDARY"),
	TERTIARY("TERTIARY"),
	TORPEDOES("TORPEDOES");
	
	private final String category;
	
	private static final Map<String, Category> stringToEnum = new ConcurrentHashMap<String, Category>();
	    static {
	        for (Category set: values()){
	            stringToEnum.put(set.category, set);
	        }
	    }

	    private Category(String category) {
	        this.category = category;
	    }

	    public String toString(){
	        return this.category;
	    }

	    public static Category fromString(String setting){
	        return stringToEnum.get(setting);
	    }  
}

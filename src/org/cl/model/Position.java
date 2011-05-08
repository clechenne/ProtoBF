package org.cl.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Position {
	A("A"), 
	Z("Z");
	
	private final String internal;
	
	private static final Map<String, Position> stringToEnum = new ConcurrentHashMap<String, Position>();
	    static {
	        for (Position set: values()){
	            stringToEnum.put(set.internal, set);
	        }
	    }

	    private Position(String internal) {
	        this.internal = internal;
	    }

	    public String toString(){
	        return this.internal;
	    }

	    public static Position fromString(String setting){
	        return stringToEnum.get(setting);
	    }
}

package com.example.ovsback.service;

import java.util.Map;

public interface ResultService {


	

	public void resetPublishStatus() ;
	    Map<Object, Long> calculateResults();

	 
	    void publishResults();
	   
	    boolean isPublished();

	    void setPublished(boolean published);
		
	}

package com.franciszabala.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.franciszabala.dao.UsernameDao;

public class UsernameDaoFileImpl implements UsernameDao{
	
	private static final String filePath = new File("").getAbsolutePath();

	@Override
	public Collection<String> getUsernames() throws IOException, FileNotFoundException {
			
		   BufferedReader reader = new BufferedReader(new FileReader(filePath + "/resource/usernames.txt"));
	       String line = "";
	       Set<String> usernameSet = new HashSet<String>();
	       try {
	    	   while ((line = reader.readLine()) != null) {
	    		  usernameSet.add(line);
	    	   }
	       } catch (Exception e) {
    		   System.out.println(line);
    		   e.printStackTrace();
    	   } finally {
    		   reader.close();
    	   }
	       return usernameSet;
	}

}

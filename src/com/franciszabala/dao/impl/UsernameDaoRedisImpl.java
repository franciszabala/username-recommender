package com.franciszabala.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.franciszabala.dao.UsernameDao;

public class UsernameDaoRedisImpl implements UsernameDao{
	
	private static final String filePath = new File("").getAbsolutePath();

	@Override
	public Collection<String> getUsernames() throws IOException, FileNotFoundException {
			
		   JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
		
		   Jedis jedis = pool.getResource();
		   try {
		     /// ... do stuff here ... for example
		     jedis.set("foo", "bar");
		     String foobar = jedis.get("foo");
		     jedis.zadd("sose", 0, "car"); jedis.zadd("sose", 0, "bike"); 
		     Set<String> sose = jedis.zrange("sose", 0, -1);
		   } finally {
		     /// ... it's time to release alive/broken Jedis instance...
		     if (null != jedis) {
		       jedis.close();
		     }
		   }
		   /// ... when closing your application:
		   pool.destroy();
		
		   
		   
		   
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

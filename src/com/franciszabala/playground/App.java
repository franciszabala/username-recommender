package com.franciszabala.playground;

import java.util.HashSet;
import java.util.Set;

import com.franciszabala.clocks.IClock;
import com.franciszabala.clocks.MiliClock;
import com.franciszabala.dao.UsernameDao;
import com.franciszabala.dao.impl.UsernameDaoFileImpl;
import com.franciszabala.looper.Looper;
import com.franciszabala.looper.LooperImpl;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws Exception {
		// doRegular();
		// doReflection();
		IClock mainClock = new MiliClock();
		long stop = 0;
		mainClock.startClock();
		long mem0 = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		System.out.println(mem0);
		UsernameDao usernameDao = new UsernameDaoFileImpl();
		
		Set<String> usernameSet = (HashSet<String>) usernameDao.getUsernames();
		stop = mainClock.stopClock();
		System.out.println("end dao: " + stop + "ms");
		
		
		System.out.println("numer of usernames on set: " + usernameSet.size());

		
		long mem1 = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();

		System.out.println(mem1);

		Looper looper2 = new LooperImpl(usernameSet, "ArrayList");
		looper2.forEachloopThrough("john");
		mem1 = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();

		System.out.println(mem1);

		stop = mainClock.stopClock();
		System.out.println("last: " + stop + "ms");
		// last: 1733ms

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
			A a = (A) Class.forName("com.franciszabala.playground.A")
					.newInstance();
			a.doSomething();
		}
		System.out.println(System.currentTimeMillis() - start);
	}

}

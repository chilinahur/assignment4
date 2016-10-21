/* CRITTERS Main.java
 * EE422C Project 4 submission by
 * Sriram Chilukuri
 * smc4474
 * 16445
 * Yousef Abdelrazzaq
 * Yja87
 * 16445
 * Slip days used: <0>
 * Fall 2016
 */
package assignment4; // cannot be in default package
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Method;


/*
 * Usage: java <pkgname>.Main <input file> test
 * input file is optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */
public class Main {

    static Scanner kb;	// scanner connected to keyboard input, or input file
    private static String inputFile;	// input file, used instead of keyboard input if specified
    static ByteArrayOutputStream testOutputString;	// if test specified, holds all console output
    private static String myPackage;	// package of Critter file.  Critter cannot be in default pkg.
    private static boolean DEBUG = false; // Use it or not, as you wish!
    static PrintStream old = System.out;	// if you want to restore output to console


    // Gets the package name.  The usage assumes that Critter and its subclasses are all in the same package.
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }

    /**
     * Main method.
     * @param args args can be empty.  If not empty, provide two parameters -- the first is a file name, 
     * and the second is test (for test output, where all output to be directed to a String), or nothing.
     */
    public static void main(String[] args) { 
        if (args.length != 0) {
            try {
                inputFile = args[0];
                kb = new Scanner(new File(inputFile));			
            } catch (FileNotFoundException e) {
                System.out.println("USAGE: java Main OR java Main <input file> <test output>");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("USAGE: java Main OR java Main <input file>  <test output>");
            }
            if (args.length >= 2) {
                if (args[1].equals("test")) { // if the word "test" is the second argument to java
                    // Create a stream to hold the output
                    testOutputString = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(testOutputString);
                    // Save the old System.out.
                    old = System.out;
                    // Tell Java to use the special stream; all console output will be redirected here from now
                    System.setOut(ps);
                }
            }
        } else { // if no arguments to main
            kb = new Scanner(System.in); // use keyboard and console
        }

        /* Do not alter the code above for your submission. */
        /* Write your code below. */
    	
while(true){
			System.out.print("critters>");
        	String input = kb.nextLine();
    		Scanner commandScanner = new Scanner(input);
    		String command = commandScanner.next();
    		
        try{
        	if(command.equals("quit")){
        		if(commandScanner.hasNext())
        			throw new Exception();
        		break;
        	}
        	
        	else if(command.equals("show")){
        		if(commandScanner.hasNext())
        			throw new Exception();
        		Critter.displayWorld();
        	}
        	
        	else if(command.equals("step")){
        		
        		if(commandScanner.hasNextInt()){
            		int num = commandScanner.nextInt();
            		
            		if(commandScanner.hasNext() || num < 0)
            			throw new Exception();

            		for(int i = 0; i < num; i++){
            			Critter.worldTimeStep();
            		}
        		}
        		else if(!commandScanner.hasNext())
       			Critter.worldTimeStep();
        		else
        			throw new Exception();
        	}
        	
        	else if(command.equals("seed")){
        		if(commandScanner.hasNextInt()){
            		int num = commandScanner.nextInt();
            		
            		if(commandScanner.hasNext() || num < 0)
            			throw new Exception();

            		Critter.setSeed(num);
        		}
        		else
        			throw new Exception();
        	}
        	
        	else if(command.equals("make")){
        		String className = new String();
        		int num = 0;
        		
        		if(commandScanner.hasNext())
        			className = commandScanner.next();
        		else
            		throw new Exception();
        		
           		if(commandScanner.hasNextInt()){
            		num = commandScanner.nextInt();
            		
            		if(commandScanner.hasNext() || num < 0)
            			throw new Exception();
           		}
           		else if(commandScanner.hasNext())
        			throw new Exception();
           		
        		//Critter.clearWorld();
        		/*
        		for(int i = 0; i< 100; i++)
        			Critter.makeCritter("Algae");
        		for(int x = 0; x < 25; x++)
        			Critter.makeCritter("Craig");
        		*/
        		if(num == 0)
        			Critter.makeCritter(className.toString());
        		else{
        			for(int i = 0; i < num; i++)
            			Critter.makeCritter(className.toString());
        		}
        	}
        	else if(command.equals("stats")){
	        		if(commandScanner.hasNext()){
	        			String className = commandScanner.next();
	            		
	            		if(commandScanner.hasNext())
	            			throw new Exception();
	            		
	            		List<Critter> result = new ArrayList<Critter>();
	            		result = Critter.getInstances(className);
	            		
	            		Class<?> claz = Class.forName(myPackage + "." + className);
	            		Method method = claz.getMethod("runStats", List.class);
	            		method.invoke(claz, result);
	        		}
	        		else
	        			throw new Exception();
        	}
    		else{
                System.out.println("invalid command: " + input);
    		}
    	}
            catch (Exception e){
            	System.out.println("error processing: " + input);
            }
        commandScanner.close();
		} 

        
        /* Write your code above */
        System.out.flush();

    }
}

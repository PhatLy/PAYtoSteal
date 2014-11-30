/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import java.util.*;

/**
 *
 * @author Ashley
 */

class Sector {
	int BACK;
	int FRWD;
	int FREE;

	Sector(){}
}

class File extends Sector{
    public char[] data = new char[504];

	File(){}
}

class dirRow {
    public char type;
    public char[] name = new char[9];
    public int blockNum;
    public short size;

    dirRow(){}
}

class Directory extends Sector{
    public dirRow[] rows = new dirRow[31];

    Directory(){}
};

public class FileSys {
    private Sector[] sectors = new Sector[100];
    private LinkedList<Integer> free;
    private int current;
    private char loc;
    
    FileSys(){} 

    private String DREAD(String com, int index, int toRead) {return "filler";}

    private void DWRITE(String com, int which, int size, String arr) {}


    char create(String t, String name) {
   	int index = -1;
        //look for file in current directory
   
        if (index > 0) {
            dlte("name"/*name?*/);
        }

    	if (free.size() > 0) {
    	    index = free.pop();

	    if (t.equals("U")) {
	        sectors[index] = new File();
	    }
    	    else if (t.equals("D")) {
	    	sectors[index] = new Directory();
	    }
	    //add to directory, extend directory if needed
    	    current = index;
	    char a = 'a';
	    loc = a; /*same method as opened as output*/
        }
 	else {
            return 'a';
        }
        return loc;
    }

    char open(String mode, String nme){              //make before create
        int index = -1;
        //look for file in current directory

        if (index < 1) {
            current = -1;
        }
        else {
            if (mode.equals("I")) {
                loc = sectors[current].data[0];
	        current = index;
	    }
	    else if (mode.equals("O")) {
	        loc = sectors[current].data[0];
    	        current = index;
            } 
	    else if (mode.equals("U")) {
	        char b = 'b';
	        loc = b; /*last byte + 1 of last sector*/
	        current = 0; //set to correct sector
    	    }
        }
	return loc;
		 
	//somehow set permissions
    }

    void close(){
        current = -1;
         //set in dir to free
    }

    boolean dlte(String name) {
        int ind = 1;
        //traverse tree to find fileindex, if not found return false
			   
        free.push(ind);
        current = -1;
        loc = 'a';
	return true;
    }

    String read(int n) {
    	String output = "";
	if (current > 0) {
	    output = DREAD("READ", current, n);
    	    if (n > 0/*size in directory factoring in number of sectors*/) { //do in dread?
	    	output += " [Only able to read " + output + " characters]";
	    }
        }
	else {
	    output = "Open a file to read";
	}
	return output;
    }

    String write(int n, String data){
	String output = "";
    	if (current > 0) {
	    //pad data if needed
	    if (n > data.length()) {
	    	int pad = n - data.length();
		for (int i = 0; i < pad; i++) {
		    data += " ";
    		}
	    }

	    //write to file
	    if (n > 0/*calculate size of file remaining (so size in dir)*/) {
	    	//calculate remaining needed sectors and pop
	        DWRITE("WRITE", current, 0/*size remaining in current*/, data);
        	n -= 0;/*size remaining in current*/
    		data = data.substring(0/*size remaining in current*/, data.length() - 0/*sizeCurrent*/);
		int numSec = 1;
		while (n > 0) {
		    if (free.size() > 0) {
			int ind = free.pop();

			sectors[ind] = new File();
    			sectors[current].FRWD = ind;
	    		sectors[ind].BACK = current;
							    
			int num = n > 504 ? 504 : n;
			DWRITE("WRITE", ind, num, "filler");
        		n -= num;
	        	data = data.substring(num, data.length() - num);
		    }
        	    else {
	   		output = "Out of available sectors";
                    }
		}
	    }
	    else {
    		DWRITE("WRITE", current, n, "filler");
	    }
	}
    	else {
	    output = "Open a file to Write.";
	}
    	return output;
    }
	    
    char seek(String base, int offset){
    	if (current > 0) {
            if (base.equals("-1")) {
		loc = sectors[current].data[0];
	    }
	    else if (base.equals("0")) {} //do nothing?
	    else if (base.equals("1")) {
		int ind = current;
    		while (offset > 504) {
	    	    ind = sectors[ind].FRWD;
            }
	    loc = sectors[ind].data[0/*size from dir or offset*/]
	    }
        }
	else {
	    return 'a';
        }
        return loc;
    }
}

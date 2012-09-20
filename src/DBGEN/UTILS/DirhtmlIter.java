/**
 * HX-2012-09-10
 */

/* ****** ****** */

package DBGEN.UTILS;

/* ****** ****** */

import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.LinkedList;

/* ****** ****** */

public
class DirhtmlIter {
//
    private String fname;
    private LinkedList<String> dirlist;
//
    private void
	__dirlist_initize
	(BufferedReader bfinp) {
	dirlist = new LinkedList<String>();
	try {
	    while (true) {
		String str = bfinp.readLine();
		if (str==null) break; else dirlist.addLast(str);
	    }
	} catch (IOException e) {
	}
	return ;
    }
//
    public
	DirhtmlIter ()
    {
	fname = "STDIN";
//
	FileReader finp = null;
	finp = new FileReader(FileDescriptor.in);
	BufferedReader bfinp = null;
	bfinp = new BufferedReader(finp);
	if (bfinp != null) __dirlist_initize (bfinp);
	return ;
    }
    public
	DirhtmlIter (String fname)
    {
//
	this.fname = fname;
//
	FileReader finp = null;
	try {
	    finp = new FileReader(fname);
	} catch (IOException e) {
	    System.err.println ("The given path [" + fname + "] cannot be opened.");
	}
	BufferedReader bfinp = null;
	bfinp = new BufferedReader(finp);
	if (bfinp != null) __dirlist_initize (bfinp);
	return ;
//
    }
//
    public String getNext ()
    {
	return dirlist.removeFirst();
    }
    public boolean hasNext () {
	return (dirlist.isEmpty() ? false : true) ;
    }
//
} // end of [DirhtmlIter]

/* ****** ****** */

/* end of [DirhtmlIter.java] */

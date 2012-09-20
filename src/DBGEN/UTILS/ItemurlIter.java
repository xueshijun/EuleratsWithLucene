/**
 * HX-2012-09-08
 */

/* ****** ****** */

package DBGEN.UTILS;

/* ****** ****** */

import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.TreeSet;
import java.util.LinkedList;

/* ****** ****** */

public
class ItemurlIter {
//
    private String fname;
    private LinkedList<String> idlist;
//
    private void
	__idlist_initize
	(BufferedReader bfinp) {
	TreeSet<String> idset;
	idset = new TreeSet<String>();
	try {
	    while (true) {
		String str = bfinp.readLine();
		if (str==null) break; else idset.add(str);
	    }
	} catch (IOException e) {
	}
	idlist = new LinkedList<String>(idset);
	idset.clear();
	return ;
    }
//
    public
	ItemurlIter ()
    {
	fname = "STDIN";
//
	FileReader finp = null;
	finp = new FileReader(FileDescriptor.in);
	BufferedReader bfinp = null;
	bfinp = new BufferedReader(finp);
	if (bfinp != null) __idlist_initize (bfinp);
	return ;
    }
    public
	ItemurlIter (String fname)
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
	if (bfinp != null) __idlist_initize (bfinp);
	return ;
//
    }
//
    public String getNext ()
    {
	return idlist.removeFirst();
    }
    public boolean hasNext () {
	return (idlist.isEmpty() ? false : true) ;
    }
//
} // end of [class]

/* ****** ****** */

/* end of [ItemurlIter.java] */

package com.gmail.bschneppdev.jvassister.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.gmail.bschneppdev.jvassister.basic.ArrayUtility;
import com.gmail.bschneppdev.jvassister.guibasic.DisplayMessage;

public class ErrorReporter
{
    public static void reportError(Exception e)
    {
	StringWriter sw = new StringWriter();
	e.printStackTrace(new PrintWriter(sw));
	String exceptionAsString = sw.toString();
	ArrayList<Object> lines = new ArrayList<Object>();
	Scanner emscnr = new Scanner(exceptionAsString);
	while (emscnr.hasNextLine())
	{
	    lines.add(emscnr.nextLine());
	}
	emscnr.close();
	Object[] objs = ArrayUtility.arrayListToArray(lines);
	String[] strs = new String[objs.length];
	for (int i = 0; i < strs.length; i++)
	{
	    strs[i] = objs[i].toString();
	}
	StringBuilder finalString = new StringBuilder();
	for (String n : strs)
	{
	    finalString.append(n + "\n");
	}
	String[] finalMsg = new String[strs.length + 1];
	for (int i = 1; i < strs.length; i++)
	{
	    finalMsg[i] = strs[i];
	}
	finalMsg[0] = "An unexpected error occured, printing stack trace:";
	DisplayMessage.displayOkMessage(finalMsg);
	e.printStackTrace();	//Redundancy!!
    }
}

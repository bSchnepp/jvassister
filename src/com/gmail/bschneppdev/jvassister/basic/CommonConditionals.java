package com.gmail.bschneppdev.jvassister.basic;

/**
 * Common conditional checks.
 * 
 * @author Brian Schnepp
 */
public final class CommonConditionals
{
    private CommonConditionals()
    {
    };

    /**
     * Checks if an argument is true or not - if it isn't, throws an
     * IllegalArgumentException.
     * 
     * @param boolean
     *            "expression"
     * @throws IllegalArgumentException
     *             if false
     */
    public static void checkArg(boolean expression)
    {
	CommonConditionals.checkArg(expression, null);
    }

    /**
     * Checks if an argument is true or not - if it isn't, throws an
     * IllegalArgumentException. Passes as an argument to
     * IllegalArgumentException error.
     * 
     * @param boolean
     *            "expression"
     * @param String
     *            "error"
     * @throws IllegalArgumentException
     *             if false
     */
    public static void checkArg(boolean expression, String error)
    {
	if (expression == false)
	{
	    throw new IllegalArgumentException(error);
	}
    }

    /**
     * Checks if a state is valid or not - if it isn't, throws an
     * IllegalStateException.
     * 
     * @param boolean
     *            "expression"
     * @throws IllegalStateException
     *             if false
     */
    public static void checkState(boolean state)
    {
	CommonConditionals.checkState(state, null);
    }

    /**
     * Checks if a state is valid or not - if it isn't, throws an
     * IllegalStateException. Passes as an argument to IllegalStateException
     * error.
     * 
     * @param boolean
     *            "expression"
     * @param String
     *            "error"
     * @throws IllegalStateException
     *             if false
     */
    public static void checkState(boolean state, String error)
    {
	if (!state)
	{
	    throw new IllegalStateException(error);
	}
    }

    /**
     * Checks (nicely) if an object is null or not.
     * 
     * @param Object
     *            obj
     * @return true if null, false otherwise.
     */
    public static boolean askIfNull(Object obj)
    {
	if (obj == null)
	{
	    return true;
	}
	return false;
    }

    /**
     * Checks if an object is null or not - if it is, throw a
     * NullPointerException.
     * 
     * @param Object
     *            obj
     */
    public static void checkIfNull(Object obj)
    {
	if (obj == null)
	{
	    throw new NullPointerException("NullPointerException - value found as null.");
	}
    }

    /**
     * Forces an object to not be null, replacing it with a default class.
     * 
     * @param Object
     *            "checked"
     * @return new Object if checked is null.
     */
    public static Object replaceNull(Object checked)
    {
	if (checked == null)
	{
	    checked = new Object();
	}
	return checked;
    }

}

package com.gmail.bschneppdev.jvassister.values;

/**
 * Handles unsigned integer types.
 * @author Brian Schnepp
 *
 */
public class UnsignedInteger extends UnsignedValue
{
    private int first31bits = 0;
    private int lastbit = 0;

    /**
     * Creates a new unsigned integer. If the value is negative, it will convert
     * it to what the value would be as if the 32nd bit was available. (-1 will
     * become the maximum unsigned int value)
     * 
     * @param int
     *            "value"
     */
    public UnsignedInteger(int value)
    {
	if (value < 0)
	{
	    this.first31bits = Integer.MAX_VALUE;
	    this.lastbit = Integer.MAX_VALUE - value;
	}
	else
	{
	    first31bits = value;
	}
    }

    /**
     * Converts a long into an unsigned integer. Value is not checked if it's
     * actually possible to be used as unsigned or not.
     * 
     * @param long
     *            "value"
     */
    public UnsignedInteger(long value)
    {
	if (value > Integer.MAX_VALUE)
	{
	    lastbit = (int) (value - Integer.MAX_VALUE);
	    first31bits = Integer.MAX_VALUE;
	}
    }

    /**
     * Checks if this unsigned int is greater than another one.
     * 
     * @param UnsignedInteger
     *            otherValue
     * @return true if greater than (exclusive), false otherwise.
     */
    public boolean isGreaterThan(UnsignedInteger otherValue)
    {
	String thisVal = this.toString();
	String otherVal = otherValue.toString();
	if (thisVal.length() > otherVal.length())
	{
	    return true;
	}
	for (int i = 0; i < otherVal.length(); i++)
	{
	    if (Integer.parseInt(thisVal.charAt(i) + "") > Integer.parseInt(otherVal.charAt(i) + ""))
	    {
		return true;
	    }
	}
	return false;
    }

    /**
     * Convert an UnsignedInteger into a normal integer.
     * @return integer value.
     */
    public int toInt()
    {
	if (this.lastbit != 0)
	{
	    return 0 - (Integer.MAX_VALUE - lastbit);	//Java won't let us just add over MAX_VALUE
	}
	return first31bits;
    }

    @Override
    public String toString()
    {
	// Do note this implementation is not the fastest and is inefficient,
	// but it is the simplest possible.
	return "" +  ((long)first31bits + (long)lastbit);
    }
}

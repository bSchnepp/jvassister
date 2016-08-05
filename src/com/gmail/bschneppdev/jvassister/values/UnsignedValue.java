package com.gmail.bschneppdev.jvassister.values;

public abstract class UnsignedValue
{
    /**
     * We expect this class to be subclassed.
     * This method is meant for toStringing after being initialized.
     * @return boolean true if valid, false otherwise.
     */
    public boolean checkValidity()
    {
	if (this.toString().contains("-"))
	{
	    return false;
	}
	return true;
    }
}

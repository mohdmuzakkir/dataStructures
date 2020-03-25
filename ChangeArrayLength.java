package dataStructures;

import java.lang.reflect.Array;

public class ChangeArrayLength
{
    public static Object[] changeLength1D(Object[] a,int n,int newLength)
    {
        // to check if the new length of array is large enough
        if(n>newLength)
            throw new IllegalArgumentException
            ("new length too small");

        //  newInstance creates an array of length: newLength and type: getComponent(which returns data type of the component of invoking instance)
        Object[] newArray = (Object []) Array.newInstance(a.getClass().getComponentType(),newLength);

        //arraycopy copies an array from source array to destination array upto n 
        System.arraycopy(a, 0, newArray, 0, n);

        return newArray; 

    }
}
package EventTheory;

import Root.BaseObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Place extends BaseObject {
    private ArrayList<BaseObject> pDimensions = new ArrayList<BaseObject>();
    private ArrayList<Long> pValues = new ArrayList<Long>();

    public Place(ArrayList<Dimension> dimensions) throws Exception
    {
        if (dimensions == null) throw new Exception("dimensions is null");
            if (dimensions.size() <= 0)
            {
                throw new Exception("Dimention is wrong <0");
            }
            else
            {
                for (int i = 0; i < dimensions.size(); i++)
                {
                    if (pDimensions.contains(dimensions.get(i)))
                    {
                        throw  new Exception("?????? ??????. ????? ????????????");
                    }
                    pValues.add(dimensions.get(i).getMin());
                    pDimensions.add(dimensions.get(i).clone());
                }
            }
    }

    public ArrayList<BaseObject> getDimension() {
        return pDimensions;
    }

    public BaseObject getDimension(int index) {
        return  pDimensions.get(index);
    }

    public long[] getValues() {
        return new long[1];
    }

    public void setValue(long value, int index) throws Exception
    {
        if (value < (((Dimension)pDimensions.get(index)).getMin()) || value > (((Dimension)pDimensions.get(index)).getMax()))
        {
            throw new Exception("Trying to set the value outside the domain of");
        }
        pValues.set(index, value);
    }

    public Place setValues(long[] value) throws Exception
    {
        if (Array.getLength(value) != pDimensions.size())
        {
            throw new Exception("Dimensoin sizes is not equals");
        }

        for (int i = 0; i < pDimensions.size(); i++)
        {
            setValue(value[i], i);
        }

        return this;
    }

    @Override
    public BaseObject clone() {
        return null;  //TODO: "????????? ?????"
    }

    @Override
    public boolean equals(Object obj) {
        return false;  //TODO: "????????? ?????"
    }

    @Override
    public String toString() {
        return null;  //TODO:"Заполни метод!"
    }

    @Override
    public int compareTo(BaseObject object) {
        return 0;  //TODO:"Заполни метод!"
    }

    public boolean compatibleTo(Place pattern) throws Exception {
        if (pattern == null)
        {
            throw new Exception("Place is null");
        }
        if (this == pattern)
        {
            return true;
        }

        if (pattern.getCount() != getCount())
        {
            return false;
        }

        for (int i = 0; i < pattern.getCount(); i++)
        {
            if (!((Dimension)pattern.getDimension(i)).equalsAsDimension((Dimension)pDimensions.get(i)))
            {
                return false;
            }
        }
        return true;
    }

    public int getCount() throws Exception
    {
        if (pDimensions.size() != pValues.size())
        {
            throw new Exception("Error of data integrity");
        }
        return pDimensions.size();
    }

    public long getValue(int index) throws Exception
    {
        if (index >= pDimensions.size() || index < 0)
        {
            throw new Exception("Trying to get the value is not an existing demension");
        }
        return pValues.get(index);
    }
}

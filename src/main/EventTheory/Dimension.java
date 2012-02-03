package EventTheory;

import Root.BaseObject;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 17.11.2010
 * Time: 23:43:24
 * To change this template use File | Settings | File Templates.
 */

public class Dimension extends BaseObject {
    private long pmin;
    private long pmax;
    
    public Dimension(long min,  long max) {
        if (min < max)
            {
                pmax = max;
                pmin = min;
            }
            else
            {
                System.out.print("-------------------------------------------------------------------------");
                System.out.print("Warning: " + this.getClass() + " creating min > max");
                System.out.print("-------------------------------------------------------------------------");
                pmin = max;
                pmax = min;
            }
    }

    public boolean equalsAsDimension(Dimension obj) {
        if (null == obj)
        {
            return false;
        }

        if (obj.pmax == pmax && obj.pmin == pmin)
        {
            return true;
        }
        return false;
    }

    public long getMax()
    {
        return pmax;
    }

    public long getMin()
    {
        return pmin;
    }

    public long getLength()
    {
        int dt = 0;
        if (pmin <= 0 && pmax >= 0)
        {
            dt = 1;
        }
        return (int) (pmax - pmin) + dt;
    }

    public BaseObject clone() {
        return new Dimension(pmin, pmax);
    }

    public boolean equals(Object obj) {
            if (this == obj)
            {
                return true;
            }
            return false;
    }

    @Override
    public String toString() {
        return null;  //TODO:"Заполни метод!"
    }

    @Override
    public int compareTo(BaseObject object) {
        return 0;  //TODO:"Заполни метод!"
    }
}

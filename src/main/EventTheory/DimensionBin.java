package main.EventTheory;

import main.Root.IBaseObject;
import main.Root.IBin;

/**
 *
 * @author Alex
 */
public class DimensionBin implements IBin {
    private long max;
    private long min;

    long getMin() {
        return min;
    }

    long getMax() {
        return max;
    }

    public IBaseObject GetInstance() {
        return null;  //TODO: "????????? ?????"
    }

    public void setMin(long min) {
        this.min = min;
    }

    public void setMax(long max) {
        this.max = max;
    }
}

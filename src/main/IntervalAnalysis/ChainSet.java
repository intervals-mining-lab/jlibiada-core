package main.IntervalAnalysis;

import main.Root.IBaseObject;
import main.Root.IBin;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 24.05.11
 * Time: 19:47
 */
public class ChainSet implements IBaseObject {
    protected ArrayList<ChainWithCharacteristic> chains = new ArrayList();

    @Override
    public IBaseObject clone() {
        return null;  //TODO: "Заполнить метод"
    }

    @Override
    public boolean equals(Object obj) {
        return false;  //TODO: "Заполнить метод"
    }

    @Override
    public IBin GetBin() {
        return null;  //TODO: "Заполнить метод"
    }

    public void add(ChainWithCharacteristic ch) {
        chains.add(ch);
    }

    public int size() {
        return chains.size();
    }
}

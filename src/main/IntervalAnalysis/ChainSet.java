package IntervalAnalysis;

import Root.BaseObject;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 24.05.11
 * Time: 19:47
 */
public class ChainSet extends BaseObject {
    protected ArrayList<ChainWithCharacteristic> chains = new ArrayList();

    @Override
    public BaseObject clone() {
        return null;  //TODO: "Заполнить метод"
    }

    @Override
    public boolean equals(Object obj) {
        return false;  //TODO: "Заполнить метод"
    }

    @Override
    public String toString() {
        return null;  //TODO:"Заполни метод!"
    }

    @Override
    public int compareTo(BaseObject object) {
        return 0;  //TODO:"Заполни метод!"
    }

    public void add(ChainWithCharacteristic ch) {
        chains.add(ch);
    }

    public int size() {
        return chains.size();
    }
}

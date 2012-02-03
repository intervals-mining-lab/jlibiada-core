package EventTheory;

import Root.BaseObject;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 30.11.2010
 * Time: 10:20:58
 */
public class ReadRule {
    protected ArrayList vault = new ArrayList();

    public ReadRule(Place place) {
    }

    public BaseObject getValue(int i) {
        return null;
    }

    public void addPlace(Place value) {
    }

    public ReadRule addRule(ReadRule rule) {
        return null;  //TODO: "To code method"
    }

    public long getCount() {
        return vault.size();
    }
}

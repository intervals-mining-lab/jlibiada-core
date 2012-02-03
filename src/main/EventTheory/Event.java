package EventTheory;

import Root.BaseObject;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 30.11.2010
 * Time: 9:08:58
 */
public class Event extends Space {
    public Event() throws Exception {
        super();
    }
    public void addDimension(Dimension dimension)
    {
        super.addDimension(dimension);
    }

    @Override
    public Event clone() {
        return null;  //TODO: "Заполнить метод"
    }

    @Override
    public boolean equals(Object obj) {
        return false;  //TODO: "Заполнить метод"
    }

    public void addToReadRule(Place key, Place value) {
    }

    public void removeFromReadRuleAt(int index) {
    }

    public void removeFromReadRule(Place key) {
    }

    public void addItem(BaseObject value, Place key) {
    }

    public void addToReadRule(Place value, ReadRule rule) {
        //TODO: "To code method"
    }

    public ReadRule getFromReadRule(Place key) throws Exception {
        if (key == null)
        {
            throw new NullPointerException("Null place in getFromReadRule of Event");
        }
        return null;
    }

    public long getReadRuleCount() {
        return 0;
    }
}

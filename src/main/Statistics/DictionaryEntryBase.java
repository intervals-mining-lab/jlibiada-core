package Statistics;

import Root.BaseObject;
import Root.IBin;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 25.01.2011
 * Time: 20:25:02
 */
public class DictionaryEntryBase extends BaseObject {
    private BaseObject key;
    private BaseObject value;

    public DictionaryEntryBase(BaseObject pkey, BaseObject pvalue) {
        key = pkey;
        value = pvalue;
    }

    public BaseObject getKey()
    {
        return key;
    }

    public BaseObject getValue()
    {
        return value;
    }

    public void setKey(BaseObject key)
    {
        this.key = key;
    }

    public void setValue(BaseObject value)
    {
        this.value = value;
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

    public IBin GetBin() {
        return null;  //TODO: "????????? ?????"
    }
}

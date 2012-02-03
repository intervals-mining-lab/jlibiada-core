package EventTheory;

import Root.BaseObject;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 23.01.2011
 * Time: 17:13:20
 */
public class PsevdoValue extends BaseObject {
    private static PsevdoValue singletone = new PsevdoValue();
    
    public static PsevdoValue Instance() {
        return singletone;
    }

    public BaseObject clone() {
        return Instance();
    }

    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass();
    }

    @Override
    public String toString() {
        String s = "";
        s += '-';
        return s;
    }

    @Override
    public int compareTo(BaseObject baseObject) {
        return 0;  //TODO:"??????? ?????!"
    }
}

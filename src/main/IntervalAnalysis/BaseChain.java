package IntervalAnalysis;

import EventTheory.Dimension;
import EventTheory.Space;
import Root.BaseObject;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 11.12.2010
 * Time: 1:22:23
 */
public class BaseChain extends Space {
    public BaseChain(int length) throws Exception {
        ClearAndSetNewLength(length);
    }

    public BaseChain() throws Exception {
        super();
    }

    @Override
    public String toString()
    {
        String s = "";
        for (long obj : vault)
        {
            s += pAlphabet.get((int) obj).toString();
        }
        return s;
    }

    protected void fillFromAnother(BaseChain chain) throws Exception {
        for (int index = 0; index < chain.getLength(); index++) {
            this.add(chain.get(index), index);
        }
    }

    public void add(BaseObject baseObject, int index) throws Exception {
        addItem(baseObject, getPlacePattern().setValues(new long[] {index}));
    }

    public BaseObject get(int pos) {
        int index = vault.get(pos);
        return pAlphabet.get(index);
    }

    public int getLength()
    {
        return getPlaceCount();
    }

    public BaseObject Clone() {
        return null;  //TODO: "????????? ?????"
    }

    public boolean Equals(Object obj) {
        return false;  //TODO: "????????? ?????"
    }

    public void ClearAndSetNewLength(int length) throws Exception
    {
        if (length <= 0)
        {
            throw new Exception("Chain length <= 0");
        }
        deleteDimentions();
        addDimension(new Dimension(0, length - 1));
    }
}

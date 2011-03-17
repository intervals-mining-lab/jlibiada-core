package libiada.Root;

/**
 * Created by IntelliJ IDEA.
 * User: Алексей
 * Date: 30.11.2010
 * Time: 10:11:33
 */
public class ValueInt implements IBaseObject {
    private long value;

    public ValueInt(long i) {
        value = i;
    }

    public IBaseObject Clone() {
        return new ValueInt(value);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean Equals(Object obj) {
        return value == ((ValueInt)obj).getValue();
    }

    public IBin GetBin() {
        return null;  //TODO: "Заполнить метод"
    }

    public long getValue() {
        return value;
    }
}

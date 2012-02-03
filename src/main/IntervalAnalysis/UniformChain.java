package IntervalAnalysis;

import EventTheory.Place;
import IntervalAnalysis.Characteristics.AuxiliaryInterfaces.ICharacteristicCalculator;
import IntervalAnalysis.Characteristics.Characteristic;
import Root.BaseObject;
import Root.SimpleTypes.ValueInt;
import Statistics.FrequencyList;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 11.12.2010
 * Time: 1:39:23
 */
public class UniformChain extends ChainWithCharacteristic {
    public UniformChain(int length, BaseObject message) throws Exception {
        super(length);
        pAlphabet.add(message);
    }

    public void addItem(BaseObject what, Place where) throws Exception
    {
        if (getMessage().equals(what))
        {
            super.addItem(what, where);            
        }
    }

    @Override
    protected void buildIntervals() throws Exception {
        if (!IntervalsChanged) return;

        IntervalsChanged = false;

        pIntervals = new FrequencyList();
        int next = -1;
        FrequencyList IntervalList;
        do
        {
            int current = next;
            next = getRight(current);
            if (next == getLength())
            {
                IntervalList = getFrequancyIntervalList(getLength());
            }
            else
            {
                IntervalList = getFrequancyIntervalList(current);
            }

            IntervalList.add(new ValueInt(next - current));
        }
        while (next != getLength());
    }

    private int getRight(int current) {
        for (int i = current + 1; i < getLength(); i++)
        {
            if (vault.get(i) == getAlpahbet().getPower()-1)
            {
                return i;
            }
        }
        return getLength();
    }

    private FrequencyList getFrequancyIntervalList(int number) {
        if (number == -1)
        {
            return startinterval;
        }
        if (number == getLength())
        {
            return endinterval;
        }
        return pIntervals;
    }

    @Override
    public double injectIntoCharacteristic(Class<? extends ICharacteristicCalculator> calculatorClass, LinkUp link) throws Exception {
        return ((Characteristic) CharacteristicSnapshot.get(calculatorClass)).value(this, link);
    }

    public BaseObject getMessage() {
        return pAlphabet.get(1);
    }
}

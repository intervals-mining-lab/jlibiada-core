package IntervalAnalysis;

import EventTheory.Place;
import IntervalAnalysis.Characteristics.AuxiliaryInterfaces.IChainDataForCalculator;
import IntervalAnalysis.Characteristics.AuxiliaryInterfaces.ICharacteristicCalculator;
import IntervalAnalysis.Characteristics.AuxiliaryInterfaces.IDataForCalculator;
import IntervalAnalysis.Characteristics.Characteristic;
import Root.BaseObject;
import Root.SimpleTypes.ValueChar;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 11.12.2010
 * Time: 1:18:31
 */
public class Chain extends ChainWithCharacteristic implements IChainDataForCalculator {
    protected ArrayList<UniformChain> pUniformChains = new ArrayList<UniformChain>();

    public Chain(int length) throws Exception {
        super(length);
        pAlphabet.remove(0);
    }

    public Chain(String s) throws Exception {
        ClearAndSetNewLength(s.length());
        //pAlphabet.remove(0);
        for (int i = 0; i < s.length(); i++)
        {
            add(new ValueChar(s.charAt(i)), i);
        }
    }

    public UniformChain getIUniformChain(int i) {
        return pUniformChains.get(i);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void ClearAndSetNewLength(int length) throws Exception {
        super.ClearAndSetNewLength(length);
        pUniformChains = new ArrayList();
    }

    public void addItem(BaseObject what, Place where) throws Exception
    {
        super.addItem(what, where);
//        if (pUniformChains.size() != getAlpahbet().getPower())
        if (isNewMessage(what))
        {
            pUniformChains.add(new UniformChain(getLength(), what));
        }
        for (int i = 0; i < pUniformChains.size(); i++)
        {
            pUniformChains.get(i).addItem(what, where);
        }
    }

    private boolean isNewMessage(BaseObject message) {
        for (UniformChain chain : pUniformChains) {
            if (chain.getMessage().equals(message)) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void buildIntervals() throws Exception {
        if (!IntervalsChanged) return;
        IntervalsChanged = false;

        for (int i = 0; i < pUniformChains.size(); i++)
        {
            IDataForCalculator Datainterface = pUniformChains.get(i);
            pIntervals.sum(Datainterface.getCommonIntervals());
            startinterval.sum(Datainterface.getStartInterval());
            endinterval.sum(Datainterface.getEndInterval());
        }
    }

    @Override
    public double injectIntoCharacteristic(Class<? extends ICharacteristicCalculator> calculatorClass, LinkUp link) throws Exception {
        return ((Characteristic) CharacteristicSnapshot.get(calculatorClass)).value(this, link);
    }

    public ChainWithCharacteristic getUniformChain(BaseObject baseObject) {
        return null;  //TODO:"Fill method"
    }

    public ChainWithCharacteristicSet getDecomposition(int wordLength, int step) throws Exception {
        ChainWithCharacteristicSet chSet = new ChainWithCharacteristicSet();
        int currentPos = 0;
        int wordCount = Math.round((getLength() - wordLength) / step);
        /*if (step == 1) {
            wordCount -= (wordLength - 1);
        }*/
        for (int j = 0; j <= wordCount; j++) {
            Chain ch = new Chain(wordLength);
            int newWordPos = 0;
            for (int i = currentPos; i < currentPos + wordLength; i++) {
                ch.add(this.get(i), newWordPos);
                newWordPos++;
            }
            currentPos += step;
            chSet.add(ch);
        }
        return chSet;
    }
}

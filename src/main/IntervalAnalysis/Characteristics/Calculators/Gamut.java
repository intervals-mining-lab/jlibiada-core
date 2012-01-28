package main.IntervalAnalysis.Characteristics.Calculators;

import main.IntervalAnalysis.Chain;
import main.IntervalAnalysis.Characteristics.AuxiliaryInterfaces.ICharacteristicCalculator;
import main.IntervalAnalysis.Characteristics.CharacteristicsFactory;
import main.IntervalAnalysis.LinkUp;
import main.IntervalAnalysis.UniformChain;
import main.Root.SimpleTypes.ValueInt;
import main.Statistics.DictionaryEntryBase;
import main.Statistics.FrequencyList;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 25.01.2011
 * Time: 20:13:46
 */
public class Gamut implements ICharacteristicCalculator {

    public double calculate(UniformChain pChain, LinkUp Link) throws Exception {

        FrequencyList CommonIntervalList = pChain.getCommonIntervals();
        FrequencyList StartInterval = pChain.getStartInterval();
        FrequencyList EndInterval = pChain.getEndInterval();

        double result = 0;
        for (int i = 0; i < CommonIntervalList.getPower(); i++)
        {
            double r1 = ((ValueInt)(((DictionaryEntryBase)CommonIntervalList.get(i)).getValue())).getValue();
            double r2 = ((ValueInt)(((DictionaryEntryBase)CommonIntervalList.get(i)).getKey())).getValue();
            result += r1 * (Math.log10(r2) / (Math.log10(2)));
        }

        switch (Link)
        {
            case Start:
                return result + Math.log(((ValueInt) ((DictionaryEntryBase)StartInterval.get(0)).getKey()).getValue())/Math.log(2);
            case End:
                return result + Math.log(((ValueInt) ((DictionaryEntryBase)EndInterval.get(0)).getKey()).getValue())/Math.log(2);
            case Both:
                return result + Math.log(((ValueInt) ((DictionaryEntryBase)StartInterval.get(0)).getKey()).getValue())/Math.log(2) +
                    Math.log(((ValueInt) ((DictionaryEntryBase)EndInterval.get(0)).getKey()).getValue())/Math.log(2);
            case Circle:
                return result + Math.log(((ValueInt) ((DictionaryEntryBase)StartInterval.get(0)).getKey()).getValue() +
                    ((ValueInt) ((DictionaryEntryBase)EndInterval.get(0)).getKey()).getValue() - 1)/Math.log(2);
            default:
                throw new Exception("Very strange error :)");
        }
    }

    public double calculate(Chain pChain, LinkUp Link) throws Exception {
        double temp = 0;
        for (int i = 0; i < pChain.getAlpahbet().getPower(); i++)
        {
            temp += pChain.getIUniformChain(i).getCharacteristic(Link, CharacteristicsFactory.getG());
        }
        return temp;
    }

    @Override
    public String getName() {
        return "Gamut (delta)";
    }
}

package IntervalAnalysis.Characteristics.Calculators;

import IntervalAnalysis.Chain;
import IntervalAnalysis.Characteristics.AuxiliaryInterfaces.ICharacteristicCalculator;
import IntervalAnalysis.Characteristics.AuxiliaryInterfaces.IDataForCalculator;
import IntervalAnalysis.LinkUp;
import IntervalAnalysis.UniformChain;
import Root.SimpleTypes.ValueInt;
import Statistics.DictionaryEntryBase;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 28.03.11
 * Time: 22:14
 */
public class Length implements ICharacteristicCalculator{
    @Override
    public double calculate(UniformChain pChain, LinkUp Link) throws Exception {
        switch (Link) {
            case Start:
                IDataForCalculator dataStart = pChain;
                return pChain.getLength() - ((ValueInt)((DictionaryEntryBase)(dataStart.getEndInterval().get(0))).getValue()).getValue() + 1;
            case End:
                IDataForCalculator dataEnd = pChain;
                return pChain.getLength() - ((ValueInt)((DictionaryEntryBase)(dataEnd.getStartInterval().get(0))).getValue()).getValue() + 1;
            case Both:
            case Circle:
                return pChain.getLength();
            default:
                throw new Exception("Link up does not identified");
        }
    }

    @Override
    public double calculate(Chain pChain, LinkUp Link) throws Exception {
        return pChain.getLength();
    }

    @Override
    public String getName() {
        return "Length (L)";
    }
}

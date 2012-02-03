package IntervalAnalysis.Characteristics.Calculators;

import IntervalAnalysis.Chain;
import IntervalAnalysis.ChainWithCharacteristic;
import IntervalAnalysis.Characteristics.AuxiliaryInterfaces.ICharacteristicCalculator;
import IntervalAnalysis.Characteristics.AuxiliaryInterfaces.IDataForCalculator;
import IntervalAnalysis.LinkUp;
import IntervalAnalysis.UniformChain;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 28.03.11
 * Time: 22:06
 */
public class Count implements ICharacteristicCalculator {
    @Override
    public double calculate(UniformChain pChain, LinkUp Link) throws Exception {
        return CommonCalculate(pChain);
    }

    @Override
    public double calculate(Chain pChain, LinkUp Link) throws Exception {
        return CommonCalculate(pChain);
    }

    @Override
    public String getName() {
        return "Message count (N)";
    }

    private double CommonCalculate(ChainWithCharacteristic pChain) throws Exception {
        IDataForCalculator data = pChain;
        return data.getCommonIntervals().getCount() + data.getStartInterval().getCount();
    }
}

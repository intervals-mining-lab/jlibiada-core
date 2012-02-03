package IntervalAnalysis.Characteristics.Calculators;

import IntervalAnalysis.Chain;
import IntervalAnalysis.ChainWithCharacteristic;
import IntervalAnalysis.Characteristics.AuxiliaryInterfaces.ICharacteristicCalculator;
import IntervalAnalysis.Characteristics.CharacteristicsFactory;
import IntervalAnalysis.LinkUp;
import IntervalAnalysis.UniformChain;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 23.04.11
 * Time: 15:45
 */
public class Regularity implements ICharacteristicCalculator {
    @Override
    public double calculate(UniformChain pChain, LinkUp Link) throws Exception {
        return CommonCalculate(pChain, Link);
    }

    @Override
    public double calculate(Chain pChain, LinkUp Link) throws Exception {
        return CommonCalculate(pChain, Link);
    }

    private double CommonCalculate(ChainWithCharacteristic pChain, LinkUp link) throws Exception {
        double dg = pChain.getCharacteristic(link, CharacteristicsFactory.getDeltaG());
        double D = pChain.getCharacteristic(link, CharacteristicsFactory.getD());
        return dg / D;
    }

    @Override
    public String getName() {
        return "Regularity (r)";
    }
}

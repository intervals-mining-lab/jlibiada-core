package IntervalAnalysis.Characteristics.Calculators;

import IntervalAnalysis.Chain;
import IntervalAnalysis.Characteristics.AuxiliaryInterfaces.ICharacteristicCalculator;
import IntervalAnalysis.Characteristics.CharacteristicsFactory;
import IntervalAnalysis.LinkUp;
import IntervalAnalysis.UniformChain;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 21.01.2011
 * Time: 22:20:08
 */
public class GeometricMiddling implements ICharacteristicCalculator {
    public double calculate(UniformChain pChain, LinkUp Link) throws Exception {
        double G = pChain.getCharacteristic(Link, CharacteristicsFactory.getG());
        double n_j = pChain.getCharacteristic(Link, CharacteristicsFactory.getIntervalsCount());
        return Math.pow(2, G/n_j);
    }

    public double calculate(Chain pChain, LinkUp Link) throws Exception {
        double G = pChain.getCharacteristic(Link, CharacteristicsFactory.getG());
        double n_j = pChain.getCharacteristic(Link, CharacteristicsFactory.getIntervalsCount());
        return Math.pow(2, G / n_j);
    }

    @Override
    public String getName() {
        return "Geometric middling interval (G)";
    }
}

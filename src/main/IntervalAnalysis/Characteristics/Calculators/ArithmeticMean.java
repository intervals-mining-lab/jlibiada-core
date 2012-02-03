package IntervalAnalysis.Characteristics.Calculators;

import IntervalAnalysis.Chain;
import IntervalAnalysis.Characteristics.AuxiliaryInterfaces.ICharacteristicCalculator;
import IntervalAnalysis.Characteristics.CharacteristicsFactory;
import IntervalAnalysis.LinkUp;
import IntervalAnalysis.UniformChain;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 28.03.11
 * Time: 22:27
 */
public class ArithmeticMean implements ICharacteristicCalculator {
    @Override
    public double calculate(UniformChain pChain, LinkUp Link) throws Exception {
        double n = pChain.getCharacteristic(LinkUp.Both, CharacteristicsFactory.getLength());
        double n_j = pChain.getCharacteristic(LinkUp.Both, CharacteristicsFactory.getN());
        return n/n_j;
    }

    @Override
    public double calculate(Chain pChain, LinkUp Link) throws Exception {
        double result = 0;
        for (int i = 0; i < pChain.getAlpahbet().getPower(); i++) {
            result += pChain.getIUniformChain(i).getCharacteristic(Link,  CharacteristicsFactory.getDeltaA());
        }
        return result / pChain.getAlpahbet().getPower();
    }

    @Override
    public String getName() {
        return "Arithmetic mean";
    }
}

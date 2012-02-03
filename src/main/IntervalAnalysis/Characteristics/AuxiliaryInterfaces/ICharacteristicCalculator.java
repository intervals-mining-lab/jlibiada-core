package IntervalAnalysis.Characteristics.AuxiliaryInterfaces;

import IntervalAnalysis.Chain;
import IntervalAnalysis.LinkUp;
import IntervalAnalysis.UniformChain;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 21.01.2011
 * Time: 21:14:18
 */
public interface ICharacteristicCalculator {
        double calculate(UniformChain pChain, LinkUp Link) throws Exception;

        double calculate(Chain pChain, LinkUp Link) throws Exception;

        String getName();
}

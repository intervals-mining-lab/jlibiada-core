package test.IntervalAnalysis;

import junit.framework.TestCase;
import IntervalAnalysis.Chain;
import IntervalAnalysis.ChainWithCharacteristic;
import IntervalAnalysis.UniformChain;
import Root.SimpleTypes.ValueChar;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 11.12.2010
 * Time: 1:18:55
 */
public class testChainTest extends TestCase {
    private Chain chainBase;

    public void setUp() throws Exception {
        chainBase = new Chain(10);
    }

    public void testSimularChainsGet() throws Exception {
        ValueChar MessageA = new ValueChar('a');
        ValueChar MessageC = new ValueChar('c');
        ValueChar MessageG = new ValueChar('g');
        ValueChar MessageT = new ValueChar('t');
        UniformChain uniformChainA = new UniformChain(10, MessageA);

        chainBase.add(MessageC, 0);

        chainBase.add(MessageC, 1);

        chainBase.add(MessageA, 2);
        uniformChainA.add(MessageA, 2);

        chainBase.add(MessageC, 3);

        chainBase.add(MessageG, 4);

        chainBase.add(MessageC, 5);

        chainBase.add(MessageT, 6);

        chainBase.add(MessageT, 7);

        chainBase.add(MessageA, 8);
        uniformChainA.add(MessageA, 8);

        chainBase.add(MessageC, 9);

        ChainWithCharacteristic ChainCreatedUniformChain = chainBase.getUniformChain(MessageA);

        assertEquals(uniformChainA, ChainCreatedUniformChain);
    }
}

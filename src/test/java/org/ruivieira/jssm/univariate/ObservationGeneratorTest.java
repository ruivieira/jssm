package org.ruivieira.jssm.univariate;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.junit.Test;
import org.ruivieira.jssm.common.Structure;

import static org.junit.Assert.assertEquals;

public class ObservationGeneratorTest {

    @Test
    public void gaussian_locallyconstant() {

        final int nobs = 100;

        final Structure structure = UnivariateStructure.createLocallyConstant();

        final RealVector[] states = StageGenerator.states(nobs, structure, new ArrayRealVector(1));
        final RealVector[] observations = ObservationGenerator.gaussian(states, structure, 1.0);

        assertEquals(nobs, observations.length);
    }

    @Test
    public void gaussian_locallylinear() {

        final int nobs = 100;

        final Structure structure = UnivariateStructure.createLocallyLinear();

        final RealVector[] states = StageGenerator.states(nobs, structure, new ArrayRealVector(2));
        final RealVector[] observations = ObservationGenerator.gaussian(states, structure, 1.0);

        assertEquals(nobs, observations.length);
    }

}
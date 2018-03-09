package org.ruivieira.jssm.univariate;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.junit.Test;
import org.ruivieira.jssm.common.Structure;

import static org.apache.commons.math3.linear.MatrixUtils.createRealIdentityMatrix;
import static org.junit.Assert.*;

public class StageGeneratorTest {

    @Test
    public void states_nobs() {

        final int nobs = 100;

        final Structure structure = new Structure(createRealIdentityMatrix(1),
                createRealIdentityMatrix(1),
                createRealIdentityMatrix(1));

        final RealVector[] states = StageGenerator.states(nobs, structure, new ArrayRealVector(1));

        assertEquals(states.length, nobs);
    }

    @Test
    public void states_dimensions() {

        final int nobs = 10;

        final Structure structure = new Structure(createRealIdentityMatrix(1),
                createRealIdentityMatrix(1),
                createRealIdentityMatrix(1));

        final RealVector[] states = StageGenerator.states(nobs, structure, new ArrayRealVector(1));

        assertEquals(states[0].getDimension(), 1);
    }

}
package org.ruivieira.jssm.examples;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.ruivieira.jssm.common.Structure;
import org.ruivieira.jssm.univariate.ObservationGenerator;
import org.ruivieira.jssm.univariate.StageGenerator;
import org.ruivieira.jssm.univariate.UnivariateStructure;

public class UnivariatePoissonCase {

    public static void main(String[] args) {
        final int nobs = 100;

        final Structure structure = UnivariateStructure.createLocallyConstant();

        final RealVector[] states = StageGenerator.states(nobs, structure, new ArrayRealVector(1));
        final RealVector[] observations = ObservationGenerator.poisson(states, structure);

        for (RealVector y : observations) {
            System.out.println(y);
        }

    }
}

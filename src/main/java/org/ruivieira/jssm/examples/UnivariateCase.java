package org.ruivieira.jssm.examples;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.ruivieira.jssm.common.Structure;
import org.ruivieira.jssm.univariate.ObservationGenerator;
import org.ruivieira.jssm.univariate.StageGenerator;
import org.ruivieira.jssm.univariate.UnivariateStructure;

public class UnivariateCase {

    public static void main(String[] args) {
        final int nobs = 5000;

        final Structure structure = UnivariateStructure.createLocallyConstant();

        final RealVector[] states = StageGenerator.states(nobs, structure, new ArrayRealVector(1));
        final RealVector[] observations = ObservationGenerator.gaussian(states, structure, 1.0);

        for (RealVector y : observations) {
            System.out.println(y);
        }

    }
}

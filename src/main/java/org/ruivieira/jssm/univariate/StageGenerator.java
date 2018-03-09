package org.ruivieira.jssm.univariate;

import org.apache.commons.math3.distribution.MultivariateNormalDistribution;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.ruivieira.jssm.common.Structure;

public class StageGenerator {

    public static RealVector[] states(int nobs,
                         Structure structure,
                         RealVector state0) {

        final RealVector[] states = new RealVector[nobs];

        for (int i = 0 ; i < nobs ; i++) {
            final double[] mean;

            if (i == 0) {
                mean = state0.toArray();
            }  else {
                mean = states[i - 1].toArray();
            }
            final double[][] covariance = structure.getW().getData();
            states[i] = new ArrayRealVector(new MultivariateNormalDistribution(mean, covariance).sample());
        }

        return states;
    }

}

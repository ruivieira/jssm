package org.ruivieira.jssm.univariate;

import org.apache.commons.math3.distribution.MultivariateNormalDistribution;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.ruivieira.jssm.common.Structure;

import static org.apache.commons.math3.linear.MatrixUtils.createRealVector;

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
                mean = structure.getG().preMultiply(states[i - 1]).toArray();
            }
            final double[][] covariance = structure.getW().getData();
            states[i] = new ArrayRealVector(new MultivariateNormalDistribution(mean, covariance).sample());
        }

        return states;
    }

    public static RealVector advance(RealVector state,
                                     Structure structure) {

        final double[] mean = structure.getG().preMultiply(state).toArray();
        final double[] mean1 = new MultivariateNormalDistribution(mean, structure.getW().getData()).sample();

        return createRealVector(mean1);

    }

}

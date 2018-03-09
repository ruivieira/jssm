package org.ruivieira.jssm.univariate;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.ruivieira.jssm.common.Structure;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.apache.commons.math3.linear.MatrixUtils.createRealVector;

public class ObservationGenerator {

    public static RealVector[] gaussian(RealVector[] states,
                                        Structure structure,
                                        double V) {

        final RealMatrix Ft = structure.getF().transpose();

        final Stream<RealVector> means = Arrays.stream(states).map(Ft::preMultiply);

        return means.map(mean -> createRealVector(new double[]{new NormalDistribution(mean.getEntry(0), V)
                .sample()}))
                .toArray(RealVector[]::new);

    }

}

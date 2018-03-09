package org.ruivieira.jssm.univariate;

import org.apache.commons.math3.linear.RealMatrix;
import org.ruivieira.jssm.common.Structure;

import static org.apache.commons.math3.linear.MatrixUtils.createColumnRealMatrix;
import static org.apache.commons.math3.linear.MatrixUtils.createRealIdentityMatrix;
import static org.apache.commons.math3.linear.MatrixUtils.createRealMatrix;

public class UnivariateStructure {

    final private static double DEFAULT_W = 1.0;

    public static Structure createLocallyConstant(double W) {

        // TODO: Sanity check on W dimensions

        return new Structure(createRealIdentityMatrix(1),
                createRealIdentityMatrix(1),
                createRealIdentityMatrix(1).scalarMultiply(W));

    }

    public static Structure createLocallyConstant() {
        return createLocallyConstant(DEFAULT_W);
    }

    public static Structure createLocallyLinear(RealMatrix W) {

        // TODO: Sanity check on W dimensions

        final RealMatrix F = createColumnRealMatrix(new double[]{1.0, 0.0});
        final RealMatrix G = createRealMatrix(new double[][]{{1.0, 1.0},{0.0, 1.0}});

        return new Structure(F, G, W);
    }

    public static Structure createLocallyLinear() {
        return createLocallyLinear(createRealIdentityMatrix(2));
    }


}


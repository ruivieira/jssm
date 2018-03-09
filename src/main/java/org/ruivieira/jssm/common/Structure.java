package org.ruivieira.jssm.common;

import org.apache.commons.math3.linear.RealMatrix;

import static org.ruivieira.jssm.common.MatrixUtils.blockDiagonal;
import static org.ruivieira.jssm.common.MatrixUtils.verticalCat;

public class Structure {

    private RealMatrix F;
    private RealMatrix G;

    private RealMatrix W;

    public Structure(RealMatrix F, RealMatrix G, RealMatrix W) {
        this.F = F;
        this.G = G;
        this.W = W;
    }

    public Structure add(Structure another) {

        final RealMatrix newF = verticalCat(this.F, another.F);
        final RealMatrix newG = blockDiagonal(this.G, another.G);
        final RealMatrix newW = blockDiagonal(this.W, another.W);

        return new Structure(newF, newG, newW);
    }

    public RealMatrix getW() {
        return W;
    }

    public RealMatrix getF() {
        return F;
    }

    public RealMatrix getG() {
        return G;
    }

}

package org.ruivieira.jssm.univariate;

import org.apache.commons.math3.linear.RealMatrix;
import org.junit.Test;
import org.ruivieira.jssm.common.Structure;

import static junit.framework.TestCase.assertEquals;
import static org.apache.commons.math3.linear.MatrixUtils.createRealIdentityMatrix;


public class UnivariateStructureTest {

    @Test
    public void createLocallyConstant_default() {
        final Structure lc = UnivariateStructure.createLocallyConstant();

        assertEquals(lc.getW().getData()[0][0], 1.0);
    }

    @Test
    public void createLocallyConstant_specific() {
        final Structure lc = UnivariateStructure.createLocallyConstant(2.3);

        assertEquals(lc.getW().getData()[0][0], 2.3);
    }
    @Test
    public void createLocallyConstant_dimensions() {
        final Structure lc = UnivariateStructure.createLocallyConstant(2.3);

        RealMatrix W = lc.getW();

        assertEquals(W.getColumnDimension(), 1);
        assertEquals(W.getRowDimension(), 1);
    }

    @Test
    public void createLocallyLinear_F_dimensions() {
        final Structure ll = UnivariateStructure.createLocallyLinear();

        final RealMatrix F = ll.getF();

        assertEquals(F.getRowDimension(), 2);
        assertEquals(F.getColumnDimension(), 1);
    }

    @Test
    public void createLocallyLinear_G_dimensions() {
        final Structure ll = UnivariateStructure.createLocallyLinear();

        final RealMatrix G = ll.getG();

        assertEquals(G.getRowDimension(), 2);
        assertEquals(G.getColumnDimension(), 2);
    }

    @Test
    public void createLocallyLinear_W_dimensions_default() {
        final Structure ll = UnivariateStructure.createLocallyLinear();

        final RealMatrix W = ll.getW();

        assertEquals(W.getRowDimension(), 2);
        assertEquals(W.getColumnDimension(), 2);
    }

    @Test
    public void createLocallyLinear_W_dimensions_provided() {

        final RealMatrix W = createRealIdentityMatrix(2).scalarMultiply(2.3);

        final Structure ll = UnivariateStructure.createLocallyLinear(W);

        assertEquals(W.getRowDimension(), 2);
        assertEquals(W.getColumnDimension(), 2);
        assertEquals(W.getEntry(0,0), 2.3);
    }


    @Test
    public void add_locallylinear_dimensions_F() {
        final Structure lc = UnivariateStructure.createLocallyConstant();
        final Structure ll = UnivariateStructure.createLocallyLinear();

        final Structure combined = lc.add(ll);

        assertEquals(combined.getF().getRowDimension(), 3);
        assertEquals(combined.getF().getColumnDimension(), 1);
    }

    @Test
    public void add_locallylinear_dimensions_G() {
        final Structure lc = UnivariateStructure.createLocallyConstant();
        final Structure ll = UnivariateStructure.createLocallyLinear();

        final Structure combined = lc.add(ll);

        assertEquals(3, combined.getG().getRowDimension());
        assertEquals(3, combined.getG().getColumnDimension());
    }

    @Test
    public void add_locallylinear_dimensions_W() {
        final Structure lc = UnivariateStructure.createLocallyConstant();
        final Structure ll = UnivariateStructure.createLocallyLinear();

        final Structure combined = lc.add(ll);

        assertEquals(3, combined.getW().getRowDimension());
        assertEquals(3, combined.getW().getColumnDimension());
    }

}
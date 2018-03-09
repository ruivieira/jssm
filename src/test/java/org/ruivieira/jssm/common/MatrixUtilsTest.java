package org.ruivieira.jssm.common;

import org.apache.commons.math3.linear.RealMatrix;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.apache.commons.math3.linear.MatrixUtils.createRealMatrix;
import static org.ruivieira.jssm.common.MatrixUtils.*;

public class MatrixUtilsTest {

    @Test
    public void verticalCat_simple() {

        final RealMatrix A = createRealMatrix(5, 3);
        final RealMatrix B = createRealMatrix(3, 3);

        final RealMatrix C = verticalCat(A, B);

        assertEquals(3, C.getColumnDimension());
        assertEquals(8, C.getRowDimension());

    }

    @Test
    public void horizontalCat_simple() {
        final RealMatrix A = createRealMatrix(2, 7);
        final RealMatrix B = createRealMatrix(2, 4);

        final RealMatrix C = horizontalCat(A, B);

        assertEquals(11, C.getColumnDimension());
        assertEquals(2, C.getRowDimension());
    }

    @Test
    public void blockDiagonal_simple() {

        final RealMatrix A = createRealMatrix(2, 2).scalarAdd(1.0);
        final RealMatrix B = createRealMatrix(5, 5).scalarAdd(2.0);

        final RealMatrix C = blockDiagonal(A, B);

        System.out.println(C);

        assertEquals(7, C.getColumnDimension());
        assertEquals(7, C.getRowDimension());

    }
}
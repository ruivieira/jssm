package org.ruivieira.jssm.common;

import org.apache.commons.math3.linear.RealMatrix;

import static org.apache.commons.math3.linear.MatrixUtils.createRealMatrix;

public class MatrixUtils {

    public static RealMatrix verticalCat(RealMatrix A, RealMatrix B) {
        // TODO: Check they have the same number of columns
        final int rows_A = A.getRowDimension();
        final int rows_B = B.getRowDimension();
        final int cols = A.getColumnDimension();

        final double[][] data = new double[rows_A + rows_B][cols];

        for (int i = 0 ; i < rows_A ; i ++) {
            data[i] = A.getRow(i);
        }

        for (int i = rows_A ; i < (rows_A+rows_B) ; i++) {
            data[i] = B.getRow(i-rows_A);
        }

        return createRealMatrix(data);
    }

    public static RealMatrix horizontalCat(RealMatrix A, RealMatrix B) {
        // TODO: Check they have the same number of columns
        final int cols_A = A.getColumnDimension();
        final int cols_B = B.getColumnDimension();
        final int total_cols = cols_A + cols_B;

        final int rows = A.getRowDimension();



        final RealMatrix block = createRealMatrix(rows, total_cols);

        for (int i = 0 ; i < cols_A ; i++) {
            block.setColumn(i, A.getColumn(i));
        }
        for (int i = cols_A ; i < total_cols ; i++) {
            block.setColumn(i, B.getColumn(i - cols_A));
        }

        return block.copy();

    }

    public static RealMatrix blockDiagonal(RealMatrix A, RealMatrix B) {
        // TODO: check if it is a square matrix

        final RealMatrix A_pad = createRealMatrix(A.getRowDimension(), B.getColumnDimension());
        final RealMatrix B_pad = createRealMatrix(B.getRowDimension(), A.getColumnDimension());

        final RealMatrix new_A = horizontalCat(A, A_pad);
        final RealMatrix new_B = horizontalCat(B_pad, B);

        return verticalCat(new_A, new_B);

    }

}

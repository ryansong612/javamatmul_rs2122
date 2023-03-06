package uk.ac.imperial.matrixmult;


public class MatrixBuilder {

  public static Matrix build(double[][] source) {

    int nRows = source.length;

    int nCols = source[0].length;

    ConcurrentMatrix matrix = new ConcurrentMatrix(nRows, nCols);

    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < nCols; j++) {
        matrix.set(i, j, source[i][j]);
      }
    }
    return matrix;
  }

  public static Matrix build(int nRows, int nCols) {

    ConcurrentMatrix matrix = new ConcurrentMatrix(nRows, nCols);

    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < nCols; j++) {
        matrix.set(i, j, 0);
      }
    }
    return matrix;
  }
}

package uk.ac.imperial.matrixmult;

public class MatrixMultiplier {

  public static Matrix multiply(Matrix a, Matrix b) throws Exception {

    if (a.getNumColumns() != b.getNumRows()) {
      throw new Exception("Cannot multiply due to invalid dimensions.");
    }

    Matrix result = new ConcurrentMatrix(a.getNumRows(), b.getNumColumns());

    // rows fo first  * columns of second
    for (int r = 0; r < a.getNumRows(); r++) {
      for (int c = 0; c < b.getNumColumns(); c++) {
        double dotProduct = 0;
        for (int i = 0; i < a.getNumColumns(); i++) {
          dotProduct += a.get(r, i) * b.get(i, c);
        }
        result.set(r, c, dotProduct);
      }
    }
    return result;
  }
}

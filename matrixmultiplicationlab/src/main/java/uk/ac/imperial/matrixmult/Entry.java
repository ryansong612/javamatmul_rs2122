package uk.ac.imperial.matrixmult;

import java.util.Objects;

public class Entry {

  public final Integer column;

  public final Integer row;

  public Entry(int column, int row) {
    this.column = column;
    this.row = row;
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof Entry)
        && (Objects.equals(((Entry) o).row, row))
        && Objects.equals(((Entry) o).column, column);
  }

  @Override
  public int hashCode() {
    int hc = 1;
    hc = 31 * hc + row.hashCode();
    hc = 31 * hc + column.hashCode();
    return hc;
  }

  @Override
  public String toString() {
    return "(" + column + ", " + row + ")";
  }
}

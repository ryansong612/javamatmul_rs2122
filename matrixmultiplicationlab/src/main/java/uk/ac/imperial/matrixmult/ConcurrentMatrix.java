package uk.ac.imperial.matrixmult;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMatrix implements Matrix {

  public int columns;

  public int rows;

  ConcurrentMap<Entry, Double> representation = new ConcurrentHashMap<>();

  public ConcurrentMatrix(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
  }

  @Override
  public double get(int row, int column) {
    if (row < 0 || row >= rows || column < 0 || column >= columns) {
      throw new IndexOutOfBoundsException();
    }
    Entry find = new Entry(row, column);
    return representation.get(find);
  }

  @Override
  public void set(int row, int column, double value) {
    if (row < 0 || row >= rows || column < 0 || column >= columns) {
      throw new IndexOutOfBoundsException();
    }
    Entry location = new Entry(row, column);
    if (representation.containsKey(location)) {
      representation.replace(location, value);
    } else {
      representation.put(location, value);
    }
  }

  @Override
  public int getNumRows() {
    return rows;
  }

  @Override
  public int getNumColumns() {
    return columns;
  }

  @Override
  public String toString() {
    return representation.toString();
  }
}

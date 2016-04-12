package project.Calculator;

import java.util.Random;

/**
 * Created by vladi_000 on 1/29/2016.
 */
public class Matrix {

    final private int rows;
    final private int columns;
    private int maxLengthOfValue = 0;
    final private double[][] matrix;
    private static final double rangeMin = -10000;
    private static final double rangeMax = 10000;


    public Matrix(int rows, int columns) throws IndexOutOfBoundsException {
        this.columns = columns;
        this.rows = rows;
        this.matrix = new double[rows][columns];
    }

    public Matrix(int rows, int columns, Random random) throws IndexOutOfBoundsException {
        this(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                setElement(i,j,rangeMin + (rangeMax - rangeMin) * random.nextDouble());
            }
        }
    }

    public double getElement(int rowNum, int columnsNum) {
        return matrix[rowNum][columnsNum];
    }

    public void setElement(int rowNum, int columnsNum, double value) throws IndexOutOfBoundsException {
        maxLengthOfValue = String.valueOf(matrix[rowNum][columnsNum]).length();
        matrix[rowNum][columnsNum] = value;
    }

    public int getRowsNumber() {
        return rows;

    }

    public int getColumnsNumber() {
        return columns;
    }


    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                stringBuilder.append(String.format("%1$" + maxLengthOfValue + 5 + "s" ,String.valueOf(matrix[i][j])));
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

}

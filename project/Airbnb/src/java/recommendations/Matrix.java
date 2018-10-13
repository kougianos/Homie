/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendations;

import java.util.HashSet;

/**
 *
 * @author kougi
 */
public class Matrix {

    private int rows;
    private int columns;
    private float[][] data;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        data = new float[rows][];
        for (int i = 0; i < rows; i++) {
            data[i] = new float[columns];
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = -1;
            }
        }
    }

    public void cleanup() {
        data = null;
    }

    public void normalize() {
        float avg = 0;
        int p = 0;

        for (int i = 0; i < rows; i++) {
            avg = p = 0;
            for (int j = 0; j < columns; j++) {
                if (data[i][j] != -1) {
                    avg += data[i][j];
                    p++;
                }
            }
            if (p > 0) {
                avg /= p;
            }
            for (int j = 0; j < columns; j++) {
                if (data[i][j] != -1) {
                    data[i][j] -= avg;
                } else {
                    data[i][j] = 0;
                }
            }
        }
    }

    public float norm(int row) {
        float norm = 0;        
        for (int j = 0; j < columns; j++) {
            norm += Math.pow(data[row][j], 2);
        }
        return (float) Math.sqrt(norm);
    }
    
    public float product(int row1, int row2) {
        float product = 0;        
        
        for (int j = 0; j < columns; j++) {
            product += data[row1][j]*data[row2][j];
        }
        return product;
    }

    public HashSet<Integer> getUnknownColumns(int row) {
        HashSet<Integer>  set = new HashSet<Integer> ();
        
        for (int j = 0; j < columns; j++) {
            if (data[row][j] == -1) {
                set.add(j);
            }
        }
        return set;
    }
    
    public float similarity(int row1, int row2) {
        if (row1 == row2) {
            return 1;
        } else {
            float norm1 = norm(row1);
            float norm2 = norm(row2);
            
            if (norm1*norm2 == 0) {
                return 0;
            } else {
                float sim = product(row1, row2)/(norm1*norm2);
                return sim;
            }
        }
    }
    
    public float collaboration(int row, int col) {
        float estimation = 0;
        for (int i = 0; i < rows; i++) {
            if (i != row) {
                float rate = data[i][col];
                float sim = similarity(i, row);
                float p = rate*sim;
              
                estimation = estimation + p;
            }
        }
        return estimation;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public float[][] getData() {
        return data;
    }

    public void setData(float[][] data) {
        this.data = data;
    }
    
    
}

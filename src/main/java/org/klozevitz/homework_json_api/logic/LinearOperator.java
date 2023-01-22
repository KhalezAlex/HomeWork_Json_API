package org.klozevitz.homework_json_api.logic;

public class LinearOperator {
    private double[][] operator;

    public double[][] getOperator() {
        return operator;
    }

    public void setOperator(double[][] operator) {
        this.operator = operator;
    }

    public LinearOperator(double[][] operator) {
        this.operator = operator;
    }

    public LinearOperator() {};

// linear operator addition operation
    public void sum(LinearOperator lo) {
        for (int i = 0; i < this.operator.length; i++)
            for (int j = 0; j < this.operator[0].length; j ++)
                this.operator[i][j] += lo.getOperator()[i][j];
    }

// linear operator subtraction operation
    public void diff(LinearOperator lo) {
        for (int i = 0; i < this.operator.length; i++)
            for (int j = 0; j < this.operator[0].length; j ++)
                this.operator[i][j] -= lo.getOperator()[i][j];
    }

// linear operator multiplication operation
    public void multiply(LinearOperator lo) {
        if (this.operator.length != 1 && lo.getOperator().length != 1)
            linearMultiply(lo);
        else
            scalarMultiply(lo);
    }

// linear multiplication
    private void linearMultiply(LinearOperator lo) {
        double[][] multiply = new double[this.operator.length][this.operator.length];
        for (int i = 0; i < this.operator.length; i++)
            for (int j = 0; j < this.operator.length; j ++)
                for (int k = 0; k < this.operator[0].length; k++)
                    multiply[i][j] += lo.getOperator()[k][j] * this.operator[i][k];
        this.operator = multiply;
    }

// scalar multiplication
    private void scalarMultiply(LinearOperator lo) {
        double m;
        if (lo.getOperator().length == 1)
            m = lo.getOperator()[0][0];
        else {
            m = this.operator[0][0];
            this.operator = lo.getOperator();
        }
        for (int i = 0; i < this.operator.length; i++)
            for (int j = 0; j < this.operator[0].length; j++)
                this.operator[i][j] *= m;
    }

//get 0-j minor for determinant method
    private LinearOperator minor0J(LinearOperator lo, int indexJ) {
        double[][] minor = new double[lo.getOperator().length - 1][lo.getOperator().length - 1];
        int indI = 0;
        int indJ;
        for (int i = 0; i < lo.getOperator().length; i++) {
            indJ = 0;
            if (i != 0) {
                for (int j = 0; j < lo.getOperator().length; j++)
                    if (j != indexJ) {
                        minor[indI][indJ] = lo.getOperator()[i][j];
                        indJ++;
                    }
                indI++;
            }
        }
        return new LinearOperator(minor);
    }

//linear operator determinant
    public double determinant() {
        int determinant = 0;
        if (this.operator.length == 1)
            return this.operator[0][0];
        for (int j = 0; j < this.operator.length; j++)
            determinant += Math.pow(-1, j) * this.operator[0][j] * minor0J(this, j).determinant();
        return determinant;
    }

    @Override
    public String toString() {
        String str = "{";
        for (double[] doubles : this.operator) {
            for (int j = 0; j < this.operator[0].length; j++)
                str = str.concat(doubles[j] + ", ");
            str = str.substring(0, str.length() - 2).concat("\n");
        }
        return str.substring(0, str.length() - 1).concat("}");
    }
}
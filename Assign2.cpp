//Addition Subraction multipilcation on metrices


#include <iostream>

using namespace std;

int main() {
    int row1, col1, row2, col2;

    // Get dimensions of the matrices
    cout << "Enter dimensions of matrix 1 (row col): ";
    cin >> row1 >> col1;
    cout << "Enter dimensions of matrix 2 (row col): ";
    cin >> row2 >> col2;

    // Check if matrix operations are possible
    if (col1 != row2) {
        cout << "Matrix multiplication not possible!" << endl;
        return 1;
    }

    // Declare matrices
    int matrix1[row1][col1], matrix2[row2][col2], result[row1][col2];

    // Get matrix 1
    cout << "Enter elements of matrix 1:" << endl;
    for (int i = 0; i < row1; i++) {
        for (int j = 0; j < col1; j++) {
            cin >> matrix1[i][j];
        }
    }

    // Get matrix 2
    cout << "Enter elements of matrix 2:" << endl;
    for (int i = 0; i < row2; i++) {
        for (int j = 0; j < col2; j++) {
            cin >> matrix2[i][j];
        }
    }

    // Addition
    if (row1 == row2 && col1 == col2) {
        cout << "Addition Result:" << endl;
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
                cout << result[i][j] << " ";
            }
            cout << endl;
        }
    } else {
        cout << "Addition not possible!" << endl;
    }

    // Subtraction
    if (row1 == row2 && col1 == col2) {
        cout << "Subtraction Result:" << endl;
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
                cout << result[i][j] << " ";
            }
            cout << endl;
        }
    } else {
        cout << "Subtraction not possible!" << endl;
    }

    // Multiplication
    cout << "Multiplication Result:" << endl;
    for (int i = 0; i < row1; i++) {
        for (int j = 0; j < col2; j++) {
            result[i][j] = 0;
            for (int k = 0; k < col1; k++) {
                result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
            cout << result[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}

#include <iostream>
using namespace std;

#define MAX 100  // Maximum size for the arrays

int max(int m, int n) { return (m > n) ? m : n; }

int* add(int A[], int B[], int m, int n)
{
    static int sum[MAX]; // Use static to ensure the array is not deallocated after function returns
    int size = max(m, n);

    for (int i = 0; i < size; i++) {
        sum[i] = 0;  // Initialize sum array elements to 0
    }

    for (int i = 0; i < m; i++)
        sum[i] = A[i];

    for (int i = 0; i < n; i++)
        sum[i] += B[i];

    return sum;
}

void printPoly(int poly[], int n)
{
    for (int i = 0; i < n; i++) {
        cout << poly[i];
        if (i != 0)
            cout << "x^" << i;
        if (i != n - 1)
            cout << " + ";
    }
}

int main()
{
    int A[MAX], B[MAX];
    int m, n;

    // Get input for first polynomial
    cout << "Enter the degree of the first polynomial: ";
    cin >> m;
    cout << "Enter the coefficients of the first polynomial (from constant term to highest degree): ";
    for (int i = 0; i <= m; i++) {
        cin >> A[i];
    }

    // Get input for second polynomial
    cout << "Enter the degree of the second polynomial: ";
    cin >> n;
    cout << "Enter the coefficients of the second polynomial (from constant term to highest degree): ";
    for (int i = 0; i <= n; i++) {
        cin >> B[i];
    }

    cout << "First polynomial is \n";
    printPoly(A, m + 1);
    cout << "\nSecond polynomial is \n";
    printPoly(B, n + 1);

    int* sum = add(A, B, m + 1, n + 1);
    int size = max(m + 1, n + 1);

    cout << "\nSum polynomial is \n";
    printPoly(sum, size);

    return 0;
}

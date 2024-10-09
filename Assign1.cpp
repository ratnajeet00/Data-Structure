#include <iostream>
using namespace std;


int max(int m, int n) { return (m > n) ? m : n; }


int* add(int A[], int B[], int m, int n)
{
    int size = max(m, n);
    int* sum = new int[size];

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
	int i=0;
  
    int A[4];
    cout<<"Enter poly 1";
    for(i=0; i<4;i++){
		cin>>A[i];
	}
	

   
    int B[4];
    cout<<"Enter poly 2";
	for(i=0; i<4;i++){
		cin>>B[i];
	}
	

    cout << "First polynomial is \n";
    printPoly(A, 4);
    cout << "\nSecond polynomial is \n";
    printPoly(B, 4);

    int* sum = add(A, B, 4, 4);
    int size = max(4, 4);

    cout << "\nsum polynomial is \n";
    printPoly(sum, size);
	return 0;
}



#include<iostream>
using namespace std;
int main(){
	int a[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
	int key,low,high=30;
	int mid,flag=0;
	cout<<"Enter Key to Find";
	cin>>key;
	while(low<=high){
		mid=(high+low)/2;
		cout<<mid<<" ";
		if(a[mid]==key){
			flag+=1;
			break;
		}
		else if(a[mid]>key){
			high=mid-1;
		}
		else{
			low=mid+1;
		}
	}
	if(flag!=0){
		cout<<"Key found at:"<<mid;
	}
	else{
		cout<<"wrong key";
	}
	
}

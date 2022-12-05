//https://cses.fi/problemset/task/1645?fbclid=IwAR3y_pF3kcFfdLRckDEl6mp4atiEbhDeXU7rh0X01o_SyQc5rkRpRw34fzQ
#include<bits/stdc++.h>
using namespace std;

int n;

int main() {
	cin >> n;
	int arr [n + 1];
	arr[0] = 0;
	for(int i = 1; i <= n; i++){
		cin >> arr[i];
	}
	stack<int> myStack;
	myStack.push(0);
	
	for(int i = 1; i <= n ; i++){
		int top = myStack.top();
		while(arr[top] >= arr[i]){
			myStack.pop();
			top = myStack.top();
		}
		cout << top << " ";
		myStack.push(i);		
	}
		
	return 0;
}



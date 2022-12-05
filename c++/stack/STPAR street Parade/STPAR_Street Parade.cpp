#include<bits/stdc++.h>

using namespace std;

void solve() {
	while(true) {
		int n; 
    	cin >> n;
    	if (n == 0) {
      		return; 
    	}
    	int arr[n+1];
    	for(int i=1; i<= n; i++){
    		cin >> arr[i];
		}
		
		int currentTruck = 1;
		stack<int> mystack;
		for(int i=1; i<=n; i++){
			while(mystack.empty() == false && mystack.top() == currentTruck){
				mystack.pop();
				currentTruck++;
			}
			if(currentTruck != arr[i]){
				mystack.push(arr[i]);
			}else{
				currentTruck++;
			}
		}
		
		while (mystack.empty() == false && mystack.top() == currentTruck) {
      		currentTruck++; 
      		mystack.pop();
    	}
    	if (currentTruck > n) {
      		cout << "yes" << endl; 
    	}
    	else {
      		cout << "no" << endl; 
    	}
	}
}

int main(){
	
	solve();
	return 0;
}

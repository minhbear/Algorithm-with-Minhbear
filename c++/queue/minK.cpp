//https://oj.vnoi.info/problem/mink

#include<iostream>
#include<deque>

using namespace std;

int numTest; 
int n, k; 
int a[17005];

int main() {
	cin >> numTest;
	for(int i=1; i<=numTest; i++){
		cin >> n >> k;
		for(int i=1; i<=n; i++){
			cin >> a[i];
		}
		deque<int> dq;
		for(int i=1; i<=k; i++){
			while(!dq.empty() && a[i]<dq.back()){
				dq.pop_back();
			}
			dq.push_back(a[i]);
		}
		cout << dq.front() << ' '; 
		for(int i=k+1; i<=n; i++){
			if(a[i-k] == dq.front()){
				dq.pop_front();
			}
			while(!dq.empty() && a[i]<dq.back()){
				dq.pop_back();
			}
			dq.push_back(a[i]);
			cout << dq.front() << ' ';
		}
		std::cout << std::endl; 
	}
	
	return 0;
}

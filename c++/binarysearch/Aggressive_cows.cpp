// https://www.spoj.com/problems/AGGRCOW/fbclid=IwAR1JlvzIM1RCYMzYQtiY9CW6iNmi_HgTLhXPHty1ft4q7R2__3mt3XmUTvM
#include<bits/stdc++.h>
using namespace std;

int N,C, numTest;
int arr[100005];

int main() {
	cin >> numTest;
	while(numTest > 0){
		cin >> N >> C;
		
		for(int i=1; i<= N; i++){
			cin >> arr[i];
		}
		sort(arr+1, arr+N+1);
		
		int l=1, r=1000000000;
		int ans;
		while(l<=r){
			int mid = (l+r)/2;
			int lastPosition = arr[1];
			int numbCows=1;
			for(int i=2; i<= N; i++){
				if(arr[i]-lastPosition >= mid){
					numbCows++;
					lastPosition = arr[i];
				}
			}
			if(numbCows >= C){
				ans = mid;
				l = mid+1;
			}else{
				r = mid-1;
			}
		}
		cout << ans << endl;
		numTest--;
		
	}
	
	return 0;
}

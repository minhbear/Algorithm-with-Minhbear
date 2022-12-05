//https://oj.vnoi.info/problem/move12?fbclid=IwAR0A3IGbAE8IfYRXF9flGcyEimCyhJCTDLFGK_5KzqgbmWrAsfabx1JT_fo
#include <iostream>
#include <algorithm>
#include <queue>
#include <functional>
#include <utility>
#include <math.h>

using namespace std;

struct police {
	int column;
	int speed;
};
police a[10005];
int n;

//check police verify time to move
bool check(vector < pair <int, int> > &a){
	sort(a.begin(), a.end());
	priority_queue <int, vector <int>, greater<int> > pq;
	int p = 0;
	for(int column=1; column <= n; column++){
		while(!pq.empty()){
			if(pq.top() < column){
				pq.pop();
			}
			else{
				break;
			}
		}
		while (p<n && a[p].first <= column){
			pq.push(a[p].second);
			p++;
		}
		if(pq.empty() == true){
			return false;
		}else{
			pq.pop();
		}
	}
	return true;
}

int main() {
	cin >> n;
	for(int i=1; i<=n; i++){
		cin >> a[i].column >> a[i].speed;
	}
	
	int lo=0;
	int hi=100000007;
	int ans=-1;
	while(lo<=hi){
		int mid = (lo+hi)/2;
		vector <pair <int, int> > segment;
		for(int i=1; i<=n; i++){
			segment.push_back(make_pair(max(1, a[i].column-mid/a[i].speed), min(n, a[i].column + mid / a[i].speed)));
		}
		if(check(segment) == true){
			ans = mid;
			hi = mid-1;
		}else{
			lo=mid+1;
		}
	}
	
	cout << ans << endl;
	return 0;
}








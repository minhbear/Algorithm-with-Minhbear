//https://atcoder.jp/contests/dp/tasks/dp_a
#include<bits/stdc++.h>

using namespace std;
int n;
int a[100005];
int f[100005];

void minHigh() {
	for(int i=3; i<=n; i++){
		f[i] = min(f[i-1] + abs(a[i]-a[i-1]), f[i-2] + abs(a[i]-a[i-2]));
	}	
	cout << f[n] << endl;
}

int main() {
	cin >> n;
	for(int i=1; i<=n; i++){
		cin >> a[i];
	}
	f[1] = 0; f[2] = abs(a[2] - a[1]);
	minHigh();
	return 0;
}

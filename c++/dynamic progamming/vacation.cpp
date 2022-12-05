//https://atcoder.jp/contests/dp/tasks/dp_c?fbclid=IwAR0SiObhKGdT2WQkO2XVKwjQGi80HaIPv8AJP2C2_q3j5QkcaMgVn0vi7Qs	
#include<bits/stdc++.h>
using namespace std;
const int MAX_ROW = 100005; 
const int COL = 4;
int days[MAX_ROW][COL];
int f[MAX_ROW][COL];
int n;

int maxPoint() {
	f[1][1] = days[1][1]; f[1][2] = days[1][2]; f[1][3] = days[1][3];
	for(int i=2; i<= n; i++){
		f[i][1] = days[i][1] + max(f[i-1][2], f[i-1][3]);
		f[i][2] = days[i][2] + max(f[i-1][1], f[i-1][3]);
		f[i][3] = days[i][3] + max(f[i-1][1], f[i-1][2]);
	}
	
	int point = max( max(f[n][1], f[n][2]), max(f[n][1], f[n][3]) );
	
	return point;
}

int main () {
	cin >> n;
	for(int i=1; i<=n; i++){
		for(int j=1; j<COL; j++){
			cin >> days[i][j];
		}
	}
	
	cout << maxPoint() << endl;
	
	return 0;
}

//https://atcoder.jp/contests/dp/tasks/dp_d?fbclid=IwAR31W8OXni7cy-TdJjAzJeRD5YNURclQWBuEy8c75pD7ckQA0i62B1B_vXg
#include<bits/stdc++.h>
using namespace std;

int weight[105];
int value[105];
int n;
int w;
long long dp[105][100005];

long long knapsack() {
	for(int i=0; i<=n; i++){
		for(int j=0; j<=w; j++){
			if(i==0|| j==0){
				dp[i][j]=0;
			}else if(weight[i] <= j){
				dp[i][j] = max( dp[i-1][j], dp[i-1][j-weight[i]] + value[i] );
			}else{
				dp[i][j] = dp[i-1][j];
			}
		}
	}
	
	return dp[n][w];
}

int main() {
	cin >> n >> w;
	for(int i=1; i<=n; i++){
		cin >> weight[i] >> value[i];
	}
	
	cout << knapsack() << endl; 
	return 0;
}

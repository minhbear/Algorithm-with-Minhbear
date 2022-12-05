//https://cses.fi/problemset/stats/1142

//IDEA:
//The largest rectangle must have the same height as the shortest bar that it
//contains. For each i, consider the largest rectangle with height H[i] such
//that bar i is the shortest bar it contains. The answer is simply the largest
//of these N rectangles.

//Since the heights of these rectangles are fixed, we just want them to be as wide
//as possible. Notice how the rectangle of bar i is bounded by the the closest
//shorter bars on each side of bar i (or the ends of the histogram if these bars
//don't exist).

//We can use a monotone stack twice to find the closest shorter bars on each side
//of each bar. 
#include<bits/stdc++.h>
using namespace std;

int a [200005];
int prePos[200005], sufPos[200005];

int main() {
	int n;
	cin >> n;
	for(int i = 1; i <= n; i++){
		cin >> a[i];
	}
	
	//Find the position that board in that position is closet with board in i and 
	//height that board is less then height of board i
	//From left to right
	
	stack<int> mystack;
	mystack.push(0);
	for(int i = 1; i <= n; i++){
		while(a[mystack.top()] >= a[i]){
			mystack.pop();
		}
		prePos[i] = mystack.top();
		mystack.push(i);
	}
	
	//clean stack
	while(!mystack.empty()){
		mystack.pop();
	}
	
	//Find the position that board in that position is closet with board in i and 
	//height that board is less then height of board i
	//From right to left
	
	mystack.push(n+1);
	for(int i=n; i>= 1; i--){
		while(a[mystack.top()] >= a[i]){
			mystack.pop();
		}
		sufPos[i] = mystack.top();
		mystack.push(i);
	}
	
	//So we have 2 array keep tract the closet board that height is less than board at i
	//so from prePos[i]+1 to sufPos[i]-1 is the distance of the width of largest rectangle
	//at index i, so we just loop all board and find the max area
	
	long long ans = -1;
	for(int i=1; i<= n; i++){
		ans = max(ans, 1LL * a[i] * (sufPos[i] - prePos[i] - 1)); 
	}
	
	cout << ans << endl;
	
	return 0;
}

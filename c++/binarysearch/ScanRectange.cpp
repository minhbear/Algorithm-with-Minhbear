//https://oj.vnoi.info/problem/icpc21_beta_n?fbclid=IwAR0xuNSfsIPc2d7qwzjWz6Y-zI6H4Mh1QNDUSCU5uaGGCE_6UgMkYeCUBt4
#include<iostream>

using namespace std;

const int lim = 1000000000;
long long ask(int x1, int y1, int x2, int y2) {
	cout << "? " << x1 << ' ' << y1 << ' ' << x2 << ' ' << y2 << endl;
	fflush(stdout);
	long long square;
	cin >> square;
	if(square == -1){
		exit(0);
	}
	
	return square;
}

int main() {
	
	long long S = ask(1,1,lim,lim);
	int lo=1; int hi=lim;
	int up=-1;
	while(lo<=hi){
		int mid=(lo+hi) >> 1;
		long long value = ask(1,1,mid,lim);
		if(value == 0){
			lo = mid+1;
		}else{
			up = mid;
			hi = mid-1;
		}
	}
	long long value = ask(up,1,up,lim);
	long long x = S/value;
	long long y = S/x;
	int down = up+x-1;
	lo=1;
	hi=lim;
	int left = -1;
	while(lo<=hi){
		int mid=(lo+hi)>>1;
		long long value=ask(1,1,lim,mid);
		if(value == 0){
			lo=mid+1;
		}else{
			left = mid;
			hi=mid-1;
		}
	}
	int right = left+y-1;
	cout <<"! " << up << ' ' << left << ' ' << down << ' ' << right <<endl;
	
	return 0;
}

//https://codeforces.com/problemset/gymProblem/101021/1
#include<iostream>
#include<string>

int main() {
	int lo=1;
	int hi=1000000;
	int ans=0;
	while(lo<=hi){
		int mid = (lo+hi)/2;
		std::cout << mid << std::endl;
		fflush(stdout);
		std::string answer;
		std::cin >> answer;
		if(answer == ">="){
			ans=mid;
			lo=mid+1;
		}else{
			hi=mid-1;
		}
	}
	
	std::cout << "! " << ans << std:endl;
	fflush(stdout);
	return 0;
}

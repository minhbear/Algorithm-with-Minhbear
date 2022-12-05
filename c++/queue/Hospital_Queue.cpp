//https://vjudge.net/problem/UVA-12207?fbclid=IwAR2flT0UGth7yFYUzhFUqGDi4IBmhX9W1j-37amotvpfS89QGL6E3QJ3WLc
#include<bits/stdc++.h>

using namespace std;

//Idea
//We will use queue to this problem, but we need to focus the range of P and C
//1<= P <= 1000000000 and 1<=C<=1000 
//Imagzine we push all Max P value in condition is 1000000000 we need to process 10000000000 element that is not good
//Instead we see that nurse just call 1000 command wit N and 'E x'
//=> we just push min(P, C) element to queue
//If command is N: we just move element front queue to the back
//If command is E x: we create temeprary queue push element in QUEUE expect x and we print x then push x to back que temp 

void solve() {
	int t = 0;
	while(true){
		int P, C;
		cin >> P >> C;
		if(P == 0 && C == 0){
			return ;
		}else{
			cout << "Case " << ++t << ":\n";
			int MIN = min(P,C);
			queue<int> q;
			//Push element to the queue
			for(int i=1; i<=MIN ; i++){
				q.push(i);
			}
			for(int i=1; i<=C; i++){
				char cmd;
				cin >> cmd;
				if(cmd == 'N'){
					int front = q.front();
					cout << front << "\n";
					q.pop();
					q.push(front);
				}else{
					int index;
					cin >> index;
					//create tmpqueue
					queue<int> tmp;
					tmp.push(index);
					while(!q.empty()){
						if(q.front() != index){
							tmp.push(q.front());
						}
						q.pop();
					}
					//copy again queue
					while(!tmp.empty()){
						int frontTmp = tmp.front();
						tmp.pop();
						q.push(frontTmp);
					}
				}
			}
		}
	}
}

int main() {
	solve();
	return 0;
}

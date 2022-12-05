#include <bits/stdc++.h>;

using namespace std;
int numTestCase;
string s;

int main() {
	cin >> numTestCase;
	for(int i = 1; i <= numTestCase; i++){
		cin >> s;
		stack <int> keepWeight;
		for(int i = 0; i < (int)s.size(); i++){
			if(s[i] == '('){
				//push 0 to stack to asing the bracket
				keepWeight.push(0);
			}else if(s[i] == 'C'){
				//push 12 to stack
				keepWeight.push(12);
			}else if(s[i] == 'H'){
				//push 1 to stack
				keepWeight.push(1);
			}else if(s[i] == 'O'){
				//push 16 to stack
				keepWeight.push(16);
			}else if(s[i] == ')'){
				int sum = 0;
				while(true){
					int top = keepWeight.top();
					keepWeight.pop();
					if(top == 0){
						break;
					}
					sum += top;
				}
				keepWeight.push(sum);
			}else{
				int top = keepWeight.top();
				keepWeight.pop();
				int heso = s[i] - '0';
				top = top * heso;
				keepWeight.push(top);
			}
		}
		
		int res = 0;
		while(!keepWeight.empty()){
			int t = keepWeight.top(); 
      		keepWeight.pop();
      		res += t; 
		}
	
		cout << res << endl;
	}
	return 0;
}

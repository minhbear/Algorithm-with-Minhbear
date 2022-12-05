#include<iostream>
#include<stack>
#include<string> 

using namespace std;

int main() {
	int n;
	cin >> n;
	for(int i=1; i<= n; i++){
		stack<char> mystack;
		string s;
		cin >> s;
		for(int i=0; i<=(int)s.size(); i++){
			if(s[i] == '('){
				mystack.push('!');
			}else if(s[i] == '+' || s[i] == '*' || s[i] == '-' || s[i] == '/' || s[i] == '^'){
				mystack.push(s[i]);
			}else if(s[i] == ')'){
				while(mystack.top() != '!'){
					cout << mystack.top();
					mystack.pop();	
				}
				mystack.pop();
			}else if('a' <= s[i] && s[i] <= 'z'){
				cout << s[i];
			}
		}
		cout << endl;
	}
	return 0;
}

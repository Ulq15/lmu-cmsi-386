#pragma once
#include <string>
using namespace std;

struct say: string {
public:
	string operator()(string someString) {
		sentence = sentence.append(" ").append(someString);
		return say(sentence);
	}
	string operator()() {
		return sentence;
	}
private:
	string sentence="";
};
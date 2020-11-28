#pragma once
#include <string>
using namespace std;

struct say: string {
public:
	say() : string("") { }
	say(string someString) : string(someString) {
		sentence = someString;
	}
	auto operator()(string someString) {
		return say(sentence+" "+someString);
	}
	auto operator()() {
		return sentence;
	}
private:
	string sentence;
};
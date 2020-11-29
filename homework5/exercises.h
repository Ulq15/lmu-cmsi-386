#pragma once
#include <string>
#include <vector>
#include <map>
#include <list>
#include <algorithm>

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

auto sorted_word_counts(list<string> words) {
	auto dictionary = map<string, int>();
	for (const string& str : words) {
		dictionary[str]++;
	}
	vector<pair<string, int>> v(dictionary.begin(), dictionary.end());
	sort(v.begin(), v.end(), [](auto x, auto y) {return x.second > y.second; });
	return v;
};
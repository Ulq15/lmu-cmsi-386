#pragma once
#include <string>
#include <vector>
#include <map>
#include <list>
#include <algorithm>
#include <iostream>

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

template <class T>
class Queue {
private:
	struct Node {
		T data;
		Node* next;
		Node(T data, Node* next) :data(data), next(next) {}
	};
	Node* head;
	Node* tail;
	int cur_size = 0;
public:
	Queue() : head(nullptr), tail(head) {}

	~Queue() {
		while (head != nullptr) {
			Node* prevHead = head;
			head = head->next;
			delete prevHead;
		}
	}

	void enqueue(T item) {
		if (isEmpty()) {
			head = new Node(item, head);
			tail = head;
		}
		else {
			tail->next = new Node(item, nullptr);
			tail = tail->next;
		}
		cur_size++;
	}

	T dequeue() {
		if (isEmpty()) {
			throw underflow_error("Cannot dequeue an empty Queue");
		}
		Node* node_to_dequeue = head;
		T dequeued_data = head->data;
		head = head->next;
		delete node_to_dequeue;
		cur_size--;
		return dequeued_data;
	}

	int get_size() {
		return this->cur_size;
	}

	bool isEmpty() {
		return get_size() == 0;
	}
	
	ostream& operator<<(ostream& os) {
		Node* cur_Node = head;
		os << '{';
		while (cur_Node != tail) {
			os << cur_Node->data << ", ";
			cur_Node = cur_Node->next;
		}
		os << cur_Node->data << '}';
		return os;
	}

	//Destroys Copy Construction and Copy Assignment
	Queue(Queue&) = delete;
	Queue& operator=(Queue&) = delete;

	//Brings back Move via construction and move via assignment
	//Move constructor: since a constructor is being used, the queue variable would
	//be initially empty so moving is straight forward
	Queue(Queue&& other) noexcept {
		Node* cur_Node = head;
		while (!other.isEmpty()) {
			this->enqueue(other.dequeue());
		}
	}
	//Move assignment: since the queue existed before this is called, it may contain
	//nodes from previous use, so need to get rid of the old nodes and then add the
	//new nodes
	Queue& operator=(Queue&& other) noexcept {
		while (!this->isEmpty()) {
			this->dequeue();
		}
		Node* cur_Node = head;
		while (!other.isEmpty()) {
			this->enqueue(other.dequeue());
		}
		return *this;
	}
};
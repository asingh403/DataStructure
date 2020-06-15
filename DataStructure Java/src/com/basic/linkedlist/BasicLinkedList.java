package com.basic.linkedlist;

public class BasicLinkedList<X> {

	private Node first;
	private Node last;
	private int nodeCount;

	public BasicLinkedList() {
		first = null;
		last = null;
		nodeCount = 0;

	}

	public void add(X item) {

		// This Cond. is something we are adding first time.
		if (first == null) {
			first = new Node(item);
			last = first;
		}

		// We want to grab the last node and update something it's value.
		else {
			Node newLastNode = new Node(item);
			last.setNextNode(newLastNode);
			last = newLastNode;
		}
		nodeCount++;

	}

	public void insert(X item, int position) {
		if (size() < position) {
			throw new IllegalStateException("the LINKED_LIST is smaller than the position you entered");
		}

		Node currentNode = first;

		for (int i = 1; i < position && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}

		// Severs the link chain and reconnects with the new node

		Node newNode = new Node(item);
		Node nextNode = currentNode.getNextNode();
		currentNode.setNextNode(newNode);
		newNode.setNextNode(nextNode);
		nodeCount++;
	}

	public X removeAt(int position) {
		if (first == null) {
			throw new IllegalStateException("the LINKED_LIST is empty and there are no ITEMS to remove");
		}
		Node CurrentNode = first;
		Node prevNode = first;
		// Start at 1 because we already on the first node
		for (int i = 1; i < position && CurrentNode != null; i++) {
			prevNode = CurrentNode;
			CurrentNode = CurrentNode.getNextNode();
		}

		// Now update the pointer and throw away the old first
		X nodeItem = CurrentNode.getNodeItem();
		prevNode.setNextNode(CurrentNode.getNextNode());
		nodeCount--;
		return nodeItem;

	}

	public X remove() {
		if (first == null) {
			throw new IllegalStateException("The LINKED_LIST is empty there is no ITEMS to remove");
		}

		X nodeItem = first.getNodeItem();

		// Update the first pointer and throw away the old first
		first = first.getNextNode();
		nodeCount--;
		return nodeItem;

	}

	public X get(int position) {
		if (first == null) {
			throw new IllegalStateException("the LINKED_LIST is empty and there are no ITEMS to GET");
		}
		Node CurrentNode = first;
		for (int i = 1; i < size() && CurrentNode != null; i++) {
			if (i == position) {
				return CurrentNode.getNodeItem();
			}
			CurrentNode = CurrentNode.getNextNode();
		}

		// if we did not find the item then return NULL
		return null;
	}

	public int find(X item) {
		if (first == null) {
			throw new IllegalStateException("the LINKED_LIST is empty and there are no ITEMS to FIND");
		}
		Node CurrentNode = first;
		for (int i = 1; i < size() && CurrentNode != null; i++) {
			if (CurrentNode.getNodeItem().equals(item)) {
				return i;
			}
			CurrentNode = CurrentNode.getNextNode();
		}
		return -1;
	}

	public String toString() {
		StringBuffer contents = new StringBuffer();
		Node curNode = first;

		while (curNode != null) {
			contents.append(curNode.getNodeItem());
			curNode = curNode.getNextNode();
			if (curNode != null) {
				contents.append(" , ");
			}
		}
		return contents.toString();
	}

	public int size() {
		return nodeCount;

	}

	private class Node {
		private Node nextNode;
		private X nodeItem;

		public Node(X item) {
			this.nextNode = null;
			this.nodeItem = item;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public X getNodeItem() {
			return nodeItem;
		}

	}

}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

	public static void main(String[] args) {
		Node root = new Node('A');
		root.left = new Node('B');
		root.right = new Node('C');
		root.left.left = new Node('D');
		root.left.right = new Node('E');
		
		root.right.right = new Node('G');
		root.right.left = new Node('F');
		
		LevelReverse(root);
//		LevelReverseQueue(root);
		
	}

	public static void LevelReverse(Node root) {

		if(root==null) return;
		Stack<Node> first = new Stack<Node>();
		Stack<Node> second = new Stack<Node>();
		first.push(root);
		boolean check = true;
		while (!first.isEmpty()) {
			Node s = (Node) first.pop();
			System.out.print((char)s.data + " ");

			if (check) {
				if (s.left != null) {
					second.push(s.left);
				}
				if (s.right != null)
					second.push(s.right);
				
			} else {
				if (s.right != null)
					second.push(s.right);

				if (s.left != null) {
					second.push(s.left);
				}
			}
			if (first.isEmpty()) {
				System.out.println();
				check = !check;
				Stack<Node> temp = new Stack<>();
				first=second;
				second = temp;
			}

		}

	}
	public static void LevelReverseQueue(Node root) {

		if(root==null) return;
		Queue<Node> first = new LinkedList<Node>();
		Queue<Node> second = new LinkedList<Node>();
		first.add(root);
		boolean check = true;
		while (!first.isEmpty()) {
			Node s = (Node) first.poll();
			System.out.print((char)s.data + " ");

			if (check) {

				if (s.right != null)
					second.add(s.right);

				if (s.left != null) {
					second.add(s.left);
				}
				
			} else {
				if (s.left != null) {
					second.add(s.left);
				}
				if (s.right != null)
					second.add(s.right);

			}
			if (first.isEmpty()) {
				System.out.println();
				check = !check;
				Queue<Node> temp = new LinkedList<>();
				first=second;
				second = temp;
			}

		}

	}
}

class Node {
	int data;
	Node left;
	Node right;

	Node(int d) {
		data = d;
		left = null;
		right = null;
	}

}
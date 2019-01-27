package Lec20;

public class BinarySearchTree {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinarySearchTree(int[] inorder) {
		this.root = construct(inorder, 0, inorder.length - 1);
	}

	private Node construct(int[] inorder, int ilo, int ihi) {

		if (ilo > ihi) {
			return null;
		}

		int mid = (ihi + ilo) / 2;

		Node nn = new Node();
		nn.data = inorder[mid];
		nn.left = construct(inorder, ilo, mid - 1);

		nn.right = construct(inorder, mid + 1, ihi);

		return nn;
	}

	public void display() {
		System.out.println("--------------");
		display(this.root);
		System.out.println("--------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";
		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node.right == null) {
			return node.data;
		}

		return max(node.right);
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (item > node.data) {
			return find(node.right, item);
		} else if (item < node.data) {
			return find(node.left, item);
		} else {
			return true;
		}

	}

	public int height() {

		return height(this.root);

	}

	private int height(Node node) {

		if (node == null) {
			return -1;
		}

		int th = -1;

		int lh = height(node.left);
		th = Math.max(th, lh);
		int rh = height(node.right);
		th = Math.max(th, rh);

		return th + 1;
	}

	public void pirntInRange(int lo, int hi) {
		printInRange(this.root, lo, hi);
	}

	private void printInRange(Node node, int lo, int hi) {

		if (node == null) {
			return;
		}

		if (node.data < lo) {
			printInRange(node.right, lo, hi);
		} else if (node.data > hi) {
			printInRange(node.left, lo, hi);
		} else {
			printInRange(node.left, lo, hi);
			System.out.print(node.data + " ");
			printInRange(node.right, lo, hi);
		}
	}

	public void printDecreasing() {
		printDecreasing(this.root);

	}

	private void printDecreasing(Node node) {

		if (node == null) {
			return;
		}

		printDecreasing(node.right);
		System.out.print(node.data + " ");
		printDecreasing(node.left);

	}

	private class SumofGreater {
		int sum;
	}

	public void replaceWithSumofGreater() {
		SumofGreater sg = new SumofGreater();
		replaceWithSumofGreater(this.root, sg);
	}

	private void replaceWithSumofGreater(Node node, SumofGreater sg) {

		if (node == null) {
			return;
		}

		replaceWithSumofGreater(node.right, sg);
		int temp = node.data;
		node.data = sg.sum;
		sg.sum += temp;
		replaceWithSumofGreater(node.left, sg);

	}

	public void addAtProperLocation(int item) {
		addAtProperLocation(this.root, item);
	}

	private void addAtProperLocation(Node node, int item) {

		if (item > node.data) {
			if (node.right != null) {
				addAtProperLocation(node.right, item);
			} else {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			}
		} else {
			if (node.left != null) {
				addAtProperLocation(node.left, item);
			} else {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			}
		}

	}

	public void removeNodeRetainingBST(int item) {
		removeNodeRetainingBST(this.root, null, item);
	}

	private void removeNodeRetainingBST(Node node, Node parent, int item) {

		if (node == null) {
			return;
		}

		if (item > node.data) {
			removeNodeRetainingBST(node.right, node, item);
		} else if (item < node.data) {
			removeNodeRetainingBST(node.left, node, item);
		} else {

			// leaf node
			if (node.left == null && node.right == null) {
				if (parent.left == node) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}

			// node with left node and right null

			else if (node.left != null && node.right == null) {
				if (parent.left == node) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			}

			// node with left node and right null

			else if (node.left == null && node.right != null) {
				if (parent.left == node) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			}

			// node with both left and right node
			else {
				// most suitable node to be replaced with this node are
				// the max of this node's left or min of this node's right

				int temp = max(node.left);
				node.data = temp;

				removeNodeRetainingBST(node.left, node, temp);

			}

		}

	}

}

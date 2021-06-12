public class AVLClass {
	public NodeAVL root;

	public void insert(Babys data, frecuans list) {
		root = insert(root, data, list);
	}

	private NodeAVL insert(NodeAVL AVLnode, Babys data, frecuans list) {
		if (AVLnode == null) {
			AVLnode = new NodeAVL(data);
			AVLnode.NodeAVLList(list);
			return AVLnode;

		} else {
			int k = (AVLnode.getData().getName()).compareTo(data.getName());
//			int s = (AVLnode.getData().getGender()).compareTo(data.getGender());	
			if (k > 0) {
				AVLnode.setLeft(insert(AVLnode.getLeft(), data, list));
			}
//			else if(k==0) {
//				if(s<0)
//					AVLnode.setLeft(insert(AVLnode.getLeft(), data, list));
//				else
//					AVLnode.setRight(insert(AVLnode.getRight(), data, list));
//			}
			else {
				AVLnode.setRight(insert(AVLnode.getRight(), data, list));
			}

			AVLnode.setHight(Math.max(height(AVLnode.getLeft()), height(AVLnode.getRight())) + 1);
			int heightDiff = heightDiff(AVLnode);
			if (heightDiff < -1) {
				if (heightDiff(AVLnode.getRight()) > 0) {
					AVLnode.setRight(rightRotate(AVLnode.getRight()));
					return leftRotate(AVLnode);
				} else {
					return leftRotate(AVLnode);
				}
			} else if (heightDiff > 1) {
				if (heightDiff(AVLnode.getLeft()) < 0) {
					AVLnode.setLeft(leftRotate(AVLnode.getLeft()));
					return rightRotate(AVLnode);
				} else {
					return rightRotate(AVLnode);
				}
			}

		}
		return AVLnode;
	}

//	public void insertNum(int data) {
//		root = insertNum(root, data);
//	}
//
//	private NodeAVL insertNum(NodeAVL AVLNode, int data) {
//		if (AVLNode == null) {
//			AVLNode = new NodeAVL(data);
//			return AVLNode;
//		} else {
//			if (((Comparable<Integer>) data).compareTo(AVLNode.getDataNum()) < 0) {
//				AVLNode.setLeft(insertNum(AVLNode.getLeft(), data));
//
//			} else
//				AVLNode.setRight( insertNum(AVLNode.getRight(), data));
//			AVLNode.setHight( Math.max(height(AVLNode.getLeft()), height(AVLNode.getRight())) + 1);
//			int HeightDiff = heightDiff(AVLNode);
//			if (HeightDiff == -2) {
//				if (heightDiff(AVLNode.getRight()) > 0) {
//					AVLNode.setRight( rightRotate(AVLNode.getRight()));
//					return leftRotate(AVLNode);
//
//				} else {
//					return leftRotate(AVLNode);
//
//				}
//			} else if (HeightDiff == 2) {
//				if (heightDiff(AVLNode.getLeft()) < 0) {
//					AVLNode.setLeft( leftRotate(AVLNode.getLeft()));
//					return rightRotate(AVLNode);
//				} else
//					return rightRotate(AVLNode);
//			}
//
//		}
//
//		return AVLNode;
//	}

	public NodeAVL insertList2(NodeAVL AVLnode, frecuans list) {
		AVLnode.NodeAVLList(list);
		return AVLnode;
	}

	private NodeAVL leftRotate(NodeAVL AVLNode) {
		NodeAVL AVLNodeRight = AVLNode.getRight();
		AVLNode.setRight(AVLNodeRight.getLeft());
		AVLNodeRight.setLeft(AVLNode);
		AVLNode.setHight(Math.max(height(AVLNode.getLeft()), height(AVLNode)) + 1);
		AVLNodeRight.setHight(Math.max(height(AVLNodeRight.getLeft()), height(AVLNodeRight.getRight())) + 1);
		return AVLNodeRight;
	}

	private NodeAVL rightRotate(NodeAVL AVLNode) {
		NodeAVL AVLNodeleft = AVLNode.getLeft();
		AVLNode.setLeft(AVLNodeleft.getRight());
		AVLNodeleft.setRight(AVLNode);
		AVLNode.setHight(Math.max(height(AVLNode.getLeft()), height(AVLNode.getRight())) + 1);
		AVLNodeleft.setHight(Math.max(height(AVLNodeleft.getLeft()), height(AVLNodeleft.getRight())) + 1);
		return AVLNodeleft;
	}

	private int heightDiff(NodeAVL AVLnode) {
		if (AVLnode == null) {
			return 0;
		}
		return (height(AVLnode.getLeft()) - height(AVLnode.getRight()));
	}

	private int height(NodeAVL AVLnode) {
		if (AVLnode == null) {
			return 0;
		}
		return AVLnode.getHight();
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(NodeAVL node) {

		if (node != null) {
			System.out.print(node.getData() + " " + node.list.toString() + "\n");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	
//	public String max() {
//		root = max(root);
//		return root.getData().getName();
//	}
//
//	private NodeAVL max(NodeAVL node) {
//		int maxFree = 0;
//		NodeAVL maxNode=null;
//		
//		if (node != null) {
//			if (node.list.Sum() > maxFree) {
//				maxFree = node.list.Sum();
//				maxNode=node;
//			}
//			preOrder(node.getLeft());
//			preOrder(node.getRight());
//		}
//		return maxNode;
//	}
	
	public int maxFree2 = 0;
	public NodeAVL maxNode=null;
	
	public void max2() {
		max2(root);
	}
	
	private void max2(NodeAVL node) {

		if (node != null) {
			int x =node.list.Sum();
			if (x > maxFree2) {
				maxFree2 = x;
				maxNode=node;
			}
			max2(node.getLeft());
			max2(node.getRight());
		}
	}
	
	int yearCounter=0;
	
	public void total(int year) {
		total(root,year);
	}
	
	private void total(NodeAVL node,int year) {
		
		if (node != null) {
			Node curr = node.list.first;
			while (curr != null) { 
				if (curr.getData().getYear()==year) {
					yearCounter++;
				}
				curr = curr.getNext();
			}
			
			total(node.getLeft(),year);
			total(node.getRight(),year);
		}
	}

	
	
	public NodeAVL findfind(String data, String dataG) {
		NodeAVL curr = root;
		while (curr != null) {
			if (curr.getData().getName().equals(data) && curr.getData().getGender().equals(dataG)) {
				return curr;
				// break;
			}
			int d = (curr.getData().getName()).compareTo(data);
			curr = d < 0 ? curr.getRight() : curr.getLeft();
		}
		return curr;

	}
	
	String SAVL = "";
	public void printLevelOrder(NodeAVL rootL){
	    int h = rootL.hight;
	    for (int i=1; i<=h; i++){
	    	printUnder(rootL, i);
	    }
	}
	private void printUnder(NodeAVL rootL, int level){
		if (rootL != null) {
	    if (level == 1) {
	        //System.out.println(rootL.getData());
	        SAVL+=rootL.getData()+rootL.list.toString();
	    }
	    else if (level > 1){
	    	printUnder(rootL.getLeft(), level-1);
	    	printUnder(rootL.getRight(), level-1);
	    }
		}
		else if (rootL == null)
	        return;
	}

}
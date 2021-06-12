
public class NodeAVL {
	private Babys data;
	private int dataNum;
	LinkedList list = new LinkedList();
	
	private NodeAVL Left;
	private NodeAVL Right;
	int hight;
	
	
	public NodeAVL(Babys data) {
		super();
		this.data = data;
		hight=1;
		
	}
	
	public NodeAVL(int dataNum) {
		super();
		this.dataNum = dataNum;
		hight=1;
		
	}
	
	public void NodeAVLList(frecuans data) {
		this.list.InsertionSorted(data); 
	}
	
	public Babys getData() {
		return data;
	}


	public void setData(Babys data) {
		this.data = data;
	}
	
	public int getDataNum() {
		return dataNum;
	}

	public void setDataNum(int dataNum) {
		this.dataNum = dataNum;
	}

	public NodeAVL getLeft() {
		return Left;
	}
	public void setLeft(NodeAVL left) {
		Left = left;
	}
	public NodeAVL getRight() {
		return Right;
	}
	public void setRight(NodeAVL right) {
		Right = right;
	}
	public int getHight() {
		return hight;
	}
	public void setHight(int hight) {
		this.hight = hight;
	}
	
}
public class AVLTreeNode{
	private int height;
	private int balance;
	private int key;
	private AVLTreeNode parent;
	private AVLTreeNode lChild;
	private AVLTreeNode rChild;
	public AVLTreeNode(){
		key = 0;
		height = 1;
		balance = 0;
		parent = null;
		lChild = null;
		rChild = null;
	}
	public int getKey(){
		return key;
	}
	public void setKey(int k){
		key = k;
	}
	public int getHeight(){
		return height;
	}
	public int getBalance(){
		return balance;
	}
	public AVLTreeNode getParent(){
		return parent;
	}
	public AVLTreeNode getLChild(){
		return lChild;
	}
	public AVLTreeNode getRChild(){
		return rChild;
	}
	public void setHeight(){
		if(lChild == null && rChild == null){
			height = 1;
		}else if(lChild ==null && rChild != null) {
			rChild.setHeight();
			height = rChild.getHeight()+1;
		}else if(lChild !=null && rChild == null){
			lChild.setHeight();
			height = lChild.getHeight()+1;
		}else{
			 rChild.setHeight();
			 lChild.setHeight();
			 height = (lChild.getHeight() > rChild.getHeight())? (lChild.getHeight()+1) : (rChild.getHeight()+1);
		}
	}
	public void setBalance(){
        if(lChild == null && rChild == null){
            balance = 0;
        }else if(lChild ==null && rChild != null) {
            rChild.setBalance();
            balance = rChild.getHeight();
        }else if(lChild !=null && rChild == null){
            lChild.setBalance();
            balance = -lChild.getHeight();
        }else{
            rChild.setBalance();
            lChild.setBalance();
            balance = rChild.getHeight()- lChild.getHeight();
        }
	}
	public void setParent(AVLTreeNode p){
		parent = p;
	}
	public void setLChild(AVLTreeNode l){
		lChild = l;
	}
	public void setRChild(AVLTreeNode r){
		rChild = r;
	}
}

public class AVLTree{
	private AVLTreeNode root;
	
	public AVLTree(){
		root = null;
	}
	public AVLTreeNode getRoot(){
		return root;
	}
	private void lR(AVLTreeNode node){
		 if(node.getParent()==null){
			 AVLTreeNode rChild = node.getRChild();
			 node.setRChild(rChild.getLChild());
			 if(rChild.getLChild() != null){
			 	rChild.getLChild().setParent(node);
			 }
			rChild.setLChild(node);
			node.setParent(rChild);
			root = rChild;
			rChild.setParent(null);
		 }else{
		 	AVLTreeNode parent = node.getParent();
			AVLTreeNode rChild = node.getRChild();
			node.setRChild(rChild.getLChild());
			if(rChild.getLChild() != null){
				rChild.getLChild().setParent(node);
			}
			rChild.setLChild(node);
			node.setParent(rChild);
			if(parent.getLChild() == node){
				parent.setLChild(rChild);
			}else{
				parent.setRChild(rChild);
			}
			rChild.setParent(parent);

		 }
	}
	private void rR(AVLTreeNode node){
		if(node.getParent()==null){
			AVLTreeNode lChild = node.getLChild();
			node.setLChild(lChild.getRChild());
			if(lChild.getRChild()!=null){
				lChild.getRChild().setParent(node);
			}
			lChild.setRChild(node);
			node.setParent(lChild);
			root = lChild;
			lChild.setParent(null);
		}else{
			AVLTreeNode parent = node.getParent();
			AVLTreeNode lChild = node.getLChild();
			node.setLChild(lChild.getRChild());
			if(lChild.getRChild()!=null){
				lChild.getRChild().setParent(node);
			}
			lChild.setRChild(node);
			node.setParent(lChild);
			if(parent.getLChild() == node){
				parent.setLChild(lChild);
			}else{
				parent.setRChild(lChild);
			}
			lChild.setParent(parent);
		}
	}
	private void balance(AVLTreeNode node){
		if(node.getBalance()==-2 && node.getLChild().getBalance()==-1){
			rR(node);
		}else if(node.getBalance()==-2 && node.getLChild().getBalance()==1){
			lR(node.getLChild());
			rR(node);
		}else if(node.getBalance()==2 && node.getRChild().getBalance()==1){
			lR(node);
		}else if(node.getBalance()==2 && node.getRChild().getBalance()==-1){
			rR(node.getRChild());
			lR(node);
		}
	}
	public void insertNode(AVLTreeNode node){
		AVLTreeNode temp = root;
		if (root == null){
			root = node;
		}else{
			while(temp != null){
				if(temp.getKey() >= node.getKey()&&temp.getLChild()!=null){
					temp = temp.getLChild();
				}else if(temp.getKey() >= node.getKey()&&temp.getLChild()==null){
					temp.setLChild(node);
					node.setParent(temp);
					root.setHeight();
					root.setBalance();
					while(temp!=null){
						if(temp.getBalance()!= 2 && temp.getBalance()!= -2){
							temp = temp.getParent();
						}else{
							balance(temp);
							root.setHeight();
							root.setBalance();
							temp = temp.getParent();
						}
					}
					break;
				}else if(temp.getKey() < node.getKey()&&temp.getRChild()!=null){
					temp = temp.getRChild();
				}else if(temp.getKey() < node.getKey()&&temp.getRChild()==null){
					temp.setRChild(node);
					node.setParent(temp);
					root.setHeight();
					root.setBalance();
					while(temp!=null){
						 if(temp.getBalance()!= 2 && temp.getBalance()!= -2){
							   temp = temp.getParent();
						 }else{
							 balance(temp);
							  root.setHeight();
							  root.setBalance();
							  temp = temp.getParent();
						 }
					}
					break;
				}
			}
		}
	}
	public void buildAVLTree(int[] keys){
		for(int i = 0; i < keys.length; i++){
			AVLTreeNode temp = new AVLTreeNode();
			temp.setKey(keys[i]);
			insertNode(temp);
		}
	}
    private void printTree(AVLTreeNode e,int num,String bb){
        if(e != null){
            for (int i = 0; i<num; i++){
                if(i<num-1){
                    if( bb.charAt(i)=='1'){
                        System.out.print("| ");
                    }else{
                        System.out.print("  ");
                    }
                }else{
                    System.out.print("|-");
                }
            }
            System.out.print("->k:");
            System.out.print(e.getKey());
	    System.out.print(" / h:");
	    System.out.print(e.getHeight());
            System.out.print(" / b:");
            System.out.print(e.getBalance());
            System.out.print("\n");
            String bb1 = "1";
            String bb0 = "0";
            printTree(e.getLChild(),num+1,bb+bb1);
            if(e.getRChild()!= null){
                for (int i = 0; i<num; i++){
                    if( bb.charAt(i)=='1'){
                        System.out.print("| ");
                    }else{
                        System.out.print("  ");
                    }
                }
                System.out.print("| \n");
            }
            printTree(e.getRChild(),num+1,bb+bb0);
        }
    }
    public void printAll(){
        AVLTreeNode temp = root;
        String bb = "";
        printTree(temp,0,bb);
        System.out.print("\n");
    }

}

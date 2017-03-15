public class Test{
    public static void main(String[] argvs){
        AVLTree temp = new AVLTree();
        int[] keys = {33,1,12,2,34,5,63,121,22,12333,11,3};
        temp.buildAVLTree(keys);
	temp.getRoot().setHeight();
	temp.getRoot().setBalance();
	temp.printAll();

        AVLTree temp1 = new AVLTree();
	int[] keys1 = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,10,11,12,13,14,15,16};
	temp1.buildAVLTree(keys1);
	temp1.getRoot().setHeight();
	temp1.getRoot().setBalance();
	temp1.printAll();
	//System.out.println(temp.searchKey(12333) != null);
        //System.out.println(temp.searchKey(3333) != null);
    }
}

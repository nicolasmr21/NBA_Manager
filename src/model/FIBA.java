package model;

import NBAUtil.AVLTree;
import NBAUtil.BSTree;
import NBAUtil.RBTree;

public class FIBA {

	AVLTree<Integer, String> matchesAVL;
	BSTree<Integer, String> matchesBBS;
	
	RBTree<Double, String> pointsRBT;
	BSTree<Double, String> pointsBST;
	
	AVLTree<Double, String> reboundsAVL;
	
	RBTree<Double, String> stealsRBT;
	
	public FIBA()
	{
		matchesAVL = new AVLTree<>();
		matchesBBS = new BSTree<>();
		pointsBST = new BSTree<>();
		pointsRBT = new RBTree<>();
		reboundsAVL = new AVLTree<>();
		stealsRBT = new RBTree<>();
	}
	
	
}

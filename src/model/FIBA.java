package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import NBAUtil.AVLTree;
import NBAUtil.BSTree;
import NBAUtil.Node;
import NBAUtil.RBTree;

public class FIBA {

	private AVLTree<Integer, String> matchesAVL;
	private BSTree<Integer, String> matchesBST;
	
	private RBTree<Double, String> pointsRBT;
	private BSTree<Double, String> pointsBST;
	
	private AVLTree<Double, String> reboundsAVL;
	
	private RBTree<Double, String> stealsRBT;
	
	public FIBA()
	{
		matchesAVL = new AVLTree<>();
		matchesBST = new BSTree<>();
		pointsBST = new BSTree<>();
		pointsRBT = new RBTree<>();
		reboundsAVL = new AVLTree<>();
		stealsRBT = new RBTree<>();
		
		uploadPlayers();
	}
	
	/**
	 * This method is responsible for loading a txt file which contains the players 
	 * which is read for the operation of the main server
	 */
	
	
	private void uploadPlayers() {
		File file = new File ("archivo/dataset.txt");		
		try {
			FileReader reader = new FileReader(file); 
			BufferedReader br = new BufferedReader(reader); 
			
			
			String line = "";
			String[] s;
			int x = 1;
			while((line = br.readLine()) != null){
				s = line.split(",");
				Player p = new Player(s[0], Integer.parseInt(s[1]), 
						s[2], s[3], 
						Integer.parseInt(s[4]), Double.parseDouble(s[5]), Double.parseDouble(s[6]),
						Double.parseDouble(s[7]), Double.parseDouble(s[8]));
				
				matchesBST.insert(new Node<Integer, String>(p.getMp(), ""+x));
				matchesAVL.insert(new Node<Integer, String>(p.getMp(), ""+x));
				pointsBST.insert(new Node<Double, String>(p.getPpm(), ""+x)); 
				pointsRBT.insert(new Node<Double, String>(p.getPpm(), ""+x)); 
				reboundsAVL.insert(new Node<Double, String>(p.getRpm(), ""+x));
				stealsRBT.insert(new Node<Double, String>(p.getSpm(), ""+x)); 
			
				
				String path="archivo/"+x+".txt";
	            File f = new File(path);

	            // If file doesn't exists, then create it
	            if (!file.exists()) {
	                file.createNewFile();
	            }
	            FileWriter fw = new FileWriter(f.getAbsoluteFile());
	            BufferedWriter bw = new BufferedWriter(fw);

	            // Write in file
	            bw.write(p.toString());

	            // Close connection
	            bw.close();
	            x++;
			}
			
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public Node<Integer, String> searchMatchesAVL(int matches)
	{
		return matchesAVL.search(matches);
	}
	
	public Node<Integer, String> searchMatchesBBS(int matches)
	{
		return matchesBST.search(matches);
	}
	
	public Node<Double, String> searchPointsRBT(double points)
	{
		return pointsRBT.search(points);
	}
	
	public Node<Double, String> searchPointsBST(double points)
	{
		return pointsBST.search(points);
	}
	
	public Node<Double, String> searchReboundsAVL(double rebounds)
	{
		return reboundsAVL.search(rebounds);
	}
	
	public Node<Double, String> searchStealsRBT(double steals)
	{
		return stealsRBT.search(steals);
	}
}

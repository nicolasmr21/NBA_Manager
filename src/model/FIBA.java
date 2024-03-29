package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import NBAUtil.AVLTree;
import NBAUtil.BSTree;
import NBAUtil.List;
import NBAUtil.Node;
import NBAUtil.RBNode;
import NBAUtil.RBTree;

public class FIBA {

	//STATISTICS
	
	private int size;
	
	private AVLTree<Integer, String> matchesAVL;
	private BSTree<Integer, String> matchesBST;
	
	private RBTree<Double, String> pointsRBT;
	private BSTree<Double, String> pointsBST;
	
	private AVLTree<Double, String> reboundsAVL;
	
	private RBTree<Double, String> stealsRBT;
	
	//SIMPLE
	
	private AVLTree<String, String> idAVL;

	private boolean isLoading;
	
	public FIBA()
	{
		matchesAVL = new AVLTree<>();
		matchesBST = new BSTree<>();
		pointsBST = new BSTree<>();
		pointsRBT = new RBTree<>();
		reboundsAVL = new AVLTree<>();
		stealsRBT = new RBTree<>();
		idAVL = new AVLTree<>();
		isLoading = false;
	}
	
	/**
	 * This method is responsible for loading a txt file which contains the players 
	 * which is read for the operation of the main server
	 */
	
	
	public void uploadPlayers(String path) {
		
		File file = new File (path);		
		try {
			FileReader reader = new FileReader(file); 
			BufferedReader br = new BufferedReader(reader); 
			
			
			String line = "";
			String[] s;
			int x = 1;
			while((line = br.readLine()) != null){
				s = line.split(",");
	
				size++;
				idAVL.insert(new Node<String, String>(s[3], ""+x));

				matchesBST.insert(new Node<Integer, String>(Integer.parseInt(s[4]), ""+x));
				matchesAVL.insert(new Node<Integer, String>(Integer.parseInt(s[4]), ""+x));
				pointsBST.insert(new Node<Double, String>(Double.parseDouble(s[9]), ""+x)); 
				pointsRBT.insertRB(new RBNode<Double, String>(Double.parseDouble(s[9]), ""+x)); 
				reboundsAVL.insert(new Node<Double, String>(Double.parseDouble(s[6]), ""+x));
				stealsRBT.insertRB(new RBNode<Double, String>(Double.parseDouble(s[5]), ""+x)); 
			
				
				String path2="archivo/"+x+".txt";
	            File f = new File(path2);

	            // If file doesn't exists, then create it
	            if (!f.exists()) {
	                file.createNewFile();
	            }
	            FileWriter fw = new FileWriter(f.getAbsoluteFile());
	            BufferedWriter bw = new BufferedWriter(fw);

	            // Write in file
	            bw.write(s[0]+","+s[1]+","+s[2]+","+s[3]+","+s[4]+","+s[5]+","+s[6]+","+s[7]+","+s[8]+","+s[9]);

	            // Close connection
	            bw.close();
	            x++;
	            

			}
    		isLoading = false;

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void addPlayer(String name, String age, String team, String id,
			int mp, double ppm, double trb, double stl, double blk) throws IOException {
		
		int x = size;
		idAVL.insert(new Node<String, String>(id, ""+x));

		matchesBST.insert(new Node<Integer, String>(mp, ""+x));
		matchesAVL.insert(new Node<Integer, String>(mp, ""+x));
		pointsBST.insert(new Node<Double, String>(ppm, ""+x)); 
		pointsRBT.insertRB(new RBNode<Double, String>(ppm, ""+x)); 
		reboundsAVL.insert(new Node<Double, String>(blk, ""+x));
		stealsRBT.insertRB(new RBNode<Double, String>(stl, ""+x)); 
	
		
		String path2="archivo/"+x+".txt";
        File f = new File(path2);

        // If file doesn't exists, then create it
        if (!f.exists()) {
            f.createNewFile();
        }
        FileWriter fw = new FileWriter(f.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        System.out.println(name);
        // Write in file
        bw.write(name+","+age+","+team+","+id+","+mp+","+stl+","+trb+","+0+","+blk+","+ppm);

        
        bw.close(); 
        size++;
	}
	
	
	public String searchID(String id) {
		
		return ""+idAVL.search(id).getVal().get(0);
	}
	
	
	//Search by equals sign
	public List<String> searchMatchesAVL(int matches)
	{
		return matchesAVL.search(matches).getVal();
	}
	
	public List<String> searchMatchesBBS(int matches)
	{
		return matchesBST.search(matches).getVal();
	}
	
	public List<String> searchPointsRBT(double points)
	{
		return pointsRBT.search(points).getVal();
	}
	
	public List<String> searchPointsBST(double points)
	{
		return pointsBST.search(points).getVal();
	}
	
	public List<String> searchReboundsAVL(double rebounds)
	{
		return reboundsAVL.search(rebounds).getVal();
	}
	
	public List<String> searchStealsRBT(double steals)
	{
		return stealsRBT.search(steals).getVal();
	}
	
	//Search by bigger sign
	
	public List<String> searchMoreMatchesAVL(int matches)
	{
		return matchesAVL.getBiggerThan(matches);
	}
	
	public List<String> searchMoreMatchesBBS(int matches)
	{
		return matchesBST.getBiggerThan(matches);
	}
	
	public List<String> searchMorePointsRBT(double points)
	{
		return pointsRBT.getBiggerThan(points);
	}
	
	public List<String> searchMorePointsBST(double points)
	{
		return pointsBST.getBiggerThan(points);
	}
	
	public List<String> searchMoreReboundsAVL(double rebounds)
	{
		return reboundsAVL.getBiggerThan(rebounds);
	}
	
	public List<String> searchMoreStealsRBT(double steals)
	{
		return stealsRBT.getBiggerThan(steals);
	}
	
	//Search by less sign
	
	public List<String> searchLessMatchesAVL(int matches)
	{
		return matchesAVL.getLessThan(matches);
	}
	
	public List<String> searchLessMatchesBBS(int matches)
	{
		return matchesBST.getLessThan(matches);
	}
	
	public List<String> searchLessPointsRBT(double points)
	{
		return pointsRBT.getLessThan(points);
	}
	
	public List<String> searchLessPointsBST(double points)
	{
		return pointsBST.getLessThan(points);
	}
	
	public List<String> searchLessReboundsAVL(double rebounds)
	{
		return reboundsAVL.getLessThan(rebounds);
	}
	
	public List<String> searchLessStealsRBT(double steals)
	{
		return stealsRBT.getLessThan(steals);
	}

	public boolean isLoading() {
		return isLoading;
	}

	public void setLoading(boolean isLoading) {
		this.isLoading = isLoading;
	}
	
	
	
}

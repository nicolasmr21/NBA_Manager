package model;

public class Player {
	
	private String name;
	private int age;
	private String team;
	private String id;
	
	private int mp;
	private double ppm, rpm, spm, bpm;

	public Player(String name, int age, String team, String id, int mp, double ppm, double rpm, double spm,
			double bpm) {
		super();
		this.name = name;
		this.age = age;
		this.team = team;
		this.id = id;
		this.mp = mp;
		this.ppm = ppm;
		this.rpm = rpm;
		this.spm = spm;
		this.bpm = bpm;
	}

	
	
	
	public String getName() {
		return name;
	}




	public int getAge() {
		return age;
	}




	public String getTeam() {
		return team;
	}




	public String getId() {
		return id;
	}




	public int getMp() {
		return mp;
	}




	public double getPpm() {
		return ppm;
	}




	public double getRpm() {
		return rpm;
	}




	public double getSpm() {
		return spm;
	}




	public double getBpm() {
		return bpm;
	}




	@Override
	public String toString() {
		return name + "," + age + "," + team + "," + id + "," + mp + "," + ppm
				+ "," + rpm + "," + spm + "," + bpm;
	}

	
	
}

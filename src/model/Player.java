package model;

public class Player {

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
	private String name;
	private int age;
	private String team;
	private String id;
	
	private int mp;
	private double ppm, rpm, spm, bpm;
	
	
}

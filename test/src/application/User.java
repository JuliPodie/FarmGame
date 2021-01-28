package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class User {
	
	static String path = "src/Save/Save.txt";
	boolean newGame = false;
	
	private double lvlCap;
	
	private String name;
	private int lvl;
	private int lvlXp;
	
	private int money;
	
	private int wood;
	private int metal;
	private int hay;
	
	private int egg;
	private int wool;
	private int milk;
	

	private int lvlChicken;
	private int lvlSheep;
	private int lvlCow;
	private int lvlDog;
	private int lvlHorse;
	
	public User() {
		
		loadFile();
		if (name.contentEquals("NewGame")) {
            reset();
		}
	}
	 
	 public void saveFile() {
		
		 try (FileWriter fw = new FileWriter(path);
			BufferedWriter bw = new BufferedWriter(fw);){
			 
		 	bw.write(this.getName());
			bw.newLine();
			
			bw.write(Double.toString(lvlCap));
			bw.newLine();
			
			bw.write(Integer.toString(lvl));
			bw.newLine();
			
			bw.write(Integer.toString(lvlXp));
			bw.newLine();
					
			bw.write(Integer.toString(money));
			bw.newLine();
					
					
			bw.write(Integer.toString(wood));
			bw.newLine();

			bw.write(Integer.toString(metal));
			bw.newLine();
					
			bw.write(Integer.toString(hay));
			bw.newLine();
				
			 
			bw.write(Integer.toString(egg));
			bw.newLine();
			 
			bw.write(Integer.toString(wool));
			bw.newLine();
			 
			bw.write(Integer.toString(milk));
			bw.newLine();
			 	
			
			bw.write(Integer.toString(lvlChicken));
			bw.newLine();
			 
			bw.write(Integer.toString(lvlSheep));
			bw.newLine();
				
			bw.write(Integer.toString(lvlCow));
			bw.newLine();
			
			bw.write(Integer.toString(lvlDog));
			bw.newLine();
			 
			bw.write(Integer.toString(lvlHorse));
			bw.newLine();		
			 
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
		
	 public void loadFile() {
		 try (FileReader fr = new FileReader(path);
				 BufferedReader br = new BufferedReader(fr);){
			 
			 name = br.readLine();
			 lvlCap =Double.parseDouble(br.readLine());
			 lvl = Integer.parseInt(br.readLine());
			 lvlXp = Integer.parseInt(br.readLine());
			 
			 money = Integer.parseInt(br.readLine());
			 
			 wood = Integer.parseInt(br.readLine());
			 metal = Integer.parseInt(br.readLine());
			 hay = Integer.parseInt(br.readLine());
			 
			 egg = Integer.parseInt(br.readLine());
			 wool = Integer.parseInt(br.readLine());
			 milk = Integer.parseInt(br.readLine());
			 
			 lvlChicken = Integer.parseInt(br.readLine());
			 lvlSheep = Integer.parseInt(br.readLine());
			 lvlCow = Integer.parseInt(br.readLine());
			 lvlDog = Integer.parseInt(br.readLine());
			 lvlHorse = Integer.parseInt(br.readLine());

		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
	 
	
	public void reset() {
		newGame = true;
		
		name = "NewGame";
        
		lvl = 5;
		lvlXp = 0;
		lvlCap = 100;
		
		money = 9000;
		
		egg = 1;
		wool = 2;
		milk = 3;
		
		wood = 4;
        metal = 5;
        hay = 6;
        
        lvlChicken = 0;
        lvlSheep = 0;
        lvlCow = 0;
        lvlDog = 0;
        lvlHorse = 0;
        saveFile();
	}

	public boolean isNewGame() {
		return newGame;
	}

	public void setNewGame(boolean newGame) {
		this.newGame = newGame;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	
	public int getLvlXp() {
		return lvlXp;
	}

	public void setLvlXp(int lvlXp) {
		if(lvlXp>=lvlCap) {
			lvlXp = lvlXp - (int) lvlCap;
			lvlCap = (int) (lvlCap * 1.2);
			lvl++;
		}
	
		this.lvlXp = lvlXp;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getMetal() {
		return metal;
	}

	public void setMetal(int metal) {
		this.metal = metal;
	}

	public int getHay() {
		return hay;
	}

	public void setHay(int hay) {
		this.hay = hay;
	}

	public int getWool() {
		return wool;
	}
	
	public int getEgg() {
		return egg;
	}

	public void setEgg(int egg) {
		this.egg = egg;
	}

	public void setWool(int wool) {
		this.wool = wool;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	public int getLvlSheep() {
		return lvlSheep;
	}

	public void setLvlSheep(int lvlSheep) {
		this.lvlSheep = lvlSheep;
	}

	public int getLvlCow() {
		return lvlCow;
	}

	public void setLvlCow(int lvlCow) {
		this.lvlCow = lvlCow;
	}

	public int getLvlChicken() {
		return lvlChicken;
	}

	public void setLvlChicken(int lvlChicken) {
		this.lvlChicken = lvlChicken;
	}

	public int getLvlDog() {
		return lvlDog;
	}

	public void setLvlDog(int lvlDog) {
		this.lvlDog = lvlDog;
	}

	public int getLvlHorse() {
		return lvlHorse;
	}

	public void setLvlHorse(int lvlHorse) {
		this.lvlHorse = lvlHorse;
	}
	
	
	public String getLvlS() {
		return Integer.toString(lvl);
	}
	
	public double getLvlXpD() {
		double xp;
		xp = lvl+lvlCap-1;
		xp = lvlXp/xp;
		return xp;
	}

	public String getMoneyS() {
		return Integer.toString(money);
	}

	public String getWoodS() {
		return Integer.toString(wood);
	}

	public String getMetalS() {
		return Integer.toString(metal);
	}

	public String getHayS() {
		return Integer.toString(hay);
	}

	public String getWoolS() {
		return Integer.toString(wool);
	}

	public String getMilkS() {
		return Integer.toString(milk);
	}

	public String getEggS() {
		return Integer.toString(egg);
	}

	public String getLvlSheepS() {
		return Integer.toString(lvlSheep);
	}
	
	public String getLvlCowS() {
		return Integer.toString(lvlCow);
	}

	public String getLvlChickenS() {
		return Integer.toString(lvlChicken);
	}

	public String getLvlDogS() {
		return Integer.toString(lvlDog);
	}

	public String getLvlHorseS() {
		return Integer.toString(lvlHorse);
	}
}
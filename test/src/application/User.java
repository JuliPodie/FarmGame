package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class User {
	
	static String path = "src/Save/Save.txt";
	boolean newGame = false;
	
	private String name;
	private int money;
	private int lvl;
	private int wood;
	private int metal;
	private int hay;
	private int eggs;
	private int lvlChicken;
	private int lvlSheep;
	private int lvlCow;
	private int amtChicken;
	private int amtSheep;
	private int amtCow;
	 
	 public User() {
		loadFile();
		if (name.contentEquals("NewGame")) {
			newGame = true;
			money = 9000;
			lvl = 1;
			wood = 3;
            metal = 0;
            hay = 10;
            eggs = 1;
            lvlChicken = 1;
            lvlSheep = 1;
            lvlCow = 0;
            amtChicken=1;
            amtSheep=0;
            amtCow =0;	
		}
	}
	 
	 public void saveFile() {
		 try (FileWriter fw = new FileWriter(path);
				 BufferedWriter bw = new BufferedWriter(fw);){
								
			 bw.write(this.getName());
			 bw.newLine();
					
			 bw.write(Integer.toString(money));
			 bw.newLine();
					
			 bw.write(Integer.toString(lvl));
			 bw.newLine();
					
			 bw.write(Integer.toString(wood));
			 bw.newLine();

			 bw.write(Integer.toString(metal));
			 bw.newLine();
					
			 bw.write(Integer.toString(hay));
			 bw.newLine();
				
			 bw.write(Integer.toString(eggs));
			 bw.newLine();
					
			 bw.write(Integer.toString(lvlChicken));
			 bw.newLine();
					
			 bw.write(Integer.toString(lvlSheep));
			 bw.newLine();
					
			 bw.write(Integer.toString(lvlCow));
			 bw.newLine();
					
			 bw.write(Integer.toString(amtChicken));
			 bw.newLine();
					
			 bw.write(Integer.toString(amtSheep));
			 bw.newLine();
					
			 bw.write(Integer.toString(amtCow));
			 bw.newLine();
					
			 fw.close();
			 bw.close();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
		
	 public void loadFile() {
		 try (FileReader fr = new FileReader(path);
				 BufferedReader br = new BufferedReader(fr);){
				
			 name = br.readLine();
			 money = Integer.parseInt(br.readLine());
			 lvl = Integer.parseInt(br.readLine());
			 wood = Integer.parseInt(br.readLine());
			 metal = Integer.parseInt(br.readLine());
			 hay = Integer.parseInt(br.readLine());
			 eggs = Integer.parseInt(br.readLine());
			 lvlChicken = Integer.parseInt(br.readLine());
			 lvlSheep = Integer.parseInt(br.readLine());
			 lvlCow = Integer.parseInt(br.readLine());
			 amtChicken = Integer.parseInt(br.readLine());
			 amtSheep = Integer.parseInt(br.readLine());
			 amtCow = Integer.parseInt(br.readLine());

			 fr.close();
			 br.close();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
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
	
	public int getEggs() {
		return eggs;
	}

	public void setEggs(int eggs) {
		this.eggs = eggs;
	}

	public int getLvlChicken() {
		return lvlChicken;
	}

	public void setLvlChicken(int lvlChicken) {
		this.lvlChicken = lvlChicken;
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

	public int getAmtChicken() {
		return amtChicken;
	}

	public void setAmtChicken(int amtChicken) {
		this.amtChicken = amtChicken;
	}

	public int getAmtSheep() {
		return amtSheep;
	}

	public void setAmtSheep(int amtSheep) {
		this.amtSheep = amtSheep;
	}

	public int getAmtCow() {
		return amtCow;
	}

	public void setAmtCow(int amtCow) {
		this.amtCow = amtCow;
	}
}
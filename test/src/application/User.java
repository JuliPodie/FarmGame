package application;

public class User {
	
	 private String Name;
	 private int Money;
	 private int Lvl;
	 private int Wood;
	 private int Metal;
	 private int Hay;
	 private int LvlChicken;
	 private int LvlSheep;
	 private int LvlCow;
	 private int Eegs;
	 private int AmtChicken;
	 private int AmtSheep;
	 private int AmtCow;
	 
	 
	 
	 
	 public User(Boolean newGame) {
		if (newGame) {
			Money = 100;
			Lvl = 1;
			Wood = 3;
			Metal = 0;
			Hay = 10;
			LvlChicken = 1;
			LvlSheep = 1;
			LvlCow = 1;
			Eegs = 0;
			AmtChicken=1;
			AmtSheep=0;
			AmtCow =0;
			
		} else {
			Save.loadFile();
			Money = Save.saveMoney;
			Lvl = Save.saveLvl;
			Wood = Save.saveWood;
			Metal = Save.saveMetal;
			Hay = Save.saveHay;
			LvlChicken = Save.saveLvlChicken;
			LvlSheep = Save.saveLvlSheep;
			LvlCow = Save.saveWood;
			Eegs = Save.saveEegs;
			Name = Save.saveName;
			AmtChicken = Save.saveAmtChicken;
			AmtSheep = Save.saveAmtSheep;
			AmtCow = Save.saveAmtCow;
		}
	}
	 
	 
	 
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getMoney() {
		return Money;
	}
	public void setMoney(int money) {
		Money = money;
	}
	public int getLvl() {
		return Lvl;
	}
	public void setLvl(int lvl) {
		Lvl = lvl;
	}
	public int getWood() {
		return Wood;
	}
	public void setWood(int wood) {
		Wood = wood;
	}
	public int getMetal() {
		return Metal;
	}
	public void setMetal(int metal) {
		Metal = metal;
	}
	public int getHay() {
		return Hay;
	}
	public void setHay(int hay) {
		Hay = hay;
	}
	public int getLvlChicken() {
		return LvlChicken;
	}
	public void setLvlChicken(int lvlChicken) {
		LvlChicken = lvlChicken;
	}
	public int getLvlSheep() {
		return LvlSheep;
	}
	public void setLvlSheep(int lvlSheep) {
		LvlSheep = lvlSheep;
	}
	public int getLvlCow() {
		return LvlCow;
	}
	public void setLvlCow(int lvlCow) {
		LvlCow = lvlCow;
	}
	public int getAmtChicken() {
		return AmtChicken;
	}
	public void setAmtChicken(int amtChicken) {
		AmtChicken = amtChicken;
	}
	public int getAmtSheep() {
		return AmtSheep;
	}
	public void setAmtSheep(int amtSheep) {
		AmtSheep = amtSheep;
	}
	public int getAmtCow() {
		return AmtCow;
	}
	public void setAmtCow(int amtCow) {
		AmtCow = amtCow;
	}
	public int getEegs() {
		return Eegs;
	}
	public void setEegs(int eegs) {
		Eegs = eegs;
	}


}

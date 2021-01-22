package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
	
	static String path = "src/Save/Save.txt";
	
	static String saveName;
	static int saveMoney;
	static int saveLvl;
	static int saveWood;
	static int saveMetal;
	static int saveHay;
	static int saveLvlChicken;
	static int saveLvlSheep;
	static int saveLvlCow;
	static int saveAmtChicken;
	static int saveAmtSheep;
	static int saveAmtCow;
	static int saveEegs;

	public static void saveFile() {
		try (FileWriter fw = new FileWriter(path);
			 BufferedWriter bw = new BufferedWriter(fw);){
							
				bw.write(saveName);
				bw.newLine();
				
				bw.write(Integer.toString(saveMoney));
				bw.newLine();
				
				bw.write(Integer.toString(saveLvl));
				bw.newLine();
				
				bw.write(Integer.toString(saveWood));
				bw.newLine();
				
				bw.write(Integer.toString(saveMetal));
				bw.newLine();
				
				bw.write(Integer.toString(saveHay));
				bw.newLine();
				
				bw.write(Integer.toString(saveLvlChicken));
				bw.newLine();
				
				bw.write(Integer.toString(saveLvlSheep));
				bw.newLine();
				
				bw.write(Integer.toString(saveLvlCow));
				bw.newLine();
				
				bw.write(Integer.toString(saveAmtChicken));
				bw.newLine();
				
				bw.write(Integer.toString(saveAmtSheep));
				bw.newLine();
				
				bw.write(Integer.toString(saveAmtCow));
				bw.newLine();
				
				bw.write(Integer.toString(saveEegs));
				bw.newLine();
				
				bw.close();
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	public static void loadFile() {
		try (FileReader fr = new FileReader(path);
			 BufferedReader br = new BufferedReader(fr);){
			
				saveName = br.readLine();
				saveMoney = Integer.parseInt(br.readLine());
				saveLvl = Integer.parseInt(br.readLine());
				saveWood = Integer.parseInt(br.readLine());
				saveMetal = Integer.parseInt(br.readLine());
				saveHay = Integer.parseInt(br.readLine());
				saveLvlChicken = Integer.parseInt(br.readLine());
				saveLvlSheep = Integer.parseInt(br.readLine());
				saveLvlCow = Integer.parseInt(br.readLine());
				saveAmtChicken = Integer.parseInt(br.readLine());
				saveAmtSheep = Integer.parseInt(br.readLine());
				saveAmtCow = Integer.parseInt(br.readLine());
				saveEegs = Integer.parseInt(br.readLine());
				
				br.close();
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
}

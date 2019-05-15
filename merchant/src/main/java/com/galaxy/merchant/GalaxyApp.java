package com.galaxy.merchant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author DAMA
 *
 */
public class GalaxyApp {
	    public static void main( String[] args ) throws IOException
	    {

			try(BufferedReader br = new BufferedReader(new FileReader("./inputFile.txt"));) {
				String line = br.readLine();
				while (line != null) {

					ContentProcess process = new ContentProcess();
					process.processLogic(line);

					line = br.readLine();
				}
			} catch (FileNotFoundException ex) {
				Logger.getLogger(GalaxyApp.class.getName()).log(Level.SEVERE, Constants.NO_FILE);
			} catch (IOException ex) {

				Logger.getLogger(GalaxyApp.class.getName()).log(Level.SEVERE, Constants.INVALID_INPUT);
			} 
	    }

}

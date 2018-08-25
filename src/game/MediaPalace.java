package game;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;

public class MediaPalace {


	/*
	 * To use this method, you must first download JLayer: http://www.javazoom.net/javalayer/javalayer.html, and add the jar to project.
	 * Then uncomment this method.
	 */
	// private void playMp3FromComputer(String fileName) throws JavaLayerException {
	// FileInputStream songStream = new FileInputStream(fileName);
	//
	// final Player playMp3 = new Player(songStream);
	//
	// Thread t = new Thread() {
	// public void run() {
	// try {
	// playMp3.play();
	// } catch (JavaLayerException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// };
	// t.start();
	// }

	/* This method will use your default mp3 player to play the song */
	public void playMusicOnComputer(String fileName) {
		File fileToPlay = new File(fileName);
		try {
			java.awt.Desktop.getDesktop().open(fileToPlay);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/* If you want to use an mp3, you must first convert it to a .wav file on http://media.io */
	public AudioClip loadSound(String fileName) {
		return JApplet.newAudioClip(getClass().getResource(fileName));
	}

	public void playSoundFromInternet(String soundURL) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new URL(soundURL));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			Thread.sleep(500);
		} catch (Exception ex) {
			System.out.println("Problem playing sound: " + soundURL);
			ex.printStackTrace();
		}
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


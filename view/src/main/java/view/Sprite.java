package view;

import java.awt.Graphics;
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JFrame;



public class Sprite extends JFrame{ 

	private static final long serialVersionUID = 1L;
	
	BufferedImage sprites;
	Animator diamond;
	
	BufferedImage sprite1;
	Animator characterl;
	
	BufferedImage sprite2;
	Animator doorc;
	
	BufferedImage sprite3;
	Animator dooro;
	
	BufferedImage sprite4;
	Animator characterR;
	
	BufferedImage sprite5;
	Animator characterD;
	
	BufferedImage sprite6;
	Animator characterU;
	
	  public Sprite() {
		    setTitle("mes sprites");
		    //D�finit sa taille : 400 pixels de large et 100 pixels de haut
		    setSize(600, 950);
		    //Nous demandons maintenant � notre objet de se positionner au centre
		    setLocationRelativeTo(null);
		    //Termine le processus lorsqu'on clique sur la croix rouge
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    //D�finition de sa couleur de fond        
		    //On pr�vient notre JFrame que notre JPanel sera son content pane
		    setVisible(true);
		    setResizable(true);
		    init();
		    init1();
		    init2();
		    init3();
		    init4();
		    init5();
		    init6();
		     }       
	  
	  private void init() {
		  BufferedImageLoader loader = new  BufferedImageLoader();
		  BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("res/entity/74359.png");
		} catch (IOException ex) {
			Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
		}
		  SpriteSheet ss = new SpriteSheet(spriteSheet);
		  
		  sprites = ss.grabSprite(0, 0, 32, 32);
		  
		  ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
		  
		  sprites.add(ss.grabSprite(63, 0, 18, 17));
		  sprites.add(ss.grabSprite(63, 16, 18, 17));
		  sprites.add(ss.grabSprite(63, 32, 18, 17));
		  sprites.add(ss.grabSprite(63, 48, 18, 17));
		  
		  diamond = new Animator(sprites);
		  diamond.setSpeed(70);
		  diamond.play();
	  }
	  
	  private void init1() {
		  BufferedImageLoader loader = new  BufferedImageLoader();
		  BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("res/entity/74336.png");
		} catch (IOException ex) {
			Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
		}
		  SpriteSheet ss = new SpriteSheet(spriteSheet);
		  
		  sprite1 = ss.grabSprite(0, 0, 32, 32);
		  
		  ArrayList<BufferedImage> spritesCharacterL = new ArrayList<BufferedImage>();
		  
		  spritesCharacterL.add(ss.grabSprite(33, 17, 14, 16));
		  spritesCharacterL.add(ss.grabSprite(17, 17, 14, 16));
		  spritesCharacterL.add(ss.grabSprite(1, 17, 14, 16));
		  
		  characterl = new Animator(spritesCharacterL);
		  characterl.setSpeed(130);
		  characterl.play();
	  }
	  
	  private void init2() {
		  BufferedImageLoader loader = new  BufferedImageLoader();
		  BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("res/entity/74359.png");
		} catch (IOException ex) {
			Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
		}
		  SpriteSheet ss = new SpriteSheet(spriteSheet);
		  
		  sprite2 = ss.grabSprite(0, 0, 32, 32);
		  
		  ArrayList<BufferedImage> spritesDoorc = new ArrayList<BufferedImage>();
		  
		  spritesDoorc.add(ss.grabSprite(96, 0, 16, 16));
		  spritesDoorc.add(ss.grabSprite(96, 16, 16, 16));
		  spritesDoorc.add(ss.grabSprite(96, 32, 16, 16));
		  spritesDoorc.add(ss.grabSprite(96, 48, 16, 16));
		  
		  doorc = new Animator(spritesDoorc);
		  doorc.setSpeed(180);
		  doorc.play();
	  }
	  
	  private void init3() {
		  BufferedImageLoader loader = new  BufferedImageLoader();
		  BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("res/entity/74359.png");
		} catch (IOException ex) {
			Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
		}
		  SpriteSheet ss = new SpriteSheet(spriteSheet);
		  
		  sprite3 = ss.grabSprite(0, 0, 32, 32);
		  
		  ArrayList<BufferedImage> spritesDooro = new ArrayList<BufferedImage>();
		  
		  spritesDooro.add(ss.grabSprite(112, 0, 16, 16));
		  spritesDooro.add(ss.grabSprite(112, 16, 16, 16));
		  spritesDooro.add(ss.grabSprite(112, 32, 16, 16));
		  spritesDooro.add(ss.grabSprite(112, 48, 16, 16));
		  
		  dooro = new Animator(spritesDooro);
		  dooro.setSpeed(180);
		  dooro.play();
	  }
	  
	  private void init4() {
		  BufferedImageLoader loader = new  BufferedImageLoader();
		  BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("res/entity/74336.png");
		} catch (IOException ex) {
			Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
		}
		  SpriteSheet ss = new SpriteSheet(spriteSheet);
		  
		  sprite4 = ss.grabSprite(0, 0, 32, 32);
		  
		  ArrayList<BufferedImage> spritesCharacterR = new ArrayList<BufferedImage>();
		  
		  spritesCharacterR.add(ss.grabSprite(1, 48, 14, 16));
		  spritesCharacterR.add(ss.grabSprite(17, 48, 14, 16));
		  spritesCharacterR.add(ss.grabSprite(33, 48, 14, 16));
		  
		  characterR = new Animator(spritesCharacterR);
		  characterR.setSpeed(130);
		  characterR.play();
	  }
	  
	  private void init5() {
		  BufferedImageLoader loader = new  BufferedImageLoader();
		  BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("res/entity/74336.png");
		} catch (IOException ex) {
			Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
		}
		  SpriteSheet ss = new SpriteSheet(spriteSheet);
		  
		  sprite5 = ss.grabSprite(0, 0, 32, 32);
		  
		  ArrayList<BufferedImage> spritesCharacterD = new ArrayList<BufferedImage>();
		  
		  spritesCharacterD.add(ss.grabSprite(80, 17, 16, 17));
		  spritesCharacterD.add(ss.grabSprite(64, 17, 16, 17));
		  
		  characterD = new Animator(spritesCharacterD);
		  characterD.setSpeed(130);
		  characterD.play();
	  }
	  private void init6() {
		  BufferedImageLoader loader = new  BufferedImageLoader();
		  BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("res/entity/74336.png");
		} catch (IOException ex) {
			Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
		}
		  SpriteSheet ss = new SpriteSheet(spriteSheet);
		  
		  sprite6 = ss.grabSprite(0, 0, 32, 32);
		  
		  ArrayList<BufferedImage> spritesCharacterU = new ArrayList<BufferedImage>();
		  
		  spritesCharacterU.add(ss.grabSprite(32, 80, 16, 17));
		  
		  characterU = new Animator(spritesCharacterU);
		  characterU.setSpeed(130);
		  characterU.play();
	  }
	  
	  Image characterlImage;
	  Graphics characterlg;
	  
	  Image dbImage;
	  Graphics dbg;
	  
	  Image dcbImage;
	  Graphics dcbg;
	  
	  Image dobImage;
	  Graphics dobg;
	  
	  Image characterRImage;
	  Graphics characterRg;
	  
	  Image characterDImage;
	  Graphics characterDg;
	  
	  Image characterUImage;
	  Graphics characterUg;
	  
	  public void paint (Graphics g) {
		  dbImage = createImage(getWidth(), getHeight());
		  dbg = dbImage.getGraphics();
		  paintComponent(dbg);
		  g.drawImage(dbImage, 0, 0, null);
		  characterlImage = createImage(getWidth(), getHeight());
		  characterlg = characterlImage.getGraphics();
		  paintComponent(characterlg);
		  g.drawImage(characterlImage, 0, 0, null);
		  dcbImage = createImage(getWidth(), getHeight());
		  dcbg = dcbImage.getGraphics();
		  paintComponent(dcbg);
		  g.drawImage(dcbImage, 0, 0, null);
		  dobImage = createImage(getWidth(), getHeight());
		  dobg = dobImage.getGraphics();
		  paintComponent(dobg);
		  g.drawImage(dobImage, 0, 0, null);
		  characterRImage = createImage(getWidth(), getHeight());
		  characterRg = characterRImage.getGraphics();
		  paintComponent(characterRg);
		  g.drawImage(characterRImage, 0, 0, null);
		  characterDImage = createImage(getWidth(), getHeight());
		  characterDg = characterDImage.getGraphics();
		  paintComponent(characterDg);
		  g.drawImage(characterDImage, 0, 0, null);
		  characterUImage = createImage(getWidth(), getHeight());
		  characterUg = characterUImage.getGraphics();
		  paintComponent(characterUg);
		  g.drawImage(characterUImage, 0, 0, null);
	  }
	  
	  public void paintComponent(Graphics g) {
		  if(diamond != null) {
			  diamond.update(System.currentTimeMillis());
			  g.drawImage(diamond.sprite, 400, 400, 32, 32, null);
		  }
			  if(characterl != null) {
				  characterl.update(System.currentTimeMillis());
				  g.drawImage(characterl.sprite, 250, 400, 32, 32, null);
			  }
			  if(doorc != null) {
				  doorc.update(System.currentTimeMillis());
				  g.drawImage(doorc.sprite, 100, 400, 32, 32, null);
			  }
			  if(dooro != null) {
				  dooro.update(System.currentTimeMillis());
				  g.drawImage(dooro.sprite, 150, 400, 32, 32, null);
			  }
			  if(characterR != null) {
				  characterR.update(System.currentTimeMillis());
				  g.drawImage(characterR.sprite, 200, 400, 32, 32, null);
			  }
			  if(characterD != null) {
				  characterD.update(System.currentTimeMillis());
				  g.drawImage(characterD.sprite, 300, 400, 32, 32, null);
			  }
			  if(characterU != null) {
				  characterU.update(System.currentTimeMillis());
				  g.drawImage(characterU.sprite, 350, 400, 32, 32, null);
			  }
			  
			  
		   repaint();
	  }
	  
	
}
	  




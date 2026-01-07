 package firstProjectPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;

public class MainCode extends JPanel implements Runnable {
   public Rectangle[] Star;
   public Rectangle[] Star2;
   public Rectangle[] Star3;
   public Rectangle[] Star4;
   public Rectangle[] Star5;
   public Rectangle[] Star6;
   public Rectangle BackWall;
   public Rectangle Ceiling;
   public Rectangle Character;
   public Rectangle Floor;
   public Rectangle Obstacle;
   public Rectangle Obstacle2;
   public Rectangle Obstacle3;
   public Rectangle Obstacle4;
   public Rectangle Obstacle5;
   public Rectangle Obstacle6;
   public Rectangle Obstacle7;
   public Rectangle Obstacle8;
   public Rectangle Obstacle9;
   public Rectangle Obstacle10;
   public Rectangle Obstacle11;
   public Rectangle Obstacle12;
   public Rectangle Obstacle13;
   public Rectangle Eye;
   private static final Color VIOLET = new Color(123, 0, 128);
   private static final Color INDIGO = new Color(75, 0, 130);
   private static final Color SKYBLUE = new Color(4, 247, 130);
   private static final Color PINK = new Color(245, 65, 183);
   private static final Color FULLRED = new Color(255, 0, 0);
   private static final Color ORANGEBEAST = new Color(255, 128, 0);
   private static final Color WATERCOLOR = new Color(0, 255, 255);
   private static final Color CHARACTERCOLOR = new Color(240, 240, 0);
   private static final Color YOLO = new Color(10, 195, 230);
   public static int KeyJump = 32;
   public static int KeyRight = 68;
   public static int KeyLeft = 65;
   public static int KeyPause = 80;
   public static int KeyDrink = 76;
   public int Width = 800;
   public int Height = 600;
   public int CharacterWidth = 24;
   public int CharacterHeight = 36;
   public int fps = 1000;
   public int FallingSpeed = 1;
   public int FallingFrame = 0;
   public int FloorHeight = 80;
   public int CeilingHeight = 80;
   public int MovementFallingSpeed = 10;
   public int MovementResetSpeed = 1;
   public int MovementSpeed = 100;
   public int MovementFrame = 0;
   public int NoseWidth = 20;
   public int NoseHeight = 20;
   public int JumpingLength = 100;
   public int JumpingFrame = 0;
   public int JumpingSpeed = 0;
   public int JumpingCountFrame = 0;
   public int JumpingCountSpeed;
   public int xs;
   public int ys;
   public int ObstacleHeight;
   public int ObstacleHeight2;
   public int ObstacleHeight3;
   public int ObstacleHeight4;
   public int ObstacleHeight5;
   public int ObstacleHeight6;
   public int ObstacleHeight7;
   public int ObstacleHeight8;
   public int ObstacleHeight9;
   public int ObstacleHeight10;
   public int ObstacleHeight11;
   public int ObstacleHeight12;
   public int ObstacleHeight13;
   public int EyeWidth;
   public int EyeHeight;
   public int ShotSpeed;
   public int PotionSpeed;
   public int PotionFrame;
   public int MovingSpeed;
   public int MovingFrame;
   public int MovingCountSpeed;
   public int MovingCountFrame;
   public int MovingLength;
   public int currentStarsize;
   public int length;
   public int BackWallHeight;
   public static boolean objectsDefined = false;
   public boolean Falling;
   public boolean running;
   public static boolean Movement = false;
   public static boolean Right = false;
   public static boolean Left = false;
   public boolean Jumping;
   public boolean LeftNose;
   public boolean RightNose;
   public boolean inGame;
   public boolean Shoot;
   public boolean Gun;
   public boolean PotionDrank;
   public boolean Moving;
   public Thread game;

   public MainCode(WindowDesign f) {
      this.JumpingCountSpeed = this.FallingSpeed;
      this.xs = 0;
      this.ys = 0;
      this.ObstacleHeight = 180;
      this.ObstacleHeight2 = 270;
      this.ObstacleHeight3 = 360;
      this.ObstacleHeight4 = 450;
      this.ObstacleHeight5 = 540;
      this.ObstacleHeight6 = 630;
      this.ObstacleHeight7 = 720;
      this.ObstacleHeight8 = 630;
      this.ObstacleHeight9 = 540;
      this.ObstacleHeight10 = 450;
      this.ObstacleHeight11 = 360;
      this.ObstacleHeight12 = 270;
      this.ObstacleHeight13 = 180;
      this.EyeWidth = 10;
      this.EyeHeight = 10;
      this.ShotSpeed = 1;
      this.PotionSpeed = 2;
      this.PotionFrame = 0;
      this.MovingSpeed = 10;
      this.MovingFrame = 0;
      this.MovingCountSpeed = this.MovementSpeed;
      this.MovingCountFrame = this.JumpingCountFrame;
      this.MovingLength = 100;
      this.currentStarsize = 10;
      this.length = 1;
      this.BackWallHeight = 900;
      this.Falling = true;
      this.running = true;
      this.Jumping = true;
      this.LeftNose = false;
      this.RightNose = true;
      this.inGame = true;
      this.Shoot = false;
      this.Gun = false;
      this.PotionDrank = false;
      this.Moving = true;
      this.setBackground(Color.BLACK);
      this.defineObjects();
      this.game = new Thread(this);
      this.game.start();
      f.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == MainCode.KeyLeft) {
            	MainCode.Left = true;
            	MainCode.this.RightNose = false;
            	MainCode.this.LeftNose = true;
            }

            if (e.getKeyCode() == MainCode.KeyRight) {
            	MainCode.Right = true;
            	MainCode.this.LeftNose = false;
            	MainCode.this.RightNose = true;
            }

            if (e.getKeyCode() == MainCode.KeyJump && !MainCode.this.Falling) {
            	MainCode.this.Jumping = true;
            }

            if (e.getKeyCode() == MainCode.KeyPause) {
               if (MainCode.this.inGame) {
            	   MainCode.this.inGame = false;
               } else {
            	   MainCode.this.inGame = true;
               }

               if (e.getKeyCode() == MainCode.KeyDrink) {
            	   MainCode.this.PotionDrank = true;
               }
            }

         }

         public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == MainCode.KeyLeft) {
            	MainCode.Left = false;
            }

            if (e.getKeyCode() == MainCode.KeyRight) {
            	MainCode.Right = false;
            }

            if (e.getKeyCode() == MainCode.KeyDrink) {
            	MainCode.this.PotionDrank = false;
            }

         }
      });
   }

   public void defineObjects() {
      this.Character = new Rectangle(this.Width / 2 - this.CharacterWidth / 2, this.Height / 2 - this.CharacterHeight / 2, this.CharacterWidth, this.CharacterHeight);
      this.Floor = new Rectangle(-1000, this.Height - this.FloorHeight, this.Width + 7000, this.FloorHeight);
      this.Ceiling = new Rectangle(-1000, this.Height + this.CeilingHeight, this.Width + 7000, this.CeilingHeight);
      this.BackWall = new Rectangle(-1000, this.Height - this.BackWallHeight, this.Width / 4, this.BackWallHeight);
      this.Obstacle = new Rectangle(500, this.Height - this.ObstacleHeight, this.Width / 4, this.ObstacleHeight);
      this.Obstacle2 = new Rectangle(770, this.Height - this.ObstacleHeight2, this.Width / 4, this.ObstacleHeight2);
      this.Obstacle3 = new Rectangle(1040, this.Height - this.ObstacleHeight3, this.Width / 4, this.ObstacleHeight3);
      this.Obstacle4 = new Rectangle(1340, this.Height - this.ObstacleHeight4, this.Width / 4, this.ObstacleHeight4);
      this.Obstacle5 = new Rectangle(1600, this.Height - this.ObstacleHeight5, this.Width / 4, this.ObstacleHeight5);
      this.Obstacle6 = new Rectangle(1850, this.Height - this.ObstacleHeight6, this.Width / 4, this.ObstacleHeight6);
      this.Obstacle7 = new Rectangle(2150, this.Height - this.ObstacleHeight7, this.Width / 4, this.ObstacleHeight7);
      this.Obstacle8 = new Rectangle(2450, this.Height - this.ObstacleHeight8, this.Width / 4, this.ObstacleHeight8);
      this.Obstacle9 = new Rectangle(2780, this.Height - this.ObstacleHeight9, this.Width / 4, this.ObstacleHeight9);
      this.Obstacle10 = new Rectangle(3100, this.Height - this.ObstacleHeight10, this.Width / 4, this.ObstacleHeight10);
      this.Obstacle11 = new Rectangle(3530, this.Height - this.ObstacleHeight11, this.Width / 4, this.ObstacleHeight11);
      this.Obstacle12 = new Rectangle(3900, this.Height - this.ObstacleHeight12, this.Width / 4, this.ObstacleHeight12);
      this.Obstacle13 = new Rectangle(4300, this.Height - this.ObstacleHeight13, this.Width / 4, this.ObstacleHeight13);
      this.Eye = new Rectangle(this.Width / 2 - this.EyeWidth / 2, this.Height / 2 - this.EyeHeight / 2, this.EyeWidth, this.EyeHeight);
      this.Star = new Rectangle[50];
      Random ra = new Random();

      for(int i = 0; i < this.Star.length; ++i) {
         this.currentStarsize = ra.nextInt(5);
         this.Star[i] = new Rectangle(ra.nextInt(this.Width), ra.nextInt(this.Height), this.currentStarsize, this.currentStarsize);
      }

      this.Star2 = new Rectangle[50];
      Random ra2 = new Random();

      for(int i = 0; i < this.Star2.length; ++i) {
         this.currentStarsize = ra2.nextInt(5);
         this.Star2[i] = new Rectangle(ra2.nextInt(this.Width), ra2.nextInt(this.Height), this.currentStarsize, this.currentStarsize);
      }

      this.Star3 = new Rectangle[50];
      Random ra3 = new Random();

      for(int i = 0; i < this.Star3.length; ++i) {
         this.currentStarsize = ra3.nextInt(5);
         this.Star3[i] = new Rectangle(ra3.nextInt(this.Width), ra3.nextInt(this.Height), this.currentStarsize, this.currentStarsize);
      }

      this.Star4 = new Rectangle[50];
      Random ra4 = new Random();

      for(int i = 0; i < this.Star4.length; ++i) {
         this.currentStarsize = ra4.nextInt(5);
         this.Star4[i] = new Rectangle(ra4.nextInt(this.Width), ra4.nextInt(this.Height), this.currentStarsize, this.currentStarsize);
      }

      this.Star5 = new Rectangle[50];
      Random ra5 = new Random();

      for(int i = 0; i < this.Star5.length; ++i) {
         this.currentStarsize = ra5.nextInt(5);
         this.Star5[i] = new Rectangle(ra5.nextInt(this.Width), ra5.nextInt(this.Height), this.currentStarsize, this.currentStarsize);
      }

      this.Star6 = new Rectangle[50];
      Random ra6 = new Random();

      for(int i = 0; i < this.Star6.length; ++i) {
         this.currentStarsize = ra6.nextInt(5);
         this.Star6[i] = new Rectangle(ra6.nextInt(this.Width), ra6.nextInt(this.Height), this.currentStarsize, this.currentStarsize);
      }

      objectsDefined = true;
      this.repaint();
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (objectsDefined) {
         g.setColor(YOLO);
         g.fillRect(this.Character.x - this.xs, this.Character.y - this.ys, this.Character.width, this.Character.height);
         g.setColor(Color.PINK);
         g.fillRect(this.Floor.x - this.xs, this.Floor.y - this.ys, this.Floor.width, this.Floor.height);
         g.setColor(FULLRED);
         g.fillRect(this.Obstacle.x - this.xs, this.Obstacle.y - this.ys, this.Obstacle.width, this.Obstacle.height);
         g.setColor(ORANGEBEAST);
         g.fillRect(this.Obstacle2.x - this.xs, this.Obstacle2.y - this.ys, this.Obstacle2.width, this.Obstacle2.height);
         g.setColor(Color.YELLOW);
         g.fillRect(this.Obstacle3.x - this.xs, this.Obstacle3.y - this.ys, this.Obstacle3.width, this.Obstacle3.height);
         g.setColor(Color.GREEN);
         g.fillRect(this.Obstacle4.x - this.xs, this.Obstacle4.y - this.ys, this.Obstacle4.width, this.Obstacle4.height);
         g.setColor(SKYBLUE);
         g.fillRect(this.Obstacle5.x - this.xs, this.Obstacle5.y - this.ys, this.Obstacle5.width, this.Obstacle5.height);
         g.setColor(INDIGO);
         g.fillRect(this.Obstacle6.x - this.xs, this.Obstacle6.y - this.ys, this.Obstacle6.width, this.Obstacle6.height);
         g.setColor(VIOLET);
         g.fillRect(this.Obstacle7.x - this.xs, this.Obstacle7.y - this.ys, this.Obstacle7.width, this.Obstacle7.height);
         g.setColor(INDIGO);
         g.fillRect(this.Obstacle8.x - this.xs, this.Obstacle8.y - this.ys, this.Obstacle8.width, this.Obstacle8.height);
         g.setColor(SKYBLUE);
         g.fillRect(this.Obstacle9.x - this.xs, this.Obstacle9.y - this.ys, this.Obstacle9.width, this.Obstacle9.height);
         g.setColor(Color.GREEN);
         g.fillRect(this.Obstacle10.x - this.xs, this.Obstacle10.y - this.ys, this.Obstacle10.width, this.Obstacle10.height);
         g.setColor(Color.YELLOW);
         g.fillRect(this.Obstacle11.x - this.xs, this.Obstacle11.y - this.ys, this.Obstacle11.width, this.Obstacle11.height);
         g.setColor(ORANGEBEAST);
         g.fillRect(this.Obstacle12.x - this.xs, this.Obstacle12.y - this.ys, this.Obstacle12.width, this.Obstacle12.height);
         g.setColor(FULLRED);
         g.fillRect(this.Obstacle13.x - this.xs, this.Obstacle13.y - this.ys, this.Obstacle13.width, this.Obstacle13.height);
         g.setColor(Color.WHITE);
         g.fillRect(this.Eye.x, this.Eye.y, this.Eye.width, this.Eye.height);
         g.setColor(Color.PINK);
         g.fillRect(this.BackWall.x - this.xs, this.BackWall.y - this.ys, this.BackWall.width, this.BackWall.height);
         g.setColor(Color.PINK);
         g.fillRect(this.Ceiling.x - this.xs, this.Ceiling.y - this.ys, this.Ceiling.width, this.Ceiling.height);
         this.repaint();
         if (this.LeftNose) {
            g.setColor(ORANGEBEAST);
            g.fillRect(this.Character.x - this.NoseWidth - this.xs, this.Character.y + this.Character.height / 4 - this.ys, this.NoseWidth, this.NoseHeight);
         } else if (this.RightNose) {
            g.setColor(ORANGEBEAST);
            g.fillRect(this.Character.x + this.Character.width - this.xs, this.Character.y + this.Character.height / 4 - this.ys, this.NoseWidth, this.NoseHeight);
            this.repaint();
         }

         g.setColor(FULLRED);

         int i;
         for(i = 0; i < this.Star.length; ++i) {
            g.fill3DRect(this.Star[i].x - this.xs, this.Star[i].y - this.ys, this.Star[i].width, this.Star[i].height, true);
            this.repaint();
         }

         g.setColor(Color.YELLOW);

         for(i = 0; i < this.Star2.length; ++i) {
            g.fill3DRect(this.Star2[i].x - this.xs, this.Star2[i].y - this.ys, this.Star2[i].width, this.Star2[i].height, true);
            this.repaint();
         }

         g.setColor(Color.GREEN);

         for(i = 0; i < this.Star3.length; ++i) {
            g.fill3DRect(this.Star3[i].x - this.xs, this.Star3[i].y - this.ys, this.Star3[i].width, this.Star3[i].height, true);
            this.repaint();
         }

         g.setColor(SKYBLUE);

         for(i = 0; i < this.Star4.length; ++i) {
            g.fill3DRect(this.Star4[i].x - this.xs, this.Star4[i].y - this.ys, this.Star4[i].width, this.Star4[i].height, true);
            this.repaint();
         }

         g.setColor(VIOLET);

         for(i = 0; i < this.Star5.length; ++i) {
            g.fill3DRect(this.Star5[i].x - this.xs, this.Star5[i].y - this.ys, this.Star5[i].width, this.Star5[i].height, true);
            this.repaint();
         }

         g.setColor(INDIGO);

         for(i = 0; i < this.Star6.length; ++i) {
            g.fill3DRect(this.Star6[i].x - this.xs, this.Star6[i].y - this.ys, this.Star6[i].width, this.Star6[i].height, true);
            this.repaint();
         }

         if (!this.inGame) {
            g.setColor(FULLRED);
            g.drawString("Paused Press P To Unpause", 10, 20);
            this.Jumping = false;
            Right = false;
            Left = false;
            if (this.LeftNose) {
               g.setColor(ORANGEBEAST);
               g.fillRect(this.Character.x - this.NoseWidth - this.xs, this.Character.y + this.Character.height / 4 - this.ys, this.NoseWidth, this.NoseHeight);
            } else if (this.RightNose) {
               g.setColor(ORANGEBEAST);
               g.fillRect(this.Character.x + this.Character.width - this.xs, this.Character.y + this.Character.height / 4 - this.ys, this.NoseWidth, this.NoseHeight);
               this.repaint();
            }

            if (!this.LeftNose) {
               g.setColor(ORANGEBEAST);
               g.fillRect(this.Character.x - this.NoseWidth - this.xs, this.Character.y + this.Character.height / 4 - this.ys, this.NoseWidth, this.NoseHeight);
            } else if (!this.RightNose) {
               g.setColor(ORANGEBEAST);
               g.fillRect(this.Character.x + this.Character.width - this.xs, this.Character.y + this.Character.height / 4 - this.ys, this.NoseWidth, this.NoseHeight);
               this.repaint();
            }

            this.repaint();
         }
      }

   }

   public void run() {
      while(this.running) {
         if (this.inGame) {
            Point pt1 = new Point(this.Character.x, this.Character.y + this.Character.height);
            Point pt2 = new Point(this.Character.x + this.Character.width, this.Character.y + this.Character.height);
            if (this.Jumping) {
               ++this.FallingFrame;
            } else {
               if (this.FallingSpeed >= this.FallingFrame) {
                  if (!this.Floor.contains(pt1) && !this.Floor.contains(pt2) && !this.Obstacle.contains(pt1) && !this.Obstacle.contains(pt2) && !this.Obstacle2.contains(pt1) && !this.Obstacle2.contains(pt2) && !this.Obstacle3.contains(pt1) && !this.Obstacle3.contains(pt2) && !this.Obstacle4.contains(pt1) && !this.Obstacle4.contains(pt2) && !this.Obstacle5.contains(pt1) && !this.Obstacle5.contains(pt2) && !this.Obstacle6.contains(pt1) && !this.Obstacle6.contains(pt2) && !this.Obstacle7.contains(pt1) && !this.Obstacle7.contains(pt2) && !this.Obstacle8.contains(pt1) && !this.Obstacle8.contains(pt2) && !this.Obstacle9.contains(pt1) && !this.Obstacle9.contains(pt2) && !this.Obstacle10.contains(pt1) && !this.Obstacle10.contains(pt2) && !this.Obstacle11.contains(pt1) && !this.Obstacle11.contains(pt2) && !this.Obstacle12.contains(pt1) && !this.Obstacle12.contains(pt2) && !this.Obstacle13.contains(pt1) && !this.Obstacle13.contains(pt2) && !this.Character.contains(pt1) && !this.Character.contains(pt2) && !this.BackWall.contains(pt1) && !this.BackWall.contains(pt2)) {
                     this.Falling = true;
                  } else {
                     this.Falling = false;
                  }
               }

               if (this.Falling) {
                  ++this.Character.y;
                  ++this.ys;
               }

               this.FallingFrame = 0;
            }

            if (this.JumpingCountFrame >= this.JumpingCountSpeed) {
               if (this.Jumping) {
                  if (this.JumpingFrame <= this.JumpingLength) {
                     --this.Character.y;
                     --this.ys;
                     ++this.JumpingFrame;
                  } else {
                     this.JumpingFrame = 0;
                     this.Jumping = false;
                  }
               }

               this.JumpingCountFrame = 0;
            } else {
               ++this.JumpingCountFrame;
            }

            if (this.Falling) {
               this.MovementSpeed = this.MovementFallingSpeed;
            } else {
               this.MovementSpeed = this.MovementResetSpeed;
            }

            if (Right) {
               ++this.Character.x;
               ++this.xs;
            }

            if (Left) {
               --this.Character.x;
               --this.xs;
            }

            this.MovementFrame = 0;
         } else {
            ++this.MovementFrame;
         }

         this.fpsSetter();
         this.repaint();
      }

   }

   public void fpsSetter() {
      try {
         Thread.sleep((long)(this.fps / 1000));
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }
}
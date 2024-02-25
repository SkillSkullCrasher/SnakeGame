import java.util.*;

class Snake {
    int position;
    int size;

    Snake(int position) {
        this.position = position;
        this.size = 1;
    }
}

public class SnakeGame {
    public static int m = 8;
    public static int n = 8;
    public static int[][] arr = new int[m][n];
    public static int ball = 0;

    public static boolean check(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    public static void display() {
        // return i >= 0 && i < m && j >= 0 && j < n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
         
        } //  System.out.println("BALL: "+ball);
    }

    public static void main(String[] args) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = i * n + j + 1; // Adding 1 to start from 1 instead of 0
            }
        }
       display();

        Timer timer = new Timer();
   
       timer.schedule(new Task(), 0,50000);
        
        Snake snake = new Snake(0);
        Scanner sc = new Scanner(System.in);
      
        
        int temp=snake.position;
        int i = 0;
        int j = 0;
        while (snake.size != 0) {
            String mov = sc.next();
            display();
          
            // int currentPos = arr[0][0];

            if (mov.equals("U")) {
                if (check(i - 1, j)) {
                    i--;
                    // arr[i][j] = snake.position;
                   
                    snake.position = arr[i ][j];
                    System.out.println(snake.position);
                    if (ball == snake.position) {
                        snake.size += 1;
                        System.out.println("SCORE"+snake.size);
                        timer.schedule(new Task(), 0,50000);
                        
                    } 
                }
                else {
                    System.out.println("-------------Game over-------------------");
                    System.out.println("Your Score: " + snake.size);
                     System.out.println("Do you wanna play again: y/n ");
                    String ch = sc.next();
                     if(ch == "y"){snake.size = 1;}
                    else{
                    snake.size = 0;
                    break;}
                }
            } else if (mov.equals("D")) {
                if (check(i + 1, j)) {
                    // arr[i][j] = snake.position;
                    i++;
                    snake.position = arr[i ][j];
                    System.out.println("SNAKE POS: "+snake.position);
                    
                  
                
                    if (ball == snake.position) {
                        snake.size += 1;
                        System.out.println("SCORE"+snake.size);
                        timer.schedule(new Task(), 0,50000);
                    } 
                }   else {
                    System.out.println("-------------Game over-------------------");
                    System.out.println("Your Score: " + snake.size);
                     System.out.println("Do you wanna play again: y/n ");
                    String ch = sc.next();
                     if(ch == "y"){snake.size = 1;}
                    else{
                    snake.size = 0;
                    break;}
                }
          }
                
            else if (mov.equals("L")) {
                if (check(i, j - 1)) {
                    // arr[i][j] = snake.position;  
                    j--;
                    snake.position = arr[i][j ];
                    System.out.println("SNAKE POS: "+snake.position);
                   
                    if (ball == snake.position) {
                        snake.size += 1;
                        System.out.println("SCORE"+snake.size);
                        timer.schedule(new Task(), 0,50000);
                    } 
                }   else {
                    System.out.println("-------------Game over-------------------");
                    System.out.println("Your Score: " + snake.size);
                     System.out.println("Do you wanna play again: y/n ");
                    String ch = sc.next();
                     if(ch == "y"){snake.size = 1;}
                    else{
                    snake.size = 0;
                    break;}
                }
          }else if (mov.equals("R")) {
                if (check(i, j + 1)) {
                    // arr[i][j] = snake.position;
                    
                    j++;
                    snake.position = arr[i][j ];
                    System.out.println("SNAKE POS: "+snake.position);
                  
                    if (ball == snake.position) {
                        snake.size += 1;
                        System.out.println("SCORE"+snake.size);
                        timer.schedule(new Task(), 0,50000);
                    } 
                }   else {
                    System.out.println("-------------Game over-------------------");
                    System.out.println("Your Score: " + snake.size);
                     System.out.println("Do you wanna play again: y/n ");
                    String ch = sc.next();
                     if(ch == "y"){snake.size = 1;}
                    else{
                    snake.size = 0;
                    break;}
                }
          }
        }timer.cancel();
    }

    static class Task extends TimerTask {
        @Override
        public void run() {
            // Task logic goes here
            Random rand = new Random();
            ball = rand.nextInt(1,arr[m - 1][n - 1]);
            System.out.println("BALLL" + ball);
        }
    }

}











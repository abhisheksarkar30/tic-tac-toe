import java.util.*;
public class tictactoe
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t[][]=new int[3][3],r,w,l,c,ch=1;
        do
        {
            if(ch>=1&&ch<=5)
            System.out.println("");
            System.out.println("\n\n\n\n\n\n\t\t\t\t\t\t<<<<<<<<<<<< T I C  T A C  T O E >>>>>>>>>>>>");
            System.out.println("\n\n\t\t\t\t\t\t\t    1: Player vs Computer\n\t\t\t\t\t\t\t    2: Computer vs Player");
            System.out.print("\t\t\t\t\t\t\t    3: Multiplayer\n\t\t\t\t\t\t\t    4: Credits");
            System.out.print("\n\t\t\t\t\t\t\t    5: Exit\n\n\t\t\t\t\t\t\t    Enter your choice:  ");
            ch=sc.nextInt();
            if(ch>0&&ch<4)
            System.out.println("X-Player/1st Player  O-Computer/2nd Player");            
            switch(ch)
            {
                case 1:
                w=0;l=0;
                do
                {
                    for(int i=0;i<9;i++)
                    t[i/3][i%3]=5;
                    for(int i=1;i<6;i++)
                    {
                        printer(t);
                        if(check(t,0))
                        {
                            System.out.println("Computer wins!!!\nWins:- "+w+"\nLosses:- "+ ++l);
                            break;
                        }
                        do
                        {
                            System.out.print("\nEnter row: ");
                            r=sc.nextInt();
                            System.out.print("Enter column: ");
                            c=sc.nextInt();
                            if(r<1||r>3||c<1||c>3||t[r-1][c-1]!=5)
                            System.out.println("\n\nInvalid Position!!! Try again!!!");
                            else
                            {
                                t[r-1][c-1]=1;
                                break;
                            }            
                        }while(true);
                        if(check(t,3))
                        {
                            printer(t);
                            System.out.println("You won!!!\nWins:- "+(++w)+"\nLosses:- "+l);
                            break;
                        }
                        else if(i==5)
                        {
                            printer(t);
                            System.out.println("Match Draw!!! You are playing well...");
                            break;
                        }
                        if(i==1)
                        if(t[1][1]!=5)
                        t[0][0]=0;
                        else
                        t[1][1]=0;
                        else
                        {
                            if(isempty(t,0,1)!=-1)
                            t[isempty(t,0,1)][isempty(t,0,2)]=0;
                            else
                            {
                                if(isempty(t,2,1)!=-1)
                                t[isempty(t,2,1)][isempty(t,2,2)]=0;
                                else if(i==2&&(t[0][0]+t[2][2]==2||t[0][2]+t[2][0]==2)&&t[1][1]==0)
                                t[1][0]=0;
                                else
                                {
                                    if(t[1][0]+t[1][2]==10)
                                    t[1][0]=0;
                                    else if(t[0][1]+t[2][1]==10)
                                    t[0][1]=0;
                                    else if((t[0][1]+t[1][1]+t[2][1])==6)
                                    if(t[0][1]==5)
                                    t[0][1]=0;
                                    else
                                    t[2][1]=0;
                                    else if((t[1][0]+t[1][1]+t[1][2])==6)
                                    if(t[1][0]==5)
                                    t[1][0]=0;
                                    else
                                    t[1][2]=0;
                                }
                            }
                        }
                    }
                    System.out.print("\nWill you continue (Y/N)? ");
                }while(sc.next().equalsIgnoreCase("Y"));
                break;
                case 2:
                w=0;l=0;
                do
                {
                    for(int i=0;i<9;i++)
                    t[i/3][i%3]=5;
                    for(int i=1;i<6;i++)
                    {
                        if(i==1)
                        if(((int)(Math.random()*10))%2==0)
                        t[0][0]=0;
                        else
                        t[1][1]=0;
                        else if(i==2)
                        if(t[0][0]==5)
                        t[0][0]=0;
                        else if(t[2][2]==5)
                        t[2][2]=0;
                        else
                        t[0][2]=0;                        
                        else
                        {
                            if(isempty(t,0,1)!=-1)
                            t[isempty(t,0,1)][isempty(t,0,2)]=0;
                            else
                            {
                                if(isempty(t,2,1)!=-1)
                                t[isempty(t,2,1)][isempty(t,2,2)]=0;
                                else if(i==3)
                                t[2][0]=0;                            
                                else
                                {
                                    if(t[1][0]+t[1][2]==10)
                                    t[1][0]=0;
                                    else if(t[0][1]+t[2][1]==10)
                                    t[0][1]=0;
                                    else if((t[0][1]+t[1][1]+t[2][1])==6)
                                    if(t[0][1]==5)
                                    t[0][1]=0;
                                    else
                                    t[2][1]=0;
                                    else if((t[1][0]+t[1][1]+t[1][2])==6)
                                    if(t[1][0]==5)
                                    t[1][0]=0;
                                    else
                                    t[1][2]=0;
                                    else if((t[2][0]+t[1][1]+t[0][2])==6)
                                    if(t[2][0]==5)
                                    t[2][0]=0;
                                    else
                                    t[0][2]=0;
                                }
                            }
                        }
                        printer(t);
                        if(check(t,0))
                        {
                            System.out.println("Computer wins!!!\nWins:- "+w+"\nLosses:- "+ ++l);
                            break;
                        }
                        else if(i==5)
                        {
                            printer(t);
                            System.out.println("Match Draw!!! You are playing well...");
                            break;
                        }
                        do
                        {
                            System.out.print("\nEnter row: ");
                            r=sc.nextInt();
                            System.out.print("Enter column: ");
                            c=sc.nextInt();
                            if(r<1||r>3||c<1||c>3||t[r-1][c-1]!=5)
                            System.out.println("\n\nInvalid Position!!! Try again!!!");
                            else
                            {
                                t[r-1][c-1]=1;
                                break;
                            }            
                        }while(true);
                        if(check(t,3))
                        {
                            printer(t);
                            System.out.println("You won!!!\nWins:- "+(++w)+"\nLosses:- "+l);
                            break;
                        }
                    }
                    System.out.print("\nWill you continue (Y/N)? ");
                }while(sc.next().equalsIgnoreCase("Y"));
                break;
                case 3: 
                w=0;l=0;
                String s1,s2;
                System.out.print("\nEnter 1st player's name(only):  ");
                s1=sc.next();
                System.out.print("Enter 2nd player's name(only):  ");
                s2=sc.next();
                do
                {
                    for(int i=0;i<9;i++)
                    t[i/3][i%3]=5;
                    for(int i=1;i<=9;i++)
                    {
                        printer(t);
                        do
                        {
                            System.out.println((i%2==1?s1:s2)+"'s Turn:-");
                            System.out.print("Enter row: ");
                            r=sc.nextInt();
                            System.out.print("Enter column: ");
                            c=sc.nextInt();
                            if(r<1||r>3||c<1||c>3||t[r-1][c-1]!=5)
                            System.out.println("\n\nInvalid Position!!! Try again!!!\n");
                            else
                            {
                                t[r-1][c-1]=i%2==1?1:0;
                                break;
                            }            
                        }while(true);
                        if(check(t,3*(i%2)))
                        {
                            printer(t);                        
                            System.out.println((i%2==0?s2:s1)+" wins!!!\n"+s1+":- "+(i%2==1?++w:w)+"\n"+s2+":- "+(i%2==1?l:++l));
                            break;
                        }
                        else if(i==9)
                        {
                            printer(t);
                            System.out.println("Match Draw!!!");
                        }
                    }
                    System.out.print("\nWill you continue (Y/N)? ");
                }while(sc.next().equalsIgnoreCase("Y"));
                break;
                case 4:new present().credit();
                break;
                case 5: System.out.print("\n\n\n\n\n\n\n\t\t\t\t\t\t\tYou are terminated Successfully!!!"); break;
                default:  System.out.print("Invalid Choice... Please try again!!!\n");
            }        
        }while(ch!=5);
    }
    public static int isempty(int t[][],int s,int c)
    {
        for(int j=0;j<3;j++)
        if(t[j][0]+t[j][2]==s&&t[j][1]==5)
        return c==1?j:1;
        else if(t[j][0]+t[j][1]==s&&t[j][2]==5)
        return c==1?j:2;
        else if(t[j][1]+t[j][2]==s&&t[j][0]==5)
        return c==1?j:0;
        else if(t[0][j]+t[2][j]==s&&t[1][j]==5)
        return c==1?1:j;
        else if(t[1][j]+t[2][j]==s&&t[0][j]==5)
        return c==1?0:j;
        else if(t[0][j]+t[1][j]==s&&t[2][j]==5)
        return c==1?2:j;
        if((t[0][0]+t[2][2]==s||t[0][2]+t[2][0]==s)&&t[1][1]==5)
        return 1;
        else if(t[1][1]+t[2][2]==s&&t[0][0]==5)
        return 0;
        else if(t[1][1]+t[0][0]==s&&t[2][2]==5)
        return 2;
        else if(t[1][1]+t[2][0]==s&&t[0][2]==5)
        return c==1?0:2;
        else if(t[1][1]+t[0][2]==s&&t[2][0]==5)
        return c==1?2:0;
        return -1;
    }
    public static void printer(int t[][])
    {
        System.out.println("\n\nCurrent Situation:-\n");
        for(int i=0;i<3;i++)
        {
            System.out.print("\t\t\t");
            for(int j=0;j<3;j++)
            {
                System.out.print(t[i][j]==1?'X':t[i][j]==0?'O':' ');
                if(j!=2)
                System.out.print(" | ");
            }
            if(i!=2)
            System.out.println("\n\t\t\t- | - | -");
        }
        System.out.println("\n\n");
    }
    public static boolean check(int t[][],int c)//Checks whether anyone won!!
    {
        for(int i=0;i<3;i++)
        if((t[0][i]+t[1][i]+t[2][i])==c||(t[i][0]+t[i][1]+t[i][2])==c)
        return true;
        if((t[0][0]+t[1][1]+t[2][2])==c||(t[0][2]+t[1][1]+t[2][0])==c)
        return true;
        return false;
    }
}
class present
{
    public static void credit()
    {
        double t0,t1;
        System.out.println("\n\n\n\t\t\t\t\t\t\t *********PRESENTED BY*********\n\n\n\n\n");
        for(t0=t1=System.currentTimeMillis();(t1-t0)<500;t1=System.currentTimeMillis());
        System.out.println("\t\t\t\t *       *  * * * *    * * *        *      * * *    * * *   * * * *  * * * * *");
        System.out.println("\t\t\t\t * *   * *  *        *             * *    *        *     *  *            *");
        System.out.println("\t\t\t\t *   *   *  * * *    *   * * *    * * *    * * *   *     *  * * *        *");
        System.out.println("\t\t\t\t *       *  *        *       *   *     *        *  *     *  *            *");
        System.out.println("\t\t\t\t *       *  * * * *    * * *    *       *  * * *    * * *   *            *");
        for(t0=t1=System.currentTimeMillis();(t1-t0)<1000;t1=System.currentTimeMillis());
        System.out.println("\n\n\n");
        System.out.println("\t\t     * *     * * *   * * *    * * *    * * *   * * *        *      * * * * *  *   * * *   *       *   * * * ");
        System.out.println("\t\t   *     *  *     *  *     *  *     * *     *  *    *      * *         *      *  *     *  * *     *  *      ");
        System.out.println("\t\t   *        *     *  * * *    * * *   *     *  * * *      * * *        *      *  *     *  *   *   *   * * * ");
        System.out.println("\t\t   *     *  *     *  *   *    *       *     *  *   *     *     *       *      *  *     *  *     * *        *");
        System.out.println("\t\t     * *     * * *   *     *  *        * * *   *     *  *       *      *      *   * * *   *       *   * * * ");
        for(t0=t1=System.currentTimeMillis();(t1-t0)<3000;t1=System.currentTimeMillis());
        
        System.out.println("\n\n\n\t\t\t\t\t\t\t *********Programmed By*********\n\n\n\n");
        for(t0=t1=System.currentTimeMillis();(t1-t0)<1000;t1=System.currentTimeMillis());
        System.out.println("\t\t\t\t\t    *      * * *   *     *  *   * * *   *     *  * * * *  *     *");
        System.out.println("\t\t\t\t\t   * *     *    *  *     *  *  *        *     *  *        *   *  ");
        System.out.println("\t\t\t\t\t  * * *    * * *   * * * *  *   * * *   * * * *  * * *    * *    ");
        System.out.println("\t\t\t\t\t *     *   *    *  *     *  *        *  *     *  *        *   *  ");
        System.out.println("\t\t\t\t\t*       *  * * *   *     *  *   * * *   *     *  * * * *  *     *");
        System.out.println("\n\n");
        for(t0=t1=System.currentTimeMillis();(t1-t0)<1000;t1=System.currentTimeMillis());
        System.out.println("\t\t\t\t   *       *      *      *       *  * * * *  * * *    *      *      *       *");
        System.out.println("\t\t\t\t     *   *       * *      *     *   *        *    *   *     * *     * *     *");
        System.out.println("\t\t\t\t       *        * * *      *   *    * * *    * * *    *    * * *    *   *   *");
        System.out.println("\t\t\t\t     *   *     *     *      * *     *        *   *    *   *     *   *     * *");
        System.out.println("\t\t\t\t   *       *  *       *      *      * * * *  *     *  *  *       *  *       *");
        System.out.println("\n\n");
        for(t0=t1=System.currentTimeMillis();(t1-t0)<1000;t1=System.currentTimeMillis());
        System.out.println("\t\t\t\t\t*       *    * *    *     *  *       *  *      *      *       *");
        System.out.println("\t\t\t\t\t* *   * *  *     *  *   *     *     *   *     * *     * *     *");
        System.out.println("\t\t\t\t\t*   *   *  *        * *        *   *    *    * * *    *   *   *");
        System.out.println("\t\t\t\t\t*       *  *     *  *   *       * *     *   *     *   *     * *");
        System.out.println("\t\t\t\t\t*       *    * *    *     *      *      *  *       *  *       *");
        for(t0=t1=System.currentTimeMillis();(t1-t0)<2000;t1=System.currentTimeMillis());
        
        System.out.println("\n\n\t\t\t\t\t\t\t   Copyrights (©)   Reserved");
        System.out.println("\n\n\n\t\t\t\t\t\t\t   ***********EULA***********\n");
        System.out.println("\t\t\t\t\t   This Gaming program has been made with reserved copyrights");
        System.out.println("\t\t\t\t\t   and permissions granted from Indian Government. No part of");
        System.out.println("\t\t\t\t\t   this program, or more precisely, no duplication, must take");
        System.out.println("\t\t\t\t\t   place, otherwise under the Reserved Copyrights Penalty Law");
        System.out.println("\t\t\t\t\t   the offender, may be jailed, or may be fined to a sum upto");
        System.out.println("\t\t\t\t\t   Rs. 10000/- or both!!!\n\n\n");
        System.out.println("\t\t\t\t\t   For More Details, feel free to drop a line @:");
        System.out.println("\t\t\t\t\t   abhishek.sarkar30@yahoo.co.in\n\n\n");
        System.out.println("\t\t\t\t\t   . . . . P R E S S  E N T E R  T O  C O N T I N U E . . . .");
        (new Scanner(System.in)).nextLine();        
    }
}
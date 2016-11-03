/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package als;

import static java.nio.file.Files.size;
import java.util.Random;

public class ALS {

    
    public static void main(String[] args) {
    Random rand = new Random();
    int size=10;
 
    int e1=2,e2=4,e3=5,x1=3,x2=3,x3=4,f,l,k,ra;
    int[] f1,f2,f3,l1,l2,l3,a1,a2,a3,t1,t2,t3,t4;
    f1=new int[size];f2=new int[size];f3=new int[size];
    l1=new int[size];l2=new int[size]; l3=new int[size];
    a1=new int[size];a2=new int[size]; a3=new int[size];
    t1=new int[size];t2=new int[size]; t3=new int[size];t4=new int[size];
    for(int i=0;i<size;i++)
    {  
        ra= rand.nextInt(20) + 1;f1[i]=ra;
        ra= rand.nextInt(20) + 1;f2[i]=ra;
        ra= rand.nextInt(20) + 1;f3[i]=ra;
        ra= rand.nextInt(20) + 1;a1[i]=ra;
        ra= rand.nextInt(20) + 1;a2[i]=ra;
        ra= rand.nextInt(20) + 1;a3[i]=ra;
        ra= rand.nextInt(20) + 1;l1[i]=ra;
        ra= rand.nextInt(20) + 1;l2[i]=ra;
        ra= rand.nextInt(20) + 1;l3[i]=ra;
        ra= rand.nextInt(20) + 1;t1[i]=ra;
        ra= rand.nextInt(20) + 1;t2[i]=ra;
        ra= rand.nextInt(20) + 1;t3[i]=ra;
        ra= rand.nextInt(20) + 1;t4[i]=ra;    
    }
    f1[0]=e1+a1[0];
    f2[0]=e2+a2[0];
    f3[0]=e3+a3[0];
    Algo(a1,a2,a3,t1,t2,t3,t4,f1,f2,f3,l1,l2,l3,size);
    //Recursive Call
    //AlgoRec(a1,a2,a3,t1,t2,t3,t4,f1,f2,f3,l1,l2,l3,size);

    if((f1[5]+x1)<(f2[5]+x2)&& (f1[5]+x1) < (f3[5]+x3))
    { 
        f=f1[5]+x1;l=1;
    }
    else if((f2[5]+x2)<(f1[5]+x1)&& (f2[5]+x2) < (f3[5]+x3))
    {
        f=f2[5]+x2;l=2;
    }
    else
    {
        f=f3[5]+x3;l=3;
    }
    System.out.print("f1\t:");
    for(int i=0;i<size;i++)
    {
       System.out.print(f1[i]+ " ");
    }
    System.out.print("\nf2\t:");
    for(int i=0;i<size;i++)
    {
        System.out.print(f2[i]+ " ");
    }
    System.out.print("\nf3\t:");
    for(int i=0;i<size;i++)
    {
        System.out.print(f3[i]+ " ");
    }
    System.out.print("\nl3\t:");
    for(int i=1;i<size;i++)
    {
       System.out.print(l3[i]+ " ");
    }

    System.out.print("\nl1\t:");
    for(int i=1;i<size;i++)
    {
      System.out.print(l1[i]+ " ");
    }
    System.out.print("\nl2\t:");
    for(int i=1;i<size;i++)
    {
      System.out.print(l2[i]+ " ");
    }

System.out.println("Optimal Time: "+f);
System.out.println("Optimal line: "+l);

System.out.println("\n\nOptimal Path\n");
System.out.println("Line "+l+" Station "+size);
k=l;
for(int j=size-1;j>=1;j--)
{

if (k==1)
{
k=l1[j]; 
System.out.println("Line "+k+" Station "+(j)+" ");
}
else if(k==2)
{
k=l2[j];
System.out.println("Line "+k+" Station "+(j)+" ");
}
else
{
k=l3[j];
System.out.println("Line "+k+" Station "+(j)+" ");
}
}
System.out.println();
}    

    
    public static void Algo(int[] a1,int[] a2,int[] a3,int[] t1,int[] t2,int[] t3,int[] t4,int[] f1,int[] f2,int[] f3, int[] l1,int[] l2,int[] l3,int s)
    {
        for(int j=1;j<s;j++)
    {
        if((f1[j-1]+a1[j]) <=(f1[j-1]+t1[j-1]+a2[j]))
    {
        f1[j]=f1[j-1]+a1[j];
        l1[j]=1;
    }
        else
        {
        f1[j]=f2[j-1]+t1[j-1]+a2[j]; 
        l1[j]=2;
        }
        if( (f2[j-1]+a2[j])<=(f2[j-1]+t2[j-1]+a1[j])&& (f2[j-1]+a2[j])<=(f2[j-1]+t3[j-1]+a3[j]))
        {
        f2[j]=f2[j-1]+a2[j]; 
        l2[j]=2;
        }
        else if((f2[j-1]+t2[j-1]+a1[j])<=(f2[j-1]+a2[j])&&(f2[j-1]+t2[j-1]+a1[j])<=(f2[j-1]+t3[j-1]+a3[j]))
        {
           f2[j]=f2[j-1]+t2[j-1]+a1[j];
           l2[j]=1;
        }
        else 
        {
           f2[j]=f2[j-1]+t3[j-1]+a3[j];
           l2[j]=3;
        }
        if( (f3[j-1]+a3[j])<=(f3[j-1]+t3[j-1]+a2[j]))
        {
            f3[j]=f3[j-1]+a3[j]; 
            l3[j]=3;
        }
        else
        {
           f3[j]=f3[j-1]+t4[j-1]+a2[j];
           l3[j]=2;
        }
    }
}
  
/**
  public static int AlgoRec(int[] a1,int[] a2,int[] a3,int[] t1,int[] t2,int[] t3,int[] t4,int[] f1,int[] f2,int[] f3, int[] l1,int[] l2,int[] l3,int s){    // Recursive Loop
        
        return Math.min(Rec(a1,a2,a3,t1,t2,t3,t4,f1,f2,f3,l1,l2,l3,0) + f1[0], 
                                Rec(a1,a2,a3,t1,t2,t3,t4,f1,f2,f3,l1,l2,l3,0) + f2[1]);
  }
  public static int Rec(int[] a1,int[] a2,int[] a3,int[] t1,int[] t2,int[] t3,int[] t4,int[] f1,int[] f2,int[] f3, int[] l1,int[] l2,int[] l3,int s){
       

        int T0 = Math.min(Rec(a1,a2,a3,t1,t2,t3,t4,f1,f2,f3,l1,l2,l3,s) + f1[s]
                                , Rec(a1,a2,a3,t1,t2,t3,t4,f1,f2,f3,l1,l2,l3,s) + t1[s] + f2[s]);
        int T1 = Math.min(Rec(a1,a2,a3,t1,t2,t3,t4,f1,f2,f3,l1,l2,l3,s) + f1[s+1]
                                , Rec(a1,a2,a3,t1,t2,t3,t4,f1,f2,f3,l1,l2,l3,s) + t1[s+1] + f2[s+1]);

        return Math.min(T0, T1);
    }
    **/
}
import java.util.Scanner;

public class LongestCommonSubsequence {
	
	static String ar[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		String b=sc.nextLine();
		ar=new String[a.length()+1][b.length()+1];
//		LCS(a,b);
		for(int i=0;i<=a.length();i++)
		{
			for(int j=0;j<=b.length();j++)
			{
				ar[i][j]="";
			}
		}
		LCS(a,b);
		System.out.println("Longest Common Subsequence of "+a+" and "+b+" is: "+ar[a.length()][b.length()] );
		System.out.println("Length : "+ar[a.length()][b.length()].length());
//		print(a.length()+1,b.length()+1);
	}
	
	public static void print(int la,int lb)
	{
		for(int i=0;i<la;i++)
		{
			for(int j=0;j<lb;j++)
			{
				System.out.println(ar[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public static void LCS(String a,String b)
	{
		String a1="",b1="";
		
		for(int i=1;i<=a.length();i++)
		{
			a1=a.substring(0,i);
			for(int j=1;j<=b.length();j++)
			{
				b1=b.substring(0, j);
				
				if(a1.charAt(i-1)==b1.charAt(j-1))
				{   
					
					ar[i][j]+=ar[i-1][j-1]+a1.charAt(i-1);
				}
				else
				{
					ar[i][j]+=max(ar[i][j-1],ar[i-1][j]);
				}
			}
		}
	}
	public static String max(String a,String b)
	{
		if(a.length()>b.length())
			return a;
		return b;
	}

}

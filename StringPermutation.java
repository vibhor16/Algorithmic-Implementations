import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class StringPermutation {

	static ArrayList<String> res=new ArrayList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a string:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		System.out.println("Number of Permutations are: ");
		numPerm(s);
		System.out.println("String(s) are: \n");
		permute(s, 0,s.length()-1 );
		
	}
	
	public static void numPerm(String s)
	{
		HashMap<Character, Integer> hm=new HashMap<>();
		for(int i=0;i<s.length();i++)
		{
			if(hm.get(s.charAt(i))==null)
			hm.put(s.charAt(i),1);
			else
				hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
		}
		
		int den=1;
		for(char c:hm.keySet())
		{
			den*=factorial(hm.get(c));
			
		}
		
		System.out.println(factorial(s.length())/den+"\n");
		
		
	}
	public static int factorial(int n)
	{
		int mul=1;
		for(int i=1;i<=n;i++)
			mul*=i;
		return mul;
	}
	public static boolean isPresent(String s)
	{
		if(res.contains(s))
		return	true;
		return false;
	}
	public static void permute(String s,int l,int r)
	{
		if(l==r)
		{
			if(!isPresent(s))
			{
			res.add(s);	
			System.out.println(s);
			}
		}
		else
		{
			for(int i=l;i<=r;i++)
			{
			s=swap(s,l,i);
			permute(s,l+1,r);
			s=swap(s,l,i);
			}
		}
		
	}

	public static String swap(String s,int l,int r)
	{
		
		StringBuffer sb=new StringBuffer(s);
		char k=sb.charAt(l);
		sb.setCharAt(l, sb.charAt(r));
		sb.setCharAt(r, k);
		s=sb.toString();
		return s;
		
		
//	   char[] ss=new char[s.length()];
//	   ss=s.toCharArray();
//	   System.out.println("Swap : ");
//	   char k=ss[l];
//	   ss[l]=ss[r];
//	   ss[r]=k;
//	   return ss.toString();
	}

}

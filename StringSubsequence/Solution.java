// Look in the copy -- every step, ask do i need to include first char in output string or not
public class StringSubsequence {
    public static void main(String[] args) {
        genSubs("rabbbit", "","rabbit");
    }
    public static void genSubs(String s,String out, String t){
        if(s.length() ==0) {
            System.out.println(out);
            return;
        }
        // Dont keep 1st char in output
        genSubs(s.substring(1), out, t);
        // Keep 1st char in output
        genSubs(s.substring(1), out + s.charAt(0), t);

    }
}


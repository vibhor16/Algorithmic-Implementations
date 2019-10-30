// Bactracking 100%
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<String>();
        
        String map[] = new String[10];
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";

        ArrayList<String> res = new ArrayList<>();

        findCombi(digits,map,"", 0,res);
        return res;
    }
    public void findCombi(String s, String[] map,String res, int index, ArrayList<String> res1){
        if(res.length() == s.length()){
            res1.add(res);
            res = res.substring(0,res.length()-1);
            return;
        }

            for(char cc:((String)map[s.charAt(index)-48]).toCharArray() ){
                findCombi(s,map,res + cc, index+1,res1);
            }

    }
}

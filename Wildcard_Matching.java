public class Solution {
    public boolean isMatch(String s, String p) {
        
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int pend = pc.length;
        int send = sc.length;
        
        int si = 0, pi = 0, star = -1, ss = 0;
        
        while(si < send){
            
            if((pi < pend && pc[pi] == sc[si]) || (pi < pend && pc[pi] == '?')) {si++;pi++;continue;}
            if(pi < pend && pc[pi] == '*') {star = pi++;ss = si;continue;}
            if(star != -1) {pi = star + 1;si = ++ss;continue;}
            return false;
        }
        
        while(pi < pend && pc[pi] == '*') pi++;
        
        return pi == pend;
    }
}

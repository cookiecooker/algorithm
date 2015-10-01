public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> temp = new ArrayList<String>();
        
        if(start == null || end == null || dict == null) return res;
        if(start.equals(end)){
            temp.add(start);
            temp.add(end);
            res.add(temp);
        }
        
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        map.put(end, new ArrayList<String>());
        map.put(start, new ArrayList<String>());
        for(String str : dict) map.put(str, new ArrayList<String>());
        
        HashSet<String> set = new HashSet<String>();
        LinkedList<String> queue = new LinkedList<String>();
        ArrayList<String> cur = new ArrayList<String>();
        queue.offer(end);
        while(!queue.isEmpty()){
            
            int size = queue.size();
            cur.clear();
            set.clear();
            
            for(int i = 0;i < size;i++){
                
                String top = queue.poll();
                dict.remove(top);
                cur.add(top);
            }
            
            for(String str : cur)
                for(int i = 0;i < str.length();i++)
                    for(char c = 'a';c <= 'z';c++){
                        
                        char[] word = str.toCharArray();
                        word[i] = c;
                        String tmp = new String(word);
                        
                        if(!tmp.equals(str) && dict.contains(tmp)){
                            
                            if(!set.contains(tmp)) queue.offer(tmp);
                            map.get(str).add(tmp);
                            set.add(tmp);
                        }
                    }
            
            if(set.contains(start)) break;        
            
        }
       
        temp.add(end);
        buildPath(end,start,map,res,temp);
        return res;
    }
	
    private void buildPath(String end,String start,HashMap<String,ArrayList<String>> map, ArrayList<ArrayList<String>> res,
        ArrayList<String> temp){
            
            if(end.equals(start)){
                
                ArrayList<String> record = new ArrayList<String>(temp);
                Collections.reverse(record);
                res.add(record);
                return;
            }
            
            ArrayList<String> pre = map.get(end);
            for(String str : pre){
                temp.add(str);
                buildPath(str,start,map,res,temp);
                temp.remove(temp.size() - 1);
            }
        
    }

}

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] s1Split = s1.split(" ");
        String[] s2Split = s2.split(" ");
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for(String s : s1Split){
            if(map1.containsKey(s)){
                map1.put(s, map1.get(s) + 1);
            }else{
                map1.put(s, 1);
            }
        }

        for(String s : s2Split){
            if(map2.containsKey(s)){
                map2.put(s, map2.get(s) + 1);
            }else{
                map2.put(s, 1);
            }
        }

        for(String key : map1.keySet()){
            if(map1.get(key) == 1 && !map2.containsKey(key)){
                list.add(key);
            }
        }

        for(String key : map2.keySet()){
            if(map2.get(key) == 1 && !map1.containsKey(key)){
                list.add(key);
            }
        }
        String[] result = new String[list.size()];
        int i = 0;
        for(String s : list){
            result[i++] = s;
        }
        return result;
    }
}
package Hashmap;

import java.util.HashMap;

public class hashmap_map1
{
    public HashMap <String,Integer> map1;

    public void hashmap_map1()
    {
        this.map1 = new HashMap<String, Integer>();
        map1.put("a",1);
        map1.put("b",2);
        map1.put("c",3);
        map1.put("d",4);
    }

    public void output()
    {
        System.out.println(map1);
    }

    public static void main(String [] args)
    {
        hashmap_map1 map_one = new hashmap_map1();
        map_one.hashmap_map1();
        map_one.output();
    }

}

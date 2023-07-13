package Hashmap;

import java.util.HashMap;

public class hashmap_map2
{
    public HashMap<String,Integer> map2;

    public void hashmap_map2()
    {
        this.map2 = new HashMap<String, Integer>();
        map2.put("a",1);
        map2.put("e",2);
        map2.put("c",8);
        map2.put("f",4);
    }

    public void output()
    {
        System.out.println(map2);
    }

    public static void main(String [] args)
    {
        hashmap_map2 map_two = new hashmap_map2();
        map_two.hashmap_map2();
        map_two.output();
    }

}


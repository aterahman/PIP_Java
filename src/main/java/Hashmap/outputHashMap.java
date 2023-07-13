package Hashmap;

import java.util.*;

public class outputMap
{
    public HashMap <String, Integer> map1,map2, outputMap;
    List <String> map1_keys,map2_keys;
    List <Integer>  map1_values,map2_values;

    public void map1_initialisation()
    {
        hashmap_map1 map_one = new hashmap_map1();
        map_one.hashmap_map1();
        this.map1 = map_one.map1;

        Iterator it1 = map1.entrySet().iterator();

        while (it1.hasNext())
        {
            Map.Entry pairs1 = (Map.Entry)it1.next();

        }

        //converting HAshmap keys to Arraylist
        this.map1_keys = new ArrayList<String>(map1.keySet());

        for(String keys : map1_keys)
        {
            System.out.println(keys);
        }

        //converting values to arraylist
        this.map1_values = new ArrayList<Integer>(map1.values());

        for(Integer values : map1_values)
        {
            System.out.println(values);
        }
    }

    public void map2_initialisation()
    {
        hashmap_map2 map_two = new hashmap_map2();
        map_two.hashmap_map2();
        this.map2 = map_two.map2;

        Iterator it2 = map2.entrySet().iterator();

        while (it2.hasNext())
        {
            Map.Entry pairs1 = (Map.Entry)it2.next();

        }

        //converting HAshmap keys to Arraylist
        this.map2_keys = new ArrayList<String>(map2.keySet());

        for(String keys : map2_keys)
        {
            System.out.println(keys);
        }

        //converting values to arraylist
        this.map2_values = new ArrayList<Integer>(map2.values());

        for(Integer values : map2_values)
        {
            System.out.println(values);
        }
    }

    public void outputMap()
    {

        //comparing keys to see if they're equal, adding if they are
        for(int i=0; i< map1_keys.size();i++)
        {
            String new_key ="";
            int new_value =0;

            for(int j = 0; j< map2_keys.size();j++)
            {
                if(((map1_keys.toArray())[i]).equals((map2_keys.toArray())[j]))
                {
                    new_key = ((map1_keys.toArray()[i]).toString());
                    new_value = Integer.parseInt((map1_values.toArray())[i].toString()) + Integer.parseInt((map2_values.toArray())[j].toString());

                }

            }
            if( !new_key.isEmpty() && new_value!=0)
            {
                this.outputMap.put(new_key,new_value);
            }
        }

        //comparing values to see if they are equal
        for(int i = 0; i<map1_values.size(); i++)
        {
            for(int j =0; j<map2_values.size(); j++)
            {
                int map1_value,map2_value;
                String new_map1_key="", new_map2_key="";
                if(((map1_values.toArray())[i]).equals((map2_values.toArray())[j]))
                {
                    new_map1_key = (map1_keys.toArray())[i].toString();
                    new_map2_key = (map2_keys.toArray())[j].toString();
                }
                if(!new_map1_key.isEmpty() && !new_map2_key.isEmpty())
                {
                    System.out.println(new_map1_key + "&" + new_map2_key);
                }
            }
        }




    }

    public void output()
    {
        System.out.println(map1);
        System.out.println(map2);
        System.out.println(outputMap);
    }


    public static void main(String [] args)
    {
        outputMap outputmap = new outputMap();
        outputmap.map1_initialisation();
        outputmap.map2_initialisation();
        outputmap.output();
        outputmap.outputMap();
    }





}

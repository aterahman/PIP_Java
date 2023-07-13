package Hashmap;

import java.util.*;

public class outputHashMap
{
    public static HashMap <String, Integer> map1,map2, outputMap;
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

//        for(String keys : map1_keys)
//        {
//            System.out.println(keys);
//        }

        //converting values to arraylist
        this.map1_values = new ArrayList<Integer>(map1.values());

//        for(Integer values : map1_values)
//        {
//            System.out.println(values);
//        }
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

//        for(String keys : map2_keys)
//        {
//            System.out.println(keys);
//        }

        //converting values to arraylist
        this.map2_values = new ArrayList<Integer>(map2.values());

//        for(Integer values : map2_values)
//        {
//            System.out.println(values);
//        }
    }

    public void outputMap()
    {
        HashMap <String,Integer> outputhashmap = new HashMap<>();

        //comparing keys to see if they're equal, adding if they are
        for(int i=0; i< map1_keys.size();i++)
        {
            String new_key ="";
            int new_value =0;

            for(int j = 0; j< map2_keys.size();j++)
            {
                //checking if the keys match
                if(((map1_keys.toArray())[i]).equals((map2_keys.toArray())[j]))
                {
                    new_key = ((map1_keys.toArray()[i]).toString());
                    System.out.println("The common key is " + new_key);

                    int key1_value = Integer.parseInt((map1_values.toArray())[i].toString());
                    System.out.println("The value of " +new_key+" in Map 1 is :"+key1_value );

                    int key2_value = Integer.parseInt((map2_values.toArray())[j].toString());
                    System.out.println("The value of " +new_key+" in Map 2 is :"+key2_value );

                    //new value is the sum of old values
                    new_value = key1_value +key2_value ;

                }

            }
            if( !new_key.isEmpty() && new_value!=0)
            {
                System.out.println("The new Key and Values are : "+new_key + "=" + new_value);
                outputhashmap.put(new_key,new_value);
            }
        }

        //comparing values to see if they are equal
        for(int i = 0; i<map1_values.size(); i++)
        {
            for(int j =0; j<map2_values.size(); j++)
            {
                int map1_value,map2_value;
                String new_map1_key="", new_map2_key="";

                //checking if the values at the given indexes match
                if(((map1_values.toArray())[i]).equals((map2_values.toArray())[j]))
                {
                    new_map1_key = (map1_keys.toArray())[i].toString();
                    new_map2_key = (map2_keys.toArray())[j].toString();
                }
                if(!new_map1_key.isEmpty() && !new_map2_key.isEmpty() && !new_map1_key.equals(new_map2_key))
                {
                    System.out.println("Keys with same values are :");
                    System.out.println(new_map1_key + "&" + new_map2_key);

                    System.out.println("Their values are : ");
                    System.out.println(map1.get(new_map1_key) + "&" + map2.get(new_map2_key));

                    //adding the keys and values to output map
                    outputhashmap.put(new_map1_key,map1.get(new_map1_key));
                    outputhashmap.put(new_map2_key,map2.get(new_map2_key));
                }
            }
        }


        this.outputMap = outputhashmap;

    }

    //printing all the values
    public static void main(String [] args)
    {
        outputHashMap outputmap = new outputHashMap();
        outputmap.map1_initialisation();
        outputmap.map2_initialisation();

        //Printing map 1
        System.out.println("Map 1 is : "+map1);

        //Printing map 2
        System.out.println("Map 2 is : "+map2);

        //getting the output map
        outputmap.outputMap();

        //printing the output map
        System.out.println("Output Map is :"+outputMap);
    }





}

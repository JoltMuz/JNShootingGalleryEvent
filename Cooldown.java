package io.github.JoltMuz.joltitems;


import java.util.HashMap;
import java.util.Map;


public class Cooldown
{
    public static Map<String, Double> wand = new HashMap<>();

    public static boolean checkCooldown(String playerName, Map ItemName, int cooldown)
    {
        if (ItemName.containsKey(playerName))
        {
            if ( System.currentTimeMillis()/ (double)1000 - (Double) ItemName.get(playerName) > cooldown)
            {
                ItemName.put(playerName,System.currentTimeMillis()/(double)1000);
                return true;
            }
        }
        else
        {
            ItemName.put(playerName,System.currentTimeMillis()/(double)1000);
            return true;
        }
        return false;
    }

}

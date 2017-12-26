/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberfreq;

/**
 *
 * @author jack
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberFreq {

    /**
     * @param args the command line arguments
     */
    public int popular(int[] inputarray){
        Arrays.sort(inputarray);
        int prev = inputarray[0];
        int pop = inputarray[0];
        //going to start from initial position
        
        int count = 1; // current counter of specific element
        int maxCount = 1; //this is used to keep count of maximum element
        
        for (int i = 1; i < inputarray.length; i++)
        {   //iterating through the array
            if (inputarray[i]==prev) //current element will be checked with previous
            {
                count += 1;//since it's true, count is incremented
            }
            else
            {   //not true, which means it is a new element
                if(count > maxCount)
                {   //if this count somehow is greater than the maxcount, this is 
                    //new popular
                    pop = inputarray[i-1];
                    //the reason why it is i-1 is because when new element comes 
                    //the previous one before current one is the most and we need
                    //to remember this info
                    maxCount = count;
                }
                prev = inputarray[i];
                count = 1; //reset it to 1 since we stored the previous value on 
                //maxCount
            }
            
        }
        
        return count > maxCount ? inputarray[inputarray.length-1] : pop;
        //if count > maxCount, then the array before the last element was the most popular
        //else previously stored pop is the answer
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int list[]={1,2,3,4,5,5,6,7,7,7,8,7};
        int result = new NumberFreq().popular(list);
        //calling class
        System.out.println(result);
        System.out.println("Just testing");
             
    }
    
}

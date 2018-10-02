package com.collibra.exercise; 

import java.net.*;
import java.io.*;
 
public class CollibraConversation {
 
    public String processInput(String theInput) {
        String theOutput = null;
        System.out.println("The input was " + theInput);

        if (theInput.startsWith("HI, I'M")) {
            theOutput = "HI " + theInput.substring(7);
        }
        
        return theOutput;
    }
}

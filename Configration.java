/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.managment.system;

import java.util.Random;
import java.util.UUID;

/**
 *
 * @author monirozzaman.rony
 */
public class Configration {

    public static String getRendomId() {
        Random ran = new Random();
        int x = ran.nextInt(6) + 5;
        return String.valueOf(x);
    }

}

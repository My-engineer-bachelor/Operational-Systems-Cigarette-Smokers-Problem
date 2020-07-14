/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author lab
 */
public class ProblemTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        try {
        	new Problem().simulate();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}

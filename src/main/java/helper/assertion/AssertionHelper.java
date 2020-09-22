package helper.assertion;


import static org.junit.jupiter.api.Assertions.*;

public class AssertionHelper {

    /**
     * Compare two strings using Junit assertion
     * @param  s1
     * @param  s2
     */
    public static void verifyText(String s1, String s2){
        assertEquals(s1, s2);
    }

    /**
     * Verify the station is true or false
     * @param status
     */
    public static void verifyTrue(boolean status){
        assertTrue(status);
    }

    /**
     * Verify the station is true or false
     * @param status
     */
    public static void verifyFalse(boolean status){
        assertFalse(status);
    }

    /**
     * Verify if string object is null or not
     * @param s1
     */
    public static void verifyNull(String s1){
        assertNull(s1);
    }

    /**
     * Verify if string object is null or not
     * @param s1
     */
    public static void verifyNotNull(String s1){
        assertNotNull(s1);
    }

    /**
     * Check if the condition is false
     */
    public static void fail(){
        assertTrue(false);
    }

    /**
     * Check if the condition is true
     */
    public static void pass(){
        assertTrue(true);
    }

    /**
     * Update the test status as per pass or fail
     * @param status
     */
    public static void updateTestStatus(boolean status){
        if(status){
            pass();
        }
        else{
            fail();
        }
    }

}

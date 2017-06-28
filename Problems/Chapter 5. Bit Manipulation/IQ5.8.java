import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 5: Bit Manipulation
        // IQ 5.8: Draw Line

        /*

        Question: Draw Line: A monochrome screen is stored as a single array of bytes, allowing eight consecutive
        pixels to be stored in one byte. The screen has width w, where w is divisible by 8 (that is, no byte will
        be split across rows). The height of the screen, of course, can be derived from the length of the array
        and the width. Implement a function that draws a horizontal line from (xl, y) to (x2 J y) .
        The method signature should look something like:

        drawLine(byte[] screen, int width, int x1, int x2, int y)

        Hints: #366, #381, #384, #391
         */
        

    }

    public static byte[] drawLine(byte [] screen, int width, int x1, int x2, int y){

        // Adjust x values to proper pixel values in screen
        x1 *= width*y;
        x2 *= width*y;


        for (int x = x1; x <= x2; x++){

            int arrayIndex =  x/8;
            
            if ( (x % 8 == 0) && (x + 7 <= x2) ){
                screen[arrayIndex]  = (byte) (-1);
                x+= 8;
            }
            else{
                int pixelIndex = x % 8;
                int binaryIndex = 7 - pixelIndex;
                
                int mask = 1;
                mask = mask << binaryIndex;
                
                screen[arrayIndex] = (byte) (screen[arrayIndex] | mask);
            }
        }

        return screen;
    }




}
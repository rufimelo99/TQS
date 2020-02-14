import org.junit.jupiter.api.Test;
import tqsua.lab1stack.TQS_stack;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;
/*
    -> CTRL+SHIFT+F10 to run tests
*/
 */
public class TQS_stack_test {
    public TQS_stack_test(){

    }

    @Test
    public void Empty_on_Construction( ){
        TQS_stack Stack = new TQS_stack();
        assertTrue(Stack.isEmpty(), "It is not empty on construction");
    }
    @Test
    public void Size0_on_Construction( ){
        TQS_stack Stack = new TQS_stack();
        assertEquals(Stack.size(), 0, "A stack does not has size 0 on construction");
    }

    @Test
    public void n_pushes( ){
        TQS_stack Stack = new TQS_stack();
        int r= 1 + (int)(Math.random() * ((100 - 1) + 1));
        for(int i=0; i<r; i++){
            Stack.push(1);
        }
        assertEquals(r, Stack.size(), "After n pushes to an empty stack, n > 0, the stack is not empty and its size is not n");
    }

    @Test
    public void value_push_and_popped_are_the_same(){
        TQS_stack Stack = new TQS_stack();
        int r= 1 + (int)(Math.random() * ((100 - 1) + 1));
        Stack.push(r);
        assertEquals(r, Stack.pop(), "If one pushes x then pops, the value popped is not x.");
    }

    @Test
    public void value_push_and_peeked_and_size(){
        TQS_stack Stack = new TQS_stack();
        int initial_size = Stack.size();
        int r= 1 + (int)(Math.random() * ((100 - 1) + 1));
        Stack.push(r);
        Stack.pop();
        int final_size = Stack.size();

        assertEquals(initial_size, final_size, "If one pushes x then peeks, the value returned is x, but the size does not stay the same");

    }

    @Test
    public void n_size_and_n_pops(){

        TQS_stack Stack = new TQS_stack();
        int r= 1 + (int)(Math.random() * ((100 - 1) + 1));
        for(int i=0; i<r; i++){
            Stack.push(1);
        }


        int initial_size = Stack.size();
        for(int i=0; i<initial_size; i++){
            Stack.pop();
        }


        assertEquals(0, Stack.size(), "If the size is n, then after n pops, the stack is not empty nor his size is 0");
    }

    //https://www.baeldung.com/junit-assert-exception
    @Test
    public void popping_empty_stack(){
        TQS_stack Stack = new TQS_stack();
        assertThrows(NoSuchElementException.class, () -> {
            Stack.pop();
        }, "Popping from an empty stack does not throw a NoSuchElementException ");

    }


    @Test
    public void peeking_empty_stack(){
        TQS_stack Stack = new TQS_stack();
        assertThrows(NoSuchElementException.class, () -> {
            Stack.peek();
        }, "Peeking into anempty stack does not throw a NoSuchElementException");

    }

    @Test
    public void check_bounds(){
        assertThrows(IllegalStateException.class, () -> {
            TQS_stack Stack = new TQS_stack();
            int r= 1 + (int)(Math.random() * ((100-1) + 1));
            Stack.setBounds(r);
            for(int i=0; i<r+1; i++){
                Stack.push(1);
            }
        }, "For bounded stacks only, pushing onto a full stack does not throw an IllegalStateException");

    }


}

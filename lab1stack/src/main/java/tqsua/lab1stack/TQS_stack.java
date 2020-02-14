package tqsua.lab1stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class TQS_stack {
    private ArrayList<Integer> elementos;
    private Integer Bounds = null;

    public TQS_stack(){
        elementos = new ArrayList<>();
    }
    public void setBounds(Integer bounds) {
        this.Bounds = bounds;
    }



    public boolean push(Integer elem){
        if (this.Bounds == null){
            elementos.add(elem);
            return true;
        }
        else{

            if(elementos.size()==Bounds){
                throw new IllegalStateException();
            }
            else{

                elementos.add(elem);
                return true;
            }
        }
    }

    public Integer pop(){
        if (elementos.size()>0) {
            int elem_popped= elementos.get(elementos.size()-1);
            elementos.remove( elementos.size()-1);
            return elem_popped;
            }
        else {
            throw new NoSuchElementException();
        }
        }



    public Integer peek(){
        if( elementos.size()>0){

            return elementos.get(elementos.size()-1);
        }
        else{
            throw new NoSuchElementException();
        }
    }

    public boolean isEmpty(){
        if (elementos.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public Integer size(){
        return elementos.size();
    }

    public int getBounds() {
        return this.Bounds;
    }
}



package question3;

import question3.tp3.PileI;
import question3.tp3.PileVideException;
import question3.tp3.PilePleineException;

public class PileModele<T> extends  java.util.Observable implements PileI<T> {

    private PileI<T> pile;
   //constracteur
    public PileModele(PileI<T> pile) {
        this.pile = pile;
    }
    //add element 
    public void empiler(T o) throws PilePleineException {
        if (estPleine()) throw new PilePleineException(o.toString());
        try{
            this.pile.empiler(o);
        }catch(Exception e){

        }finally{
            setChanged();
            notifyObservers();
        } 
    }
   //remove element
    public T depiler() throws PileVideException {
        if (estVide()) throw new PileVideException();
        
        try{
            return this.pile.depiler();
        }catch(Exception e){
            
        }finally{
            setChanged();
            notifyObservers();
        }
        return null;
    }
   //sommet 
    public T sommet() throws PileVideException {
        if (estVide()) throw new PileVideException();
        return  this.pile.sommet();
    }
   //taille du pile
    public int taille() {
        return pile.taille();
    }
    //capacite
    public int capacite() {
        return pile.capacite();
    }
    //pil vide
    public boolean estVide() {
        return pile.estVide();
    }
   //pile pleine
    public boolean estPleine() {
        return pile.estPleine();
    }

    public String toString() {
        return pile.toString();
    }
}
package question1;

public class PatternObservateur extends junit.framework.TestCase {

    public void testNotify() {
        ConcreteSubject list;
        ConcreteObserver observer;

        list = new ConcreteSubject();           // création d'un "observé" constitué d'une liste
        observer = new ConcreteObserver();      // création d'un observateur
        list.addObserver(observer);             // ajouter cet observateur à la liste
        list.insert("il fait beau, ce matin");  // modification de cette liste, l'observateur doit
                                                // (dervrait) être notifié

        // "vérification" :
        assertFalse(observer.senders().empty());                            // elle ne doit pas être vide,
        assertEquals(list, observer.senders().pop());                       // est-ce le bon émetteur ?
        assertEquals("il fait beau, ce matin", observer.arguments().pop()); // le paramètre reçu est-il correct ?
    }

    
    public void test1() {
       /*initi les liste observable.*/
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();// list
        
        question1.ConcreteObserver o1 = new question1.ConcreteObserver();//premiere observable
        
        question1.ConcreteObserver o2 = new question1.ConcreteObserver();// deusieme observable
        l1.addObserver(o1);
        l1.addObserver(o2);
        l1.insert("test");
        l1.insert(" 1 ");
        
        assertFalse(o1.senders().empty());
        assertFalse(o2.senders().empty()); 
        //pop du o1
        assertEquals(l1, o1.senders().pop()); 
        assertEquals(l1, o1.senders().pop()); 
        //pop du o2
        assertEquals(l1, o2.senders().pop());
        assertEquals(l1, o2.senders().pop()); 
        //insertion des elem
        assertEquals(" 1 ", o1.arguments().pop());
        assertEquals(" 1 ", o2.arguments().pop());
        assertEquals("test", o1.arguments().pop());
        assertEquals("test", o2.arguments().pop());
        
        assertTrue(o1.senders().empty() && o1.arguments().empty());
        assertTrue(o2.senders().empty() && o2.arguments().empty());
    }
 
    
    
   

    
    public void test2() {
        
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();// 1er list
        
        question1.ConcreteSubject l2 = new question1.ConcreteSubject();// 2 list 
        
        question1.ConcreteObserver o = new question1.ConcreteObserver();// 1 observ
        l1.addObserver(o);
        l2.addObserver(o);
        l1.insert("testA");
        l1.insert(" A ");
        l2.insert("testB");
        l2.insert(" B ");
 //pop
        assertEquals(l2, o.senders().pop());
        assertEquals(l2, o.senders().pop());
        assertEquals(l1, o.senders().pop());
        assertEquals(l1, o.senders().pop());
        assertEquals(" B ", o.arguments().pop());
        assertEquals("testB", o.arguments().pop()); 
        assertEquals(" A ", o.arguments().pop());
        assertEquals("testA", o.arguments().pop());
 
        assertTrue(o.senders().empty() && o.arguments().empty());
    }
 
  

    
    public void test3() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteSubject l2 = new question1.ConcreteSubject();// 2 list
        question1.ConcreteObserver o1 = new question1.ConcreteObserver();
        question1.ConcreteObserver o2 = new question1.ConcreteObserver();// 2 obser
        l1.addObserver(o1);
        l1.addObserver(o2);
        l2.addObserver(o1);
        l2.addObserver(o2);
 
        assertTrue(l1.countObservers() == 2);
        assertTrue(l2.countObservers() == 2);
        l1.deleteObserver(o1);
        assertTrue(l1.countObservers() == 1);
        l1.deleteObserver(o2);
        assertTrue(l1.countObservers() == 0);
        l2.deleteObservers();
        assertTrue(l2.countObservers() == 0);
 
        assertTrue(o1.senders().empty());
        assertTrue(o2.senders().empty());
        assertTrue(l1.countObservers() == 0);
        assertTrue(l2.countObservers() == 0);
   
    
    
    
}}

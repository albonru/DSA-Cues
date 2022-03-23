package edu.upc.eetac.dsa;

public class QueueImpl<E> implements Queue<E> {

    public int max; //max elements allowed in queue
    public E[] queue; //queue of E generic type
    public int nelem; //number of elements in queue

    public QueueImpl (int max) {
        this.max = max;
        this.queue = (E[]) new Object[max]; //Q : A QUE SI NO A NULL?? A NEW E[MAX]?? A : SI, PERO OBJECT
                                            //A : TIPUS GENERIC NO TE CONSTRUCTOR, FER CAST
        this.nelem = 0;
    }

    @Override
    public void push(E e) throws FullQueueException { //Q: OMPLIR CLASSES EXCEPCIONS?? A : NO

            if (this.nelem < this.max) {
                this.queue[this.nelem] = e;
                this.nelem++;
            }
            else {
                throw new FullQueueException();
            }
    }

    @Override
    public E pop() throws EmptyQueueException { //Q : TRY-CATCH O IF-ELSE?? A : IF ELSE, ALGU ALTRE FA TRYCATCH
        if (this.nelem != 0) {
                E popped = this.queue[0]; //Q : PRIMER O ULTIM OBJECTE DEL ARRAY?? A : NO ES PILA, TREUS PRIMER
                this.queue[0] = null;
                for (int i = 0; i<this.nelem; i++) //Q : CONFIRMAR NO UN FOR-EACH?? A : NO, CONTROL INDEX
                    this.queue[i] = this.queue[i+1];
                this.nelem--;
                return popped;
        }
        else
            throw new EmptyQueueException();
    }

    @Override
    public int size() {
        return this.nelem;
    }
}

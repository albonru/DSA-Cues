package edu.upc.eetac.dsa;

public class QueueImpl<E> implements Queue<E> {

    public int max; //max elements allowed in queue
    public E[] queue; //queue of E type

    public QueueImpl (int max) {
        this.max = max;
        this.queue = null; //CONSULTA : A QUE SI NO A NULL??
    }

    @Override
    public void push(E e) throws FullQueueException { //CONSULTA: OMPLIR CLASSES EXCEPCIONS??
        try {
            if (this.queue.length < this.max)
                this.queue[this.queue.length - 1] = e;
        }
        catch(Exception FullQueueException) {
            System.out.println("Full Queue");
        }
    }

    @Override
    public E pop() throws EmptyQueueException { //CONSULTA : TRY-CATCH O IF-ELSE??
        try {
            if (this.queue.length != 0) {
                E popped = this.queue[0];
                this.queue[0] = null;
                for (int i = 0; i<this.queue.length; i++) //CONSULTA : CONFIRMAR NO UN FOR-EACH??
                    this.queue[i] = this.queue[i+1];
                return popped;
            }
        }
        catch(Exception EmptyQueueException) {
            System.out.println("Empty Queue");
        }
        return null; //CONSULTA : DEMANA RETURN, NULL??
    }

    @Override
    public int size() {
        return this.queue.length;
    }
}

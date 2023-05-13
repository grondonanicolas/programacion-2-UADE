package org.uade.adt;

public interface IGenericQueueOfQueue<T> {

    /**
     * Añade una cola a la cola de colas.
     * @param q la cola a añadir.
     */
    void add(GenericQueue<T> q);

    /**
     * Remueve la primera cola de la cola de colas.
     */
    void remove();

    /**
     * Revisa si la cola de colas está vacía.
     * @return true si la cola de colas está vacía, false en caso contrario.
     */
    boolean isEmpty();

    /**
     * Obtiene la primera cola de la cola de colas.
     * @return la primera cola de la cola de colas.
     */
    GenericQueue<T> getFirst();

    /**
     * Concatena otra cola de colas a esta cola.
     * @param q la cola de colas a concatenar.
     */
    void concatenate(IGenericQueueOfQueue<T> q);

    /**
     * Aplana la cola de colas en una sola cola.
     * @return una cola con todos los elementos de la cola de colas.
     */
    IGenericQueue<T> flat();

    /**
     * Invierte la cola de colas y cada cola dentro de esta.
     */
    void reverseWithDepth();
}

package com.carlos.pruebas.ED;

import com.carlos.pruebas.ED.Exceptions.NoDataException;
import java.util.ArrayList;

/**
 * Al igual que una pila normal esta puede guardar los datos agregando un tag de
 * identificacion para buscar elementos dentro de la pila
 *
 * @author benjamin
 * @param <T>
 */
public class PilaTag<T> {

    private NodoPilaTag<T> raiz;
    private int size;

    /**
     * Contructor de la Pila
     */
    public PilaTag() {
        this.raiz = null;
        this.size = 0;
    }

    /**
     * Introduce un elemento en la pila
     *
     * @param data
     * @param tag
     */
    public void push(T data, String tag) {
        if (this.raiz == null) {
            this.raiz = new NodoPilaTag<T>(data, tag, null);
            this.size++;
        } else {
            NodoPilaTag<T> tmp = this.raiz;
            this.raiz = new NodoPilaTag<T>(data, tag, tmp);
            this.size++;
        }
    }

    /**
     * Retira el elmento superior de la pila sacandolo Si la pila esta vacia
     * genera una excepcion NoDataException
     *
     * @return
     */
    public T pop() {
        if (this.isEmpty()) {
            return null;
        } else {
            NodoPilaTag<T> tmp = this.raiz;
            this.raiz = tmp.getNext();
            this.size--;
            return tmp.getData();
        }
    }

    /**
     * Retorna el objeto superior en la pila sin sacarlo Si la pila esta vacia
     * genera una excepcion NoDataException
     *
     * @return
     */
    public T peek() throws NoDataException {
        if (this.isEmpty()) {
            throw new NoDataException("No hay elementos en la pila");
        } else {
            return this.raiz.getData();
        }
    }

    /**
     * Retorna un valor logico, si existe un elemento en la pila con un tag
     * determinado
     *
     * @param tag
     * @return
     */
    public boolean buscar(String tag) {
        if (this.isEmpty()) {
            return false;
        } else {
            NodoPilaTag<T> tmp = this.raiz;
            while (tmp != null) {
                if (tmp.getTag().equals(tag)) {
                    return true;
                }
                tmp = tmp.getNext();
            }
            return false;
        }
    }

    /**
     *
     * @param tag
     * @return
     */
    public T retornar(String tag) {
        if (this.isEmpty()) {
            return null;
        } else {
            NodoPilaTag<T> tmp = this.raiz;
            while (tmp != null) {
                if (tmp.getTag().equals(tag)) {
                    return tmp.getData();
                }
                tmp = tmp.getNext();
            }
            return null;
        }
    }

    /**
     * Retorna un valor logico si la pila esta vacia, true si lo esta, false si
     * esta tiene elementos
     *
     * @return
     */
    public boolean isEmpty() {
        if (this.raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna el tamaño de la pila
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Retorna la pila en forma de ArrayList
     *
     * @return
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> data = new ArrayList<>();
        if (this.raiz == null) {
            data = null;
        } else {
            NodoPilaTag<T> tmp = this.raiz;
            while (tmp != null) {
                data.add(tmp.data);
                tmp = tmp.getNext();
            }
        }
        return data;
    }
    
    /**
     * Retorna la pila en forma de Array
     *
     * @return
     */
    public T[] toArray(Class<T[]> arrayType) {
        T[] res = null;
        if (this.toArrayList() == null) {
            return null;
        } else {
            res = arrayType.cast(java.lang.reflect.Array.newInstance(arrayType.getComponentType(), this.toArrayList().size()));
            for (int i = 0; i < res.length; i++) {
                res[i] = this.toArrayList().get(i);
            }
        }
        return res;
    }

    public void imprimirPila() {
        if (this.raiz == null) {
            System.out.println("Pila vacia");
        } else {
            System.out.println("-----------------------");
            NodoPilaTag<T> tmp = this.raiz;
            while (tmp != null) {
                System.out.println(tmp.toString());
                tmp = tmp.getNext();
            }
            System.out.println("-----------------------");
        }
    }

    public class NodoPilaTag<T> {

        private NodoPilaTag<T> next;
        private T data;
        private String tag;

        public NodoPilaTag(T data, String tag, NodoPilaTag<T> next) {
            this.next = next;
            this.data = data;
            this.tag = tag;
        }

        /**
         * Retorna el siguiente elemento del nodo evaluado
         *
         * @return
         */
        public NodoPilaTag<T> getNext() {
            return next;
        }

        /**
         * Retorna el dato guardado en el nodo evaluado
         *
         * @return
         */
        public T getData() {
            return data;
        }

        /**
         * Retorna el tag del elemento en la pila
         *
         * @return
         */
        public String getTag() {
            return tag;
        }

        @Override
        public String toString() {
            return "Data: " + data;
        }

    }
}

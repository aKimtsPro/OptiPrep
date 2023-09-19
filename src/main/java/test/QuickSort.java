package test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickSort {

    public static int iter = 0;

    public static void main(String[] args) {
        int[] tab = IntStream.generate( () -> (int)(Math.random()*100) )
                .limit(10000)
                .toArray();

        System.out.println(Arrays.toString(tab));
        quickSort(tab, 0, tab.length-1);
        System.out.println(Arrays.toString(tab));
    }

    public static void quickSort(int[] tab, int start, int end){
        if( start >= end ) return;

        // On prend un pivot, on met les valeurs inférieurs avant, supérieurs après
        int indexPivot = partionner(tab, start, end);

        // On refait l'algo pour les valeurs d'avant et les valeurs d'après
        quickSort(tab, start, indexPivot-1);
        quickSort(tab, indexPivot+1, end);
    }

    public static int partionner(int[] tab, int start, int end){
        int pivot = tab[end];
        int i = start-1;

        for (int j = start; j < end; j++) {
            ++iter;
            if( tab[j] < pivot && ++i != j ){
                int temp = tab[j];
                tab[j] = tab[i];
                tab[i] = temp;
            }
        }

        i++;
        tab[end] = tab[i];
        tab[i] = pivot;

        return i;
    }

}

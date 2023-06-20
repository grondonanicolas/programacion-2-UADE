package org.uade.exercise4;

import org.uade.adt.*;

public class Exercise4 {
    public static ISet generateSetWithAddAll(){
        ISet initialSetAddAll = generateBuilderSet().Add(1);
        int[] values = {9, 2, 94};
        return initialSetAddAll.AddAll(values, initialSetAddAll);
    }
    public static IStack generateBuilderStack() {
        return new Stack();
    }

    public static ISet generateBuilderSet() {
        return new Set();
    }
}

package org.uade.exercise4;

import org.uade.adt.*;

public class Exercise4 {
    public static ISet generateInitialSetAddAll(){
        ISet initialSetAddAll = generateBuilderSet().add(9).add(2).add(94);
        return initialSetAddAll;
    }

    public static ISet generateFinalSetAddAll(ISet initialSet){
        ISet finalSet = generateBuilderSet();
        return finalSet.addAll(initialSet);
    }
    public static IStack generateBuilderStack() {
        return new Stack();
    }

    public static ISet generateBuilderSet() {
        return new Set();
    }
}

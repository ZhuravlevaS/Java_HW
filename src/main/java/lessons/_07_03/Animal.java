package lessons._07_03;

public interface Animal { public default String getName() { return null; } }
 interface Mammal { public default String getName() { return null; } }
 abstract class Otter implements Mammal, Animal {
     @Override
     public String getName() {
         return Mammal.super.getName();
     }
 }

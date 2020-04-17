
package pkg05_shapes;

public abstract class Shape {
    //data
    protected String name = "Geometric objekt"; //bude viditelné v potomcích
    
    
    
    //methods
    public String getShapeName(){//
    return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {//překrýva toString třídy object, defaultná implementace, muze byt prekryta
    return this.name + ": " + getShapeName();
    }
    
    
    
   
    public abstract double computeArea();
}

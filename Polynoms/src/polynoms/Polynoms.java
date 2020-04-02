package polynoms;
//knihovní třída

public class Polynoms {

    private Polynoms() {
//nemuze se vytvorit objekt
    }

    public static Polynom sum(Polynom a, Polynom b) {
        boolean isABigger = a.getDegree() > b.getDegree();

        Polynom max = isABigger ? a : b;
        Polynom min = isABigger ? b : a;
        double[] sumCoef = new double[max.getDegree() + 1];
        for (int i = 0; i < max.getDegree() + 1; i++) {
            sumCoef[i] = max.getCoefAt(i);
        }
        for (int i = 0; i < min.getDegree() + 1; i++) {
            sumCoef[i] = sumCoef[i] + min.getCoefAt(i);
        }
        return Polynom.getInstanceReverted(sumCoef);
    }
    
    //TODO 
    public static Polynom multiply(Polynom a, Polynom b){
    int sizeA = a.getDegree();
        int sizeB = b.getDegree();
        double[] p1 = a.getAllCoef();
        double[] p2 = b.getAllCoef();
        double[] multiCoef = new double[sizeA + sizeB + 1];
        for (int i = 0; i < sizeA + sizeB + 1; i++) {
            multiCoef[i] = 0;
        }
        for (int i = 0; i < sizeA + 1; i++) {
            for (int j = 0; j < sizeB + 1; j++) {
                multiCoef[i + j] = multiCoef[i + j] + (p1[i] * p2[j]);
            }
        }
        return Polynom.getInstanceReverted(multiCoef);
    }

    public static void main(String[] args) {
        Polynom p1 = Polynom.getInstance(5, 3, 0, 6);
        Polynom p2 = Polynom.getInstance(6, 3, 1);
        System.out.println(Polynoms.sum(p1, p2));
        System.out.println(p2.computeValue(2));
    }

}

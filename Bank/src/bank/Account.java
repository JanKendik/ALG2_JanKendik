package bank;

public class Account {

    private double money;

    public Account() {
        this.money = 0;
        //prázdný konstruktor, pro možnost vytvoření prázdného účtu
    }

    public Account(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
    

    public void addAmount(double amountIn) {
        if (amountIn > 0) {
            this.money = this.money + amountIn;
        } else {
            throw new IllegalArgumentException("Vkládaný obnos musí týt kladné číslo");
        }
    }

    public void takeAmount(double amountOut) {
        if ((amountOut <= this.money) && (amountOut > 0)) {
            this.money = this.money - amountOut;
        } else {
            throw new IllegalArgumentException("Vybíraný obnos musí být kladné číslo, Nebo na účtě již nemáte dost peněz");
        }
    }

    @Override
    public String toString() {
        return "Account{" + "money=" + money + '}';
    }

    
    
   /* public static void main(String[] args) {
        Account a = new Account();
        Account b = new Account(100);
        //b.takeAmount(110);
        System.out.println(b.toString());
        System.out.println(a.toString());
        a.addAmount(10);
        System.out.println(a.toString());
    }*/
}

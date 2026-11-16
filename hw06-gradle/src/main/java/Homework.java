import enums.Banknote;

import java.util.ArrayList;
import java.util.List;

public class Homework {
    static void main() {
        List<Banknote> banknotes = new ArrayList<>();
        banknotes.add(Banknote.FIVE);
        banknotes.add(Banknote.TEN);
        banknotes.add(Banknote.TWENTY);
        banknotes.add(Banknote.FIFTY);
        banknotes.add(Banknote.HUNDRED);
        ATM atm = new ATM(banknotes);
        atm.deposit(Banknote.HUNDRED, 2);
        atm.deposit(Banknote.FIFTY, 1);
        System.out.println(atm.getBalance());

        System.out.println(atm.withdraw(100));
        System.out.println(atm.getBalance());
    }
}

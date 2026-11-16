import enums.Banknote;

import java.util.*;

public class ATM {
    private Map<Integer, Integer> balance;

    public ATM(List<Banknote> banknotes) {
        balance = new HashMap<>();
        for (Banknote b : banknotes) {
            balance.put(b.getValue(), 0);
        }
    }

    public boolean deposit(Banknote banknote, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("count must be greater than 0");
        }
        balance.put(banknote.getValue(), balance.get(banknote.getValue()) + count);
        return true;
    }

    public boolean withdraw(int amount) {
        validateAmount(amount);

        int temp = getBalance();
        if (temp < amount) {
            throw new IllegalArgumentException("Not enough balance.");
        }

        Map<Integer,Integer> map = new HashMap<>(balance);
        if (process(map, amount)) {
            balance = map;
            return true;
        }
        return false;
    }

    private boolean process(Map<Integer,Integer> map, int amount) {
        Set<Integer> keys = new TreeSet<>(Collections.reverseOrder());
        keys.addAll(map.keySet());
        for (int i : keys) {
            if (i > amount) {
                continue;
            }

            int countBanknotes = map.get(i);

            if (countBanknotes > 0) {

                int c = amount / i;
                if (c > 0) {
                    if (countBanknotes >= c) {
                        amount -= c * i;
                        map.put(i, map.get(i) - c);
                    } else {
                        amount -= countBanknotes * i;
                        map.put(i, map.get(i) - countBanknotes);
                    }

                    if (amount == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getBalance() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : balance.entrySet()) {
            sum += entry.getValue() * entry.getKey();
        }
        return sum;
    }

    private static void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
    }
}

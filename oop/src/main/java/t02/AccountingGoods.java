package t02;


import t02.goods.Good;
import t02.goods.OfficeGood;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Map;

/**
 * Created on 18.01.2017.
 */
public class AccountingGoods {
    private List<Accountable<Good>> list = new ArrayList<>();

    public AccountingGoods() {
    }

    public void add(Accountable<Good> accountable) {
        list.add(accountable);
    }

    public int overallAmount() {
        int amount = 0;
        for (Accountable<Good> accountable : list) {
            amount += accountable.overallAmount();
        }
        return amount;
    }

    public double totalCost() {
        double total = 0;
        for (Accountable<Good> accountable : list) {
            total += accountable.totalCost();
        }
        return total;
    }

    public void printReport(Accountable<Good> accountable) {
        int counter = 1;
        Formatter f = new Formatter(System.out);
        f.format("%s #%d\n", accountable.getName(), accountable.getId());
        if (accountable.goods().isEmpty()) {
            f.format("empty\n\n");
            return;
        }
        f.format("    %s      %s    %s\n", "name", "amount", "cost, $");
        for (Map.Entry<Good, Integer> entry : accountable.goods().entrySet()) {
            Good good = entry.getKey();
            int number = entry.getValue();
            f.format("%2d. %-8.10s\t%d\t\t%.2f\n", counter++, good.getName(), number, good.getPrice()*number);
        }
        f.format("%14.5s\t%d\t\t%.2f\n\n", "Total", accountable.overallAmount(), accountable.totalCost());
    }

    public void printReport() {
        for (Accountable<Good> accountable : list) {
            printReport(accountable);
        }
        new Formatter(System.out).format("%14.7s\t%d\t\t%.2f\n\n", "Result", overallAmount(), totalCost());
    }

    public static void main(String[] args) {
        Workplace workplace1 = new Workplace();
        Workplace workplace2 = new Workplace();
        Worker worker = new Worker("Ivan", workplace1);
        AccountingGoods accountingGoods = new AccountingGoods();
        accountingGoods.add(worker.getWorkplace());
        accountingGoods.add(workplace2);

        workplace2.addGood(new OfficeGood(14, "Pen"));

        workplace1.addGood(new OfficeGood(12, "Pen"));
        workplace1.addGood(new OfficeGood(12, "Pen"));
        workplace1.addGood(new OfficeGood(15, "Pencil"));
        workplace1.addGood(new OfficeGood(15.34, "Ruler"));
        workplace1.addGood(new OfficeGood(123.34, "Ruler"));
        workplace1.addGood(new OfficeGood(123.34, "Paper"));

        accountingGoods.printReport();

        workplace1.deleteGood(new OfficeGood(123.34, "Paper"));
        accountingGoods.printReport();
    }
}

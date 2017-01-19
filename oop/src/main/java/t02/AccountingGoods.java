package t02;


import t02.goods.Good;
import t02.goods.OfficeGood;

import java.util.Formatter;
import java.util.Map;

/**
 * Created on 18.01.2017.
 */
public class AccountingGoods {
    private Accountable<Good> accounting;

    public AccountingGoods(Accountable<Good> accounting) {
        this.accounting = accounting;
    }

    public void printReport() {
        int counter = 1;
        Formatter f = new Formatter(System.out);
        f.format("%s #%d\n", accounting.getName(), accounting.getId());
        for (Map.Entry<Good, Integer> entry : accounting.goods().entrySet()) {
            Good good = entry.getKey();
            int number = entry.getValue();
            f.format("%2d. %-8.10s\t%d goods cost %.2f $\n", counter++, good.getName(), number, good.getPrice()*number);
        }
        f.format("%14.5s\t%d goods cost %.2f $\n", "Total", accounting.itemsNumber(), accounting.totalCost());
    }

    public static void main(String[] args) {
        Workplace workplace = new Workplace();
        workplace.addGood(new OfficeGood(12, "Pen"));
        workplace.addGood(new OfficeGood(12, "Pen"));
        workplace.addGood(new OfficeGood(15, "Pencil"));
        workplace.addGood(new OfficeGood(15.34, "Ruler"));
        workplace.addGood(new OfficeGood(123.34, "Ruler"));
        workplace.addGood(new OfficeGood(123.34, "Paper"));

        Accountable<Good> wp = workplace;
        AccountingGoods service = new AccountingGoods(wp);
        service.printReport();

        workplace.deleteGood(new OfficeGood(123.34, "Paper"));
        service.printReport();
    }
}

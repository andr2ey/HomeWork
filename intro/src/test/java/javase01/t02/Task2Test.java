package javase01.t02;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;


public class Task2Test {

    @Test
    public void leastNumberVerification() {
        Assert.assertThat(Task2.leastNumber(0.26), is(1));
        Assert.assertThat(Task2.leastNumber(0.25), is(2));
        Assert.assertThat(Task2.leastNumber(0.004), is(15));
        Assert.assertThat(Task2.leastNumber(0.0004), is(50));
        Assert.assertThat(Task2.leastNumber(4E-10), is(50_000));
    }

}

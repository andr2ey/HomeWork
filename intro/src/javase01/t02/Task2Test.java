package javase01.t02;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;


public class Task2Test {

    @Test
    public void leastNumberVerification() {
        Assert.assertThat(Task2.searchOfLeastNumber(0.26), Is.is(1));
        Assert.assertThat(Task2.searchOfLeastNumber(0.25), Is.is(2));
        Assert.assertThat(Task2.searchOfLeastNumber(0.004), Is.is(15));
        Assert.assertThat(Task2.searchOfLeastNumber(0.0004), Is.is(50));
        Assert.assertThat(Task2.searchOfLeastNumber(4E-10), Is.is(50_000));
        Assert.assertThat(Task2.searchOfLeastNumber(5.562684646268004E-16), Is.is(42_399_211));
    }

}
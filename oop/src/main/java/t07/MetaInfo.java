package t07;

import java.lang.annotation.*;

/**
 * Created on 20.01.2017.
 */
@Target(ElementType.TYPE)
@Documented
public @interface MetaInfo {
    String author() default "unknown";
    String lastModified();
}

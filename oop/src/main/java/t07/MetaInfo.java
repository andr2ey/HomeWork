package t07;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created on 20.01.2017.
 */
@Target(ElementType.TYPE)
@Documented
public @interface MetaInfo {
    String author();
    String lastModified();
}

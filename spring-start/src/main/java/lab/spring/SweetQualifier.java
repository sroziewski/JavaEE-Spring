package lab.spring;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE})
//@Retention(RetentionPolicy.SOURCE) // after compilation it is removed from bytecode e.g. Override, Deprecated
@Retention(RetentionPolicy.RUNTIME) // after compilation it exists in bytecode
@Qualifier // treated as Qualifier
public @interface SweetQualifier {
}

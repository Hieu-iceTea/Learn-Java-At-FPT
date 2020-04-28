package AdvancedLearning.LearnAnnotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE)

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.SOURCE)

public @interface MyAnnotation {
    public String value();
}

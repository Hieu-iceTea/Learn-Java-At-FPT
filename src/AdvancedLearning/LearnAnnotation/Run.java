package AdvancedLearning.LearnAnnotation;

@MyAnnotation(value = "Hello World")
public class Run {
    @MyAnnotation(value = "Huhu")
    @SuppressWarnings(value = "Hehehe")
    @Deprecated
    public static void testMethod(){

    }
}

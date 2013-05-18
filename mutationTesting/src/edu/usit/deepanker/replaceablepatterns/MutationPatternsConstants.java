package edu.usit.deepanker.replaceablepatterns;

import java.util.regex.Pattern;

class MutationPatternsConstants {
    /*public static Pattern getAddArithmeticOperatorReplacementPattern(){
        return Pattern.compile("[^\\s]+[\\s]*[\\+]+?[\\s]*[^\\s]+");
    }
    public static Pattern getSubtractArithmeticOperatorReplacementPattern(){
        return Pattern.compile("[^\\s]+[\\s]*[\\-]+[\\s]*[^\\s]+");
    }
    public static Pattern getMultiplyArithmeticOperatorReplacementPattern(){
        return Pattern.compile("[^\\s]+[\\s]*[\\*][\\s]*[^\\s]+");
    }
    public static Pattern getDivideArithmeticOperatorReplacementPattern(){
        return Pattern.compile("[^\\s]+[\\s]*[/][\\s]*[^\\s]+");
    }*/
    public static final Pattern ADD_ARITHMETIC_OPERATOR_REPLACEMENT_PATTERN=Pattern.compile("\\+");
    public static final Pattern SUBTRACTION_ARITHMETIC_OPERATOR_REPLACEMENT_PATTERN=Pattern.compile("-");
    public static final Pattern MULTIPLICATION_ARITHMETIC_OPERATOR_REPLACEMENT_PATTERN=Pattern.compile("\\*");
    public static final Pattern DIVISION_ARITHMETIC_OPERATOR_REPLACEMENT_PATTERN=Pattern.compile("/");
}

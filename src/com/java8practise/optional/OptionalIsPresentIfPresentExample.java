package com.java8practise.optional;

import java.util.Optional;

public class OptionalIsPresentIfPresentExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);
        System.out.println("Scenario 0 : "+ optional.isPresent());
        if (optional.isPresent())
            System.out.println("Scenario 1 if:" + optional.get());
        else
            System.out.println("Scenario 1 else:" + optional);

        Optional<String> optional1 = Optional.ofNullable("Not NULL");
        System.out.println("Scenario 2:" + optional1);
        optional1.ifPresent((s)->System.out.println(optional1.get() + "(In Built Consumer Lambda Here)"));
    }
}

/*


Scenario 0 : false
Scenario 1 else:Optional.empty
Scenario 2:Optional[Not NULL]
Not NULL(In Built Consumer Lambda Here)

 */

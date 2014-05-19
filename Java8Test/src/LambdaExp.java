import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 
public class LambdaExp {
   
    interface IntegerMath {
    	// default operation
        int operation(int a, int b);
        
//        int op(int a,int b); // compiler error
        
//        String op(int a, int b); // compiler error
        
//        int operation(int a, int b, int c); // compiler error
        
        
    }
    
    interface IntegerString {
        String operation(String a, int b);
    }
   
    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
  
    public static void main(String... args) {
    	//
    	// Lambda vs Anonymous
    	//
    	LambdaExp myApp = new LambdaExp();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        
        System.out.println("40 + 2 = " +
            myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
            myApp.operateBinary(20, 10, subtraction));    
        
        IntegerString str = (a, b) -> {String s = a.concat("50") + b; return s;}; 
        System.out.println(str);
        
        System.out.println(str.operation("testStr", -60));
        
        // no lambda
        Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("hello world1");
				System.out.println("hello world2");
			}
		};
		
		// with lambda
        Runnable r2 = () -> {System.out.println("hello world1"); System.out.println("hello world2");};
        
        // Lambda with foreach (java.util.function.Consumer)
        List<String> list1 = Arrays.asList("A", "B", "C", "D", "E");
        list1.forEach((a) -> {System.out.println(a + "1");});
        
        List<String> list2 = Arrays.asList("A", "B", "C", "D", "E");
        list2.forEach(System.out::println);
        
        //
        // (java.util.function.Predicated)
        //
        // Lambda with condition (java.util.function.Predicated)
        System.out.println("Print language whose length greater than 4:");
        
        // As condition for Type String
        // inputPredicated with has the same type as parameterize type (String)
        Predicate<String> a =  (inputPredicated)->inputPredicated.startsWith("A");
        boolean testResult = a.test(list2.get(0));
        System.out.println(testResult);
    }
}
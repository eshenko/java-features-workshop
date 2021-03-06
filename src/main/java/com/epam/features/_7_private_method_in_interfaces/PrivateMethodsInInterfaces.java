package com.epam.features._7_private_method_in_interfaces;

import java.util.Optional;

/**
 * @since 9
 */
public interface PrivateMethodsInInterfaces {
    String lastElement();
    String nthElement(int n);

    default Optional<Integer> lastElementAsInt() {
        try {
            return Optional.of(Integer.valueOf(lastElement()));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    default Optional<Integer> nthElementAsInt(int n) {
        try {
            return Optional.of(Integer.valueOf(nthElement(n)));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        PrivateMethodsInInterfaces storage = new PrivateMethodsInInterfaces() {
            @Override
            public String lastElement() {
                return "abc";
            }

            @Override
            public String nthElement(int n) {
                return "2";
            }
        };

        System.out.println(storage.lastElementAsInt());
        System.out.println(storage.nthElementAsInt(1));
    }
}

package net.devtech.utilib.functions;


public interface PentaFunction<A, B, C, D, E, F> {
	F apply(A a, B b, C c, D d, E e);
}
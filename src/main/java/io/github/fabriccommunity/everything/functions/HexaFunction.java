package net.devtech.utilib.functions;


public interface HexaFunction<A, B, C, D, E, F, G> {
	G apply(A a, B b, C c, D d, E e, F f);
}
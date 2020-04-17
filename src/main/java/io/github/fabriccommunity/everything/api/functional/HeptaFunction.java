package io.github.fabriccommunity.everything.api.functional;


public interface HeptaFunction<A, B, C, D, E, F, G, H> {
	H apply(A a, B b, C c, D d, E e, F f, G g);
}
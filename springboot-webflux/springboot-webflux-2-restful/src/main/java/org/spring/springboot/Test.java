package org.spring.springboot;

import java.util.Optional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Test {

	public static void main(String[] args) {
		Mono.empty().subscribe(System.out::println);
		Mono.just("foo").subscribe(System.out::println);
		
		Mono.justOrEmpty(null).subscribe(System.out::println);
		Mono.justOrEmpty("justOrEmpty1").subscribe(System.out::println);
		Mono.justOrEmpty(Optional.of("justOrEmpty2")).subscribe(System.out::println);

		Mono.error(new RuntimeException("error")).subscribe(System.out::println, System.err::println);
		
		Mono.create(a -> a.success("create MonoSink")).subscribe(System.out::println);
		
		Flux.just(1, 2, 3, 4, 5, 6).subscribe(System.out::print);
		System.out.println();
		Mono.just(1).subscribe(System.out::println);
		Flux.just(1, 2, 3, 4, 5, 6).subscribe(
			    System.out::println,
			    System.err::println,
			    () -> System.out.println("Completed!"));
		

	}
	
}

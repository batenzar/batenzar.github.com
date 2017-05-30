package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Removal {

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out
					.println("This program will search for duplicate file in the current directory. OK? (y/n)");

			try (Scanner scan = new Scanner(System.in)) {
				String ans = scan.next();
				if ("n".equalsIgnoreCase(ans)) {
					System.exit(0);
				}
			}
		}

		Stream<String> map;
		try (Stream<Path> list = Files.list(Paths.get("."))) {

			map = list.map(a -> {
				String name = a.getFileName().toString();
				if (name.startsWith("01_")) {
					name = name.replaceFirst("01_", "");
				} else if (name.startsWith("1_")) {
					name = name.replaceFirst("1_", "");
				}

				if (name.contains("_2.")) {
					name = name.replace("_2.", ".");
				}
				return name;
			});

			Set<String> duplicatedNumbersRemovedSet = new HashSet<>();
			map.filter(n -> {
				boolean result = !duplicatedNumbersRemovedSet.add(n);
				// System.out.println("Calculating:" + n + " Result: " +
				// result);
					return result;
				}).forEach(System.out::println);

		}

		// Set<String> duplicatedNumbersRemovedSet = new HashSet<>();
		// map.forEach(a -> {
		// map.filter(n -> !duplicatedNumbersRemovedSet.add(n)).forEach(
		// System.out::print);
		// });
	}
}

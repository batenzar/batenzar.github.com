package bat.test.ansiiconverter;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

public class TestToUnicode {

	public static void main(String[] args) throws Exception {
		File f = new File(
				"E:\\Torrent Download\\JOOX Top 50 Thai Songs [May 29, 2017]");
		String[] list = f.list();

		// key is here. the exist must be utf-8 to be able to write thai to .txt
		try (PrintWriter pw = new PrintWriter(new File("D:\\temp.txt"), "UTF-8")) {
			Charset.availableCharsets()
					.values()
					.forEach(
							a -> {
								try {
									String result = new String(list[0]
											.getBytes(), a);
									if (!result.contains("?")) {
										pw.println("1st Converting To chaset "
												+ a.name() + " result is "
												+ result);
									}
								} catch (Exception e) {
									e.printStackTrace();
								}

								Charset.availableCharsets()
										.values()
										.forEach(
												b -> {
													try {
														String result2 = new String(
																list[0].getBytes(a),
																b);
														if (!result2
																.contains("?")) {
															pw.println("2nd Converting From chaset "
																	+ a.name()
																	+ " to charset "
																	+ b.name()
																	+ " result is "
																	+ result2);
														}
													} catch (Exception e) {
														e.printStackTrace();
													}
												});

								try {
									String string = new String(list[0]
											.getBytes("TIS-620"), Charset
											.forName("UTF-8"));
									pw.println(string);
								} catch (Exception e) {
									e.printStackTrace();
								}

								try {
									String string = new String(
											list[0].getBytes(StandardCharsets.ISO_8859_1),
											Charset.forName("TIS-620"));
									pw.println(string);
								} catch (Exception e) {
									e.printStackTrace();
								}
							});
		}
		// String string = new String(list[0].getBytes("TIS-620"),
		// Charset.forName("UTF-8"));
		// System.out.println(string);
	}

	private static void moveFileCommand() throws Exception {
		File f = new File("D:\\TestRename");

		File s = new File("D:\\TestRename\\", f.list()[0]);
		File t = new File("D:\\TestRename\\", new String(
				f.list()[0].getBytes(StandardCharsets.ISO_8859_1),
				Charset.forName("TIS-620")));
		// s.renameTo(t);
		Files.copy(s.toPath(), t.toPath());
	}

	private static void createRenameCommand() {
		File f = new File(
				"E:\\Torrent Download\\JOOX Top 50 Thai Songs [May 29, 2017]");
		String[] list = f.list();
		try (PrintWriter pw = new PrintWriter(new File("D:\\temp.txt"), "UTF-8")) {
			Arrays.asList(list).forEach(
					a -> {
						String string = new String(a
								.getBytes(StandardCharsets.ISO_8859_1), Charset
								.forName("TIS-620"));
						pw.println("rename \"" + a + "\" \"" + string + "\"");
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

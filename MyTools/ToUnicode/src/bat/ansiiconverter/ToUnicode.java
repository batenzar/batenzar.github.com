package bat.ansiiconverter;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * Rename file from Thai character (old windows) to Unicode. 
 * The output will be in subfolder named 'output'
 */
public class ToUnicode {

	public static void main(String[] args) throws Exception {
		if (args.length < 1 ){
			System.out.println("Usage: \njava -jar bat.ansiiconverter.ToUnicode <targetfolder>");
			System.exit(0);
		}
		File folder = new File(args[0]);
		if (!folder.exists()){
			System.out.println("No such folder " + folder);
			System.exit(0);
		}
//		File folder = new File(
//				"E:\\Torrent Download\\JOOX Top 50 Thai Songs [May 29, 2017]");
		File output = new File(folder, "output");
		Files.createDirectories(output.toPath());

		String[] list = folder.list();
		Arrays.asList(list).forEach(
				a -> {
					File sourceFile = new File(folder, a);
					File targetFile = new File(output, new String(a
							.getBytes(StandardCharsets.ISO_8859_1), Charset
							.forName("TIS-620")));
					try {

						Files.copy(sourceFile.toPath(), targetFile.toPath());
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
	}
}

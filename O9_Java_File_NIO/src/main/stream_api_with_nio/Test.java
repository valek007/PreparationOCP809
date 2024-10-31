package main.stream_api_with_nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
	
	//The Files class defines methods enabling you to work with the Stream API, including lines, list, walk and find
	public static void main(String[] args) throws IOException {
		//The linew methods readd all lines from a file as a Stream
		//you can specify a charset for decoding, or use UTF-8 as the default
		//Stream<String> lines(Path path) throws IOException
		//Stream<String> lines(Path path, Charset charset) throws IOException
		Path path = Paths.get("file.txt");
		Files.lines(path).forEach(System.out::println);
		Files.lines(path, Charset.forName("ISO-8859-1")).forEach(System.out::println);
		
		//The list method returns a lazily populated Stream whose elements are entries of the given directory
		//Stream<Path> list(Path directory) throws IOException
		Path directory = Paths.get(".");
		Files.list(directory).filter(p->p.toString().endsWith(".txt")).forEach(System.out::println);
		
		//The walk methods return a Stream that is lazily populated with Path instances
		//by walking the file tree rooted at the given starting file
		//Stream<Path> walk(Path start, FIleVisitOption... options)throws IOException
		//Stream<Path> walk(Path start, int maxDepth, FileVisitOption... options) throws IOException
		Path root = Paths.get(".");
		Files.walk(root).filter(p->Files.isRegularFile(p)).forEach(System.out::println);
		Files.walk(root, 1, FileVisitOption.FOLLOW_LINKS).forEach(System.out::println);
		
		//The find method returns a Stream that is lazily populated with Path instances by searching
		//for files in a file tree tooted at the given starting file
		//Stream<Path> find(Path start, int maxDepth, BiPredicate<Path, BasicFileAttributes> matcher, FileVisitOption... options) throws IOException
		Files.find(root, 2, (p, attrs) -> p.getFileName().toString().startsWith("w")&&attrs.isRegularFile()).forEach(System.out::println);
		
		
	}

}

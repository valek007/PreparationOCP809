package main.files_class;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class Test {
	//The Files class defines static methods that operate on Path instances
	//these instances represent files and directories in the file system
	//and you can use those methods to check, read, copy, move and manage
	//metadata of a file or directory
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		//The exists method testst whether aa file exists in the file system:
		// boolean exists(Path path, LinkOption... options)
		//The notExistst method tests whether a file does not exist in the file system:
		// boolean notExists(Path path, LinkOption... options)
		Path path = Paths.get("directory");
		boolean existent = Files.exists(path);
		boolean nonExistent = Files.notExists(path, LinkOption.NOFOLLOW_LINKS);
		System.out.println(existent+" "+nonExistent);
		
		//The readAllLines methods read all lines from a file
		//you can specify a charset for decoding, or use UTF-8 as the default
		//  List<String> readAllLines(Path path) throws IOException
		//The readAllBytes method reads all bytes from a file:
		// byte[] readAllBytes(Path path) throws IOException
		Path path2 = Paths.get("file.txt");
		List<String> linesUTF8 = Files.readAllLines(path2);
		List<String> lines = Files.readAllLines(path2, Charset.forName("UTF-8"));
		byte[] bytes = Files.readAllBytes(path2);
		
		//The delete and deleteIfExists methods delete a file in the file system:
		// void delete(Path path) throws IOException
		// boolean deleteIfExists(Path path) throws IOException
		Path path3 = Paths.get("file.txt");
		Files.delete(path3);
		boolean deleted = Files.deleteIfExists(path3);
		
		//The CopyOption interface describes objects that configure how to copy or move a file
		//The Java NIO.2 API provides two enum types implementing the CopyOption interface,
		//namely LInkOption and StandardCopyOption
		//LinkOption.NOFOLLOW_LINKS: Do not follow symbolic links
		//StandardCopyOption.ATOMIC_MOVE: Move the file as an atomic file system operation
		//StandardCopyOption.COPY_ATTRIBUTES: Copy attributes to the new file
		//StandardCopyOption.REPLACE_EXISTING: Replace an existing file if it exists
		
		//The Files class defines three overloaded copy methods for copying a file
		// Path copy(Path source, Path target, CopyOption... options) throws IOException
		// long copy(Path source, OutputStream out) throws IOException
		// long copy(InputStream in, Path target, CopyOption... options) throws IOException
		Path file = Paths.get("file.txt");
		Path oracle = Paths.get("oracle.txt");
		Files.copy(file, oracle, StandardCopyOption.COPY_ATTRIBUTES);
		Files.copy(oracle, System.out);
		Files.copy(System.in, file, StandardCopyOption.REPLACE_EXISTING);
		
		//The move method moves or renames a file to a target file
		// Path move(Path source, Path target, CopyOption... options) throws IOException
		Files.move(file, oracle, StandardCopyOption.REPLACE_EXISTING);
		
		//File class method what allowed you to extract data of the indicated file:
		//getLastModifiedTime(Path path, LinkOption... options): Returns a file's last modified time
		//getOwner(Path path, LinkOptions... options): Returns the owner of a file
		//isDirectory(Path path, LinkOption... options): Tests whether a file is a directory
		//isRegularFile(Path path, LinkOption... options): Test whether a file is a regular file
		//isSymbolicLink(Path path): Tests whether a file si a symbolic link
		//isReadable(Path path): Tests whether a file is readable
		//isWritable(Path path): Tests whether a file is writable
		//isHidden(Path path): Tests whether a file is considered hidden
		//isSameFile(Path path1, Path path2): Tests whether two paths locate the same file
		
		//The FileAttributeView interface represents a view of attributes associated with a file
		//The most important subinterface of FileAttributeView is BasicFileAttributeView
		//providing a view of a basic set of file attributes common to many file systems
		//Attributes supported by BasicFileAttributeView are corresponding to methods of the BasicFileAttributes interface
		//All subinterfaces of FileAttributeView have a name: the name of a view is specified by the name method of that view
		//The getAttribute method reads the value of a file attribute
		//the attribute parameter identifies the attribute to be read and takes the form [view-name]attribute-name
		// Object getAttribute(Path, String attribute, LinkOption... options) throws IOException
		boolean isDir= (Boolean) Files.getAttribute(path3, "basic:isDirectory");
		System.out.println(isDir);//print "true" if file is the name o a directory
		
		//The getFileAttributeView and readAttributes methods read attributes of a file as a bulk operation:
		//<V extends FileAttributeView>V getFileAttributeView(Path path, Class<V> type, LinkOperation... options)
		//<A extends BasicFileAttributes>A readAttributes(Path path, Class<A>type, LinkOption...options) throw IOException
		//Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options) throws IOException
		Path path4 = Paths.get("file.txt");
		BasicFileAttributeView view= Files.getFileAttributeView(path4, BasicFileAttributeView.class);
		BasicFileAttributes attrSet1 = view.readAttributes();
		BasicFileAttributes attrSet2 = Files.readAttributes(path4, BasicFileAttributes.class);
		Map<String, Object> map = Files.readAttributes(path4, "basic:*");
		System.out.println("Size: "+attrSet1.size()+" "+map.get("size"));
		
		//The setAttribute method sets a value for a file attribute
		//the attribute parameter identifies the attribute to be set and takes the form [view-name:]attribute-name
		//Path setAttribute(Path path, String attribute, Object value, LinkOption...options) throws IOException
		Files.setAttribute(path4, "lastModifiedTime", FileTime.from(Instant.parse("2020-02-20T02:20:00.00Z")));
		//print "2020-02-20T02:20:00.00Z"
		System.out.println(Files.getLastModifiedTime(path4));
		
		
		
	
		
		
		
	}

}

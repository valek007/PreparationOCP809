package main.path_interface;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//A path instance represents a path, wich is composed of a sequence of
		//directory and file name elements, separated by a system-specific separator
		Path winsPath = Paths.get("C:\\users","directory");//absolute path
		Path unixPath = Paths.get("/","users","directory");//absolute path
		Path relPath = FileSystems.getDefault().getPath("directory");//relative path
		
		//A Path instance can be converted to and from a File:
		File file = Paths.get("file.txt").toFile();
		Path path = new File("file.txt").toPath();
		
		//The getFileName method returns the name of the last component of this path
		//The getParent method returns the parent path, or null if this path does not have a parent
		//The getRoot method returns the root component, or null if this path does not have a root component
		Path path2 = Paths.get("/users","directory","java/ocpjp8");
		Path fileName = path2.getFileName();
		System.out.println(fileName);//print "ocpjp8"
		Path parent = path2.getParent();
		System.out.println(parent);//print "users/directory/java"
		Path root = path.getRoot();
		System.out.println(root);
		
		//The getNameCount method returns the number of name elements in this path
		//The getName method returns a name element of this path at the specified index
		//The subpath method returns a relative path that is a subsequence of this path
		Path path3 = Paths.get("/","directory","java","ocpjp8");
		int count = path3.getNameCount();
		System.out.println(count);//print "3"
		Path name = path3.getName(1);
		System.out.println(name); //print "java"
		Path subpath = path.subpath(0, 2);
		System.out.println(subpath); //print "directory/java"
		
		//The isAbsolute method checks whether this path is absolute
		//The toAbsolutePath method returns the corresponding absolute path of this path
		Path absPath = Paths.get("/file");//Absolute path
		Path relPath2 = Paths.get("file");//Relative path
		System.out.println(absPath.isAbsolute());//print "true"
		System.out.println(absPath == absPath.toAbsolutePath());//print "true"
		System.out.println(relPath2.isAbsolute());//print false
		//print "<complete-path-to-current-directory>/file"
		System.out.println(relPath2.toAbsolutePath());
		
		//The normalize method returns a path that is this path with redundant name elements eliminated
		//The relativize method constructs a relative path between this path and the specified path
		//For use realtivize method the both path have to be or both absolute or both relative "Throws InlegalArgumentException"
		Path origin = Paths.get("directory/../../oracle/./java");
		Path normalized = origin.normalize();
		System.out.println(normalized);//print "../oracle/java"
		Path target = Paths.get("directory");
		System.out.println(origin.relativize(target));//print "../../../../.."
		System.out.println(normalized.relativize(target));//print "../../../directory"
		
		//The resolve method resolves the specified path against this path
		//The resolveSinling resolves the specified path again this path's parent
		//When we pass the absolute path to resolve, it returns the absolute path
		Path origin2 = Paths.get("directory/java");
		Path target2 = Paths.get("ocpjp8");
		System.out.println(origin.resolve(target2));//print "directory/java/ocpjp8"
		Path sibling = Paths.get("aws");
		System.out.println(origin.resolveSibling(sibling));//print "directory/aws"
	}

}

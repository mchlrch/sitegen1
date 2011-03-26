package ch.miranet.dsl.site.genmodel;

import ch.miranet.dsl.site.siteGenmodel.File;

public class PageExtension {
	
	public static String createRelativePath(File absSourcePath, File absTargetPath) {
		final String pathToRoot = createPathToRoot(absSourcePath.getDepth());
		return createRelativePathInternal(pathToRoot, absTargetPath);
	}
	
	// RedirectionPage
	public static String createRelativePath(String absSourcePath, File absTargetPath) {
		if ( ! absSourcePath.endsWith("/")) throw new IllegalArgumentException("absSourcePath must end with a '/': " + absSourcePath);
		
		final int srcPathDepth = countCharsInString(absSourcePath, '/');
		final String pathToRoot = createPathToRoot(srcPathDepth);
		return createRelativePathInternal(pathToRoot, absTargetPath);
	}
	
	private static String createRelativePathInternal(final String pathToRoot, File absTargetPath) {
		
		// if targetPath ends in 'index.html', then cut it off (link to containing folder instead)
		if ("index.html".equalsIgnoreCase(absTargetPath.getName())) {
			absTargetPath = absTargetPath.getParent();
		}
		
		// backtrack to documentRoot, then use target path starting from documentRoot
		final String targetPath = pathToString(absTargetPath);
		final String relativePathToTarget = pathToRoot + targetPath;
		return relativePathToTarget;
	}
	
	private static String pathToString(File path) {
		final StringBuilder sb = new StringBuilder();
		for (File f = path; f.getParent() != null; f=f.getParent()) {
			if (sb.length() > 0) sb.insert(0, '/');
			sb.insert(0, f.getName());
		}
		return sb.toString();
	}
	
	private static String createPathToRoot(int depth) {
		final StringBuilder pathToRoot = new StringBuilder();
		for (int i=1, n=depth; i<n; i++) {
			pathToRoot.append("../");
		}
		return pathToRoot.toString();
	}

	
	private static int countCharsInString(String s, char ch) {
		int count = 0;
		
		for (int from=0, index = s.indexOf(ch, from);
			 index >= 0;
			 index = s.indexOf(ch, from)) {
		  count++;
		  from = index+1;
		}
		return count;
	}
	
}

package ch.miranet.dsl.site.genmodel;

import ch.miranet.dsl.site.siteGenmodel.File;

public class PageExtension {
	public static String createRelativePath(File absSourcePath, File absTargetPath) {
		
		// if targetPath ends in 'index.html', then cut it off (link to containing folder instead)
		if ("index.html".equalsIgnoreCase(absTargetPath.getName())) {
			absTargetPath = absTargetPath.getParent();
		}
		
		// backtrack to documentRoot, then use target path starting from documentRoot
		final String pathToRoot = createPathToRoot(absSourcePath.getDepth());
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

}

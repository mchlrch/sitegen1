package ch.miranet.dsl.site.domain2genmodel;

import java.util.Arrays;
import java.util.List;

public class PageFooterFactoryExtension {
	
	public static List<Object> cutInSegments(List<Object> elements, Integer segmentCount, Integer segmentIndex) {
		final int[] countPerSegment = new int[segmentCount];
		Arrays.fill(countPerSegment, elements.size() / segmentCount);
		
		// distribute leftover elements to the first segments
		final int leftover = elements.size() % segmentCount;
		for (int i=0, n=leftover; i<n; i++) {
			countPerSegment[i]++; 
		}
		
		int startForIndex = 0;
		for (int i=0, n=segmentIndex; i<n; i++) {
			startForIndex += countPerSegment[i];
		}
		
		final List<Object> segmentAtIndex = elements.subList(startForIndex, startForIndex+countPerSegment[segmentIndex]);
		return segmentAtIndex;
	}
	
}

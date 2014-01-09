import java.util.HashMap;

public class LongestConsecutiveSequence {
	int[] set = null;
	int[] max = null;
	int[] min = null;
	int[] h = null;
	HashMap<Integer, Integer> map = null;

	public int longestConsecutive(int[] num) {
		if (num == null || num.length == 0)
			return 0;

		int len = num.length;
		set = new int[len];
		max = new int[len];
		min = new int[len];
		h = new int[len];
		for (int i = 0; i < len; ++i) {
			set[i] = i;
			max[i] = num[i];
			min[i] = num[i];
			h[i] = 1;
		}

		map = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; ++i) {
			map.put(num[i], i);
		}

		for (int i = 0; i < len; ++i) {
			int value = num[i];
			int pos1 = positionByValue(value - 1);
			if (pos1 >= 0) {
				merge(i, pos1);
			}
			int pos2 = positionByValue(value + 1);
			if (pos2 >= 0) {
				merge(i, pos2);
			}
		}
		int maxLen = 0;
		for (int i = 0; i < len; ++i) {
			if (maxLen < max[i] - min[i] + 1) {
				maxLen = max[i] - min[i] + 1;
			}
		}
		return maxLen;
	}

	public int positionByValue(int value) {
		if (map.containsKey(value)) {
			return map.get(value);
		} else {
			return -1;
		}
	}

	public int findSet(int pos) {
		if (set[pos] != pos) {
			set[pos] = findSet(set[pos]);
		}
		return set[pos];
	}

	public void merge(int pos1, int pos2) {
		int s1 = findSet(pos1);
		int s2 = findSet(pos2);
		if (h[s1] < h[s2]) {
			set[s1] = s2;
			max[s2] = Math.max(max[s2], max[s1]);
			min[s2] = Math.min(min[s2], min[s1]);
		} else {
			if (h[s2] == h[s1]) {
				++h[s1];
			}
			set[s2] = s1;
			max[s1] = Math.max(max[s1], max[s2]);
			min[s1] = Math.min(min[s1], min[s2]);
		}
	}
}

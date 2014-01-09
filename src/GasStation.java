public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		int maxLen = 0;
		int total = 0;
		int maxStart = 0;
		int start = 0;

		for (int i = 0; i < 2 * len; ++i) {
			int index = i % len;
			int remain = gas[index] - cost[index];
			total += remain;
			if (total < 0) {
				start = i + 1;
				total = 0;
			} else {
				if (maxLen < i - start + 1) {
					maxLen = i - start + 1;
					maxStart = start;
				}
			}
		}

		if (maxLen >= len)
			return (maxStart % len);

		total = 0;
		maxLen = 0;
		start = 2 * len - 1;
		for (int i = 2 * len - 1; i >= 0; --i) {
			int remain = gas[i % len] - cost[(i + len - 1) % len];
			total += remain;
			if (total < 0) {
				start = i - 1;
				total = 0;
			} else {
				if (maxLen < start - i + 1) {
					maxLen = start - i + 1;
					maxStart = start;
				}
			}
		}

		if (maxLen >= len) {
			return (maxStart % len);
		} else {
			return -1;
		}
	}
}

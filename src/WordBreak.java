import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return false;
		}

		int len = s.length();
		boolean[] result = new boolean[len];
		for (int i = 0; i < len; ++i) {
			if (dict.contains(s.substring(0, i + 1))) {
				result[i] = true;
				continue;
			}

			for (int j = 0; j < i; ++j) {
				if (result[j] && dict.contains(s.substring(j + 1, i + 1))) {
					result[i] = true;
					break;
				}
			}
		}
		return result[len - 1];
	}
}

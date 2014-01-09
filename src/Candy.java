public class Candy {
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;

		if (ratings.length == 1)
			return 1;

		int[] dist = new int[ratings.length];
		int sum = 0;
		for (int i = 0; i < ratings.length; ++i) {
			sum += findmin(ratings, dist, i);
		}
		return sum;
	}

	boolean bottom(int[] ratings, int index) {
		return (index == 0 || ratings[index] <= ratings[index - 1])
				&& (index == ratings.length - 1 || ratings[index] <= ratings[index + 1]);
	}

	private int findmin(int[] ratings, int[] dist, int index) {
		if (dist[index] != 0)
			return dist[index];

		if (bottom(ratings, index)) {
			dist[index] = 1;
			return 1;
		}

		int min = 0;
		if (index > 0 && ratings[index - 1] < ratings[index]) {
			min = dist[index - 1];
		}

		int current = index + 1;
		if (index < ratings.length - 1 && ratings[index + 1] < ratings[index]) {
			while (!bottom(ratings, current)) {
				++current;
			}
			dist[current] = 1;
			while (current != index) {
				--current;
				dist[current] = dist[current + 1] + 1;
			}
			min = Math.max(dist[current + 1], min);
		}

		dist[index] = min + 1;
		return dist[index];
	}
}

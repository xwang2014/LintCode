package lintcode;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets {

	/**
	 * @param S
	 *            : A set of numbers.
	 * @return: A list of lists. All valid subsets.
	 */
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
		// Sort
		Collections.sort(S);

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> buffer = new ArrayList<Integer>();

		process(ans, S, buffer, 0);

		return ans;
	}

	private void process(ArrayList<ArrayList<Integer>> ans,
			ArrayList<Integer> S, ArrayList<Integer> buffer, int idx) {
		if (idx == S.size()) {
			ans.add(new ArrayList<Integer>(buffer));
			return;
		}

		// Do not select current number
		process(ans, S, buffer, idx + 1);

		// Select current number
		buffer.add(S.get(idx));
		process(ans, S, buffer, idx + 1);
		buffer.remove(buffer.size() - 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

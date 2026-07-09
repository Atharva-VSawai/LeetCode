class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int swaps = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(row[i], i);
        }

        for (int i = 0; i < n; i += 2) {

            int first = row[i];
            int partner = first ^ 1;

            if (row[i + 1] == partner)
                continue;

            int partnerIndex = map.get(partner);

            int temp = row[i + 1];
            row[i + 1] = row[partnerIndex];
            row[partnerIndex] = temp;

            map.put(row[partnerIndex], partnerIndex);
            map.put(row[i + 1], i + 1);

            swaps++;
        }

        return swaps;
    }
}
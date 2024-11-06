class Solution {
    public int[] sortByBits(int[] arr) {
        // Convert int[] to Integer[] to use Comparator
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int aBits = Integer.bitCount(a);
                int bBits = Integer.bitCount(b);
                if (aBits == bBits)
                    return a - b;
                return aBits - bBits;
            }
        });

        return Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();
    }
}
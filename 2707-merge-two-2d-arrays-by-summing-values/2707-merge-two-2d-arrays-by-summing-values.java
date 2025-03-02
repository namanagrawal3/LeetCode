class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<List<Integer>> temp = new ArrayList<>();

        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            List<Integer> l = new ArrayList<>();
            if (nums1[i][0] == nums2[j][0]) {
                l.add(nums1[i][0]);
                l.add(nums1[i][1] + nums2[j][1]);
                i++;
                j++;
            }
            else if (nums1[i][0] < nums2[j][0]) {
                l.add(nums1[i][0]);
                l.add(nums1[i][1]);
                i++;
            }
            else {
                l.add(nums2[j][0]);
                l.add(nums2[j][1]);
                j++;
            }
            temp.add(l);
        }

        while (i < n1) {
            List<Integer> l = new ArrayList<>();
            l.add(nums1[i][0]);
            l.add(nums1[i][1]);
            temp.add(l);
            i++;
        }

        while (j < n2) {
            List<Integer> l = new ArrayList<>();
            l.add(nums2[j][0]);
            l.add(nums2[j][1]);
            temp.add(l);
            j++;
        }

        int[][] ans = new int[temp.size()][2];
        for (int k = 0; k < temp.size(); k++) {
            ans[k][0] = temp.get(k).get(0);
            ans[k][1] = temp.get(k).get(1);
        }

        return ans;
    }
}
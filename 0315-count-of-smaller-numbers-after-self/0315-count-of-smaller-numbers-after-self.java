class Solution {
    class Pair {
        int item;
        int idx;
        public Pair(int e, int i) {
            item = e;
            idx = i;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(ans, arr, 0, n-1);             // Descending sorted order

        List<Integer> ll = new ArrayList<>();
        for (int a: ans) {
            ll.add(a);
        }
        return ll;
    }
    public void mergeSort(int[] count, Pair[] arr, int l, int r) {
        if (l == r)
            return;

        int mid = (l + r)/2;
        mergeSort(count, arr, l, mid);
        mergeSort(count, arr, mid+1, r);
        merge(count, arr, l, mid, r);
    }
    public void merge(int[] count, Pair[] arr, int l, int mid, int r) {
        Pair[] temp = new Pair[r-l+1];
        int i = 0;
        int left = l;
        int right = mid+1;

        while (left <= mid && right <= r) {
            if (arr[left].item <= arr[right].item) {
                temp[i++] = arr[right];
                right++;
            }
            else {
                temp[i++] = arr[left];
                count[arr[left].idx] += r - right + 1;
                left++;
            }
        }

        while (left <= mid) {
            temp[i++] = arr[left];
            left++;
        }

        while (right <= r) {
            temp[i++] = arr[right];
            right++;
        }

        for (int j = 0; j < temp.length; j++) {
            arr[l+j] = temp[j];
        }
    }
}
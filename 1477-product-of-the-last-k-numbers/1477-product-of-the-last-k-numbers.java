class ProductOfNumbers {
    List<Integer> l;
    List<Integer> pro;
    int n = 0; 
    public ProductOfNumbers() {
        l = new ArrayList<>();
        pro = new ArrayList<>();
    }
    
    public void add(int num) {
        l.add(num);
        if (num == 0) {
            pro.clear();
            n = 0;
            return;
        }

        if (n == 0) 
            pro.add(num);
        else 
            pro.add(pro.get(n-1)*num);
        n++;
    }
    
    public int getProduct(int k) {
        if (n < k)
            return 0;
        if (n-k == 0)
            return pro.get(n-1);
        return pro.get(n-1)/pro.get(n-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
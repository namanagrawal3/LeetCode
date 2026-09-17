class ATM {
    private int[] denom = {20, 50, 100, 200, 500};
    private int[] denomCount;
    private long balance;

    public ATM() {    
        denomCount = new int[5];
        balance = 0;
    }
    
    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            denomCount[i] += banknotesCount[i];
        }
        addInBalance(banknotesCount);
    }
    
    public int[] withdraw(int amount) {
        if (amount > balance)
            return new int[]{-1};
        
        int[] notes = new int[5];
        int remain = amount;

        for (int i = 4; i >= 0; i--) {
            int notesCount = Math.min(denomCount[i], remain/denom[i]);
            if (notesCount > 0)
                remain -= denom[i] * notesCount;
            notes[i] = notesCount;
        }

        if (remain != 0)
            return new int[]{-1};
        
        balance -= amount;
        for (int i = 0; i < 5; i++) {
            denomCount[i] -= notes[i];
        }
        return notes;
    }

    private void addInBalance(int[] banknotesCount) {
        balance += banknotesCount[0] * 20;
        balance += banknotesCount[1] * 50;
        balance += banknotesCount[2] * 100;
        balance += banknotesCount[3] * 200;
        balance += banknotesCount[4] * 500;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
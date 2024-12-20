public enum Coin {
    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25);

    final int value;

    Coin(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}


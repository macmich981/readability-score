public static BigInteger calcDoubleFactorial(int n) {
    BigInteger res = BigInteger.valueOf(1);

    for (int i = n; i >= 0; i = i - 2) {
        if (i == 0 || i == 1) {
            return res;
        } else {
            res = res.multiply(BigInteger.valueOf(i));
        }
    }
    return res;
}

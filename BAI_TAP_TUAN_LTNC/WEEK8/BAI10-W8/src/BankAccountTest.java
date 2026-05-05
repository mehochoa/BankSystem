import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;
    private static final double DELTA = 0.001;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("1234", "Nhan", 500.0);
    }

    /**
     * deposit
     * EC1: amount <= 0: IllegalArgumentException
     * EC2: amount > 0: cộng tiền
     * BVA1: amount = -0.01: IllegalArgumentException
     * BVA2: amount = 0.00: IllegalArgumentException
     * BVA3: amount = 0.01: cộng tiền
     */
    @Test
    public void testDeposit_EP_InvalidAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.deposit(-1));
        assertEquals("Số tiền nạp phải lớn hơn 0.",  exception.getMessage());
    }

    @Test
    public void testDeposit_EP_ValidAmount() {
        account.deposit(100.0);
        assertEquals(600.0, account.getBalance(), DELTA);
    }

    @Test
    public void testDeposit_BVA_BelowZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-0.01);
        });
        assertEquals("Số tiền nạp phải lớn hơn 0.", exception.getMessage());
    }

    @Test
    public void testDeposit_BVA_AtZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(0.0);
        });
        assertEquals("Số tiền nạp phải lớn hơn 0.", exception.getMessage());
    }

    @Test
    public void testDeposit_BVA_AboveZero() {
        account.deposit(0.01);
        assertEquals(500.01, account.getBalance(), DELTA);
    }

    /**
     * withdraw
     * EC1 (Không hợp lệ): amount <= 0 (IllegalArgumentException)
     * EC2 (Hợp lệ, đủ tiền): 0 < amount <= balance (true, trừ tiền)
     * EC3 (Hợp lệ, không đủ tiền): amount > balance (false, không trừ tiền)
     *
     * có 2 ranh giới: 0, balance (500)
     * -0.01 (IllegalArgumentException)
     * 0.0 (IllegalArgumentException)
     * 0.01 (Thành công, trả về true)
     * 499.99 (Thành công, trả về true)
     * 500.0 (Thành công, trả về true)
     * 500.01 (Thất bại, trả về false)
     */
    @Test
    public void testWithdraw_EP_InvalidAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-1));
        assertEquals("Số tiền rút phải lớn hơn 0.",   exception.getMessage());
    }

    @Test
    public void testWithdraw_EP_ValidAmount_EnoughBalance() {
        assertTrue(account.withdraw(100.0));
        assertEquals(400.0, account.getBalance(), DELTA);
    }

    @Test
    public void testWithdraw_EP_ValidAmount_NotEnoughBalance() {
        assertFalse(account.withdraw(600.0));
        assertEquals(500.0, account.getBalance(), DELTA); // Số dư không đổi
    }

    @Test
    public void testWithdraw_BVA_BelowZero() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-0.01));
    }

    @Test
    public void testWithdraw_BVA_AtZero() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
    }

    @Test
    public void testWithdraw_BVA_AboveZero() {
        assertTrue(account.withdraw(0.01));
        assertEquals(499.99, account.getBalance(), DELTA);
    }

    @Test
    public void testWithdraw_BVA_BelowBalance() {
        assertTrue(account.withdraw(499.99));
        assertEquals(0.01, account.getBalance(), DELTA);
    }

    @Test
    public void testWithdraw_BVA_AtBalance() {
        assertTrue(account.withdraw(500.0));
        assertEquals(0.0, account.getBalance(), DELTA);
    }

    @Test
    public void testWithdraw_BVA_AboveBalance() {
        assertFalse(account.withdraw(500.01));
        assertEquals(500.0, account.getBalance(), DELTA);
    }

    // sequence
    @Test
    public void testAccountTransactionSequence() {
        BankAccount seqAccount = new BankAccount("999999", "Tran Van B", 0.0);
        assertEquals(0.0, seqAccount.getBalance(), DELTA);

        seqAccount.deposit(500.0);
        assertEquals(500.0, seqAccount.getBalance(), DELTA);

        // Rút 200 (thành công)
        boolean withdraw1 = seqAccount.withdraw(200.0);
        assertTrue(withdraw1);
        assertEquals(300.0, seqAccount.getBalance(), DELTA);

        // Rút 400 (thất bại do số dư hiện tại chỉ còn 300)
        boolean withdraw2 = seqAccount.withdraw(400.0);
        assertFalse(withdraw2);

        assertEquals(300.0, seqAccount.getBalance(), DELTA);
    }
}

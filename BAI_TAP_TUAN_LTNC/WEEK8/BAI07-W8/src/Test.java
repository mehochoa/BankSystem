/**
 * equivalence class for "price"
 * - EC1: price < 0 -> InValid
 * - EC2: 0 <= price < 100 -> Valid
 * - EC3: price >= 100 -> Valid
 *
 * TC1 -> EC1: -10, GUEST -> IllegalArgumentException
 * TC2 -> EC2: 50, MEMBER -> 47.5
 * TC3 -> EC3: 150, VIP -> 120
 * TC4 -> 50, UNKNOWN -> IllegalArgumentException
 *
 * price =
 * -0.01 -> IllegalArgumentException
 * 0.0 -> EC2
 * 0.01 -> EC2
 * 99.99 -> EC2
 * 100.0 -> EC3
 * 100.01 -> EC3
 *
 * price = -10, 50, 150
 * memberType = GUEST, MEMBER, VIP, OTHER
 * -> 3x4=12 pairs
 */
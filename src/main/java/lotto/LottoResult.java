package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
    private final double profitRate;

    public LottoResult(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }

        for (Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();

            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        profitRate = calculateProfitRate(purchaseAmount);
    }

    private double calculateProfitRate(int purchaseAmount) {
        long totalPrize = rankCount.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public double getProfitRate() {
        return profitRate;
    }
}

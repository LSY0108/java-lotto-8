package lotto;

import java.util.Map;

public class OutputView {
    public static void printResult(LottoResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Rank[] printOrder = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};

        for (Rank rank : printOrder) {
            String format = getRankFormat(rank);
            System.out.printf(format, result.getRankCount().get(rank));
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.getProfitRate());
    }

    private static String getRankFormat(Rank rank) {
        return switch (rank) {
            case FIFTH -> "3개 일치 (5,000원) - %d개%n";
            case FOURTH -> "4개 일치 (50,000원) - %d개%n";
            case THIRD -> "5개 일치 (1,500,000원) - %d개%n";
            case SECOND -> "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n";
            case FIRST -> "6개 일치 (2,000,000,000원) - %d개%n";
            default -> "";
        };
    }
}

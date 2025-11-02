package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(winningNumbers);

        System.out.println("\n입력 확인");
        System.out.println("구입 금액: " + purchaseAmount);
        System.out.println("당첨 번호: " + winningNumbers);
        System.out.println("보너스 번호: " + bonusNumber);
    }
}

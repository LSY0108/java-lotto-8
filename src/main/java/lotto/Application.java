package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        List<Lotto> purchasedLottos = LottoMachine.drawLottos(purchaseAmount);
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(winningNumbers);

        LottoResult result = new LottoResult(purchasedLottos, winningNumbers, bonusNumber, purchaseAmount);
        OutputView.printResult(result);
    }
}
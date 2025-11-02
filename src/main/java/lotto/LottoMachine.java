package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static List<Lotto> drawLottos(int purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE;
        System.out.println("\n" + count + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toList());
            lottos.add(new Lotto(numbers));
            System.out.println(numbers);
        }

        return lottos;
    }
}

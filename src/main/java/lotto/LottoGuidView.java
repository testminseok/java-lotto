package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGuidView {

    private final BufferedReader bufferedReader;

    public LottoGuidView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int getPurchaseAmount() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        int amountPaid = Integer.parseInt(this.bufferedReader.readLine());

        System.out.println((amountPaid / LottoPurchasingMachine.AMOUNT) + "개를 구매했습니다.");

        return amountPaid;
    }

    public void showLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public List<String> getPrevWinningLottoNumbers() throws IOException {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<String> lottoNumbers = new ArrayList<String>();
        lottoNumbers.addAll(Arrays.asList(this.bufferedReader.readLine().split(",")));
        return lottoNumbers;
    }

    public String enteredBonusBallNumber() throws IOException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return this.bufferedReader.readLine();
    }

    public void showNumericalStatement(List<Integer> result , double yield) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + LottoPurchasingMachine.FOURTH_PRIZE_MONEY + "원)- " + result.get(LottoPurchasingMachine.FOURTH_PLACE_INDEX) + "개");
        System.out.println("4개 일치 (" + LottoPurchasingMachine.THIRD_PRIZE_MONEY + "원)- " + result.get(LottoPurchasingMachine.THIRD_PLACE_INDEX) + "개");
        System.out.println("5개 일치 (" + LottoPurchasingMachine.SECOND_PRIZE_MONEY + "원)- " + result.get(LottoPurchasingMachine.SECOND_PLACE_INDEX) + "개");
        System.out.println("6개 일치 (" + LottoPurchasingMachine.FIRST_PRIZE_MONEY + "원)- " + result.get(LottoPurchasingMachine.FIRST_PLACE_INDEX) + "개");
        System.out.println("총 수익률은 " + yield + "입니다.");
    }
}

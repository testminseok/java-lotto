package lotto.domain;

import java.util.*;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final Set<Lotto> lottos;

    public Lottos(int paidMoney) {
        lottos = new HashSet<>();

        int count = paidMoney / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.of());
        }
    }

    public Lottos(Set<Lotto> lottos) {
        this.lottos = new HashSet<>(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public MatchResult getResult(WinningNumbers winningNumber) {
        MatchResult matchResult = MatchResult.getInstance();

        for (Lotto lotto : lottos) {
            Rank rank = lotto.getMatchResult(winningNumber);

            matchResult.updateResult(rank);
        }

        return matchResult;
    }

    public String toString(String format, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString(format, delimiter));
        }

        return stringBuilder.toString();
    }
}
package com.jaeyeonling.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final LottoGenerator lottoGenerator;

    public LottoGame() {
        this(new RandomLottoGenerator());
    }

    LottoGame(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buy(final Money money) {
        final List<Lotto> lottos = new ArrayList<>();
        while (money.canBuy(Lotto.PRICE)) {
            final Lotto lotto = lottoGenerator.generate();

            money.buy(lotto);

            lottos.add(lotto);
        }

        return lottos;
    }
}
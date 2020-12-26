package edu.nextstep.lotto.domain;

import java.util.List;

import edu.nextstep.lotto.domain.sub.LottoGameResult;
import edu.nextstep.lotto.domain.sub.Lottos;
import edu.nextstep.lotto.domain.sub.WinningLotto;

public class LottoGame {
	private final Lottos soldLottos;
	private final WinningLotto winningLotto;

	public LottoGame(Lottos soldLottos, List<Integer> firstRankLotto, int bonusNumber) {
		this.soldLottos = soldLottos;
		this.winningLotto = new WinningLotto(firstRankLotto, bonusNumber);
	}

	public LottoGameResult getResult() {
		return new LottoGameResult(this.soldLottos, this.winningLotto);
	}

}
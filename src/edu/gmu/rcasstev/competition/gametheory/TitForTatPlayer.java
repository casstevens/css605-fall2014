package edu.gmu.rcasstev.competition.gametheory;

import java.util.UUID;

public class TitForTatPlayer extends AbstractGamePlayer {

	@Override
	public GameStrategy getGameStrategy(UUID opponentId,
			GamePayoffs gamePayoffs, GameHistory gameHistory) {

		GameStrategy otherStrategy = gameHistory.getLastStrategy(opponentId,
				gamePayoffs, getUniqueId());

		if (otherStrategy == null) {
			return GameStrategy.STRATEGY1;
		}

		return otherStrategy;
	}
}

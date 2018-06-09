package edu.gmu.rcasstev.competition.monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sim.engine.MakesSimState;
import sim.engine.SimState;

/**
 * When running this version of the competition, the MonopolyPlayers from two
 * students are chosen to play against one another, but each student has two
 * instances of the player in the game. So, there is a total of four players in
 * the game just like in the MonopolyCompetition.
 * 
 * @author randy
 *
 */
public class MonopolyCompetition2 {

	public static final int NUM_GAMES_PER_ROUND = 1000;

	public static void main(String[] args) {

		MakeMonopolyState makeMonopolyState = new MakeMonopolyState();

		SimState.doLoop(makeMonopolyState, new String[] { "-quiet", "-repeat",
				"" + makeMonopolyState.getRepeat() });

		makeMonopolyState.printResults();

		System.exit(0);
	}

	public static class MakeMonopolyState implements MakesSimState {

		private List<MonopolyPlayer> playersFromFile;

		private Map<Class, String> playerClassToNameMap = new HashMap<Class, String>();
		
		private Map<MonopolyPlayer, MonopolyPlayer> firstPlayerToSecondPlayerMap = new HashMap<MonopolyPlayer, MonopolyPlayer>();

		private int currentIndex = 0;

		private int gamesPlayed = 0;

		public MakeMonopolyState() {
			playersFromFile = Monopoly
					.createPlayersFromFile(Monopoly.MONOPOLY_PLAYER_FILE);

			List<MonopolyPlayer> secondPlayers = Monopoly
					.createPlayersFromFile(Monopoly.MONOPOLY_PLAYER_FILE);
			
			for (int i = 0; i < playersFromFile.size(); i++) {
				firstPlayerToSecondPlayerMap.put(playersFromFile.get(i),
						secondPlayers.get(i));
			}

			if (playersFromFile.size() % 2 != 0) {
				System.err
						.println("Number of players should be a multiple of 2");
			}
			
			for (MonopolyPlayer player : playersFromFile) {
				playerClassToNameMap.put(player.getClass(), player.toString());
			}

			Collections.shuffle(playersFromFile);
		}

		public int getRepeat() {
			return NUM_GAMES_PER_ROUND * playersFromFile.size() / 2 + 1;
		}

		// Returns the players for this game
		public List<MonopolyPlayer> getPlayersForThisGame() {
			if (currentIndex >= playersFromFile.size()) {
				gamesPlayed++;
				currentIndex = 0;
				
				// Create new instances of the players so they will start fresh
				playersFromFile = Monopoly
						.createPlayersFromFile(Monopoly.MONOPOLY_PLAYER_FILE);
				
				List<MonopolyPlayer> secondPlayers = Monopoly
						.createPlayersFromFile(Monopoly.MONOPOLY_PLAYER_FILE);
				
				firstPlayerToSecondPlayerMap.clear();
				
				for (int i = 0; i < playersFromFile.size(); i++) {
					firstPlayerToSecondPlayerMap.put(playersFromFile.get(i),
							secondPlayers.get(i));
				}

				// Shuffle for next round of games
				Collections.shuffle(playersFromFile);

				// If there has been enough games played, then print results
				if (gamesPlayed >= NUM_GAMES_PER_ROUND) {
					printResults();
				}
			}

			List<MonopolyPlayer> playersThisGame = new ArrayList<MonopolyPlayer>();

			for (int i = 0; i < 2; i++) {
				playersThisGame.add(playersFromFile.get(currentIndex));
				playersThisGame.add(firstPlayerToSecondPlayerMap
						.get(playersFromFile.get(currentIndex)));
				currentIndex++;
			}

			return playersThisGame;
		}

		public void printResults() {

			final Map<Class, Integer> playerClassToWinMap = new HashMap<Class, Integer>();

			for (MonopolyPlayer player : playersFromFile) {
				playerClassToWinMap.put(player.getClass(), 0);
			}

			for (MonopolyPlayer winner : Monopoly.winners) {
				playerClassToWinMap.put(winner.getClass(),
						playerClassToWinMap.get(winner.getClass()) + 1);
			}

			Collections.sort(playersFromFile, new Comparator<MonopolyPlayer>() {
				@Override
				public int compare(MonopolyPlayer p1, MonopolyPlayer p2) {
					return Double.compare(
							playerClassToWinMap.get(p1.getClass()),
							playerClassToWinMap.get(p2.getClass()));
				}
			});

			for (MonopolyPlayer player : playersFromFile) {
				System.out.println(playerClassToNameMap.get(player.getClass())
						+ " won " + playerClassToWinMap.get(player.getClass())
						+ " games");
			}
			
			System.exit(0);
		}

		@Override
		public SimState newInstance(long seed, String[] args) {

			List<MonopolyPlayer> playersThisGame = getPlayersForThisGame();

			Monopoly monopoly = new Monopoly(seed, playersThisGame);

			return monopoly;
		}

		@Override
		public Class simulationClass() {
			return Monopoly.class;
		}
	}
}

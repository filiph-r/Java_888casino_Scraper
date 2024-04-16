package models;

import java.util.List;

public class JackpotResponse {
	private boolean success;
	private Result result;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public static class Result {
		private Jackpots jackpots;

		public Jackpots getJackpots() {
			return jackpots;
		}

		public void setJackpots(Jackpots jackpots) {
			this.jackpots = jackpots;
		}
	}

	public static class Jackpots {
		private List<Pot> pots;

		public List<Pot> getPots() {
			return pots;
		}

		public void setPots(List<Pot> pots) {
			this.pots = pots;
		}
	}

	public static class Pot {
		private String name;
		private String amount;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}
	}
}

package patterns.bulder.House;


public class House {
	private int roomsCount;
	private int levelCount;
	private boolean isLivingBuilding;
	private boolean isFinished;
	private boolean isSold;

	public House(int roomsCount,
				 int levelCount,
				 boolean isLivingBuilding,
				 boolean isFinished,
				 boolean isSold) {
		this.roomsCount = roomsCount;
		this.levelCount = levelCount;
		this.isLivingBuilding = isLivingBuilding;
		this.isFinished = isFinished;
		this.isSold = isSold;
	}

	public int getRoomsCount() {
		return roomsCount;
	}

	public int getLevelCount() {
		return levelCount;
	}

	public boolean isLivingBuilding() {
		return isLivingBuilding;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public boolean isSold() {
		return isSold;
	}

	public static Builder builder(){
		return new Builder();
	}
	public static class Builder {
		private int roomsCount = 2;
		private int levelCount = 1;
		private boolean isLivingBuilding = false;
		private boolean isFinished = false;
		private boolean isSold = false;

		public Builder roomsCount(int roomsCount) {
			this.roomsCount = roomsCount;
			return this;
		}

		public Builder levelCount(int levelCount) {
			this.levelCount = levelCount;
			return this;
		}

		public Builder isLivingBuilding(boolean isLivingBuilding) {
			this.isLivingBuilding = isLivingBuilding;
			return this;
		}

		public Builder isFinished(boolean isFinished) {
			this.isFinished = isFinished;
			return this;
		}

		public Builder isSold(boolean isSold) {
			this.isSold = isSold;
			return this;
		}

		public House build() {
			return new House(roomsCount,
				levelCount,
				isLivingBuilding,
				isFinished,
				isSold);
		}
	}

}

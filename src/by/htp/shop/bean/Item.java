package by.htp.shop.bean;

public class Item {
	private final int id;
	private final String name;
	private final String type;
	private final String description;
	private final String manufacturer;
	private final int price;
	private final boolean isRented;
	private final String img;

	private Item(ItemBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.type = builder.type;
		this.description = builder.description;
		this.manufacturer = builder.manufacturer;
		this.price = builder.price;
		this.isRented = builder.isRented;
		this.img = builder.img;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public int getPrice() {
		return price;
	}

	public boolean isRented() {
		return isRented;
	}
	
	public String getImg() {
		return img;
	}

	public static class ItemBuilder {
		private final int id;
		private final String name;
		private final String type;
		private final String description;
		private final String manufacturer;
		private final int price;
		private final boolean isRented;
		private final String img;

		public ItemBuilder(int id, String name, String type, String description, String manufacturer, int price,
				boolean isRented, String img) {
			this.id = id;
			this.name = name;
			this.type = type;
			this.description = description;
			this.manufacturer = manufacturer;
			this.price = price;
			this.isRented = isRented;
			this.img = img;
		}

		public Item build() {
			return new Item(this);
		}
	}
}

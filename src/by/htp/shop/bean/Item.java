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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + (isRented ? 1231 : 1237);
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (isRented != other.isRented)
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}

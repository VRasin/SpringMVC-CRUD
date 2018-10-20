package spring.dao;

public class Phone {

	private int id;
	private String brand;
	private String model;
	private String processor;
	private String memory;
	
	public Phone() {
	}
	
	public Phone(int id, String brand, String model, String processor, String memory) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.processor = processor;
		this.memory = memory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", brand=" + brand + ", model=" + model + ", processor=" + processor + ", memory="
				+ memory + "]";
	}
	
	
	
}

package SpringFrameWork.Bean;

public class PropertyValue {

	private final String name;

	private final Object value;
	
	private boolean optional = false;

	private boolean converted = false;

	private Object convertedValue;
	
	public PropertyValue(String name,Object value)
	{
		this.name=name;
		this.value=value;
	}

	public boolean isOptional() {
		return optional;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	public boolean isConverted() {
		return converted;
	}

	public void setConverted(boolean converted) {
		this.converted = converted;
	}

	public Object getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(Object convertedValue) {
		this.convertedValue = convertedValue;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	
}

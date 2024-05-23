public class Data {

    public static Data VOID = new Data(new Object());

    final Object data;
    
    public Data(Object data) {
        this.data = data;
    }

    public Boolean asBoolean() {
        return (Boolean)data;
    }

    public Double asDouble() {
        if (data instanceof Double) {
            return (Double) data;
        } else if (data instanceof Integer) {
            return ((Integer) data).doubleValue(); // Convert Integer to Double
        } else {
            throw new RuntimeException("Data cannot be converted to Double: " + data);
        }
    }

    public Integer asInteger() {
        if (data instanceof Integer) {
            return (Integer) data;
        } else if (data instanceof Double) {
            return ((Double) data).intValue(); // Convert Double to Integer
        } else {
            throw new RuntimeException("Data cannot be converted to Integer: " + data);
        }
    }

    public boolean isDouble() {
        return data instanceof Double;
    }

    public boolean isString() {
        return data instanceof String;
    }

    public boolean isInteger() {
        return data instanceof Integer;
    }

    public boolean isBoolean() {
        return data instanceof Boolean;
    }

    @Override
    public int hashCode() {

        if(data == null) {
            return 0;
        }

        return this.data.hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Data that = (Data) o;
        if (this.data == null && that.data == null) {
            return true; // Both are null
        }
        if (this.data == null || that.data == null) {
            return false; // One is null and the other is not
        }
        // Compare values based on their types
        if (this.data.getClass() != that.data.getClass()) {
            return false; // Different types
        }
        return this.data.equals(that.data);
    }
}

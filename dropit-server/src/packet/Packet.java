package packet;

public class Packet implements java.io.Serializable {
	public static final int QOS_LEVEL_0 = 0;
	public static final int QOS_LEVEL_1 = 1;
	
	public static final int MAX_PRIORITY = 3;
	public static final int MID_PRIORITY = 2;
	public static final int NO_PRIORITY = 1;

	public static final int DEFAULT_CODE = 0;
	public static final int DEFAULT_PRIORITY = NO_PRIORITY;
	public static final int DEFAULT_QOS = QOS_LEVEL_0;

	// Common packet codes
	public static final int CODE_CONFIRMATION = 100;
	public static final int CODE_BUFFERHEADER = 200;
	public static final int CODE_FILEPACKET = 201;
	public static final int CODE_USERPACKET = 300;
	
	private int id; // Unique identifier of packet, should be autogenerated
	private int code; // Packet code, what does the packet contain?
	private int priority; // How fast should it be sent?
	private int qos; // Does it need confirmation from client?

	public Packet(int id) {
		this(id, DEFAULT_CODE, DEFAULT_QOS, DEFAULT_PRIORITY);
	}

	public Packet(int id, int code) {
		this(id, code, DEFAULT_QOS, DEFAULT_PRIORITY);
	}
	
	public Packet(int id, int code, int qos) {
		this(id, code, qos, DEFAULT_PRIORITY);
	}

	public Packet(int id, int code, int qos, int priority) {
		this.setId(id);
		this.setCode(code);
		this.setPriority(priority);
		this.setQos(qos);
	}

	public int getQos() {
		return qos;
	}

	public void setQos(int qos) {
		this.qos = qos;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + id;
		result = prime * result + priority;
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
		Packet other = (Packet) obj;
		if (this.getId() != other.getId())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Packet [code=" + code + ", id=" + id + ", priority=" +  priority +"]";
	}
}

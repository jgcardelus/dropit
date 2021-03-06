package packet.types;

import java.util.LinkedList;
import java.util.List;

import packet.Packet;

/**
 * Head of a multi-packet message. It should contain all the ids from the
 * Packets that form the message.
 */
public class BufferHeaderPacket extends Packet {
	public static final int NO_BUFFER_ID = -1;
	public static final int NO_BUFFER_HASH = -1;
	
	public static final int DEFAULT_BUFFER_TYPE = 0;

	private int bufferId = NO_BUFFER_ID;
	private List<Integer> packetIds = new LinkedList<Integer>();
	private int bufferHash = NO_BUFFER_HASH;
	private int bufferType = DEFAULT_BUFFER_TYPE;

	public BufferHeaderPacket(int id) {
		super(
			id, 
			Packet.CODE_BUFFERHEADER,
			Packet.QOS_LEVEL_1,
			Packet.MAX_PRIORITY);
	}

	public int getBufferType() {
		return bufferType;
	}
	/**
	 * Defines what type of message the Buffer will contain.
	 * @param bufferType
	 */
	public void setBufferType(int bufferType) {
		this.bufferType = bufferType;
	}
	public int getBufferId() {
		return bufferId;
	}
	public void setBufferId(int fileId) {
		this.bufferId = fileId;
	}
	public List<Integer> getPacketIds() {
		return packetIds;
	}
	/**
	 * Defines the ids of Packets that form the message.
	 * @param packetIds
	 */
	public void setPacketIds(List<Integer> packetIds) {
		this.packetIds = packetIds;
	}
	public int getBufferHash() {
		return bufferHash;
	}
	public void setBufferHash(int fileHash) {
		this.bufferHash = fileHash;
	}
	public void addPacket(int filePacketId) {
		this.packetIds.add(filePacketId);
	}
}

package net.client.events;

public abstract class ClientAdapter {
	public void onPacketArrived(PacketArrivedEvent event) {}
	public void onUpdateUser(UpdateUserEvent event) {}
}

package com.learning.designpattern;

import java.util.ArrayList;
import java.util.List;

enum ChannelTypeEnum {
	ENGLISH, HINDI, ALL;
}

class Channel {
	private double frequency;
	private ChannelTypeEnum TYPE;

	public Channel(double freq, ChannelTypeEnum type) {
		this.frequency = freq;
		this.TYPE = type;
	}

	public double getFrequency() {
		return frequency;
	}

	public ChannelTypeEnum getTYPE() {
		return TYPE;
	}
}

interface ChannelCollection {
	public void addChannel(Channel c);

	public void removeChannel(Channel c);

	public ChannelIterator iterator(ChannelTypeEnum type);
}

interface ChannelIterator {
	public boolean hasNext();

	public Channel next();
}

class ChannelCollectionImpl implements ChannelCollection {
	private List<Channel> channelsList;

	public ChannelCollectionImpl() {
		channelsList = new ArrayList<>();
	}

	public void addChannel(Channel c) {
		this.channelsList.add(c);
	}

	public void removeChannel(Channel c) {
		this.channelsList.remove(c);
	}

	@Override
	public ChannelIterator iterator(ChannelTypeEnum type) {
		return new ChannelIteratorImpl(type, this.channelsList);
	}

	private class ChannelIteratorImpl implements ChannelIterator {
		private ChannelTypeEnum type;
		private List<Channel> channels;
		private int position;

		public ChannelIteratorImpl(ChannelTypeEnum ty, List<Channel> channelsList) {
			this.type = ty;
			this.channels = channelsList;
		}

		@Override
		public boolean hasNext() {
			while (position < channels.size()) {
				Channel c = channels.get(position);
				if (c.getTYPE().equals(type) || type.equals(ChannelTypeEnum.ALL)) {
					return true;
				} else
					position++;
			}
			return false;
		}

		@Override
		public Channel next() {
			Channel c = channels.get(position);
			position++;
			return c;
		}
	}
}

public class B10IteratorPattern {
	public static void main(String[] args) {

	}
}
